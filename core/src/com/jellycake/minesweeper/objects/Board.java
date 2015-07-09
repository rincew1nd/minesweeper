package com.jellycake.minesweeper.objects;

import com.jellycake.minesweeper.objects.Globals;

public class Board {
    Cell cells[];
    int[] field;
    
    /**
    * Create Board
    */
    public Board() {		
        cells = new Cell[Globals.BoardWidth * Globals.BoardHeight];
        GenerateBoard();
    }
    
    private void GenerateBoard()
    {
        Field _field = new Field();
        _field.CreateField();
        field = _field.getField();
        _field = null;
        
        for (int i = 0; i < Globals.BoardWidth; i++)
            for (int j = 0; j < Globals.BoardHeight; j++)
                cells[i + j * Globals.BoardHeight] = new Cell(field[i + j * Globals.BoardHeight], i, j);
        
        for (int i = 0; i < Globals.BoardWidth; i++)
            for (int j = 0; j < Globals.BoardHeight; j++)
                for (int di = i-1; di <= i+1; di++)
                    for (int dj = j-1; dj <= j+1; dj++)
                        if (!(di==i && dj==j) && Globals.IsOnBoard(di, dj))
                            cells[i + j * Globals.BoardHeight].AddNearCell(cells[di + dj * Globals.BoardHeight]);
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
        if (Globals.IsOnBoard(x, y))
            return cells[x+y*Globals.BoardHeight];
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
        for (int i = 0; i<(Globals.BoardHeight * Globals.BoardHeight); i++)
        {
        	if (cells[i].GetState() == 9 || cells[i].GetState() == 11)
        		closed++;
        }
        if (closed == Globals.BoardMines) return true; else return false;
    }
    
    /**
    * Open all cells
    *
    */
    public void ShowAll()
    {
        for(int i = 0; i<(Globals.BoardHeight * Globals.BoardHeight); i++)
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
    	Globals.BoardHeight = height;
    	Globals.BoardWidth = width;
    	Globals.BoardMines = mines;
    	GenerateBoard();
    }
}
