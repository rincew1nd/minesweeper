package com.jellycake.minesweeper.mainmenu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

public class ControllerMenu {

    private Rectangle rect = new Rectangle(0, 0, 17, 12);
	
	public void update(float delta)
	{
		Gdx.app.log("ControllerMenu", " update. FPS "+(int)(1/delta));
	}
	
    public Rectangle getRect() {
        return rect;
    }
}
