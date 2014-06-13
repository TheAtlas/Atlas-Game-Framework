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
 * 
 * @author David <dverhaak@gmail.com>
 */
public class Components 
{
	
	private static final Logger LOG = Logger.getLogger(Components.class.getName());
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
	 * 
	 * @param component 
	 */
	public static void add(GameComponent component)
	{
		if(component == null)
		{
			throw new IllegalArgumentException("The GameComponent you're trying to add is a null.");
		} else if(Components.contains(component))
		{
			throw new IllegalArgumentException("The GameComponent you're trying to add is already added.");
		} else
		{
			components.add(component);
			Collections.sort(components, updateComparator);
		}
	}
	
	/**
	 * 
	 * @return 
	 */
	protected static List<GameComponent> getGameComponents()
	{
		return components;
	}
	
	/**
	 * 
	 * @return 
	 */
	protected static List<DrawableGameComponent> getDrawableGameComponents()
	{
		List<DrawableGameComponent> drawablecomponents = new LinkedList<>();
		for(GameComponent component : components)
		{
			if(component instanceof DrawableGameComponent)
			{
				drawablecomponents.add((DrawableGameComponent) component);
			}
		}
		Collections.sort(drawablecomponents, drawComparator);
		return drawablecomponents;
	}
	
	/**
	 * 
	 * @param name
	 * @return 
	 */
	public static GameComponent get(String name)
	{
		try
		{
			for(GameComponent component : components)
			{
				if(component.getName().equalsIgnoreCase(name))
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
	 * 
	 * @param position
	 * @return 
	 */
	public static GameComponent get(int position)
	{
		if(position < 0 || position >= components.size())
		{
			throw new IndexOutOfBoundsException("The position value to get the GameComponent of is out of bounds.");
		} else if(components.get(position) == null)
		{
			throw new NullPointerException("The object on the specified position is a null.");
		} else
		{
			return components.get(position);
		}
	}
	
	/**
	 * 
	 * @param component 
	 */
	public static void update(GameComponent component)
	{
		if(component == null)
		{
			throw new IllegalArgumentException("The component you're trying to update is a null.");
		} else if(!contains(component))
		{
			throw new IllegalArgumentException("The component you're trying to update doesn't exists.");
		} else
		{
			components.set(components.indexOf(component), component);
		}
	}
	
	/**
	 * 
	 * @param name 
	 */
	public static void remove(String name)
	{
		if(name == null || name.length() <= 0)
		{
			throw new IllegalArgumentException("The name of the object you're trying to remove is invalid.");
		} else if(!contains(name))
		{
			throw new IllegalArgumentException("The object you're trying to remove doesn't exists.");
		} else
		{
			GameComponent component = get(name);
			components.remove(component);
		}
	}
	
	/**
	 * 
	 * @param component 
	 */
	public static void remove(GameComponent component)
	{
		if(component == null)
		{
			throw new IllegalArgumentException("The component you specified to remove is a null.");
		} else if(!contains(component))
		{
			throw new IllegalArgumentException("The component you're trying to remove doesn't exists.");
		} else
		{
			components.remove(component);
		}
	}
	
	/**
	 * 
	 * @return 
	 */
	public static int getSize()
	{
		return components.size();
	}
	
	/**
	 * 
	 * @param component
	 * @return 
	 */
	public static boolean contains(GameComponent component)
	{
		return components.contains(component);
	}
	
	/**
	 * 
	 * @param name
	 * @return 
	 */
	public static boolean contains(String name)
	{
		for(GameComponent component : components)
		{
			if(component.getName().contains(name))
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 */
	protected static void dispose()
	{
		for(GameComponent component : components)
		{
			component.dispose();
		}
		components.clear();
	}
}
