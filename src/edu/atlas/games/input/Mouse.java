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
 * @todo Write documentation
 * @author David Verhaak <david@forcez.nl>
 * @since 0.1
 */
public class Mouse extends MouseAdapter
{

	private static MouseState mouseState;

	/**
	 *
	 * @todo Write documentation
	 * @return
	 * @since 0.1
	 */
	public static MouseState getState()
	{
		if (mouseState == null)
		{
			mouseState = new MouseState();
		}
		return mouseState;
	}

	/**
	 *
	 * @todo Write documentation
	 * @param mouseEvent
	 * @since 0.1
	 */
	@Override
	public void mouseClicked(MouseEvent mouseEvent)
	{
		getState().setEvent(mouseEvent);
	}

	/**
	 *
	 * @todo Write documentation
	 * @param mouseEvent
	 * @since 0.1
	 */
	@Override
	public void mouseMoved(MouseEvent mouseEvent)
	{
		getState().setEvent(mouseEvent);
	}

	/**
	 *
	 * @todo Write documentation
	 * @param mouseEvent
	 * @since 0.1
	 */
	@Override
	public void mousePressed(MouseEvent mouseEvent)
	{
		getState().setEvent(mouseEvent);
	}

	/**
	 *
	 * @todo Write documentation
	 * @param mouseEvent
	 * @since 0.1
	 */
	@Override
	public void mouseReleased(MouseEvent mouseEvent)
	{
		getState().setEvent(mouseEvent);
	}
}
