package edu.atlas.games.input;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public class Keyboard implements KeyEventDispatcher
{

	private static final Logger LOG = Logger.getLogger(Keyboard.class.getName());

	private static List<Keys> keys = new LinkedList<Keys>();

	public static KeyboardState getState()
	{
		return KeyboardState.getInstance();
	}

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
