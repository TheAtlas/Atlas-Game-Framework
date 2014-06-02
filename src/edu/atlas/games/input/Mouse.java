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
