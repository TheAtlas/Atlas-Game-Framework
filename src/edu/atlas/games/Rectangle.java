package edu.atlas.games;

/**
 *
 * @author David Verhaak <david@forcez.nl>
 */
public class Rectangle 
{

	public float x;
	public float y;
	public float width;
	public float height;
	
	public Rectangle(float x, float y, float width, float height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public float getLeft()
	{
		return x;
	}
	
	public float getRight()
	{
		return x + width;
	}
	
	public float getTop()
	{
		return y;
	}
	
	public float getBottom()
	{
		return y + height;
	}
}
