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

import edu.atlas.games.graphics.SpriteBatch;

/**
 * Handles the creation of DrawableGameComponents.
 * @author David Verhaak <david@forcez.nl>
 * @since 0.1
 */
public abstract class DrawableGameComponent extends GameComponent
{

	private int drawOrder;
	private boolean visible;

	/**
	 * Instanciates a DrawableGameComponent by calling {@link edu.atlas.games.GameComponent#GameComponent(edu.atlas.games.Game, java.lang.String)},
	 * setting the draw order to 1 and setting it's visibility on true.
	 * @param game The current instance of the Game.
	 * @param name The name of the DrawableGameComponent
	 * @see edu.atlas.games.GameComponent#GameComponent(edu.atlas.games.Game, java.lang.String)
	 * @since 0.1
	 */
	public DrawableGameComponent(Game game, String name)
	{
		super(game, name);
		this.drawOrder = 1;
		this.visible = true;
	}

	/**
	 * Instanciates a DrawableGameComponent by calling {@link edu.atlas.games.GameComponent#GameComponent(edu.atlas.games.Game)},
	 * setting the draw order to 1 and setting it's visibility on true.
	 * @param game The current instance of the Game.
	 * @see edu.atlas.games.GameComponent#GameComponent(edu.atlas.games.Game)
	 * @since 0.1
	 */
	public DrawableGameComponent(Game game)
	{
		super(game);
		this.drawOrder = 1;
		this.visible = true;
	}

	/**
	 * Initializes the DrawableGameComponent.
	 * This method is automatically called at the initialization of the Game.
	 * @since 0.1
	 */
	@Override
	public abstract void initialize();

	/**
	 * Loads the content of the DrawableGameComponent.
	 * This method is automatically called when the Game is loading content.
	 * @since 0.1
	 */
	public abstract void loadContent();

	/**
	 * Updates the DrawableGameComponent.
	 * This method is automatically called once every frame.
	 * @since 0.1
	 */
	@Override
	public abstract void update();

	/**
	 * Draws the DrawableGameComponent.
	 * This method is automatically called when the Game is Drawing.
	 * @param spriteBatch The current instance of the SpriteBatch.
	 * @since 0.1
	 */
	public abstract void draw(SpriteBatch spriteBatch);

	/**
	 * Gets the draw order of the DrawableGameComponent.
	 * @return The draw order of the DrawableGameComponent.
	 * @since 0.1
	 */
	public int getDrawOrder()
	{
		return this.drawOrder;
	}

	/**
	 * Gets the visibility state of the DrawableGameComponent.
	 * @return The visibility state of the DrawableGameComponent.
	 * @since 0.1
	 */
	public boolean isVisible()
	{
		return this.visible;
	}

	/**
	 * Sets the draw order of the DrawableGameComponent to the specified value.
	 * @param drawOrder The new draw order of the DrawableGameComponent.
	 * @since 0.1
	 */
	public void setDrawOrder(int drawOrder)
	{
		this.drawOrder = drawOrder;
	}

	/**
	 * Sets the visibility state of the DrawableGameComponent to the specified value.
	 * @param visible The new visibility state of the DrawableGameComponent.
	 * @since 0.1
	 */
	public void setVisible(boolean visible)
	{
		this.visible = visible;
	}
}
