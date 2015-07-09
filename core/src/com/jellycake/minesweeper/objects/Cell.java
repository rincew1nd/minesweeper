package com.jellycake.minesweeper.objects;

import com.badlogic.gdx.math.Vector3;
import java.util.ArrayList;
import java.util.List;

public class Cell {
    private Globals.State state;
    private final int mineCount;
    private final List<Cell> nearCells;
    public final Vector3 pos;
    
    /**
     * Constructor
     *
     * @param mineCount Mine count in this cell
     * @param x x position on board
     * @param y y position on board
     */
    public Cell(int mineCount, float x, float y){
        this.mineCount = mineCount;
        state = Globals.State.CLOSED;
        pos = new Vector3(x, y, 1f);
        nearCells = new ArrayList<Cell>();
    }
    
    /**
     * Add near cells to collections. Done for easier cells chain open
     *
     * @param cell
     */
    public void AddNearCell (Cell cell)
    {
        nearCells.add(cell);
    }
    
    /**
     * Add near cells to collections. Done for easier cells chain open
     *
     * @return Current cell state
     */
    public int GetState ()
    {
        if (state == Globals.State.CLOSED)
            return 9;
        else if (state == Globals.State.BOMB)
            return 10;
        else if (state == Globals.State.FLAG)
            return 11;
        else
            return mineCount;
    }
    
    /**
     * Open cell and near cells
     *
     * @return Current cell state
     */
    public Globals.State OpenCell()
    {
        if (mineCount == 0)
        {
            state = Globals.State.OPENED;
            for (Cell cell : nearCells)
                if (cell.state == Globals.State.CLOSED)
                    cell.OpenCell();
        }
        else if (mineCount > 0 && mineCount < 9)
            state = Globals.State.OPENED;
        else if (mineCount == 9)
            state = Globals.State.BOMB;
        
        return state;
    }
    
    /**
     * Flag cell
     */
    public void FlagCell()
    {
    	if (state == Globals.State.FLAG)
    		state = Globals.State.CLOSED;
    	else
        	state = Globals.State.FLAG;
    }
}
