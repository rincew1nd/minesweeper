package com.jellycake.minesweeper.objects;

import com.badlogic.gdx.Gdx;

public class Globals {
    
    public static boolean IsRunning = false;
    public static boolean GameOver = false;
    public static boolean Win = false;
	public static boolean isFlagClick = false;
    public static int ScreenX, ScreenY;
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
    * Check for does X;Y coordinate in bounds of minefield
    *
    * @param  heigth Height of board in cells count
    * @param  width Width of board in cells count
    * @param  mines Mines count on board
    * @param  cellSize Cell size in pixels
    */
    public static void setSize(int heigth, int width, int mines, int cellSize)
    {
    	Globals.BoardHeight = heigth;
    	Globals.BoardWidth = width;
    	Globals.BoardMines = mines;
    	Globals.cellSize = cellSize;
    	Globals.BorderHeight = Gdx.graphics.getHeight() / 2 - Globals.cellSize * Globals.BoardHeight / 2;
    	Globals.BorderWidth = Gdx.graphics.getWidth() / 2 - Globals.cellSize * Globals.BoardWidth / 2;
    	Globals.BoardCenterX = Gdx.graphics.getWidth()/2;
    	Globals.BoardCenterY = Gdx.graphics.getHeight()/2;
    }
    
    public static void SetBoards()
    {
    	Globals.BorderHeight = Gdx.graphics.getHeight() / 2 - Globals.cellSize * Globals.BoardHeight / 2;
    	Globals.BorderWidth = Gdx.graphics.getWidth() / 2 - Globals.cellSize * Globals.BoardWidth / 2;
    }
    
    public static void ChangeCellSize(int delta)
    {
    	if (Globals.cellSize + delta >= 16)
    		Globals.cellSize += delta;
    	Globals.BorderHeight = Gdx.graphics.getHeight() / 2 - Globals.cellSize * Globals.BoardHeight / 2;
    	Globals.BorderWidth = Gdx.graphics.getWidth() / 2 - Globals.cellSize * Globals.BoardWidth / 2;
    }
}
