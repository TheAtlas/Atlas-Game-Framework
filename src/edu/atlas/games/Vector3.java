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
