package com.jellycake.minesweeper;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jellycake.minesweeper.mainmenu.MainMenu;

public class minesweeper extends Game {
	
	SpriteBatch batch;
	
	@Override
	public void create () {
		Gdx.app.log("Minesweeper", " created!");
		batch = new SpriteBatch();
		AssetLoader.LoadMenuAsset();
		setScreen(new MainMenu(batch));
	}
	
	@Override
	public void dispose()
	{
		batch.dispose();
		super.dispose();
	}
}
