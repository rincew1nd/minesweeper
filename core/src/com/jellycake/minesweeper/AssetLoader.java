package com.jellycake.minesweeper;

import java.util.Map;
import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {
	
	public static Texture spriteSheet;
    public static Map<String, TextureRegion> textureRegions;
    
    public static void LoadMenuAsset()
    {
    	spriteSheet = new Texture(Gdx.files.internal("test.png"));
		Texture texture = new Texture(Gdx.files.internal("mario.png"));
		Texture texture1 = new Texture(Gdx.files.internal("borders.png")); //TODO: Delete this shit
    	textureRegions = new HashMap<>();
    	
    	// Main menu
    	textureRegions.put("PlayButton", new TextureRegion(spriteSheet, 0, 0, 45, 5));
    	textureRegions.put("SettingsButton", new TextureRegion(spriteSheet, 0, 5, 45, 5));
    	textureRegions.put("ExitButton", new TextureRegion(spriteSheet, 0, 10, 45, 5));
    	textureRegions.put("MinusButton", new TextureRegion(spriteSheet, 45, 0, 5, 5));
    	textureRegions.put("PlusButton", new TextureRegion(spriteSheet, 45, 5, 5, 5));
    	
    	//Minefield cells
		for (int i=0; i<9; i++)
	    	textureRegions.put(i+"Cell", new TextureRegion(texture, i*16, 0, 16, 16));
		textureRegions.put("ClosedCell", new TextureRegion(texture, 0, 16, 16, 16));
		textureRegions.put("BombCell", new TextureRegion(texture, 32, 16, 16, 16));
		textureRegions.put("FlagCell", new TextureRegion(texture, 48, 16, 16, 16));
		
		//Borders
		textureRegions.put("LTBorder", new TextureRegion(texture1, 00, 00, 12, 12));
		textureRegions.put("RBBorder", new TextureRegion(texture1, 13, 13, 12, 12));
		textureRegions.put("LBBorder", new TextureRegion(texture1, 00, 13, 12, 12));
		textureRegions.put("RTBorder", new TextureRegion(texture1, 13, 00, 12, 12));
		textureRegions.put("TBorder", new TextureRegion(texture1, 12, 00, 01, 12));
		textureRegions.put("BBorder", new TextureRegion(texture1, 12, 13, 01, 12));
		textureRegions.put("LBorder", new TextureRegion(texture1, 00, 12, 12, 01));
		textureRegions.put("RBorder", new TextureRegion(texture1, 13, 12, 12, 01));
		
		//Graphics
		textureRegions.put("Mario", new TextureRegion(texture, 0, 55, 26, 26));
		textureRegions.put("MinusButton", new TextureRegion(texture, 32, 82, 26, 26));
		textureRegions.put("PlusButton", new TextureRegion(texture, 59, 82, 26, 26));
		textureRegions.put("FlagButtonEnabled", new TextureRegion(texture, 32, 109, 26, 26));
		textureRegions.put("FlagButtonDisabled", new TextureRegion(texture, 59, 109, 26, 26));
		textureRegions.put("Lose", new TextureRegion(texture, 87, 82, 56, 26));
		textureRegions.put("Win", new TextureRegion(texture, 87, 109, 56, 26));
    }
    
    public static void dispose()
    {
    	spriteSheet.dispose();
    }
}
