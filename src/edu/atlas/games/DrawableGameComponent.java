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
 *
 * @author David Verhaak <david@forcez.nl>
 */
public abstract class DrawableGameComponent extends GameComponent
{

	private int drawOrder;
	private boolean visible;
	
	public DrawableGameComponent(Game game, String name)
	{
		super(game, name);
	}
	
	public DrawableGameComponent(Game game)
	{
		super(game);
	}
	
	@Override
	public abstract void initialize();
	
	public abstract void loadContent();
	
	@Override
	public abstract void update();
	
	public abstract void draw(SpriteBatch spriteBatch);
	
	public int getDrawOrder()
	{
		return this.drawOrder;
	}
	
	public boolean isVisible()
	{
		return this.visible;
	}
	
	public void setDrawOrder(int drawOrder)
	{
		this.drawOrder = drawOrder;
	}
	
	public void setVisible(boolean visible)
	{
		this.visible = visible;
	}
}
