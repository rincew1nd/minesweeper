package com.jellycake.minesweeper.objects;

import java.util.Random;

import com.jellycake.minesweeper.game.GameVariables;

public class Field {
    
    // Инитим поле
    private int[] field;
    private Random rand;
    
    /**
    * Generate a mine field
    *
    * @param  height Height of field
    * @param  width Width of field
    * @param  mines Count of mines on minefield
    * 
    * @return True - board created successfuly, False - error happend
    */
    public boolean CreateField()
    {
        if (GameVariables.BoardHeight * GameVariables.BoardWidth < GameVariables.BoardMines) return false;
        
        rand = new Random();
        
        // Создаём массив размером height*width
        field = new int[GameVariables.BoardHeight * GameVariables.BoardWidth];
        
        // Очищаем массив
        for (int i=0; i<GameVariables.BoardHeight; i++)
            for (int j=0; j<GameVariables.BoardWidth; j++)
                field[i + j * GameVariables.BoardHeight] = 0;
        
        // Генерируем мины
        for (int i=0; i<GameVariables.BoardMines; i++)
        {
            int x = rand.nextInt(GameVariables.BoardWidth - 0);
            int y = rand.nextInt(GameVariables.BoardHeight - 0);
            
            while (true)
            {
                if (field[x + y * GameVariables.BoardHeight] == 9)
                {
                    x = rand.nextInt(GameVariables.BoardWidth - 0);
                    y = rand.nextInt(GameVariables.BoardHeight - 0);
                } else {
                    field[x + y * GameVariables.BoardHeight] = 9;
                    break;
                }
            }
            
            SetMinesCount(x,y);
        }
        
        return true;
    }
    
    /**
    * Set count of mines in near cells
    *
    * @param  x X cell coordinate
    * @param  y Y cell coordinate
    */
    private void SetMinesCount(int x, int y)
    {
        for (int i = x-1; i <= x+1; i++)
            for (int j = y-1; j <= y+1; j++)
                if (!(i==x && j==y) && GameVariables.IsOnBoard(i, j) && field[i + j * GameVariables.BoardHeight] != 9)
                    field[i + j * GameVariables.BoardHeight]++;
    }
    
    /**
    * Set count of mines in near cells
    *
    * @return Returns field in int[][] array 
    */
    public int[] getField()
    {
        return field;
    }
}
