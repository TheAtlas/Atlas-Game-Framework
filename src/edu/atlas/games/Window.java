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
 * @author David Verhaak <david@forcez.nl>
 */
public class Window extends Frame implements GLEventListener, WindowListener
{

	private Game game;
	private GLCapabilities capabilities;
	private GLCanvas canvas;
	private Mouse mouse;
	
	public Window(Game game)
	{
		mouse = new Mouse();
		addMouseListener(mouse);
		this.game = game;
		capabilities = new GLCapabilities(GLProfile.getDefault());
		setSize(600, 400);
		canvas = new GLCanvas(capabilities);
		canvas.addMouseListener(mouse);
		canvas.addGLEventListener(this);
		add(canvas);
		addWindowListener(this);
	}
	
	public GLCanvas getCanvas()
	{
		return this.canvas;
	}

	@Override
	public void init(GLAutoDrawable glad)
	{
	}

	@Override
	public void dispose(GLAutoDrawable glad)
	{
	}

	@Override
	public void display(GLAutoDrawable drawable)
	{
		GL2 gl = drawable.getGL().getGL2();
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		gl.glClear(GL.GL_COLOR_BUFFER_BIT);
		gl.glOrtho(0, 600, 400, 0, 0, 1);
		if(game.isRunning())
		{
			game.draw();
		}
	}

	@Override
	public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3)
	{
	}

	@Override
	public void windowOpened(WindowEvent e)
	{
	}

	@Override
	public void windowClosing(WindowEvent e)
	{
		game.shutdown();
	}

	@Override
	public void windowClosed(WindowEvent e)
	{
	}

	@Override
	public void windowIconified(WindowEvent e)
	{
	}

	@Override
	public void windowDeiconified(WindowEvent e)
	{
	}

	@Override
	public void windowActivated(WindowEvent e)
	{
	}

	@Override
	public void windowDeactivated(WindowEvent e)
	{
	}
	
	
}
