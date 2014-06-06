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
public class Vector2
{

	/**
	 *
	 * @todo Write documentation
	 * @since 0.1
	 */
	public static final Vector2 ZERO = new Vector2(0, 0);

	/**
	 *
	 * @todo Write documentation
	 * @param vector
	 * @param other
	 * @return
	 * @since 0.2
	 */
	public static Vector2 min(Vector2 vector, Vector2 other)
	{
		return (Math.min(vector.getSquareLength(), other.getSquareLength()) == vector.getSquareLength()) ? vector : other;
	}

	/**
	 *
	 * @todo Write documentation
	 * @param vector
	 * @param other
	 * @return
	 * @since 0.2
	 */
	public static Vector2 max(Vector2 vector, Vector2 other)
	{
		return (Math.max(vector.getSquareLength(), other.getSquareLength()) == vector.getSquareLength()) ? vector : other;
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
	 * @param x
	 * @param y
	 * @since 0.1
	 */
	public Vector2(float x, float y)
	{
		this.x = x;
		this.y = y;
	}

	/**
	 *
	 * @todo Write documentation
	 * @param vector
	 * @return
	 * @since 0.2
	 */
	public float getDistanceTo(Vector2 vector)
	{
		return (float) Math.sqrt(((vector.x - x) * (vector.x - x)) + ((vector.y - y) * (vector.y - y)));
	}

	/**
	 *
	 * @todo Write documentation
	 * @param vector
	 * @since 0.1
	 */
	public void add(Vector2 vector)
	{
		this.x += vector.x;
		this.y += vector.y;
	}

	/**
	 *
	 * @todo Write documentation
	 * @param vector
	 * @since 0.1
	 */
	public void substract(Vector2 vector)
	{
		this.x -= vector.x;
		this.y -= vector.y;
	}

	/**
	 *
	 * @todo Write documentation
	 * @param vector
	 * @since 0.1
	 */
	public void multiply(Vector2 vector)
	{
		this.x *= vector.x;
		this.y *= vector.y;
	}

	/**
	 *
	 * @todo Write documentation
	 * @param vector
	 * @since 0.1
	 */
	public void divide(Vector2 vector)
	{
		this.x /= vector.x;
		this.y /= vector.y;
	}

	/**
	 *
	 * @todo Write documentation
	 * @param min
	 * @param max
	 * @todo Write method Logic
	 * @since 0.2
	 */
	public void clamp(Vector2 min, Vector2 max)
	{
		x = (x < min.x) ? min.x : (x > max.x) ? max.x : x;
		y = (y < min.y) ? min.y : (y > max.y) ? max.y : y;
	}

	/**
	 *
	 * @todo Write documentation
	 * @param vector
	 * @return
	 * @since 0.1
	 */
	public boolean equals(Vector2 vector)
	{
		return x == vector.x && y == vector.y;
	}

	/**
	 *
	 * @param matrix
	 * @since 0.2
	 */
	public void transform(Matrix matrix)
	{
		float resX = matrix.m10 * x + matrix.m20 * y;
		float resY = matrix.m11 * x + matrix.m21 * y;
		this.x = resX;
		this.y = resY;
	}

	/**
	 *
	 * @return
	 * @since 0.2
	 */
	public float getSquareLength()
	{
		return x * x + y * y;
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
		return "X: " + x + ", Y: " + y;
	}

}
