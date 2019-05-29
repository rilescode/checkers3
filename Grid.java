package checkers3;

public class Grid
{
	private Location[][] grid;
	public static final int NUM_ROWS = 9;
  	public static final int NUM_COLS = 9;

  	public Grid()
  	{
  		grid = new Location[NUM_ROWS][NUM_COLS];
  		for(int i = 0; i < grid.length;i++)
  		{
  			for(int j = 0; j < grid[0].length;j++)
  			{
  				grid[i][j] = new Location();
  			}
  		}
  	}
  	
  	public boolean hasKingPiece(int row, int col)
  	{
  		if(grid[row][col].hasKingPiece())
  		{
  			return true;
  		}
  		else
  		{
  			return false;
  		}
  	}
  
  	public boolean hasPlayerPiece(int row, int col)    
  	{
  		if(grid[row][col].hasPlayerPiece())
  		{
  			return true;
  		}
  		else
  		{
  			return false;
  		}
  	}
  
  	public boolean hasComputerPiece(int row, int col)    
  	{
  		if(grid[row][col].hasComputerPiece())
  		{
  			return true;
  		}
  		else
  		{
  			return false;
  		}
  	}
  	
  	
  
  	public boolean redWins()
  	{
  		int count = 0;
  		for(int i = 0; i < 8;i++)
  		{
  			for(int j = 0; j < 8; j++)
  			{
  				if(hasComputerPiece(i,j))
  				{
  					count++;
  				}
  			}
  		}
	  
  		if(count == 0)
  		{
  			return true;
  		}
  		else
  		{
  			return false;
  		}
  	}
  
  	public boolean whiteWins()
  	{
  		int count = 0;
  		for(int i = 0; i < 8;i++)
  		{
  			for(int j = 0; j < 8; j++)
  			{
  				if(hasPlayerPiece(i,j))
  				{
  					count++;
  				}
  			}
  		}
	  
  		if(count == 0)
  		{
  			return true;
  		}
  		else
  		{
  			return false;
  		}
  	}
  	
  	public boolean isSelected(int row, int col)
  	{
  		return grid[row][col].isSelected();
  	}
  	
  	public void select(int row, int col, boolean val)
  	{
  		grid[row][col].select(val);
  	}
  
  	public void setComputerPiece(int row, int col, boolean val)
  	{
  		grid[row][col].setComputerPiece(val);
  	}
  
  	public void setPlayerPiece(int row, int col, boolean val)
  	{
  		grid[row][col].setPlayerPiece(val);
  	}
  
  	public void setKingPiece(int row, int col, boolean val)
  	{
  		grid[row][col].setKingPiece(val);
  	}
  
  	public void addComputerChecker(CheckerPiece c)
  	{
  		setComputerPiece(c.getRow(),c.getCol(), true);
  	}
  
  	public void addPlayerChecker(CheckerPiece c)
  	{
  		setPlayerPiece(c.getRow(),c.getCol(), true);
  	}
  
	public void movePlayerPiece(int rOld, int cOld, int rNew, int cNew)
	{
		setPlayerPiece(rOld, cOld, false);
		setPlayerPiece(rNew, cNew, true);
		if(rNew == 7 || hasKingPiece(rOld,cOld))
		{
			setKingPiece(rNew, cNew, true);
			setKingPiece(rOld,cOld,false);
		}
	}
	
	public void moveComputerPiece(int rOld, int cOld, int rNew, int cNew)
	{
		setComputerPiece(rOld, cOld, false);
		setComputerPiece(rNew, cNew, true);
		if(rNew == 0|| hasKingPiece(rOld,cOld))
		{
			setKingPiece(rNew, cNew, true);
			setKingPiece(rOld,cOld, false);
		}
	}
	
	public void addPieces()
	{
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				if(i % 2 == 0)
				{
					if(j % 2 == 0)
					{
						CheckerPiece c = new CheckerPiece(i,j,0);
						addPlayerChecker(c);
					}
				}
				else
				{
					if(j % 2 != 0)
					{
						CheckerPiece c = new CheckerPiece(i,j,0);
						addPlayerChecker(c);
					}
				}
			}
		
		}
		
		for(int i = 5; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				if(i % 2 == 0)
				{
					if(j % 2 == 0)
					{
						CheckerPiece c = new CheckerPiece(i,j,1);
						addComputerChecker(c);
					}
				}
				else
				{
					if(j % 2 != 0)
					{
						CheckerPiece c = new CheckerPiece(i,j,1);
						addComputerChecker(c);
					}
				}
			}
		}
	}
}
