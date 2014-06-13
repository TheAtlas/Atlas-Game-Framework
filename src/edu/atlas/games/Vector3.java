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
 * @todo Write documentation
 * @author David Verhaak <david@forcez.nl>
 * @since 0.1
 */
public class Vector3
{

	/**
	 *
	 * @todo Write documentation
	 * @since 0.1
	 */
	public static final Vector3 ZERO = new Vector3(0, 0, 0);

	/**
	 *
	 * @todo Write documentation
	 * @param vector
	 * @param other
	 * @return
	 * @since 0.2
	 */
	public static Vector3 min(Vector3 vector, Vector3 other)
	{
		return Math.min(vector.getSquareLength(), other.getSquareLength()) == vector.getSquareLength() ? vector : other;
	}

	/**
	 *
	 * @todo Write documentation
	 * @param vector
	 * @param other
	 * @return
	 * @since 0.2
	 */
	public static Vector3 max(Vector3 vector, Vector3 other)
	{
		return Math.max(vector.getSquareLength(), other.getSquareLength()) == vector.getSquareLength() ? vector : other;
	}

	/**
	 *
	 * @todo Write documentation
	 * @since 0.1
	 */
	public float x;

	/**
	 *
	 * @todo Write documentation
	 * @since 0.1
	 */
	public float y;

	/**
	 *
	 * @todo Write documentation
	 * @since 0.1
	 */
	public float z;

	/**
	 *
	 * @todo Write documentation
	 * @param x
	 * @param y
	 * @param z
	 * @since 0.1
	 */
	public Vector3(float x, float y, float z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 *
	 * @todo Write documentation
	 * @param vector
	 * @param z
	 * @since 0.1
	 */
	public Vector3(Vector2 vector, float z)
	{
		this(vector.x, vector.y, z);
	}

	/**
	 *
	 * @todo Write documentation
	 * @param vector
	 * @return
	 * @since 0.2
	 */
	public float getDistanceTo(Vector3 vector)
	{
		return (float) Math.sqrt(((vector.x - x) * (vector.x - x)) + ((vector.y - y) * (vector.y - y)) + ((vector.z - z) * (vector.z - z)));
	}

	/**
	 *
	 * @todo Write documentation
	 * @param vector
	 * @since 0.1
	 */
	public void add(Vector3 vector)
	{
		this.x += vector.x;
		this.y += vector.y;
		this.z += vector.z;
	}

	/**
	 *
	 * @todo Write documentation
	 * @param vector
	 * @since 0.1
	 */
	public void substract(Vector3 vector)
	{
		this.x -= vector.x;
		this.y -= vector.y;
		this.z -= vector.z;
	}

	/**
	 *
	 * @todo Write documentation
	 * @param vector
	 * @since 0.1
	 */
	public void multiply(Vector3 vector)
	{
		this.x *= vector.x;
		this.y *= vector.y;
		this.z *= vector.z;
	}

	/**
	 *
	 * @todo Write documentation
	 * @param vector
	 * @since 0.1
	 */
	public void divide(Vector3 vector)
	{
		this.x /= vector.x;
		this.y /= vector.y;
		this.z /= vector.z;
	}

	/**
	 *
	 * @todo Write documentation
	 * @param min
	 * @param max
	 * @since 0.2
	 */
	public void clamp(Vector3 min, Vector3 max)
	{
		x = (x < min.x) ? min.x : (x > max.x) ? max.x : x;
		y = (y < min.y) ? min.y : (y > max.y) ? max.y : y;
		z = (z < min.z) ? min.z : (z > max.z) ? max.z : z;
	}

	/**
	 *
	 * @todo Write documentation
	 * @param vector
	 * @return
	 * @since 0.1
	 */
	public boolean equals(Vector3 vector)
	{
		return x == vector.x && y == vector.y && z == vector.z;
	}

	/**
	 *
	 * @param matrix
	 * @since 0.2
	 */
	public void transform(Matrix matrix)
	{
		float resX = matrix.m10 * x + matrix.m20 * y + matrix.m30 * z;
		float resY = matrix.m11 * x + matrix.m21 * y + matrix.m31 * z;
		float resZ = matrix.m12 * x + matrix.m22 * y + matrix.m32 * z;
		this.x = resX;
		this.y = resY;
		this.z = resZ;
	}

	/**
	 *
	 * @return
	 * @since 0.2
	 */
	public float getSquareLength()
	{
		return x * x + y * y + z * z;
	}

	/**
	 *
	 * @todo Write documentation
	 * @return
	 * @since 0.1
	 */
	@Override
	public String toString()
	{
		return "X: " + x + ", Y: " + y + ", Z: " + z;
	}

}
