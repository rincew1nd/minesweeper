package com.jellycake.minesweeper.mainmenu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jellycake.minesweeper.AssetLoader;

public class RenderMenu {

	ControllerMenu controller;
	private OrthographicCamera camera;
	
	public RenderMenu(ControllerMenu controller)
	{
		this.controller = controller;
		camera = new OrthographicCamera();
		camera.setToOrtho(true, 136, 400);
	}
	
	public void render(SpriteBatch batch)
	{
		Gdx.gl.glClearColor(10/255.0f, 15/255.0f, 230/255.0f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.app.log("RenderMenu render", "");//(1/delta) + "");
		
		batch.begin();
		batch.draw(AssetLoader.textureRegions.get("PlayButton"), 0, 50, 450, 50);
		batch.draw(AssetLoader.textureRegions.get("SettingsButton"), 0, 150, 450, 50);
		batch.draw(AssetLoader.textureRegions.get("ExitButton"), 0, 250, 450, 50);
		batch.end();
	}
	
}