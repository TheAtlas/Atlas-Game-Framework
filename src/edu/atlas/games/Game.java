/*
 * Copyright (C) 2014, David Verhaak
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.atlas.games;

import java.awt.KeyboardFocusManager;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.atlas.games.content.Content;
import edu.atlas.games.graphics.SpriteBatch;
import edu.atlas.games.graphics.Texture2D;
import edu.atlas.games.input.Keyboard;
import edu.atlas.games.input.KeyboardState;
import edu.atlas.games.input.Keys;

/**
 * Handles the main of the Game.
 * @author David Verhaak <david@forcez.nl>
 * @since 0.1
 */
public class Game implements Runnable
{

	public static final ThreadGroup THREAD_GROUP = new ThreadGroup("atlas-games");
	private static final Logger LOG = Logger.getLogger(Game.class.getName());

	private final int TARGET_FPS = 60;
	private final long OPTIMAL_TIME = 1000 / TARGET_FPS;
	private final int MAX_FRAME_SKIPS = 5;

	private long timeStarted;
	private int framesSkipped;
	private long timeDifference;
	private long sleepTime;

	private boolean running;

	private Window window;
	private SpriteBatch spriteBatch;

	private Texture2D texture;

	/**
	 * Constructs the Game by creating a <code>Window</code>,
	 * constructing the <code>SpriteBatch</code> and adding the KeyEventDispatcher.
	 * @since 0.1
	 */
	public Game()
	{
		window = new Window(this);
		spriteBatch = new SpriteBatch(this);
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new Keyboard());
	}

	/**
	 * Runs the main game loop which calls <code>initialize</code> and <code>loadContent</code>
	 * on start and calling <code>update</code> and <code>draw</code> every frame.
	 * @since 0.1
	 */
	@Override
	public void run()
	{
		initialize();
		loadContent();
		window.setVisible(true);
		running = true;
		while (running)
		{
			timeStarted = System.currentTimeMillis();
			framesSkipped = 0;
			update();
			window.getCanvas().display();
			timeDifference = System.currentTimeMillis() - timeStarted;
			sleepTime = OPTIMAL_TIME - timeDifference;
			if (sleepTime > 0)
			{
				try
				{
					Thread.sleep(sleepTime);
				} catch (InterruptedException exception)
				{
					LOG.log(Level.SEVERE, null, exception);
					shutdown();
				}
			}
			while (sleepTime < 0 && framesSkipped < MAX_FRAME_SKIPS)
			{
				update();
				sleepTime += OPTIMAL_TIME;
				framesSkipped++;
			}
		}
		shutdown();
	}

	/**
	 * Initializes the Game.
	 * This method is automatically called when the game is started.
	 * @since 0.1
	 */
	public void initialize()
	{
		LOG.log(Level.INFO, "Initialize");
		for (GameComponent component : Components.getGameComponents())
		{
			component.initialize();
		}
	}

	/**
	 * Loads the content of the Game.
	 * This method is automatically called when the game is started.
	 * @since 0.1
	 */
	public void loadContent()
	{
		LOG.log(Level.INFO, "LoadContent");
		texture = Content.load(Texture2D.class, "content/images/umbrella.png");
		for (DrawableGameComponent component : Components.getDrawableGameComponents())
		{
			component.loadContent();
		}
	}

	/**
	 * Updates the Game.
	 * This method is automatically called once every frame.
	 * @since 0.1
	 */
	public void update()
	{
		KeyboardState keyboard = Keyboard.getState();
		if (keyboard.isKeyDown(Keys.ESCAPE))
		{
			this.shutdown();
		}
		for (GameComponent component : Components.getGameComponents())
		{
			if (component.isEnabled())
			{
				component.update();
			}
		}
	}

	/**
	 * Draws the Game.
	 * This method is automatically called once every frame.
	 * @since 0.1
	 */
	public void draw()
	{
		spriteBatch.draw(texture, new Vector2(300, 300));
		for (DrawableGameComponent component : Components.getDrawableGameComponents())
		{
			if (component.isVisible())
			{
				component.draw(spriteBatch);
			}
		}
	}

	/**
	 * Shuts the Game down.
	 * This method is automatically called when the Window closes.
	 * @since 0.1
	 */
	public void shutdown()
	{
		LOG.log(Level.INFO, "Shutdown");
		running = false;
		System.exit(0);
	}

	/**
	 * Gets the current instance of the <code>Window</code> class.
	 * @return The current instance of the <code>Window</code> class.
	 * @since 0.1
	 */
	public Window getWindow()
	{
		return window;
	}

	/**
	 * Checks if the main game loop is running or not.
	 * @return The current state of the main game loop.
	 * @since 0.1
	 */
	public boolean isRunning()
	{
		return running;
	}
}
