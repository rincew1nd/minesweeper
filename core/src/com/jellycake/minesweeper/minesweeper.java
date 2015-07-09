package com.jellycake.minesweeper;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.jellycake.minesweeper.objects.Board;
import com.jellycake.minesweeper.objects.Globals;

public class minesweeper extends ApplicationAdapter {
	
	private Controller controller;
	private View view;
	
	@Override
	public void create () {
		//LoadPrefs.LoadPreferences();
		//Gdx.graphics.setDisplayMode(Globals.ScreenX, Globals.ScreenY, false);
		Gdx.graphics.setDisplayMode(450, 600, false);
		Globals.setSize(10, 10, 20, 16);
		Board board = new Board();
		//Gdx.graphics.setDisplayMode(Globals.BoardWidth*Globals.cellSize+Globals.BorderWidth*2, Globals.BoardHeight*Globals.cellSize+Globals.BorderHeight*2, false);
		controller = new Controller(board);
		Gdx.input.setInputProcessor(controller);
		view = new View(board);
		Globals.cellSize = 8*(Gdx.graphics.getWidth()/Globals.BoardWidth/8);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(204f/256, 176f/256, 48f/256, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		view.draw();
	}
	
	@Override
	public void pause()
	{
		
	}
	@Override
	public void resume()
	{
		
	}
	@Override
	public void resize(int width, int height)
	{
		//Gdx.graphics.setDisplayMode(Globals.BoardWidth*Globals.cellSize+Globals.BorderWidth*2, Globals.BoardHeight*Globals.cellSize+Globals.BorderHeight*2, false);
	}
	
	@Override
	public void dispose()
	{
	}
}
