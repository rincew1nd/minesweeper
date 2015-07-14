package com.jellycake.minesweeper.objects;

import com.badlogic.gdx.math.Vector3;
import com.jellycake.minesweeper.game.GameVariables;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    private GameVariables.State state;
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
        state = GameVariables.State.CLOSED;
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
    public String GetState ()
    {
        if (state == GameVariables.State.CLOSED)
            return "ClosedCell";
        else if (state == GameVariables.State.BOMB)
            return "BombCell";
        else if (state == GameVariables.State.FLAG)
            return "FlagCell";
        else
            return mineCount+"Cell";
    }
    
    /**
     * Open cell and near cells
     *
     * @return Current cell state
     */
    public GameVariables.State OpenCell()
    {
        if (mineCount == 0)
        {
            state = GameVariables.State.OPENED;
            for (Cell cell : nearCells)
                if (cell.state == GameVariables.State.CLOSED)
                    cell.OpenCell();
        }
        else if (mineCount > 0 && mineCount < 9)
            state = GameVariables.State.OPENED;
        else if (mineCount == 9)
            state = GameVariables.State.BOMB;
        
        return state;
    }
    
    /**
     * Flag cell
     */
    public void FlagCell()
    {
    	if (state == GameVariables.State.FLAG)
    		state = GameVariables.State.CLOSED;
    	else
        	state = GameVariables.State.FLAG;
    }
}
