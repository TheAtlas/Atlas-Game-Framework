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
package edu.atlas.games.content;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import edu.atlas.games.graphics.Texture2D;
import edu.atlas.games.media.Song;
import edu.atlas.games.util.TimeSpan;

/**
 *
 * @todo Write documentation
 * @author David Verhaak <david@forcez.nl>
 * @since 0.1
 */
public class Content
{

	/**
	 *
	 * @todo Write documentation
	 * @param <T>
	 * @param type
	 * @param url
	 * @return
	 * @since 0.2
	 */
	public static <T> T load(Class<T> type, String url)
	{
		try
		{
			if (type == Texture2D.class)
			{
				BufferedImage image = ImageIO.read(new File(url));
				Texture2D texture = new Texture2D(image.getWidth(), image.getHeight(), image.getType());
				texture.setData(image.getData());
				return type.cast(texture);
			}
			if (type == Song.class)
			{
				File file = new File(url);
				AudioFileFormat format = AudioSystem.getAudioFileFormat(file);
				String album = format.properties().get("album").toString();
				String author = format.properties().get("author").toString();
				TimeSpan duration = new TimeSpan((long) format.properties().get("duration") / 1000);
				String genre = format.properties().get("mp3.id3tag.genre").toString();
				String title = format.properties().get("title").toString();
				String track = format.properties().get("mp3.id3tag.track").toString();
				Song song = new Song(album, author, duration, genre, title, track, file);
				return type.cast(song);
			}
		} catch (IOException | UnsupportedAudioFileException exception)
		{
			Logger.getLogger(Content.class.getName()).log(Level.SEVERE, null, exception);
		}
		return null;
	}

	/**
	 *
	 * @todo Write documentation
	 * @param url
	 * @return
	 * @since 0.1
	 * @deprecated Replaced as for version 0.2. Use {@link #load(java.lang.Class, java.lang.String)} instead.
	 */
	public static Texture2D load(String url)
	{
		try
		{
			BufferedImage image = ImageIO.read(new File(url));
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
