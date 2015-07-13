package com.jellycake.minesweeper.mainmenu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainMenu implements Screen{
	
	SpriteBatch batch;
	ControllerMenu controller;
	RenderMenu render;

	public MainMenu(SpriteBatch batch)
	{
		Gdx.app.log("MainMenu"," attached");
		this.batch = batch;
		controller = new ControllerMenu();
		render = new RenderMenu(controller);
	}
	
	@Override
	public void render(float delta) {
		controller.update(delta);
		render.render(batch);
	}
	
	@Override
	public void show() {
		Gdx.app.log("Mainmenu", " show!");	
	}

	@Override
	public void resize(int width, int height) {
		Gdx.app.log("Mainmenu", " resize!"+width+"x"+height);
	}

	@Override
	public void pause() {
		Gdx.app.log("Mainmenu", " pause!");
	}

	@Override
	public void resume() {
		Gdx.app.log("Mainmenu", " resume!");
	}

	@Override
	public void hide() {
		Gdx.app.log("Mainmenu", " hide!");
	}

	@Override
	public void dispose() {
		Gdx.app.log("Mainmenu", " dispose!");
	}
	
}
