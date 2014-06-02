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
