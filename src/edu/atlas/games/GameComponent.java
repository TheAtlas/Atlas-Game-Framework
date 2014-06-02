package edu.atlas.games;

/**
 *
 * @author David Verhaak <david@forcez.nl>
 */
public abstract class GameComponent 
{
	
	private String name;
	private int updateOrder;
	private boolean enabled;
	
	public GameComponent(Game game, String name)
	{
		this.name = name;
		this.enabled = true;
		this.updateOrder = 1;
	}

	public GameComponent(Game game)
	{
		this(game, "Unnamed GameComponent");
	}
	
	public abstract void initialize();
	
	public abstract void update();
	
	public abstract void dispose();
	
	public String getName()
	{
		return name;
	}
	
	public boolean isEnabled()
	{
		return enabled;
	}
	
	public int getUpdateOrder()
	{
		return updateOrder;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setEnabled(boolean enabled)
	{
		this.enabled = enabled;
	}
	
	public void setUpdateOrder(int updateOrder)
	{
		this.updateOrder = updateOrder;
	}
}
