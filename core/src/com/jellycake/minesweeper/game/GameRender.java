package com.jellycake.minesweeper.game;

import java.util.Map;

import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.jellycake.minesweeper.AssetLoader;
import com.jellycake.minesweeper.objects.Board;

public class GameRender {

	private Board board;
	private Map<String, TextureRegion> sprites;
	
	public GameRender(Board board)
	{
		this.board = board;
		sprites = AssetLoader.textureRegions;
	}
	
	public void render(SpriteBatch batch)
    {
		Gdx.app.log("GameRender", "render!");
		
        batch.begin();
        
        //Draw cells of board
        for (int i=0; i<GameVariables.BoardHeight; i++)
            for (int j=0; j<GameVariables.BoardWidth; j++)
           		batch.draw(sprites.get(board.GetCell(i, j).GetState()), board.GetCell(i, j).pos.x*GameVariables.cellSize+GameVariables.BoardCenterX-(GameVariables.cellSize*GameVariables.BoardWidth/2), board.GetCell(i, j).pos.y*GameVariables.cellSize+GameVariables.BoardCenterY-(GameVariables.cellSize*GameVariables.BoardHeight/2), GameVariables.cellSize, GameVariables.cellSize);

        //Draw border of board
        batch.draw(sprites.get("RTBorder"), GameVariables.BoardCenterX+(GameVariables.cellSize*GameVariables.BoardWidth/2), GameVariables.BoardCenterY+(GameVariables.cellSize*GameVariables.BoardWidth/2), 12*GameVariables.cellSize/16, 12*GameVariables.cellSize/16);
        batch.draw(sprites.get("LTBorder"), GameVariables.BoardCenterX-(GameVariables.cellSize*GameVariables.BoardWidth/2)-12*GameVariables.cellSize/16, GameVariables.BoardCenterY+(GameVariables.cellSize*GameVariables.BoardWidth/2), 12*GameVariables.cellSize/16, 12*GameVariables.cellSize/16);
        batch.draw(sprites.get("RBBorder"), GameVariables.BoardCenterX+(GameVariables.cellSize*GameVariables.BoardWidth/2), GameVariables.BoardCenterY-12*GameVariables.cellSize/16-(GameVariables.cellSize*GameVariables.BoardWidth/2), 12*GameVariables.cellSize/16, 12*GameVariables.cellSize/16);
        batch.draw(sprites.get("LBBorder"), GameVariables.BoardCenterX-12*GameVariables.cellSize/16-(GameVariables.cellSize*GameVariables.BoardWidth/2), GameVariables.BoardCenterY-(GameVariables.cellSize*GameVariables.BoardWidth/2)-12*GameVariables.cellSize/16, 12*GameVariables.cellSize/16, 12*GameVariables.cellSize/16);
        for (int i=0; i<GameVariables.cellSize*GameVariables.BoardWidth ;i++)
        {
            batch.draw(sprites.get("TBorder"), GameVariables.BoardCenterX-(GameVariables.cellSize*GameVariables.BoardWidth/2)+i, GameVariables.BoardCenterY+(GameVariables.cellSize*GameVariables.BoardWidth/2), 1*GameVariables.cellSize/16, 12*GameVariables.cellSize/16); //top
            batch.draw(sprites.get("BBorder"), GameVariables.BoardCenterX-(GameVariables.cellSize*GameVariables.BoardWidth/2)+i, GameVariables.BoardCenterY-(GameVariables.cellSize*GameVariables.BoardWidth/2)-12*GameVariables.cellSize/16, 1*GameVariables.cellSize/16, 12*GameVariables.cellSize/16); //bottom
        }
        for (int i=0; i<GameVariables.cellSize*GameVariables.BoardHeight ;i++)
        {
            batch.draw(sprites.get("LBorder"), GameVariables.BoardCenterX+(GameVariables.cellSize*GameVariables.BoardWidth/2), GameVariables.BoardCenterY-(GameVariables.cellSize*GameVariables.BoardHeight/2)+i, 12*GameVariables.cellSize/16, 1*GameVariables.cellSize/16); //right
            batch.draw(sprites.get("RBorder"), GameVariables.BoardCenterX-(GameVariables.cellSize*GameVariables.BoardWidth/2)-12*GameVariables.cellSize/16, GameVariables.BoardCenterY-(GameVariables.cellSize*GameVariables.BoardHeight/2)+i, 12*GameVariables.cellSize/16, 1*GameVariables.cellSize/16); //left
        }
        
        // Buttons
        batch.draw(sprites.get("PlusButton"), Gdx.graphics.getWidth()/2-114, 0, 76, 76); //plus
        if (GameVariables.isFlagClick == true)
            batch.draw(sprites.get("FlagButtonEnabled"), Gdx.graphics.getWidth()/2-38, 0, 76, 76); //flag
        else
            batch.draw(sprites.get("PlusButton"), Gdx.graphics.getWidth()/2-38, 0, 76, 76); //flag
        batch.draw(sprites.get("FlagButtonDisabled"), Gdx.graphics.getWidth()/2+38, 0, 76, 76); //minus
        
		// GameOver and Win
		if (GameVariables.GameOver == true)
	        batch.draw(sprites.get("Lose"), Gdx.graphics.getWidth()/2-28*3, Gdx.graphics.getHeight()-26*3, 56*3, 26*3); //minus
		if (GameVariables.Win == true)
	        batch.draw(sprites.get("Win"), Gdx.graphics.getWidth()/2-28*3, Gdx.graphics.getHeight()-26*3, 56*3, 26*3); //minus
		
        batch.end();
    }
}
