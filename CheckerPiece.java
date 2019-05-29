package checkers3;

public class CheckerPiece 
{
    
    private boolean isAlive;
    private int color;
    private int row;
    private int col;
    
    public CheckerPiece(int row, int col, int color)
    {
        isAlive = true;
        this.color = color;
        this.row = row;
        this.col = col;
    }
  
    public int getRow()
    {
        return row;
    }
    
    public int getCol()
    {
        return col;
    }
    
    public void setRow(int val)
    {
    	row = val;
    }
    
    public void setCol(int val)
    {
    	col = val;
    }
    
    public int getColor()
    {
        return color;
    }
    
    public boolean booleanisAlive()
    {
        if(isAlive)
        {
            return true;
        }
        return false;
    }
    
    public String toString()
    {
        return "Piece at [" + row + ", " + col + "]";
    }
}


