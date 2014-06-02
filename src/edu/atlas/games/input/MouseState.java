package edu.atlas.games.input;

import java.awt.event.MouseEvent;

import edu.atlas.games.Vector2;


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
