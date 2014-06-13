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

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author David Verhaak <david@forcez.nl>
 */
public class Mouse extends MouseAdapter
{
	
	private static MouseState mouseState;

	public static MouseState getState()
	{
		if(mouseState == null)
		{
			mouseState = new MouseState();
		}
		return mouseState;
	}
	
	@Override
	public void mouseClicked(MouseEvent mouseEvent)
	{
		mouseState.setEvent(mouseEvent);
	}
	
	@Override
	public void mouseMoved(MouseEvent mouseEvent)
	{
		mouseState.setEvent(mouseEvent);
	}
	
	@Override
	public void mousePressed(MouseEvent mouseEvent)
	{
		mouseState.setEvent(mouseEvent);
	}
	
	@Override
	public void mouseReleased(MouseEvent mouseEvent)
	{
		mouseState.setEvent(mouseEvent);
	}
	
	@Override
	public void mouseEntered(MouseEvent mouseEvent)
	{
		mouseState.setEvent(mouseEvent);
	}
	
	@Override
	public void mouseExited(MouseEvent mouseEvent)
	{
		mouseState.setEvent(mouseEvent);
	}
}
