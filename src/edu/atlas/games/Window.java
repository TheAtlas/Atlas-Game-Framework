package edu.atlas.games;

import java.awt.Component;
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

import edu.atlas.games.input.Keyboard;
import edu.atlas.games.input.Mouse;


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
		//this.addKeyListener(keyboard);
		
		addWindowListener(this);
	}
	
	public GLCanvas getCanvas()
	{
		return this.canvas;
	}

	@Override
	public void repaint()
	{
		super.repaint();
		//canvas.display();
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
