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

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Contains a list of GameComponents and DrawableGameComponents
 * @author David <dverhaak@gmail.com>
 * @see edu.atlas.games.GameComponent
 * @see edu.atlas.games.DrawableGameComponent
 * @since 0.1
 */
public class Components
{

	private static List<GameComponent> components = new LinkedList<>();

	private static Comparator<GameComponent> updateComparator = new Comparator<GameComponent>()
	{
		@Override
		public int compare(GameComponent component, GameComponent other)
		{
			return -(component.getUpdateOrder() - other.getUpdateOrder());
		}
	};

	private static Comparator<DrawableGameComponent> drawComparator = new Comparator<DrawableGameComponent>()
	{
		@Override
		public int compare(DrawableGameComponent component, DrawableGameComponent other)
		{
			return -(component.getDrawOrder() - other.getDrawOrder());
		}
	};

	/**
	 * Adds the specified GameComponent (or DrawableGameComponent) to the list of GameComponents.
	 * @param component The (Drawable)GameComponent that will be added to the list.
	 * @see edu.atlas.games.GameComponent
	 * @see edu.atlas.games.DrawableGameComponent
	 * @see java.lang.IllegalArgumentException
	 * @since 0.1
	 */
	public static void add(GameComponent component)
	{
		if (component == null)
		{
			throw new IllegalArgumentException("The GameComponent you're trying to add is a null.");
		} else if (Components.contains(component))
		{
			throw new IllegalArgumentException("The GameComponent you're trying to add is already added.");
		} else
		{
			components.add(component);
			Collections.sort(components, updateComparator);
		}
	}

	/**
	 * Retreives the List of (Drawable)GameComponents.
	 * @return The list of (Drawable)GameComponents
	 * @since 0.1
	 */
	protected static List<GameComponent> getGameComponents()
	{
		return components;
	}

	/**
	 * Retreives the List of DrawableGameComponents.
	 * @return The List of DrawableGameComponents.
	 * @since 0.1
	 */
	protected static List<DrawableGameComponent> getDrawableGameComponents()
	{
		List<DrawableGameComponent> drawablecomponents = new LinkedList<>();
		for (GameComponent component : components)
		{
			if (component instanceof DrawableGameComponent)
			{
				drawablecomponents.add((DrawableGameComponent) component);
			}
		}
		Collections.sort(drawablecomponents, drawComparator);
		return drawablecomponents;
	}

	/**
	 * Gets the (Drawable)GameComponent with the specified name from the list.
	 * @param name The name of the (Drawable)GameComponent that will be retrieved.
	 * @return The (Drawable)GameComponent with the specified name.
	 * @since 0.1
	 */
	public static GameComponent get(String name)
	{
		try
		{
			for (GameComponent component : components)
			{
				if (component.getName().equalsIgnoreCase(name))
				{
					return component;
				}
			}
			throw new ObjectNotFoundException("No GameComponent with the specified name exists.");
		} catch (ObjectNotFoundException ex)
		{
			Logger.getLogger(Components.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	/**
	 * Gets a (Drawable)GameComponent at the specified position from the list.
	 * @param position The position of the (Drawable)GameComponent that will be retrieved.
	 * @return The (Drawable)GameComponent on the specified position.
	 * @since 0.1
	 */
	public static GameComponent get(int position)
	{
		if (position < 0 || position >= components.size())
		{
			throw new IndexOutOfBoundsException("The position value to get the GameComponent of is out of bounds.");
		} else if (components.get(position) == null)
		{
			throw new NullPointerException("The object on the specified position is a null.");
		} else
		{
			return components.get(position);
		}
	}

	/**
	 * Removes the (Drawable)GameComponent with the specified name from the list.
	 * @param name The name of the (Drawable)GameComponent that will be removed.
	 * @since 0.1
	 */
	public static void remove(String name)
	{
		if (name == null || name.length() <= 0)
		{
			throw new IllegalArgumentException("The name of the object you're trying to remove is invalid.");
		} else if (!contains(name))
		{
			throw new IllegalArgumentException("The object you're trying to remove doesn't exists.");
		} else
		{
			GameComponent component = get(name);
			components.remove(component);
		}
	}

	/**
	 * Removes the specified (Drawable)GameComponent from the list.
	 * @param component The (Drawable)GameComponent that will be removed.
	 * @since 0.1
	 */
	public static void remove(GameComponent component)
	{
		if (component == null)
		{
			throw new IllegalArgumentException("The component you specified to remove is a null.");
		} else if (!contains(component))
		{
			throw new IllegalArgumentException("The component you're trying to remove doesn't exists.");
		} else
		{
			components.remove(component);
		}
	}

	/**
	 * Gets the amount of (Drawable)GameComponents in the list.
	 * @return The amount of (Drawable)GameComponents in the list.
	 * @since 0.1
	 */
	public static int getSize()
	{
		return components.size();
	}

	/**
	 * Checks if the list contains a specified (Drawable)GameComponent
	 * @param component The (Drawable)GameComponent to check it's existance of.
	 * @return Returns true if the (Drawable)GameComponent is in the list.
	 * @since 0.1
	 */
	public static boolean contains(GameComponent component)
	{
		return components.contains(component);
	}

	/**
	 * Checks if the list contains a (Drawable)GameComponent with the specified name.
	 * @param name The name of the (Drawable)GameComponent to check the existance of.
	 * @return Returns true if the (Drawable)GameComponent with the specified name exists in the list.
	 * @since 0.1
	 */
	public static boolean contains(String name)
	{
		for (GameComponent component : components)
		{
			if (component.getName().contains(name))
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * Clears the list of (Drawable)GameComponents.
	 * @since 0.1
	 */
	protected static void dispose()
	{
		for (GameComponent component : components)
		{
			component.dispose();
		}
		components.clear();
	}
}
