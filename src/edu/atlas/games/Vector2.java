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

package edu.atlas.games;

/**
 * 
 * @author David Verhaak <david@forcez.nl>
 */
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
