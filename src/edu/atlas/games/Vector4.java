package edu.atlas.games;

/**
 *
 * @author David Verhaak <david@forcez.nl>
 */
public class Vector4 
{
	
	public static final Vector4 ZERO = new Vector4(0, 0, 0, 0);

	public float x;
	public float y;
	public float z;
	public float w;
	
	public Vector4(float x, float y, float z, float w)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
	
	public Vector4(Vector3 vector, float w)
	{
		this(vector.x, vector.y, vector.z, w);
	}
	
	public Vector4(Vector2 vector, Vector2 secondVector)
	{
		this(vector.x, vector.y, secondVector.x, secondVector.y);
	}
	
	public float getDistanceTo(Vector4 vector)
	{
		throw new UnsupportedOperationException("TODO");
	}
	
	public void add(Vector4 vector)
	{
		this.x += vector.x;
		this.y += vector.y;
		this.z += vector.z;
		this.w += vector.w;
	}
	
	public void substract(Vector4 vector)
	{
		this.x -= vector.x;
		this.y -= vector.y;
		this.z -= vector.z;
		this.w -= vector.w;
	}
	
	public void multiply(Vector4 vector)
	{
		this.x *= vector.x;
		this.y *= vector.y;
		this.z *= vector.z;
		this.w *= vector.w;
	}
	
	public void divide(Vector4 vector)
	{
		this.x /= vector.x;
		this.y /= vector.y;
		this.z /= vector.z;
		this.w /= vector.w;
	}
	
	public void clamp(Vector4 min, Vector4 max)
	{
		throw new UnsupportedOperationException("TODO");
	}
	
	public void min(Vector4 other)
	{
		throw new UnsupportedOperationException("TODO");
	}
	
	public void max(Vector4 other)
	{
		throw new UnsupportedOperationException("TODO");
	}
	
	public boolean equals(Vector4 vector)
	{
		return x == vector.x && y == vector.y && z == vector.z && w == vector.w;
	}
	
	@Override
	public String toString()
	{
		return "X: " + x + ", Y: " + y + ", Z: " + z + ", W: " + w;
	}
}
