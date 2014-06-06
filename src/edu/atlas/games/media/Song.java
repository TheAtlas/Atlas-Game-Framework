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
package edu.atlas.games.media;

import java.io.File;

import edu.atlas.games.util.TimeSpan;

/**
 *
 * @todo Write documentation
 * @author David Verhaak <david@forcez.nl>
 * @since 0.2
 */
public class Song
{

	private String album;
	private String artist;
	private TimeSpan duration;
	private String genre;
	private String name;
	private String trackNumber;
	private File source;

	/**
	 *
	 * @todo Write documentation
	 * @param album
	 * @param artist
	 * @param duration
	 * @param genre
	 * @param name
	 * @param trackNumber
	 * @param source
	 * @since 0.2
	 */
	public Song(String album, String artist, TimeSpan duration, String genre, String name, String trackNumber, File source)
	{
		this.album = album;
		this.artist = artist;
		this.duration = duration;
		this.genre = genre;
		this.name = name;
		this.trackNumber = trackNumber;
		this.source = source;
	}

	/**
	 *
	 * @todo Write documentation
	 * @return
	 * @since 0.2
	 */
	public String getAlbum()
	{
		return album;
	}

	/**
	 *
	 * @todo Write documentation
	 * @param album
	 * @since 0.2
	 */
	public void setAlbum(String album)
	{
		this.album = album;
	}

	/**
	 *
	 * @todo Write documentation
	 * @return
	 * @since 0.2
	 */
	public String getArtist()
	{
		return artist;
	}

	/**
	 *
	 * @todo Write documentation
	 * @param artist
	 * @since 0.2
	 */
	public void setArtist(String artist)
	{
		this.artist = artist;
	}

	/**
	 *
	 * @todo Write documentation
	 * @return
	 * @since 0.2
	 */
	public TimeSpan getDuration()
	{
		return duration;
	}

	/**
	 *
	 * @todo Write documentation
	 * @param duration
	 * @since 0.2
	 */
	public void setDuration(TimeSpan duration)
	{
		this.duration = duration;
	}

	/**
	 *
	 * @todo Write documentation
	 * @return
	 * @since 0.2
	 */
	public String getGenre()
	{
		return genre;
	}

	/**
	 *
	 * @todo Write documentation
	 * @param genre
	 * @since 0.2
	 */
	public void setGenre(String genre)
	{
		this.genre = genre;
	}

	/**
	 *
	 * @todo Write documentation
	 * @return
	 * @since 0.2
	 */
	public String getName()
	{
		return name;
	}

	/**
	 *
	 * @todo Write documentation
	 * @param name
	 * @since 0.2
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 *
	 * @todo Write documentation
	 * @return
	 * @since 0.2
	 */
	public String getTrackNumber()
	{
		return trackNumber;
	}

	/**
	 *
	 * @todo Write documentation
	 * @param trackNumber
	 * @since 0.2
	 */
	public void setTrackNumber(String trackNumber)
	{
		this.trackNumber = trackNumber;
	}

	/**
	 *
	 * @todo Write documentation
	 * @return
	 * @since 0.2
	 */
	public File getSource()
	{
		return source;
	}

	/**
	 *
	 * @todo Write documentation
	 * @param source
	 * @since 0.2
	 */
	public void setSource(File source)
	{
		this.source = source;
	}

	/**
	 *
	 * @todo Write documentation
	 * @return
	 * @since 0.2
	 */
	@Override
	public String toString()
	{
		return "Song{" + "album=" + album + ", artist=" + artist + ", duration=" + duration + ", genre=" + genre + ", name=" + name + ", trackNumber=" + trackNumber + ", source=" + source + '}';
	}

}
