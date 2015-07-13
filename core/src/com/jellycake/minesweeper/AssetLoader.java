package com.jellycake.minesweeper;

import java.util.Dictionary;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {
	
	public static Texture spriteSheet;
    public static Dictionary<String, TextureRegion> textureRegions;
    
    public static void LoadMenuAsset()
    {
    	spriteSheet = new Texture(Gdx.files.internal("assets/test.png"));
    	
    	textureRegions.put("PlayButton", new TextureRegion(spriteSheet, 0, 0, 45, 5));
    	textureRegions.put("SettingsButton", new TextureRegion(spriteSheet, 0, 5, 45, 5));
    	textureRegions.put("ExitButton", new TextureRegion(spriteSheet, 0, 10, 45, 5));
    	textureRegions.put("MinusButton", new TextureRegion(spriteSheet, 45, 0, 5, 5));
    	textureRegions.put("PlusButton", new TextureRegion(spriteSheet, 45, 5, 5, 5));
    }
    
    public static void dispose()
    {
    	spriteSheet.dispose();
    }
}
