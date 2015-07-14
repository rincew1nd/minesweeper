package com.jellycake.minesweeper.objects;

import com.jellycake.minesweeper.game.GameVariables;

public class Board {
    private Cell cells[];
    
    /**
    * Create Board
    */
    public Board() {		
        cells = new Cell[GameVariables.BoardWidth * GameVariables.BoardHeight];
        GenerateBoard();
    }
    
    private void GenerateBoard()
    {
        int[] field;
        Field _field = new Field();
        _field.CreateField();
        field = _field.getField();
        _field = null;
        
        for (int i = 0; i < GameVariables.BoardWidth; i++)
            for (int j = 0; j < GameVariables.BoardHeight; j++)
                cells[i + j * GameVariables.BoardHeight] = new Cell(field[i + j * GameVariables.BoardHeight], i, j);
        
        for (int i = 0; i < GameVariables.BoardWidth; i++)
            for (int j = 0; j < GameVariables.BoardHeight; j++)
                for (int di = i-1; di <= i+1; di++)
                    for (int dj = j-1; dj <= j+1; dj++)
                        if (!(di==i && dj==j) && GameVariables.IsOnBoard(di, dj))
                            cells[i + j * GameVariables.BoardHeight].AddNearCell(cells[di + dj * GameVariables.BoardHeight]);
    }
    
    /**
    * Get Cell by X;Y coordinate
    *
    * @param x Height of board (Default Globals.BoardHeight)
    * @param y Width of board (Default Globals.BoardWidth)
    * @return Cell by X;Y coordinate
    */
    public Cell GetCell(int x, int y)
    {
        if (GameVariables.IsOnBoard(x, y))
            return cells[x+y*GameVariables.BoardHeight];
        else
            return null;
    }
    
    /**
    * Get Cell by X;Y coordinate
    *
    * @return Cell by X;Y coordinate
    */
    public boolean IsAllOpened()
    {
        int closed = 0;
        for (int i = 0; i<(GameVariables.BoardHeight * GameVariables.BoardHeight); i++)
        	if (cells[i].GetState() == "ClosedCell" || cells[i].GetState() == "FlagCell")
        		closed++;
        if (closed == GameVariables.BoardMines) return true; else return false;
    }
    
    /**
    * Open all cells
    *
    */
    public void ShowAll()
    {
        for(int i = 0; i<(GameVariables.BoardHeight * GameVariables.BoardHeight); i++)
        	cells[i].OpenCell();
    }
    
    /**
    * Restart game with board with defined size and count of mines
    *
    * @param width Width of board (Default Globals.BoardHeight)
    * @param height Height of board (Default Globals.BoardWidth)
    * @param mines Mines on board (Default Globals.BoardWidth)
    */
    public void restart(int width, int height, int mines)
    {
    	GameVariables.BoardHeight = height;
    	GameVariables.BoardWidth = width;
    	GameVariables.BoardMines = mines;
    	GenerateBoard();
    }
}
