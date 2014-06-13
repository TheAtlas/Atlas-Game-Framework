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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.media.opengl.GL2;

import edu.atlas.games.graphics.SpriteBatch;
import edu.atlas.games.graphics.Texture2D;
import edu.atlas.games.input.ButtonState;
import edu.atlas.games.input.Keyboard;
import edu.atlas.games.input.Mouse;
import edu.atlas.games.input.MouseState;


public class Game implements Runnable
{
	
	private static final Logger LOG = Logger.getLogger(Game.class.getName());

	private final int TARGET_FPS = 60;
	private final long OPTIMAL_TIME = 1000 / TARGET_FPS;
	private final int MAX_FRAME_SKIPS = 5;
	
	private long timeStarted;
	private int framesSkipped;
	private long timeDifference;
	private long sleepTime;
	private long timeInitialized;
	private long lastStatusStore;
	private long statusIntervalTimer;
	private long totalFramesSkipped;
	private long framesSkippedPerStatCycle;
	private int frameCountPerStatCycle;
	private long totalFrameCount;
	private double[] fpsStore;
	private long statsCount;
	private double averageFPS;
	
	private boolean running;
	
	private Window window;
	private SpriteBatch spriteBatch;
		
	private Texture2D texture;
	private List<Vector2> edges;

	public Game()
	{
		window = new Window(this);
		spriteBatch = new SpriteBatch(this);
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new Keyboard());
	}
	
	@Override
	public void run()
	{
		initialize();
		loadContent();
		window.setVisible(true);
		running = true;
		timeInitialized = System.currentTimeMillis();
		while(running)
		{
			timeStarted = System.currentTimeMillis();
			framesSkipped = 0;
			update();
			window.getCanvas().display();
			timeDifference = System.currentTimeMillis() - timeStarted;
			sleepTime = OPTIMAL_TIME - timeDifference;
			if(sleepTime > 0)
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
			while(sleepTime < 0 && framesSkipped < MAX_FRAME_SKIPS)
			{
				update();
				sleepTime += OPTIMAL_TIME;
				framesSkipped++;
			}
		}
		shutdown();
	}
	
	public void initialize()
	{
		LOG.log(Level.INFO, "Initialize");
		for(GameComponent component : Components.getGameComponents())
		{
			component.initialize();
		}
	}
	
	public void loadContent()
	{
		LOG.log(Level.INFO, "LoadContent");
		texture = Content.load("content/images/umbrella.png");
		for(DrawableGameComponent component : Components.getDrawableGameComponents())
		{
			component.loadContent();
		}
	}
	
	public void update()
	{
		MouseState mouseState = Mouse.getState();
		if(mouseState.getLeftButton() == ButtonState.PRESSED)
		{
			System.out.println("Left mouse click");
		}
		for(GameComponent component : Components.getGameComponents())
		{
			if(component.isEnabled())
			{
				component.update();
			}
		}
	}
	
	public void draw()
	{
		spriteBatch.draw(texture, new Vector2(0, 0));
		for(DrawableGameComponent component : Components.getDrawableGameComponents())
		{
			if(component.isVisible())
			{
				component.draw(spriteBatch);
			}
		}
	}
	
	public void shutdown()
	{
		LOG.log(Level.INFO, "Shutdown");
		running = false;
		System.exit(0);
	}
	
	public GL2 getGL()
	{
		return window.getCanvas().getGL().getGL2();
	}
	
	public Window getWindow()
	{
		return window;
	}
	
	public Vector2 getSize()
	{
		return new Vector2(window.getCanvas().getWidth(), window.getCanvas().getHeight());
	}
	
	public boolean isRunning()
	{
		return running;
	}
}
