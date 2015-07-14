package com.jellycake.minesweeper.mainmenu;

import com.badlogic.gdx.Gdx;

public class MenuController {
	
	public void update(float delta)
	{
		Gdx.app.log("ControllerMenu", " update. FPS "+(int)(1/delta));
	}
}
