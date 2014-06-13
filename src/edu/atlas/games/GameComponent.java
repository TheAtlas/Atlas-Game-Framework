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
 *
 * @author David Verhaak <david@forcez.nl>
 */
public abstract class GameComponent 
{
	
	private String name;
	private int updateOrder;
	private boolean enabled;
	
	public GameComponent(Game game, String name)
	{
		this.name = name;
		this.enabled = true;
		this.updateOrder = 1;
	}

	public GameComponent(Game game)
	{
		this(game, "Unnamed GameComponent");
	}
	
	public abstract void initialize();
	
	public abstract void update();
	
	public abstract void dispose();
	
	public String getName()
	{
		return name;
	}
	
	public boolean isEnabled()
	{
		return enabled;
	}
	
	public int getUpdateOrder()
	{
		return updateOrder;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setEnabled(boolean enabled)
	{
		this.enabled = enabled;
	}
	
	public void setUpdateOrder(int updateOrder)
	{
		this.updateOrder = updateOrder;
	}
}
