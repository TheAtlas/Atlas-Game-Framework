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

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;

import edu.atlas.games.input.Mouse;

/**
 *
 * @todo Write documentation
 * @author David Verhaak <david@forcez.nl>
 * @since 0.1
 */
public class Window extends Frame implements GLEventListener, WindowListener
{

	private Game game;
	private GLCapabilities capabilities;
	private GLCanvas canvas;
	private Mouse mouse;

	/**
	 *
	 * @todo Write documentation
	 * @param game
	 * @since 0.1
	 */
	public Window(Game game)
	{
		this.game = game;
		mouse = new Mouse();
		setSize(600, 400);
		capabilities = new GLCapabilities(GLProfile.getDefault());
		canvas = new GLCanvas(capabilities);
		add(canvas);
		canvas.addMouseListener(mouse);
		canvas.addGLEventListener(this);
		addWindowListener(this);
		addMouseListener(mouse);
	}

	/**
	 *
	 * @todo Write documentation
	 * @return
	 * @since 0.1
	 */
	public GLCanvas getCanvas()
	{
		return this.canvas;
	}

	/**
	 *
	 * @todo Write documentation
	 * @param drawable
	 * @since 0.1
	 */
	@Override
	public void init(GLAutoDrawable drawable)
	{
		GL2 gl = drawable.getGL().getGL2();
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		gl.glClearColor(0, 0, 255, 1);
		gl.glClear(GL.GL_COLOR_BUFFER_BIT);
		gl.glOrtho(0, 600, 400, 0, 0, 1);
		gl.glViewport(0, 0, 600, 400);
	}

	/**
	 *
	 * @todo Write documentation
	 * @param drawable
	 * @since 0.1
	 */
	@Override
	public void dispose(GLAutoDrawable drawable)
	{
	}

	/**
	 *
	 * @todo Write documentation
	 * @param drawable
	 * @since 0.1
	 */
	@Override
	public void display(GLAutoDrawable drawable)
	{
		GL2 gl = drawable.getGL().getGL2();
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		gl.glClearColor(0, 0, 255, 1);
		gl.glClear(GL.GL_COLOR_BUFFER_BIT);
		gl.glOrtho(0, 600, 400, 0, 0, 1);
		if (game.isRunning())
		{
			game.draw();
		}
	}

	/**
	 *
	 * @todo Write documentation
	 * @param drawable
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @since 0.1
	 */
	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height)
	{
	}

	/**
	 *
	 * @todo Write documentation
	 * @param windowEvent
	 * @since 0.1
	 */
	@Override
	public void windowOpened(WindowEvent windowEvent)
	{
	}

	/**
	 *
	 * @todo Write documentation
	 * @param windowEvent
	 * @since 0.1
	 */
	@Override
	public void windowClosing(WindowEvent windowEvent)
	{
		game.shutdown();
	}

	/**
	 *
	 * @todo Write documentation
	 * @param windowEvent
	 * @since 0.1
	 */
	@Override
	public void windowClosed(WindowEvent windowEvent)
	{
	}

	/**
	 *
	 * @todo Write documentation
	 * @param windowEvent
	 * @since 0.1
	 */
	@Override
	public void windowIconified(WindowEvent windowEvent)
	{
	}

	/**
	 *
	 * @todo Write documentation
	 * @param windowEvent
	 * @since 0.1
	 */
	@Override
	public void windowDeiconified(WindowEvent windowEvent)
	{
	}

	/**
	 *
	 * @todo Write documentation
	 * @param windowEvent
	 * @since 0.1
	 */
	@Override
	public void windowActivated(WindowEvent windowEvent)
	{
	}

	/**
	 *
	 * @todo Write documentation
	 * @param windowEvent
	 * @since 0.1
	 */
	@Override
	public void windowDeactivated(WindowEvent windowEvent)
	{
	}
}
