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

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sound.sampled.*;

import edu.atlas.games.Game;

/**
 *
 * @todo Write documentation
 * @author David Verhaak <david@forcez.nl>
 * @since 0.2
 */
public class AudioPlayer
{

	private int bufferSize = 4096;
	private volatile boolean paused = false;
	private final Object lock = new Object();
	private SourceDataLine line;

	/**
	 *
	 * @todo Write documentation
	 * @since 0.2
	 */
	public void stop()
	{
		if (line != null)
		{
			line.stop();
			line.close();
		}
	}

	/**
	 *
	 * @todo Write documentation
	 * @return
	 * @since 0.2
	 */
	public boolean isPaused()
	{
		return this.paused;
	}

	/**
	 *
	 * @todo Write documentation
	 * @since 0.2
	 */
	public void pause()
	{
		if (!this.isPaused())
		{
			paused = true;
		}
	}

	/**
	 *
	 * @todo Write documentation
	 * @since 0.2
	 */
	public void resume()
	{
		if (this.isPaused())
		{
			synchronized (lock)
			{
				lock.notifyAll();
				paused = false;
			}
		}
	}

	/**
	 *
	 * @todo Write documentation
	 * @param song
	 * @since 0.2
	 */
	public void play(Song song)
	{
		new Thread(Game.THREAD_GROUP, new AudioExecutor(song), song.getName()).start();
	}

	private void playFile(Song song) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException
	{
		AudioInputStream encoded = AudioSystem.getAudioInputStream(song.getSource());
		AudioFormat encodedFormat = encoded.getFormat();
		AudioFormat decodedFormat = this.getDecodedFormat(encodedFormat);
		Long duration = null;
		AudioInputStream currentDecoded = AudioSystem.getAudioInputStream(decodedFormat, encoded);
		line = AudioSystem.getSourceDataLine(decodedFormat);
		line.open(decodedFormat);
		line.start();
		byte[] b = new byte[this.bufferSize];
		int i = 0;
		duration = song.getDuration().getTotalMilliseconds();
		synchronized (lock)
		{
			while (true)
			{
				if (paused == true)
				{
					line.stop();
					lock.wait();
					line.start();
				}
				i = currentDecoded.read(b, 0, b.length);
				if (i == -1)
				{
					break;
				}
				line.write(b, 0, i);
			}
		}

		line.drain();
		line.stop();
		line.close();
		currentDecoded.close();
		encoded.close();
	}

	/**
	 *
	 * @todo Write documentation
	 * @param value
	 * @since 0.2
	 */
	public void setVolume(double value)
	{
		if (!line.isOpen())
		{
			return;
		}
		value = (value <= 0.0) ? 0.0001 : ((value > 1.0) ? 1.0 : value);
		try
		{
			float dB = (float) (Math.log(value) / Math.log(10.0) * 20.0);
			((FloatControl) line.getControl(FloatControl.Type.MASTER_GAIN)).setValue(dB);
		} catch (Exception exception)
		{
			Logger.getLogger(AudioPlayer.class.getName()).log(Level.SEVERE, null, exception);
		}
	}

	/**
	 *
	 * @todo Write documentation
	 * @return
	 * @since 0.2
	 */
	public boolean isPlaying()
	{
		return (line != null && line.isOpen());
	}

	/**
	 *
	 * @todo Write documentation
	 * @param format
	 * @return
	 * @since 0.2
	 */
	protected AudioFormat getDecodedFormat(AudioFormat format)
	{
		return new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, format.getSampleRate(), 16, format.getChannels(), format.getChannels() * 2, format.getSampleRate(), false);
	}

	/**
	 *
	 * @todo Write documentation
	 * @return
	 * @since 0.2
	 */
	public int getBufferSize()
	{
		return bufferSize;
	}

	/**
	 *
	 * @todo Write documentation
	 * @param bufferSize
	 * @since 0.2
	 */
	public void setBufferSize(int bufferSize)
	{
		if (bufferSize <= 0)
		{
			return;
		}
		this.bufferSize = bufferSize;
	}

	/**
	 *
	 * @todo Write documentation
	 */
	private class AudioExecutor implements Runnable
	{

		private Song song;

		/**
		 *
		 * @todo Write documentation
		 * @param song
		 * @since 0.2
		 */
		public AudioExecutor(Song song)
		{
			super();
			this.song = song;
		}

		/**
		 *
		 * @todo Write documentation
		 * @since 0.2
		 */
		@Override
		public void run()
		{
			try
			{
				new AudioPlayer().playFile(song);
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException ex)
			{
				Logger.getLogger(AudioPlayer.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
}
