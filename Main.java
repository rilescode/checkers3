package checkers3;

import java.awt.Color;
import java.util.Scanner;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.WindowEvent;
import java.util.*;

public class Main extends JFrame
{
	private static final long serialVersionUID = 1L;
	private Player p;
	private Scanner myObj;
	private boolean start;
	private static boolean end;

	public Main()
	{
		start = true;
		p = new Player();
		setSize(800,800 + 29);
		setResizable(false);
		setVisible(true);
		end = false;
	}

	public void paint(Graphics g)
	{
		//Initialize graphics 2D, turning antialias on for smoother checker pieces
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
	
	    //Prints the checker board, including the coordinate8
	    if(start)
	    {
	    	g.setColor(new java.awt.Color(204, 255,255));
			g.fillRect(0, 0, 800, 800 + 29);
			g.setColor(Color.black);
			g.drawString("CHECKERS", 379, 370);
			g.drawString("By Nathan, Riley and Lucas", 338, 530);
			g.setColor(new java.awt.Color(255, 0,0));
			g.fillOval(363 + 5, 375 + 7 + 25, 90, 85);
			g.setColor(new java.awt.Color(255, 0, 0));
			g.fillOval(363 + 5, 375 + 7 + 25, 90, 78);
			g.setColor(Color.black);
			g.drawOval(363 + 5, 375 + 7 + 25, 90, 85);
			g.drawOval(363 + 20, 375 + 20 + 25, 60, 52);
			g.setColor(Color.black);
			g.drawOval(363 + 5, 375 + 7 + 25, 90, 78);	
	    }
	    else if(end)
	    {
	    	g.setColor(new java.awt.Color(204, 255,255));
			g.fillRect(0, 0, 800, 800 + 29);
			g.setColor(Color.black);
			g.drawString("THANKS FOR PLAYING", 352, 375);
			g.setColor(new java.awt.Color(255, 0,0));
			g.fillOval(363 + 5, 375 + 7 + 25, 90, 85);
			g.setColor(new java.awt.Color(255, 0, 0));
			g.fillOval(363 + 5, 375 + 7 + 25, 90, 78);
			g.setColor(Color.black);
			g.drawOval(363 + 5, 375 + 7 + 25, 90, 85);
			g.drawOval(363 + 20, 375 + 20 + 25, 60, 52);
			g.setColor(Color.black);
			g.drawOval(363 + 5, 375 + 7 + 25, 90, 78);	
	    }
	    else
	    {
			for(int i = 0; i < 800; i+=100)
			{
				for(int j = 0; j < 800; j+=100)
				{
					if(i % 200 == 0)
					{
						if(j % 200 == 0)
						{
							g.setColor(new java.awt.Color(46,139,87));
							g.fillRect(i, j + 25, 100, 100);
							g.drawString("[" + String.valueOf(j/100 - 1) +", " +  String.valueOf(i/100) + "]", i + 3, j + 21);
							g.setColor(Color.black);
							g.drawRect(i, j + 25, 100, 100);
						}
						else
						{
							g.setColor(new java.awt.Color(255,255,224));
							g.fillRect(i, j + 25, 100, 100);
							g.drawString("[" + String.valueOf(j/100 - 1) +", " +  String.valueOf(i/100) + "]", i + 3, j + 21);
							g.setColor(Color.black);
							g.drawRect(i, j + 25, 100, 100);
						}
					}
					else
					{
						if(j % 200 == 0)
						{
							g.setColor(new java.awt.Color(255,255,224));
							g.fillRect(i, j + 25, 100, 100);
							g.drawString("[" + String.valueOf(j/100 - 1) +", " +  String.valueOf(i/100) + "]", i + 3, j + 21);
							g.setColor(Color.black);
							g.drawRect(i, j + 25, 100, 100);
						}
						else
						{
							g.setColor(new java.awt.Color(46,139,87));
							g.fillRect(i, j + 25, 100, 100);
							g.drawString("[" + String.valueOf(j/100 - 1) +", " +  String.valueOf(i/100) + "]", i + 3, j + 21);
							g.setColor(Color.black);
							g.drawRect(i, j + 25, 100, 100);
						}
					}
				}
			}
			for(int i = 0; i < 8;i++)
			{
				for(int j = 0; j < 8;j++)
				{
					if(p.getGrid().hasPlayerPiece(j,i)) 
					{
						if(p.getGrid().isSelected(j, i))
						{
							g.setColor(new java.awt.Color(240, 230, 140));
							g.fillOval(i * 100 + 5, j * 100 + 7 + 25, 90, 85);
							g.setColor(Color.yellow);
							g.fillOval(i * 100 + 5, j * 100 + 7 + 25, 90, 78);
							g.setColor(Color.black);
							g.drawOval(i * 100 + 5, j * 100 + 7 + 25, 90, 85);
							g.drawOval(i * 100 + 20, j * 100 + 20 + 25, 60, 52);
						}
						else
						{
						
							g.setColor(Color.red);
							g.fillOval(i * 100 + 5, j * 100 + 7 + 25, 90, 85);
							g.setColor(Color.red);
							g.fillOval(i * 100 + 5, j * 100 + 7 + 25, 90, 78);
							g.setColor(Color.black);
							g.drawOval(i * 100 + 5, j * 100 + 7 + 25, 90, 85);
							g.drawOval(i * 100 + 20, j * 100 + 20 + 25, 60, 52);
						}
						if(p.getGrid().hasKingPiece(j,i))
						{
							g.setColor(new java.awt.Color(255,215,0));
							g.fillOval(i * 100 + 5, j * 100 + 7 + 25, 90, 85);
							g.setColor(Color.red);
							g.fillOval(i * 100 + 20, j * 100 + 20 + 25, 60, 52);
							g.setColor(Color.black);
							g.drawOval(i * 100 + 20, j * 100 + 20 + 25, 60, 52);
						}
						g.setColor(Color.black);
						g.drawOval(i * 100 + 5, j * 100 + 7 + 25, 90, 78);	
					}
					
					if(p.getGrid().hasComputerPiece(j,i)) 
					{
						if(p.getGrid().isSelected(j, i))
						{
							g.setColor(new java.awt.Color(240, 230, 140));
							g.fillOval(i * 100 + 5, j * 100 + 7 + 25, 90, 85);
							g.setColor(Color.yellow);
							g.fillOval(i * 100 + 5, j * 100 + 7 + 25, 90, 78);
							g.setColor(Color.black);
							g.drawOval(i * 100 + 5, j * 100 + 7 + 25, 90, 85);
							g.drawOval(i * 100 + 20, j * 100 + 20 + 25, 60, 52);
						}
						else
						{
							g.setColor(new java.awt.Color(169,169,169));
							g.fillOval(i * 100 + 5, j * 100 + 7 + 25, 90, 78);
							g.setColor(Color.white);
							g.fillOval(i * 100 + 5, j * 100 + 7 + 25, 90, 85);
							g.setColor(Color.black);
							g.drawOval(i * 100 + 20, j * 100 + 20 + 25, 60, 52);
						}
						if(p.getGrid().hasKingPiece(j,i))
						{
							g.setColor(new java.awt.Color(255,215,0));
							g.fillOval(i * 100 + 5, j * 100 + 7 + 25, 90, 85);
							g.setColor(Color.white);
							g.fillOval(i * 100 + 20, j * 100 + 20 + 25, 60, 52);
							g.setColor(Color.black);
							g.drawOval(i * 100 + 20, j * 100 + 20 + 25, 60, 52);
						}
						g.setColor(Color.black);
						
						g.drawOval(i * 100 + 5, j * 100 + 7 + 25, 90, 85);
						g.drawOval(i * 100 + 5, j * 100 + 7 + 25, 90, 78);
					}
					
				}
			}
	    }
	}
	
