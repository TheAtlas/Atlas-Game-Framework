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
 * Allows the throwing of an <code>ObjectNotFoundException</code>.
 * @author David Verhaak <david@forcez.nl>
 * @since 0.1
 */
public class ObjectNotFoundException extends Exception
{

	/**
	 * Creates a new instance of <code>ObjectNotFoundException</code> without detail message.
	 * @since 0.1
	 */
	public ObjectNotFoundException()
	{
		super();
	}

	/**
	 * Constructs an instance of <code>ObjectNotFoundException</code> with the specified detail message.
	 * @param msg the detail message.
	 * @since 0.1
	 */
	public ObjectNotFoundException(String msg)
	{
		super(msg);
	}
}
