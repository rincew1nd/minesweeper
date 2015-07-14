package com.jellycake.minesweeper.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jellycake.minesweeper.objects.Board;

public class MineGame implements Screen {

	SpriteBatch batch;
	private GameController controller;
	private GameRender renderer;
	
	public MineGame(SpriteBatch batch) {
		this.batch = batch;

		GameVariables.setSize(5, 5, 5, 16);
		Board board = new Board();
		controller = new GameController(board);
		renderer = new GameRender(board);
		Gdx.input.setInputProcessor(controller);
	}

	@Override
	public void render (float delta) {		
		renderer.render(batch);
	}
	
	@Override
	public void show() {
		Gdx.app.log("Game", " show!");	
	}
	@Override
	public void resize(int width, int height) {
		Gdx.app.log("Game", " resize!"+width+"x"+height);
	}
	@Override
	public void pause() {
		Gdx.app.log("Game", " pause!");
	}
	@Override
	public void resume() {
		Gdx.app.log("Game", " resume!");
	}
	@Override
	public void hide() {
		Gdx.app.log("Game", " hide!");
	}
	@Override
	public void dispose() {
		Gdx.app.log("Game", " dispose!");
	}
}