	public void startingScreen() throws InterruptedException
	{
		
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Press Enter to start a game");
	    s.nextLine();
	    start = false;
		this.repaint();
	}
	
	public void endingScreen()
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Press Enter to close the game");
	    s.nextLine();
	    dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		this.repaint();
	}

	//All comments in opponentTurn() are valid for playerTurn()
	public void opponentTurn()
	{
		int r;
		int c;
		while(true)
		{
			repaint();
			System.out.println("White Player Turn:");
			System.out.println();
			myObj = new Scanner(System.in);
			
			try 
			{
				System.out.println("Enter row: ");
				r = myObj.nextInt();
		    } 
	        catch (InputMismatchException e) 
		    {
	        	System.out.println("Invalid. Please enter an integer value");
	        	continue;
		    }
			
			try 
			{
				System.out.println("Enter col: ");
				c = myObj.nextInt();
		    } 
	        catch (InputMismatchException e) 
		    {
	        	System.out.println("Invalid");
	        	continue;
		    }
		    
		    if(r > 7 || r < 0 || c < 0 || c > 7)
		    {
		    	System.out.println("Choose a piece within bounds");
		    	continue;
		    }
		    
		    if(!p.getGrid().hasComputerPiece(r, c))
		    {
		    	System.out.println("You do not have a piece at this location");
		    	System.out.println();
		    	continue;
		    }
		    
		    //this makes it so this location is selected and will highlight on the board
		    p.select(r, c, true);
		    repaint();
		    
		    
		    if(p.getGrid().hasKingPiece(r, c))
		    {
		    	System.out.println("Would you like to go upleft, upright, downleft or downright? (ul, ur, dl, dr)");
		    }
		    else
		    {
		    	System.out.println("Would you like to go upleft or upright? (ul, ur)");
		    }
		    String turn = myObj.next();
		    
			    if(turn.equals("ul"))
			    {
			    	//Check if piece is going off the board
			    	if(r - 1 < 0 || c - 1 < 0)
			    	{
			    		System.out.println("Invalid move");
			    		p.select(r, c, false);
			    		continue;
			    	}
			    	
			    	//Make sure piece doesn't go on top of another piece of same team
			    	else if(p.getGrid().hasComputerPiece(r - 1, c - 1))
			    	{
			    		System.out.println("Invalid move");
			    		p.select(r, c, false);
			    		continue;
			    	}
			    	
			    	//Check to see if opposing player piece is in range
			    	else if(p.getGrid().hasPlayerPiece(r - 1, c - 1))
			    	{
			    		//Check to see if jumping over piece will make piece go off the board
			    		if(r - 2 < 0 || c - 2 < 0)
			    		{
			    			System.out.println("Invalid move");
			    			p.select(r, c, false);
			    			continue;
			    		}
			    		
			    		//Check to see if there is space behind piece for a valid jump
			    		else if (p.getGrid().hasPlayerPiece(r - 2, c - 2))
			    		{
			    			System.out.println("Invalid move");
			    			p.select(r, c, false);
			    			continue;
			    		}
			    		
			    		//Jumping the opposing players piece
			    		else
			    		{
				    		moveComputer(r, c, r - 2, c - 2);
				    		p.getGrid().setPlayerPiece(r - 1, c - 1, false);
				    		if(p.getGrid().hasKingPiece(r-1,c-1))
				    		{
				    			p.getGrid().setKingPiece(r - 1, c - 1, false);
				    		}
				    		break;
			    		}
			    	}
			    	
			    	//Move checker piece normally
			    	else
			    	{
			    		moveComputer(r, c, r - 1, c - 1);
			    		break;
			    	}
			    }
			    if(turn.equals("ur"))
			    {
			    	if(r - 1 < 0 || c + 1 > 7)
			    	{
			    		System.out.println("Invalid move");
			    		p.select(r, c, false);
			    		continue;
			    	}
			    	else if(p.getGrid().hasComputerPiece(r - 1,c + 1))
			    	{
			    		System.out.println("Invalid move");
			    		p.select(r, c, false);
			    		continue;
			    	}
			    	else if(p.getGrid().hasPlayerPiece(r - 1,c + 1))
			    	{
			    		if(r - 2 < 0 || c + 2 > 7)
			    		{
			    			System.out.println("Invalid move");
			    			p.select(r, c, false);
			    			continue;
			    		}
			    		else if (p.getGrid().hasPlayerPiece(r - 2, c + 2))
			    		{
			    			System.out.println("Invalid move");
			    			p.select(r, c, false);
			    			continue;
			    		}
			    		else
			    		{
				    		moveComputer(r, c, r - 2, c + 2);
				    		p.getGrid().setPlayerPiece(r - 1,c + 1,false);
				    		if(p.getGrid().hasKingPiece(r-1,c+1))
				    		{
				    			p.getGrid().setKingPiece(r - 1, c + 1, false);
				    		}
				    		break;
			    	    }
			    	}
			    	else
			    	{
			    		moveComputer(r, c, r - 1, c + 1);
			    		p.select(r, c, false);
			    		break;
			    	}
			    }
			    if(turn.equals("dl") && p.getGrid().hasKingPiece(r, c))
			    {
			    	if(r + 1 > 7 || c - 1 < 0)
			    	{
			    		System.out.println("Invalid move");
			    		p.select(r, c, false);
			    		continue;
			    	}
			    	else if(p.getGrid().hasComputerPiece(r + 1, c - 1))
			    	{
			    		System.out.println("Invalid move");
			    		p.select(r, c, false);
			    		continue;
			    	}
			    	else if(p.getGrid().hasPlayerPiece(r + 1, c - 1))
			    	{
			    		if(r + 2 > 7 || c - 2 < 0)
			    		{
			    			System.out.println("Invalid move");
			    			p.select(r, c, false);
			    			continue;
			    		}
			    		else if (p.getGrid().hasPlayerPiece(r + 2, c - 2))
			    		{
			    			System.out.println("Invalid move");
			    			p.select(r, c, false);
			    			continue;
			    		}
			    		else
			    		{
				    		moveComputer(r, c, r + 2, c - 2);
				    		p.getGrid().setPlayerPiece(r + 1, c - 1, false);
				    		if(p.getGrid().hasKingPiece(r + 1, c - 1))
				    		{
				    			p.getGrid().setKingPiece(r + 1, c - 1, false);
				    		}
				    		break;
			    	    }
			    	}
			    	else
			    	{
			    		moveComputer(r, c, r + 1, c  - 1);
			    		p.select(r, c, false);
			    		break;
			    	}
			    }
			    if(turn.equals("dr") && p.getGrid().hasKingPiece(r, c))
			    {
			    	if(r + 1 > 7 || c + 1 > 7)
			    	{
			    		System.out.println("Invalid move");
			    		p.select(r, c, false);
			    		continue;
			    	}
			    	else if(p.getGrid().hasComputerPiece(r  + 1, c + 1))
			    	{
			    		System.out.println("Invalid move");
			    		p.select(r, c, false);
			    		continue;
			    	}
			    	else if(p.getGrid().hasPlayerPiece(r + 1, c + 1))
			    	{
			    		if(r + 2 > 7 || c + 2 > 7)
			    		{
			    			System.out.println("Invalid move");
			    			p.select(r, c, false);
			    			continue;
			    		}
			    		else if (p.getGrid().hasPlayerPiece(r + 2, c + 2))
			    		{
			    			System.out.println("Invalid move");
			    			p.select(r, c, false);
			    			continue;
			    		}
			    		else
			    		{
				    		moveComputer(r, c, r + 2, c + 2);
				    		p.getGrid().setPlayerPiece(r + 1, c + 1,false);
				    		if(p.getGrid().hasKingPiece(r + 1, c + 1))
				    		{
				    			p.getGrid().setKingPiece(r + 1, c + 1, false);
				    		}
				    		break;
			    	    }
			    	}
			    	else
			    	{
			    		moveComputer(r, c, r + 1, c + 1);
			    		break;
			    	}
			    }
			    System.out.println("Enter a valid move");
			    System.out.println();
			    p.select(r, c, false);
			    repaint();
		}
		p.select(r, c, false);
	}
	
	//All comments in opponentTurn() are valid for playerTurn()
	public void playerTurn()
	{
		int r = 0;
		int c = 0;
		while(true)
		{
			
			
			System.out.println("Red Player Turn:");
			System.out.println();
			myObj = new Scanner(System.in);
			
			try 
			{
				System.out.println("Enter row: ");
				r = myObj.nextInt();
		    } 
	        catch (InputMismatchException e) 
		    {
	        	System.out.println("Invalid");
	        	continue;
		    }
			
			try 
			{
				System.out.println("Enter col: ");
				c = myObj.nextInt();
		    } 
	        catch (InputMismatchException e) 
		    {
	        	System.out.println("Invalid. Please enter an integer value");
	        	continue;
		    }
		    
		    if(r > 7 || r < 0 || c < 0 || c > 7)
		    {
		    	System.out.println("Choose a piece within bounds");
		    	continue;
		    }
		    
		    if(!p.getGrid().hasPlayerPiece(r, c))
		    {
		    	System.out.println("You do not have a piece at this location");
		    	System.out.println();
		    	continue;
		    }
		  //this makes it so this location is selected and will highlight on the board
		  //this makes it so this location is selected and will highlight on the board
		    p.select(r, c, true);
		    repaint();
		    
		    if(p.getGrid().hasKingPiece(r, c))
		    {
		    	System.out.println("Would you like to go upleft, upright, downleft or downright? (ul, ur, dl, dr)");
		    }
		    else
		    {
		    	System.out.println("Would you like to go downleft or downright? (dl, dr)");
		    }
		    String turn = myObj.next();
		    
			    if(turn.equals("ul") && p.getGrid().hasKingPiece(r,c))
			    {
			    	//Check if piece is going off the board
			    	if(r - 1 < 0 || c - 1 < 0)
			    	{
			    		System.out.println("Invalid move");
			    		p.select(r, c, false);
			    		continue;
			    	}
			    	
			    	//Make sure piece doesn't go on top of another piece of same team
			    	else if(p.getGrid().hasPlayerPiece(r - 1, c - 1))
			    	{
			    		System.out.println("Invalid move");
			    		p.select(r, c, false);
			    		continue;
			    	}
			    	
			    	//Check to see if opposing player piece is in range
			    	else if(p.getGrid().hasComputerPiece(r - 1, c - 1))
			    	{
			    		//Check to see if jumping over piece will make piece go off the board
			    		if(r - 2 < 0 || c - 2 < 0)
			    		{
			    			System.out.println("Invalid move");
			    			p.select(r, c, false);
			    			
			    			continue;
			    		}
			    		
			    		//Check to see if there is space behind piece for a valid jump
			    		else if (p.getGrid().hasComputerPiece(r - 2, c - 2))
			    		{
			    			System.out.println("Invalid move");
			    			p.select(r, c, false);
			    			continue;
			    		}
			    		
			    		//Jumping the opposing players piece
			    		else
			    		{
				    		movePlayer(r, c, r - 2, c - 2);
				    		p.getGrid().setComputerPiece(r - 1, c - 1, false);
				    		if(p.getGrid().hasKingPiece(r - 1, c - 1))
				    		{
				    			p.getGrid().setKingPiece(r - 1, c - 1, false);
				    		}
				    		break;
			    		}
			    	}
			    	
			    	//Move checker piece normally
			    	else
			    	{
			    		movePlayer(r, c, r - 1, c - 1);
			    		break;
			    	}
			    }
			    if(turn.equals("ur") && p.getGrid().hasKingPiece(r, c))
			    {
			    	if(r - 1 < 0 || c + 1 > 7)
			    	{
			    		System.out.println("Invalid move");
			    		p.select(r, c, false);
			    		continue;
			    	}
			    	else if(p.getGrid().hasPlayerPiece(r - 1,c + 1))
			    	{
			    		System.out.println("Invalid move");
			    		p.select(r, c, false);
			    		continue;
			    	}
			    	else if(p.getGrid().hasComputerPiece(r - 1,c + 1))
			    	{
			    		if(r - 2 < 0 || c + 2 > 7)
			    		{
			    			System.out.println("Invalid move");
			    			p.select(r, c, false);
			    			continue;
			    		}
			    		else if (p.getGrid().hasComputerPiece(r - 2, c + 2))
			    		{
			    			System.out.println("Invalid move");
			    			p.select(r, c, false);
			    			continue;
			    		}
			    		else
			    		{
				    		movePlayer(r, c, r - 2, c + 2);
				    		p.getGrid().setComputerPiece(r - 1,c + 1,false);
				    		if(p.getGrid().hasKingPiece(r - 1, c + 1))
				    		{
				    			p.getGrid().setKingPiece(r - 1, c + 1, false);
				    		}
				    		break;
			    	    }
			    	}
			    	else
			    	{
			    		movePlayer(r, c, r - 1, c + 1);
			    		break;
			    	}
			    }
			    if(turn.equals("dl"))
			    {
			    	if(r + 1 > 7 || c - 1 < 0)
			    	{
			    		System.out.println("Invalid move");
			    		p.select(r, c, false);
			    		continue;
			    	}
			    	else if(p.getGrid().hasPlayerPiece(r + 1, c - 1))
			    	{
			    		System.out.println("Invalid move");
			    		p.select(r, c, false);
			    		continue;
			    	}
			    	else if(p.getGrid().hasComputerPiece(r + 1, c - 1))
			    	{
			    		if(r + 2 > 7 || c - 2 < 0)
			    		{
			    			System.out.println("Invalid move");
			    			p.select(r, c, false);
			    			continue;
			    		}
			    		else if (p.getGrid().hasComputerPiece(r + 2, c - 2))
			    		{
			    			System.out.println("Invalid move");
			    			p.select(r, c, false);
			    			continue;
			    		}
			    		else
			    		{
				    		movePlayer(r, c, r + 2, c - 2);
				    		p.getGrid().setComputerPiece(r + 1, c - 1, false);
				    		if(p.getGrid().hasKingPiece(r + 1, c - 1))
				    		{
				    			p.getGrid().setKingPiece(r + 1, c - 1, false);
				    		}
				    		break;
			    	    }
			    	}
			    	else
			    	{
			    		movePlayer(r, c, r + 1, c  - 1);
			    		break;
			    	}
			    }
			    if(turn.equals("dr"))
			    {
			    	if(r + 1 > 7 || c + 1 > 7)
			    	{
			    		System.out.println("Invalid move");
			    		p.select(r, c, false);
			    		continue;
			    	}
			    	else if(p.getGrid().hasPlayerPiece(r  + 1, c + 1))
			    	{
			    		System.out.println("Invalid move");
			    		p.select(r, c, false);
			    		continue;
			    	}
			    	else if(p.getGrid().hasComputerPiece(r + 1, c + 1))
			    	{
			    		if(r + 2 > 7 || c + 2 > 7)
			    		{
			    			System.out.println("Invalid move");
			    			p.select(r, c, false);
			    			continue;
			    		}
			    		else if (p.getGrid().hasComputerPiece(r + 2, c + 2))
			    		{
			    			System.out.println("Invalid move");
			    			p.select(r, c, false);
			    			continue;
			    		}
			    		else
			    		{
				    		movePlayer(r, c, r + 2, c + 2);
				    		p.getGrid().setComputerPiece(r + 1, c + 1,false);
				    		if(p.getGrid().hasKingPiece(r + 1, c + 1))
				    		{
				    			p.getGrid().setKingPiece(r + 1, c + 1, false);
				    		}
				    		break;
			    	    }
			    	}
			    	else
			    	{
			    		movePlayer(r, c, r + 1, c + 1);
			    		break;
			    	}
			    }
			    System.out.println("Enter a valid move");
			    System.out.println();
			    p.select(r, c, false);
			    repaint();
		}
		p.select(r, c, false);
	}
	

	public void addPieces()
	{
	    p.getGrid().addPieces();
	}

	public void movePlayer(int xOld, int yOld, int xNew, int yNew)
	{
	    p.getGrid().movePlayerPiece(xOld, yOld, xNew, yNew);
	}
	
	public void moveComputer(int xOld, int yOld, int xNew, int yNew)
	{
	    p.getGrid().moveComputerPiece(xOld, yOld, xNew, yNew);
	}
	
	public boolean redWins()
	{
		if(p.getGrid().redWins())
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
		if(p.getGrid().whiteWins())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	//run method
	public static void main(String[] args) throws InterruptedException
    {
		Main m = new Main();
		m.startingScreen();
		m.addPieces();
		
		while(true)
		{
			
	        m.playerTurn();
	        m.repaint();
	        if(m.redWins())
	        {
	        	System.out.println("Red Wins!");
	        	break;
	        }
	        m.opponentTurn();
	        m.repaint();
	        if(m.whiteWins())
	        {
	        	System.out.println("White Wins!");
	        	break;
	        }
		}
		
		end = true;
		
		m.repaint();
		m.endingScreen();
    }
}






