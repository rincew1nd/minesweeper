package com.jellycake.minesweeper.objects;

import com.jellycake.minesweeper.objects.Globals;
import java.util.Random;

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
        if (Globals.BoardHeight * Globals.BoardWidth < Globals.BoardMines) return false;
        
        rand = new Random();
        
        // Создаём массив размером height*width
        field = new int[Globals.BoardHeight * Globals.BoardWidth];
        
        // Очищаем массив
        for (int i=0; i<Globals.BoardHeight; i++)
            for (int j=0; j<Globals.BoardWidth; j++)
                field[i + j * Globals.BoardHeight] = 0;
        
        // Генерируем мины
        for (int i=0; i<Globals.BoardMines; i++)
        {
            int x = rand.nextInt(Globals.BoardWidth - 0);
            int y = rand.nextInt(Globals.BoardHeight - 0);
            
            while (true)
            {
                if (field[x + y * Globals.BoardHeight] == 9)
                {
                    x = rand.nextInt(Globals.BoardWidth - 0);
                    y = rand.nextInt(Globals.BoardHeight - 0);
                } else {
                    field[x + y * Globals.BoardHeight] = 9;
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
                if (!(i==x && j==y) && Globals.IsOnBoard(i, j) && field[i + j * Globals.BoardHeight] != 9)
                    field[i + j * Globals.BoardHeight]++;
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
