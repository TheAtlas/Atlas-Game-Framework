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

/**
 * Handles the creation of GameComponents.
 * @author David Verhaak <david@forcez.nl>
 * @since 0.1
 */
public abstract class GameComponent
{

	private String name;
	private int updateOrder;
	private boolean enabled;

	/**
	 * Instanciates a GameComponent by setting the instance of the Game object,
	 * setting the name of the GameComponent and setting it's updateOrder to 1.
	 * @param game The current instance of the Game.
	 * @param name The name of the GameComponent.
	 * @since 0.1
	 */
	public GameComponent(Game game, String name)
	{
		this.name = name;
		this.enabled = true;
		this.updateOrder = 1;
	}

	/**
	 * Instanciates a GameComponent by setting the instance of the Game object,
	 * setting the name to the default name and setting it's updateOrder to 1.
	 * @param game The current instance of the Game.
	 * @since 0.1
	 */
	public GameComponent(Game game)
	{
		this(game, "Unnamed GameComponent");
	}

	/**
	 * Initializes the GameComponent.
	 * This method is automatically called at the initialization of the Game.
	 * @since 0.1
	 */
	public abstract void initialize();

	/**
	 * Updates the GameComponent.
	 * This method is automatically called once every frame.
	 * @since 0.1
	 */
	public abstract void update();

	/**
	 * Disposes the GameComponent.
	 * This method is automatically called when the Game is shutting down or
	 * when the Components list will be disposed.
	 * @since 0.1
	 */
	public abstract void dispose();

	/**
	 * Gets the name of the GameComponent.
	 * @return The name of the GameComponent.
	 * @since 0.1
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Gets the availability of the GameComponent.
	 * @return Returns true if the GameComponent is enabled.
	 * @since 0.1
	 */
	public boolean isEnabled()
	{
		return enabled;
	}

	/**
	 * Gets the update order of the GameComponent.
	 * @return The update order of the GameComponent.
	 * @since 0.1
	 */
	public int getUpdateOrder()
	{
		return updateOrder;
	}

	/**
	 * Sets the name of the GameComponent to the specified value.
	 * @param name The new name of the GameComponent.
	 * @since 0.1
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Sets the availability of the GameComponent
	 * @param enabled The new availability state of the GameComponent.
	 * @since 0.1
	 */
	public void setEnabled(boolean enabled)
	{
		this.enabled = enabled;
	}

	/**
	 * Sets the update order of the GameComponent.
	 * @param updateOrder The new update order of the GameComponent.
	 * @since 0.1
	 */
	public void setUpdateOrder(int updateOrder)
	{
		this.updateOrder = updateOrder;
	}
}
