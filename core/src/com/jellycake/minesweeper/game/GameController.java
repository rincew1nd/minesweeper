package com.jellycake.minesweeper.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.jellycake.minesweeper.objects.Board;

public class GameController implements InputProcessor{
	
	public static Vector2 mousePosition = new Vector2();
	public static Vector2 lastMousePosition = new Vector2();
	public static Vector2 startMousePosition = new Vector2();
	public static boolean[] mouseButtons = new boolean[3];
	public static boolean mouseDrag;
	private Board board;
	
	public GameController(Board board)
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
		
		if ( !(startMousePosition.x > mousePosition.x || startMousePosition.x < mousePosition.x) &&
			 !(startMousePosition.y > mousePosition.y || startMousePosition.y < mousePosition.y) &&
			 mousePosition.y > 52 )
			if (GameVariables.GameOver == false && GameVariables.Win == false)
			{
				if( mousePosition.x > GameVariables.BoardCenterX-(GameVariables.cellSize*GameVariables.BoardWidth/2) && mousePosition.x < GameVariables.BoardCenterX+(GameVariables.cellSize*GameVariables.BoardWidth/2) && 
			    	mousePosition.y > GameVariables.BoardCenterY-(GameVariables.cellSize*GameVariables.BoardHeight/2) && mousePosition.y < GameVariables.BoardCenterY+(GameVariables.cellSize*GameVariables.BoardHeight/2) )
				{
					if (GameVariables.isFlagClick == false && board.GetCell(((int)mousePosition.x - GameVariables.BoardCenterX + (GameVariables.cellSize*GameVariables.BoardWidth/2))/GameVariables.cellSize, ((int)mousePosition.y - GameVariables.BoardCenterY + (GameVariables.cellSize*GameVariables.BoardHeight/2))/GameVariables.cellSize).GetState() != 11)
					{
						System.out.println(((int)mousePosition.x - GameVariables.BoardCenterX + (GameVariables.cellSize*GameVariables.BoardWidth/2))/GameVariables.cellSize + " " +
										   ((int)mousePosition.y - GameVariables.BoardCenterY + (GameVariables.cellSize*GameVariables.BoardHeight/2))/GameVariables.cellSize + " " +
										   ((int)mousePosition.x-GameVariables.BorderWidth)/GameVariables.cellSize + " " +
										   ((int)mousePosition.y-GameVariables.BorderHeight)/GameVariables.cellSize) ;
						board.GetCell(((int)mousePosition.x - GameVariables.BoardCenterX + (GameVariables.cellSize*GameVariables.BoardWidth/2))/GameVariables.cellSize, ((int)mousePosition.y - GameVariables.BoardCenterY + (GameVariables.cellSize*GameVariables.BoardHeight/2))/GameVariables.cellSize).OpenCell();
						if (board.GetCell(((int)mousePosition.x - GameVariables.BoardCenterX + (GameVariables.cellSize*GameVariables.BoardWidth/2))/GameVariables.cellSize, ((int)mousePosition.y - GameVariables.BoardCenterY + (GameVariables.cellSize*GameVariables.BoardHeight/2))/GameVariables.cellSize).GetState() == 10)
						{
							board.ShowAll();
							GameVariables.GameOver = true;
						}
						if (board.IsAllOpened())
						{
							board.ShowAll();
							GameVariables.Win = true;
						}
					}
					if (GameVariables.isFlagClick == true && (
							board.GetCell(((int)mousePosition.x - GameVariables.BoardCenterX + (GameVariables.cellSize*GameVariables.BoardWidth/2))/GameVariables.cellSize, ((int)mousePosition.y - GameVariables.BoardCenterY + (GameVariables.cellSize*GameVariables.BoardHeight/2))/GameVariables.cellSize).GetState() == 9 ||
							board.GetCell(((int)mousePosition.x - GameVariables.BoardCenterX + (GameVariables.cellSize*GameVariables.BoardWidth/2))/GameVariables.cellSize, ((int)mousePosition.y - GameVariables.BoardCenterY + (GameVariables.cellSize*GameVariables.BoardHeight/2))/GameVariables.cellSize).GetState() == 11))
						board.GetCell(((int)mousePosition.x - GameVariables.BoardCenterX + (GameVariables.cellSize*GameVariables.BoardWidth/2))/GameVariables.cellSize, ((int)mousePosition.y - GameVariables.BoardCenterY + (GameVariables.cellSize*GameVariables.BoardHeight/2))/GameVariables.cellSize).FlagCell();
				}
			} else if (GameVariables.GameOver == true)
			{
				board.restart(GameVariables.BoardWidth, GameVariables.BoardHeight, GameVariables.BoardMines);
				GameVariables.GameOver = false;
			} else if (GameVariables.Win == true)
			{
				board.restart(GameVariables.BoardWidth, GameVariables.BoardHeight, GameVariables.BoardMines);
				GameVariables.Win = false;
			}
		
		if( mousePosition.x > Gdx.graphics.getWidth()/2-78 && mousePosition.x < Gdx.graphics.getWidth()/2-26 && 
	    	mousePosition.y > 0 && mousePosition.y < 52 )
			GameVariables.ChangeCellSize(4);
		if( mousePosition.x > Gdx.graphics.getWidth()/2-26 && mousePosition.x < Gdx.graphics.getWidth()/2+26 && 
		    mousePosition.y > 0 && mousePosition.y < 52 )
			GameVariables.isFlagClick = GameVariables.isFlagClick ? false : true;
		if( mousePosition.x > Gdx.graphics.getWidth()/2+26 && mousePosition.x < Gdx.graphics.getWidth()/2+78 && 
			mousePosition.y > 0 && mousePosition.y < 52 )
				GameVariables.ChangeCellSize(-4);
		
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		mousePosition.set(screenX, screenY * -1 + Gdx.graphics.getHeight());
		
		GameVariables.BoardCenterX += (int) (mousePosition.x - lastMousePosition.x);
		GameVariables.BoardCenterY += (int) (mousePosition.y - lastMousePosition.y);
		
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
