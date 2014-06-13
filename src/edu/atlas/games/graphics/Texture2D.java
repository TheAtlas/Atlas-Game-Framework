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


public class Texture2D extends BufferedImage
{
	
	private static final Logger LOG = Logger.getLogger(Texture2D.class.getName());

	public Texture2D(int width, int height)
	{
		super(width, height, TYPE_INT_ARGB);
	}
	
	public Texture2D(int width, int height, int type)
	{
		super(width, height, type);
	}
	
	public Texture2D(ColorModel colorModel, WritableRaster raster, boolean isRasterPremultiplied, Hashtable<?, ?> properties)
	{
		super(colorModel, raster, isRasterPremultiplied, properties);
	}
	
	public List<Vector2> getEdges()
	{
		List<Vector2> result = new LinkedList<>();
		
		/*for(int x = 0; x < this.getWidth(); x++)
		{
			for(int y = 0; y < this.getHeight(); y++)
			{
				if(getRaster().getPixel(x, y, new int[4])[3] != 0)
				{
					Vector2 vector = new Vector2(x, y);
					LOG.info(vector.toString());
					result.add(vector);
				}
			}
		}*/
		int previousPixel = -1;
		for(int x = 0; x < getWidth(); x++)
		{
			for(int y = 0; y < getHeight(); y++)
			{
				int pixel = getRaster().getPixel(x, y, new int[4])[3];
				if(pixel != 0)
				{
					if(previousPixel < 255)
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
