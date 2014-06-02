package edu.atlas.games.input;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;


public class KeyboardState 
{
	
	private static final Logger LOG = Logger.getLogger(KeyboardState.class.getName());
	
	private static KeyboardState instance;
	
	private ButtonState[] keyStates;
	
	protected KeyboardState(List<Keys> keys)
	{
		keyStates = new ButtonState[250];
		for(Keys key : Keys.values())
		{
			keyStates[key.getCode()] = ButtonState.RELEASED;
		}
		for(Keys key : keys)
		{
			LOG.info("" + key.getCode());
			keyStates[key.getCode()] = ButtonState.PRESSED;
		}
	}
	
	private KeyboardState()
	{
		keyStates = new ButtonState[250];
		for(Keys key : Keys.values())
		{
			keyStates[key.getCode()] = ButtonState.RELEASED;
		}
	}
	
	protected static KeyboardState getInstance()
	{
		if(instance == null)
		{
			instance = new KeyboardState();
		}
		return instance;
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
