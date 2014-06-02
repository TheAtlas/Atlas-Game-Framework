package edu.atlas.games;

import edu.atlas.games.graphics.SpriteBatch;

/**
 *
 * @author David Verhaak <david@forcez.nl>
 */
public abstract class DrawableGameComponent extends GameComponent
{

	private int drawOrder;
	private boolean visible;
	
	public DrawableGameComponent(Game game, String name)
	{
		super(game, name);
	}
	
	public DrawableGameComponent(Game game)
	{
		super(game);
	}
	
	@Override
	public abstract void initialize();
	
	public abstract void loadContent();
	
	@Override
	public abstract void update();
	
	public abstract void draw(SpriteBatch spriteBatch);
	
	public int getDrawOrder()
	{
		return this.drawOrder;
	}
	
	public boolean isVisible()
	{
		return this.visible;
	}
	
	public void setDrawOrder(int drawOrder)
	{
		this.drawOrder = drawOrder;
	}
	
	public void setVisible(boolean visible)
	{
		this.visible = visible;
	}
}
