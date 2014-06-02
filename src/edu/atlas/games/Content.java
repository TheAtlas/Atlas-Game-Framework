package edu.atlas.games;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import edu.atlas.games.graphics.Texture2D;

/**
 *
 * @author David Verhaak <david@forcez.nl>
 */
public class Content 
{

	public static Texture2D load(String url)
	{
		try
		{
			BufferedImage image = ImageIO.read(new File(url));
			//BufferedImage image = ImageIO.read(new URL(url));
			Texture2D texture = new Texture2D(image.getWidth(), image.getHeight(), image.getType());
			texture.setData(image.getData());
			return texture;
		} catch (IOException ex)
		{
			Logger.getLogger(Content.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}
}
