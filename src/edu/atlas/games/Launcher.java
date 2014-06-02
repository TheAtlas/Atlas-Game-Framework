package edu.atlas.games;

/**
 *
 * @author David Verhaak <david@forcez.nl>
 */
public class Launcher
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
	{
		new Thread(new ThreadGroup("atlas"), new Game(), "Game").start();
    }

}
