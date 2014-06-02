package edu.atlas.games;

/**
 *
 * @author David Verhaak <david@forcez.nl>
 */
public class Vector3 
{
	
	public static final Vector3 ZERO = new Vector3(0, 0, 0);

	public float x;
	public float y;
	public float z;
	
	public Vector3(float x, float y, float z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vector3(Vector2 vector, float z)
	{
		this(vector.x, vector.y, z);
	}
	
	public float getDistanceTo(Vector3 vector)
	{
		throw new UnsupportedOperationException("TODO");
	}
	
	public void add(Vector3 vector)
	{
		this.x += vector.x;
		this.y += vector.y;
		this.z += vector.z;
	}
	
	public void substract(Vector3 vector)
	{
		this.x -= vector.x;
		this.y -= vector.y;
		this.z -= vector.z;
	}
	
	public void multiply(Vector3 vector)
	{
		this.x *= vector.x;
		this.y *= vector.y;
		this.z *= vector.z;
	}
	
	public void divide(Vector3 vector)
	{
		this.x /= vector.x;
		this.y /= vector.y;
		this.z /= vector.z;
	}
	
	public void clamp(Vector3 min, Vector3 max)
	{
		throw new UnsupportedOperationException("TODO");
	}
	
	public void min(Vector3 vector)
	{
		throw new UnsupportedOperationException("TODO");
	}
	
	public void max(Vector3 vector)
	{
		throw new UnsupportedOperationException("TODO");
	}
	
	public boolean equals(Vector3 vector)
	{
		return x == vector.x && y == vector.y && z == vector.z;
	}
	
	@Override
	public String toString()
	{
		return "X: " + x + ", Y: " + y + ", Z: " + z;
	}
}
