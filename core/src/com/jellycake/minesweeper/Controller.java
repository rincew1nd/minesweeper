package com.jellycake.minesweeper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.jellycake.minesweeper.objects.Board;
import com.jellycake.minesweeper.objects.Globals;

public class Controller implements InputProcessor{
	
	public static Vector2 mousePosition = new Vector2();
	public static Vector2 lastMousePosition = new Vector2();
	public static Vector2 startMousePosition = new Vector2();
	public static boolean[] mouseButtons = new boolean[3];
	public static boolean mouseDrag;
	private Board board;
	
	public Controller(Board board)
	{
		this.board = board;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		mousePosition.set(screenX, screenY * -1 + Gdx.graphics.getHeight());
		lastMousePosition.set(mousePosition);
		startMousePosition.set(mousePosition);
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		mousePosition.set(screenX, screenY * -1 + Gdx.graphics.getHeight());
		
		if ( !(startMousePosition.x > mousePosition.x || startMousePosition.x < mousePosition.x) && !(startMousePosition.y > mousePosition.y || startMousePosition.y < mousePosition.y))
			if (Globals.GameOver == false && Globals.Win == false)
			{
				if( mousePosition.x > Globals.BoardCenterX-(Globals.cellSize*Globals.BoardWidth/2) && mousePosition.x < Globals.BoardCenterX+(Globals.cellSize*Globals.BoardWidth/2) && 
			    	mousePosition.y > Globals.BoardCenterY-(Globals.cellSize*Globals.BoardHeight/2) && mousePosition.y < Globals.BoardCenterY+(Globals.cellSize*Globals.BoardHeight/2) )
				{
					if (Globals.isFlagClick == false && board.GetCell(((int)mousePosition.x - Globals.BoardCenterX + (Globals.cellSize*Globals.BoardWidth/2))/Globals.cellSize, ((int)mousePosition.y - Globals.BoardCenterY + (Globals.cellSize*Globals.BoardHeight/2))/Globals.cellSize).GetState() != 11)
					{
						System.out.println(((int)mousePosition.x - Globals.BoardCenterX + (Globals.cellSize*Globals.BoardWidth/2))/Globals.cellSize + " " +
										   ((int)mousePosition.y - Globals.BoardCenterY + (Globals.cellSize*Globals.BoardHeight/2))/Globals.cellSize + " " +
										   ((int)mousePosition.x-Globals.BorderWidth)/Globals.cellSize + " " +
										   ((int)mousePosition.y-Globals.BorderHeight)/Globals.cellSize) ;
						board.GetCell(((int)mousePosition.x - Globals.BoardCenterX + (Globals.cellSize*Globals.BoardWidth/2))/Globals.cellSize, ((int)mousePosition.y - Globals.BoardCenterY + (Globals.cellSize*Globals.BoardHeight/2))/Globals.cellSize).OpenCell();
						if (board.GetCell(((int)mousePosition.x - Globals.BoardCenterX + (Globals.cellSize*Globals.BoardWidth/2))/Globals.cellSize, ((int)mousePosition.y - Globals.BoardCenterY + (Globals.cellSize*Globals.BoardHeight/2))/Globals.cellSize).GetState() == 10)
						{
							board.ShowAll();
							Globals.GameOver = true;
						}
						if (board.IsAllOpened())
						{
							board.ShowAll();
							Globals.Win = true;
						}
					}
					if (Globals.isFlagClick == true)
						board.GetCell(((int)mousePosition.x - Globals.BoardCenterX + (Globals.cellSize*Globals.BoardWidth/2))/Globals.cellSize, ((int)mousePosition.y - Globals.BoardCenterY + (Globals.cellSize*Globals.BoardHeight/2))/Globals.cellSize).FlagCell();
				}
			} else if (Globals.GameOver == true)
			{
				board.restart(Globals.BoardWidth, Globals.BoardHeight, Globals.BoardMines);
				Globals.GameOver = false;
			} else if (Globals.Win == true)
			{
				board.restart(Globals.BoardWidth, Globals.BoardHeight, Globals.BoardMines);
				Globals.Win = false;
			}
		
		if( mousePosition.x > Gdx.graphics.getWidth()/2-78 && mousePosition.x < Gdx.graphics.getWidth()/2-26 && 
	    	mousePosition.y > 0 && mousePosition.y < 52 )
			Globals.ChangeCellSize(4);
		if( mousePosition.x > Gdx.graphics.getWidth()/2-26 && mousePosition.x < Gdx.graphics.getWidth()/2+26 && 
		    mousePosition.y > 0 && mousePosition.y < 52 )
			Globals.isFlagClick = Globals.isFlagClick ? false : true;
		if( mousePosition.x > Gdx.graphics.getWidth()/2+26 && mousePosition.x < Gdx.graphics.getWidth()/2+78 && 
			mousePosition.y > 0 && mousePosition.y < 52 )
				Globals.ChangeCellSize(-4);
		
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		mousePosition.set(screenX, screenY * -1 + Gdx.graphics.getHeight());
		
		Globals.BoardCenterX += (int) (mousePosition.x - lastMousePosition.x);
		Globals.BoardCenterY += (int) (mousePosition.y - lastMousePosition.y);
		
		lastMousePosition.set(mousePosition);
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		mousePosition.set(screenX, screenY * -1 + Gdx.graphics.getHeight());
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
}
