package com.jellycake.minesweeper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.jellycake.minesweeper.objects.Board;
import com.jellycake.minesweeper.objects.Globals;

public class View {

	private Board board;
	private SpriteBatch batch;
	private BitmapFont font;
	private TextureRegion[] textures;
	
	public View(Board board)
	{
		this.board = board;
		batch = new SpriteBatch();
		font = new BitmapFont();
		font.setColor(Color.BLUE);
		
		LoadSprites();
	}
	
	public void LoadSprites()
	{
		Texture texture = new Texture(Gdx.files.internal("mario.png"));
		Texture texture1 = new Texture(Gdx.files.internal("borders.png"));
		textures = new TextureRegion[22];
		
		//Cell sprites
		for (int i=0; i<9; i++)
			textures[i] = new TextureRegion(texture, i*16, 0, 16, 16);
		textures[9] = new TextureRegion(texture, 0, 16, 16, 16);
		textures[10] = new TextureRegion(texture, 32, 16, 16, 16);
		textures[11] = new TextureRegion(texture, 48, 16, 16, 16);
		//Borders
		textures[12] = new TextureRegion(texture1, 0, 0, 12, 12); //left-top
		textures[13] = new TextureRegion(texture1, 13, 13, 12, 12); //right-bottom
		textures[14] = new TextureRegion(texture1, 0, 13, 12, 12); //Left-bottom
		textures[15] = new TextureRegion(texture1, 13, 0, 12, 12); //right-top
		textures[16] = new TextureRegion(texture1, 12, 0, 01, 12); //top
		textures[17] = new TextureRegion(texture1, 12, 13, 01, 12); //bottom
		textures[18] = new TextureRegion(texture1, 0, 12, 12, 01); //left
		textures[19] = new TextureRegion(texture1, 13, 12, 12, 01); //right
		textures[20] = new TextureRegion(texture, 0, 55, 26, 26); //head1
		textures[21] = new TextureRegion(texture, 27, 55, 26, 26); //head2
	}
	
	public void draw()
    {
        batch.begin();
        
        //Draw cells of board
        for (int i=0; i<Globals.BoardHeight; i++)
            for (int j=0; j<Globals.BoardWidth; j++)
            	batch.draw(textures[board.GetCell(i, j).GetState()], board.GetCell(i, j).pos.x*Globals.cellSize+Globals.BoardCenterX-(Globals.cellSize*Globals.BoardWidth/2), board.GetCell(i, j).pos.y*Globals.cellSize+Globals.BoardCenterY-(Globals.cellSize*Globals.BoardHeight/2), Globals.cellSize, Globals.cellSize);
        
        //Draw border of board
        batch.draw(textures[15], Globals.BoardCenterX+(Globals.cellSize*Globals.BoardWidth/2), Globals.BoardCenterY+(Globals.cellSize*Globals.BoardWidth/2), 12*Globals.cellSize/16, 12*Globals.cellSize/16); //right-top
        batch.draw(textures[12], Globals.BoardCenterX-(Globals.cellSize*Globals.BoardWidth/2)-12*Globals.cellSize/16, Globals.BoardCenterY+(Globals.cellSize*Globals.BoardWidth/2), 12*Globals.cellSize/16, 12*Globals.cellSize/16); //left-top
        batch.draw(textures[13], Globals.BoardCenterX+(Globals.cellSize*Globals.BoardWidth/2), Globals.BoardCenterY-12*Globals.cellSize/16-(Globals.cellSize*Globals.BoardWidth/2), 12*Globals.cellSize/16, 12*Globals.cellSize/16); //right-bottom
        batch.draw(textures[14], Globals.BoardCenterX-12*Globals.cellSize/16-(Globals.cellSize*Globals.BoardWidth/2), Globals.BoardCenterY-(Globals.cellSize*Globals.BoardWidth/2)-12*Globals.cellSize/16, 12*Globals.cellSize/16, 12*Globals.cellSize/16); //left-bottom
        for (int i=0; i<Globals.cellSize*Globals.BoardWidth ;i++)
        {
            batch.draw(textures[16], Globals.BoardCenterX-(Globals.cellSize*Globals.BoardWidth/2)+i, Globals.BoardCenterY+(Globals.cellSize*Globals.BoardWidth/2), 1*Globals.cellSize/16, 12*Globals.cellSize/16); //top
            batch.draw(textures[17], Globals.BoardCenterX-(Globals.cellSize*Globals.BoardWidth/2)+i, Globals.BoardCenterY-(Globals.cellSize*Globals.BoardWidth/2)-12*Globals.cellSize/16, 1*Globals.cellSize/16, 12*Globals.cellSize/16); //bottom
        }
        for (int i=0; i<Globals.cellSize*Globals.BoardHeight ;i++)
        {
            batch.draw(textures[18], Globals.BoardCenterX+(Globals.cellSize*Globals.BoardWidth/2), Globals.BoardCenterY-(Globals.cellSize*Globals.BoardHeight/2)+i, 12*Globals.cellSize/16, 1*Globals.cellSize/16); //right
            batch.draw(textures[19], Globals.BoardCenterX-(Globals.cellSize*Globals.BoardWidth/2)-12*Globals.cellSize/16, Globals.BoardCenterY-(Globals.cellSize*Globals.BoardHeight/2)+i, 12*Globals.cellSize/16, 1*Globals.cellSize/16); //left
        }		
		// GameOver and Win
		if (Globals.GameOver == true)
		{
			font.draw(batch, "Game Over", Gdx.graphics.getWidth()/2-30, Gdx.graphics.getHeight()-20);
			font.draw(batch, "Restart", Gdx.graphics.getWidth()/2-20, 20);
		}
		if (Globals.Win == true)
		{
			font.draw(batch, "Win", Gdx.graphics.getWidth()/2-10, Gdx.graphics.getWidth()-10);
			font.draw(batch, "Restart", Gdx.graphics.getWidth()/2-20, 20);
		}
		//font.draw(batch, Gdx.graphics.getHeight() + "-" + Gdx.graphics.getWidth(), 5, 15);
        batch.draw(textures[20], Gdx.graphics.getWidth()/2-78, 0, 52, 52); //right
        if (Globals.isFlagClick == true)
            batch.draw(textures[9], Gdx.graphics.getWidth()/2-26, 0, 52, 52); //flag
        else
            batch.draw(textures[11], Gdx.graphics.getWidth()/2-26, 0, 52, 52); //flag
        batch.draw(textures[21], Gdx.graphics.getWidth()/2+26, 0, 52, 52); //right
        
        batch.end();
    }
}
