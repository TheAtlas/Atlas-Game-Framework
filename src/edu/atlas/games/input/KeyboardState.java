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

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 * 
 * @author David Verhaak <david@forcez.nl>
 */
public class KeyboardState 
{
	
	private static final Logger LOG = Logger.getLogger(KeyboardState.class.getName());
	
	private static KeyboardState instance;

	protected static KeyboardState getInstance()
	{
		if(instance == null)
		{
			instance = new KeyboardState();
		}
		return instance;
	}
	
	private ButtonState[] keyStates;
	
	private KeyboardState()
	{
		keyStates = new ButtonState[250];
		for(Keys key : Keys.values())
		{
			keyStates[key.getCode()] = ButtonState.RELEASED;
		}
	}
	
	protected void setKeyState(int keyCode, ButtonState state)
	{
		keyStates[keyCode] = state;
	}
	
	public boolean isKeyDown(Keys key)
	{
		return keyStates[key.getCode()] == ButtonState.PRESSED;
	}
	
	public boolean isKeyUp(Keys key)
	{
		return keyStates[key.getCode()] == ButtonState.RELEASED;
	}
	
	public List<Keys> getPressedKeys()
	{
		List<Keys> result = new LinkedList<>();
		for(Keys key : Keys.values())
		{
			if(keyStates[key.getCode()] == ButtonState.PRESSED)
			{
				result.add(key);
			}
		}
		return result;
	}
}
