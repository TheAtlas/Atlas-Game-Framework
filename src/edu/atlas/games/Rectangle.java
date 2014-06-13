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
public class Rectangle
{

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
	public float width;

	/**
	 *
	 * @todo Write documentation
	 * @since 0.1
	 */
	public float height;

	/**
	 *
	 * @todo Write documentation
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @since 0.1
	 */
	public Rectangle(float x, float y, float width, float height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	/**
	 *
	 * @todo Write documentation
	 * @return
	 * @since 0.1
	 */
	public float getLeft()
	{
		return x;
	}

	/**
	 *
	 * @todo Write documentation
	 * @return
	 * @since 0.1
	 */
	public float getRight()
	{
		return x + width;
	}

	/**
	 *
	 * @todo Write documentation
	 * @return
	 * @since 0.1
	 */
	public float getTop()
	{
		return y;
	}

	/**
	 *
	 * @todo Write documentation
	 * @return
	 * @since 0.1
	 */
	public float getBottom()
	{
		return y + height;
	}

	/**
	 *
	 * @todo Write documentation
	 * @return
	 * @since 0.2
	 */
	public Vector2 getTopLeft()
	{
		return new Vector2(x, y);
	}

	/**
	 *
	 * @todo Write documentation
	 * @return
	 * @since 0.2
	 */
	public Vector2 getTopRight()
	{
		return new Vector2(x + width, y);
	}

	/**
	 *
	 * @todo Write documentation
	 * @return
	 * @since 0.2
	 */
	public Vector2 getBottomLeft()
	{
		return new Vector2(x, y + height);
	}

	/**
	 *
	 * @todo Write documentation
	 * @return
	 * @since 0.2
	 */
	public Vector2 getBottomRight()
	{
		return new Vector2(x + width, y + height);
	}

	/**
	 *
	 * @todo Write documentation
	 * @param point
	 * @return
	 * @since 0.2
	 */
	public boolean contains(Vector2 point)
	{
		return (point.x >= x && point.x <= x + width) && (point.y >= y && point.y <= y + height);
	}

	/**
	 *
	 * @todo Write documentation
	 * @param other
	 * @return
	 * @since 0.2
	 */
	public boolean intersects(Rectangle other)
	{
		return (contains(other.getTopLeft()) || contains(other.getTopRight()) || contains(other.getBottomLeft()) || contains(other.getBottomRight()));
	}
}
