package com.jellycake.minesweeper.game;

import com.badlogic.gdx.Gdx;

public class GameVariables {
    
    public static boolean GameOver = false;
    public static boolean Win = false;
	public static boolean isFlagClick = false;
    public static int BoardWidth, BoardHeight, BoardMines, BoardCenterX, BoardCenterY, cellSize;
    public static int BorderHeight, BorderWidth;
    public static enum State { BOMB, CLOSED, OPENED, FLAG };
    
    /**
    * Check for does X;Y coordinate in bounds of minefield
    *
    * @param  x X cell coordinate
    * @param  y Y cell coordinate
    * @return Is X;Y coords in bounds of minefield
    */
    public static boolean IsOnBoard(int x, int y)
    {
        if (x < BoardWidth && x >= 0)
            if (y < BoardHeight && y >= 0)
                return true;
        return false;
    }
    
    /**
     * Change cell size by delta pixels
     * 
     * @param delta Delta cell size in pixels
     */
    public static void ChangeCellSize(int delta)
    {
    	if (GameVariables.cellSize + delta >= 16)
    		GameVariables.cellSize += delta;
    	GameVariables.BorderHeight = Gdx.graphics.getHeight() / 2 - GameVariables.cellSize * GameVariables.BoardHeight / 2;
    	GameVariables.BorderWidth = Gdx.graphics.getWidth() / 2 - GameVariables.cellSize * GameVariables.BoardWidth / 2;
    }
    public static void setSize(int heigth, int width, int mines, int cellSize)
    {
    	GameVariables.BoardHeight = heigth;
    	GameVariables.BoardWidth = width;
    	GameVariables.BoardMines = mines;
    	GameVariables.cellSize = cellSize;
    	GameVariables.BorderHeight = Gdx.graphics.getHeight() / 2 - GameVariables.cellSize * GameVariables.BoardHeight / 2;
    	GameVariables.BorderWidth = Gdx.graphics.getWidth() / 2 - GameVariables.cellSize * GameVariables.BoardWidth / 2;
    	GameVariables.BoardCenterX = Gdx.graphics.getWidth()/2;
    	GameVariables.BoardCenterY = Gdx.graphics.getHeight()/2;
    }
    public static void SetBoards()
    {
    	GameVariables.BorderHeight = Gdx.graphics.getHeight() / 2 - GameVariables.cellSize * GameVariables.BoardHeight / 2;
    	GameVariables.BorderWidth = Gdx.graphics.getWidth() / 2 - GameVariables.cellSize * GameVariables.BoardWidth / 2;
    }
}
