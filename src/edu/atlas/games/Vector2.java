package edu.atlas.games;


public class Vector2 
{

	public static final Vector2 ZERO = new Vector2(0, 0);
	
	public float x;
	public float y;
	
	public Vector2(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	
	/**
	 * @todo Write method logic
	 * @param vector
	 * @return 
	 */
	public float getDistanceTo(Vector2 vector)
	{
		throw new UnsupportedOperationException("TODO");
	}
	
	public void add(Vector2 vector)
	{
		this.x += vector.x;
		this.y += vector.y;
	}
	
	public void substract(Vector2 vector)
	{
		this.x -= vector.x;
		this.y -= vector.y;
	}
	
	public void multiply(Vector2 vector)
	{
		this.x *= vector.x;
		this.y *= vector.y;
	}
	
	public void divide(Vector2 vector)
	{
		this.x /= vector.x;
		this.y /= vector.y;
	}
	
	/**
	 * @todo Write method logic
	 * @param min
	 * @param max
	 */
	public void clamp(Vector2 min, Vector2 max)
	{
		throw new UnsupportedOperationException("TODO");
	}
	
	/**
	 * @todo Write method logic
	 * @param other
	 */
	public void min(Vector2 other)
	{
		throw new UnsupportedOperationException("TODO");
	}
	
	/**
	 * @todo Write method logic
	 * @param other
	 */
	public void max(Vector2 other)
	{
		throw new UnsupportedOperationException("TODO");
	}
	
	public boolean equals(Vector2 vector)
	{
		return x == vector.x && y == vector.y;
	}
	
	@Override
	public String toString()
	{
		return "X: " + x + ", Y: " + y;
	}
}
