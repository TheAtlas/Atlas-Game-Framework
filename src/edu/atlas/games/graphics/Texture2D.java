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
package edu.atlas.games.graphics;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import edu.atlas.games.Vector2;

/**
 *
 * @todo Write documentation
 * @author David Verhaak <david@forcez.nl>
 * @since 0.1
 */
public class Texture2D extends BufferedImage
{

	private static final Logger LOG = Logger.getLogger(Texture2D.class.getName());

	/**
	 *
	 * @todo Write documentation
	 * @param width
	 * @param height
	 * @since 0.1
	 */
	public Texture2D(int width, int height)
	{
		super(width, height, TYPE_INT_ARGB);
	}

	/**
	 *
	 * @todo Write documentation
	 * @param width
	 * @param height
	 * @param type
	 * @since 0.1
	 */
	public Texture2D(int width, int height, int type)
	{
		super(width, height, type);
	}

	/**
	 *
	 * @todo Write documentation
	 * @param colorModel
	 * @param raster
	 * @param isRasterPremultiplied
	 * @param properties
	 * @since 0.1
	 */
	public Texture2D(ColorModel colorModel, WritableRaster raster, boolean isRasterPremultiplied, Hashtable<?, ?> properties)
	{
		super(colorModel, raster, isRasterPremultiplied, properties);
	}

	/**
	 *
	 * @todo Write documentation
	 * @return
	 * @since 0.1
	 */
	public List<Vector2> getEdges()
	{
		List<Vector2> result = new LinkedList<>();
		int previousPixel = -1;
		for (int x = 0; x < getWidth(); x++)
		{
			for (int y = 0; y < getHeight(); y++)
			{
				int pixel = getRaster().getPixel(x, y, new int[4])[3];
				if (pixel != 0)
				{
					if (previousPixel < 255)
					{
						Vector2 vector = new Vector2(x, y);
						result.add(vector);
						LOG.info(vector.toString());
					}
					previousPixel = pixel;
				}
			}
		}
		return result;
	}
}
