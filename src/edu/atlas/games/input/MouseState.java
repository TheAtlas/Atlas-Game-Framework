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

package edu.atlas.games.input;

import java.awt.event.MouseEvent;

import edu.atlas.games.Vector2;

/**
 * 
 * @author David Verhaak <david@forcez.nl>
 */
public class MouseState 
{

	private Vector2 position;
	private ButtonState leftButton;
	private ButtonState rightButton;
	private ButtonState middleButton;
	
	public MouseState()
	{
		position = Vector2.ZERO;
		leftButton = ButtonState.RELEASED;
		rightButton = ButtonState.RELEASED;
		middleButton = ButtonState.RELEASED;
	}
	
	protected void setEvent(MouseEvent mouseEvent)
	{
		position = new Vector2(mouseEvent.getX(), mouseEvent.getY());
		leftButton = mouseEvent.getButton() == 1 ? ButtonState.PRESSED : ButtonState.RELEASED;
		middleButton = mouseEvent.getButton() == 2 ? ButtonState.PRESSED : ButtonState.RELEASED;
		rightButton = mouseEvent.getButton() == 1 ? ButtonState.PRESSED : ButtonState.RELEASED;
	}
	
	public int getX()
	{
		return (int) position.x;
	}
	
	public int getY()
	{
		return (int) position.y;
	}
	
	public Vector2 getPosition()
	{
		return position;
	}
	
	public ButtonState getLeftButton()
	{
		return leftButton;
	}
	
	public ButtonState getRightButton()
	{
		return rightButton;
	}
	
	public ButtonState getMiddleButton()
	{
		return middleButton;
	}

	@Override
	public String toString()
	{
		return "MouseState{" + "position=" + position + ", leftButton=" + leftButton + ", rightButton=" + rightButton + ", middleButton=" + middleButton + '}';
	}
	
	
}
