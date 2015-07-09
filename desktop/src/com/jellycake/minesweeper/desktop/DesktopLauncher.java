package com.jellycake.minesweeper.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.jellycake.minesweeper.minesweeper;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Minesweeper";
		config.width = 300;
		config.height = 300;
		
		new LwjglApplication(new minesweeper(), config);
	}
}
