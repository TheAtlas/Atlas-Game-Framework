package edu.atlas.games.graphics;

import java.awt.Color;
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
