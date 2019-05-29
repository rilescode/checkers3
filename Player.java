package checkers3;

public class Player
{
	private Grid playerGrid;
	
	public Player()
	{
		playerGrid = new Grid();
	}
	
	public Grid getGrid()
	{
	    return playerGrid;
	}
	
	public void select(int r, int c, boolean val)
	{
		playerGrid.select(r, c, val);
	}
}


