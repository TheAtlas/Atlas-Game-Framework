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
public class Vector4
{

	/**
	 *
	 * @todo Write documentation
	 * @since 0.1
	 */
	public static final Vector4 ZERO = new Vector4(0, 0, 0, 0);

	/**
	 *
	 * @todo Write documentation
	 * @param vector
	 * @param other
	 * @return
	 * @since 0.2
	 */
	public static Vector4 min(Vector4 vector, Vector4 other)
	{
		return Math.min(vector.getSquareLength(), other.getSquareLength()) == vector.getSquareLength() ? vector : other;
	}

	/**
	 *
	 * @todo Write documentation
	 * @param vector
	 * @param other
	 * @return
	 * @todo Write method Logic
	 * @since 0.2
	 */
	public static Vector4 max(Vector4 vector, Vector4 other)
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
	 * @since 0.1
	 */
	public float w;

	/**
	 *
	 * @todo Write documentation
	 * @param x
	 * @param y
	 * @param z
	 * @param w
	 * @since 0.1
	 */
	public Vector4(float x, float y, float z, float w)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}

	/**
	 *
	 * @todo Write documentation
	 * @param vector
	 * @param w
	 * @since 0.1
	 */
	public Vector4(Vector3 vector, float w)
	{
		this(vector.x, vector.y, vector.z, w);
	}

	/**
	 *
	 * @todo Write documentation
	 * @param vector
	 * @param secondVector
	 * @since 0.1
	 */
	public Vector4(Vector2 vector, Vector2 secondVector)
	{
		this(vector.x, vector.y, secondVector.x, secondVector.y);
	}

	/**
	 *
	 * @todo Write documentation
	 * @param vector
	 * @since 0.1
	 */
	public void add(Vector4 vector)
	{
		this.x += vector.x;
		this.y += vector.y;
		this.z += vector.z;
		this.w += vector.w;
	}

	/**
	 *
	 * @todo Write documentation
	 * @param vector
	 * @since 0.1
	 */
	public void substract(Vector4 vector)
	{
		this.x -= vector.x;
		this.y -= vector.y;
		this.z -= vector.z;
		this.w -= vector.w;
	}

	/**
	 *
	 * @todo Write documentation
	 * @param vector
	 * @since 0.1
	 */
	public void multiply(Vector4 vector)
	{
		this.x *= vector.x;
		this.y *= vector.y;
		this.z *= vector.z;
		this.w *= vector.w;
	}

	/**
	 *
	 * @todo Write documentation
	 * @param vector
	 * @since 0.1
	 */
	public void divide(Vector4 vector)
	{
		this.x /= vector.x;
		this.y /= vector.y;
		this.z /= vector.z;
		this.w /= vector.w;
	}

	/**
	 *
	 * @todo Write documentation
	 * @param min
	 * @param max
	 * @since 0.2
	 */
	public void clamp(Vector4 min, Vector4 max)
	{
		x = (x < min.x) ? min.x : (x > max.x) ? max.x : x;
		y = (y < min.y) ? min.y : (y > max.y) ? max.y : y;
		z = (z < min.z) ? min.z : (z > max.z) ? max.z : z;
		w = (w < min.w) ? min.w : (w > max.w) ? max.w : w;
	}

	/**
	 *
	 * @todo Write documentation
	 * @param vector
	 * @return
	 * @since 0.1
	 */
	public boolean equals(Vector4 vector)
	{
		return x == vector.x && y == vector.y && z == vector.z && w == vector.w;
	}

	/**
	 *
	 * @param matrix
	 * @since 0.2
	 */
	public void transform(Matrix matrix)
	{
		float resX = matrix.m10 * this.x + matrix.m20 * this.y + matrix.m30 * this.z + matrix.m40 * this.w;
		float resY = matrix.m11 * this.x + matrix.m21 * this.y + matrix.m31 * this.z + matrix.m41 * this.w;
		float resZ = matrix.m12 * this.x + matrix.m22 * this.y + matrix.m32 * this.z + matrix.m42 * this.w;
		float resW = matrix.m13 * this.x + matrix.m23 * this.y + matrix.m33 * this.z + matrix.m43 * this.w;
		this.x = resX;
		this.y = resY;
		this.z = resZ;
		this.w = resW;
	}

	/**
	 *
	 * @return
	 * @since 0.2
	 */
	public float getSquareLength()
	{
		return x * x + y * y + z * z + w * w;
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
		return "X: " + x + ", Y: " + y + ", Z: " + z + ", W: " + w;
	}

}
