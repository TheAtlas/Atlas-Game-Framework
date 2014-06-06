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

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @todo Write documentation
 * @author David Verhaak <david@forcez.nl>
 * @since 0.1
 */
public class Keyboard implements KeyEventDispatcher
{

	private static final Logger LOG = Logger.getLogger(Keyboard.class.getName());

	private static List<Keys> keys = new LinkedList<>();

	/**
	 *
	 * @todo Write documentation
	 * @return
	 * @since 0.1
	 */
	public static KeyboardState getState()
	{
		return KeyboardState.getInstance();
	}

	/**
	 *
	 * @todo Write documentation
	 * @param keyEvent
	 * @return
	 * @since 0.1
	 */
	@Override
	public boolean dispatchKeyEvent(KeyEvent keyEvent)
	{
		switch (keyEvent.getID())
		{
			case KeyEvent.KEY_PRESSED:
				KeyboardState.getInstance().setKeyState(keyEvent.getKeyCode(), ButtonState.PRESSED);
				return false;
			case KeyEvent.KEY_RELEASED:
				KeyboardState.getInstance().setKeyState(keyEvent.getKeyCode(), ButtonState.RELEASED);
				return false;
		}
		return false;
	}
}
