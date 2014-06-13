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
package edu.atlas.games.util;

import java.util.concurrent.TimeUnit;

/**
 *
 * @todo Write documentation
 * @author David Verhaak <david@forcez.nl>
 * @since 0.2
 */
public class TimeSpan
{

	private int days;
	private int hours;
	private int minutes;
	private int seconds;
	private long milliseconds;

	/**
	 *
	 * @todo Write documentation
	 * @param milliseconds
	 * @since 0.2
	 */
	public TimeSpan(long milliseconds)
	{
		this.days = (int) TimeUnit.MILLISECONDS.toDays(milliseconds);
		milliseconds -= TimeUnit.DAYS.toMillis(days);
		this.hours = (int) TimeUnit.MILLISECONDS.toHours(milliseconds);
		milliseconds -= TimeUnit.HOURS.toMillis(hours);
		this.minutes = (int) TimeUnit.MILLISECONDS.toMinutes(milliseconds);
		milliseconds -= TimeUnit.MINUTES.toMillis(minutes);
		this.seconds = (int) TimeUnit.MILLISECONDS.toSeconds(milliseconds);
		milliseconds -= TimeUnit.SECONDS.toMillis(seconds);
		this.milliseconds = milliseconds;
	}

	/**
	 *
	 * @todo Write documentation
	 * @param hours
	 * @param minutes
	 * @param seconds
	 * @since 0.2
	 */
	public TimeSpan(int hours, int minutes, int seconds)
	{
		this(hours, minutes, seconds, 0, 0);
	}

	/**
	 *
	 * @todo Write documentation
	 * @param days
	 * @param hours
	 * @param minutes
	 * @param seconds
	 * @since 0.2
	 */
	public TimeSpan(int days, int hours, int minutes, int seconds)
	{
		this(days, hours, minutes, seconds, 0);
	}

	/**
	 *
	 * @todo Write documentation
	 * @param days
	 * @param hours
	 * @param minutes
	 * @param seconds
	 * @param milliseconds
	 * @since 0.2
	 */
	public TimeSpan(int days, int hours, int minutes, int seconds, long milliseconds)
	{
		this.days = days;
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
		this.milliseconds = milliseconds;
	}

	/**
	 *
	 * @todo Write documentation
	 * @return
	 * @since 0.2
	 */
	public int getDays()
	{
		return days;
	}

	/**
	 *
	 * @todo Write documentation
	 * @param days
	 * @since 0.2
	 */
	public void setDays(int days)
	{
		this.days = days;
	}

	/**
	 *
	 * @todo Write documentation
	 * @return
	 * @since 0.2
	 */
	public int getHours()
	{
		return hours;
	}

	/**
	 *
	 * @todo Write documentation
	 * @param hours
	 * @since 0.2
	 */
	public void setHours(int hours)
	{
		this.hours = hours;
	}

	/**
	 *
	 * @todo Write documentation
	 * @return
	 * @since 0.2
	 */
	public int getMinutes()
	{
		return minutes;
	}

	/**
	 *
	 * @todo Write documentation
	 * @param minutes
	 * @since 0.2
	 */
	public void setMinutes(int minutes)
	{
		this.minutes = minutes;
	}

	/**
	 *
	 * @todo Write documentation
	 * @return
	 * @since 0.2
	 */
	public int getSeconds()
	{
		return seconds;
	}

	/**
	 *
	 * @todo Write documentation
	 * @param seconds
	 * @since 0.2
	 */
	public void setSeconds(int seconds)
	{
		this.seconds = seconds;
	}

	/**
	 *
	 * @todo Write documentation
	 * @return
	 * @since 0.2
	 */
	public long getMilliseconds()
	{
		return milliseconds;
	}

	/**
	 *
	 * @todo Write documentation
	 * @param milliseconds
	 * @since 0.2
	 */
	public void setMilliseconds(long milliseconds)
	{
		this.milliseconds = milliseconds;
	}

	/**
	 *
	 * @todo Write documentation
	 * @return
	 * @since 0.2
	 */
	public long getTotalMilliseconds()
	{
		return (((days * 24 + hours) * 60 + minutes) * 60 + seconds) * 1000 + milliseconds;
	}

	/**
	 *
	 * @todo Write documentation
	 * @return
	 * @since 0.2
	 */
	public float getTotalSeconds()
	{
		return ((days * 24 + hours) * 60 + minutes) * 60 + seconds + (milliseconds / 1000);
	}

	/**
	 *
	 * @todo Write documentation
	 * @return
	 * @since 0.2
	 */
	public float getTotalMinutes()
	{
		return (days * 24 + hours) * 60 + minutes + (seconds + (milliseconds / 1000) / 60);
	}

	/**
	 *
	 * @todo Write documentation
	 * @return
	 * @since 0.2
	 */
	public float getTotalHours()
	{
		return days * 24 + hours + (minutes + (seconds + (milliseconds / 1000) / 60) / 60);
	}

	/**
	 *
	 * @todo Write documentation
	 * @return
	 * @since 0.2
	 */
	public float getTotalDays()
	{
		return days + (hours + (minutes + (seconds + (milliseconds / 1000) / 60) / 60) / 24);
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
		return "TimeSpan{" + "days=" + days + ", hours=" + hours + ", minutes=" + minutes + ", seconds=" + seconds + ", milliseconds=" + milliseconds + '}';
	}
}
