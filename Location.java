
package checkers3;

public class Location 
{
	private boolean playerPiece;
	private boolean computerPiece;
	private boolean kingPiece;
	private boolean isSelected;
	
	public Location()
	{
		playerPiece = false;
		computerPiece = false;
	}
	
	public boolean hasPlayerPiece()
	{
		if(playerPiece)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void setKingPiece(boolean val)
	{
		kingPiece = val;
	}
	
	public boolean hasKingPiece()
	{
		if(kingPiece)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean hasComputerPiece()
	{
		if(computerPiece)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void setPlayerPiece(boolean val)
	{
		playerPiece = val;
	}
	
	public void setComputerPiece(boolean val)
	{
		computerPiece = val;
	}
	
	public void select(boolean s)
	{
		isSelected = s;
	}
	
	public boolean isSelected()
	{
		return isSelected;
	}

}


