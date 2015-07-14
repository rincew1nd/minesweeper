/*
package com.jellycake.minesweeper;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import com.jellycake.minesweeper.game.GameVariables;

public class LoadPrefs {	
	
	public static void LoadPreferences()
	{
		File f = new File(System.getProperty("java.class.path"));
		File dir = f.getAbsoluteFile().getParentFile();
		String path = dir.toString();
		
		File xml = new File(path+"/prefs.xml");
	    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    
	    DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	    Document document = null;
		try {
			document = builder.parse(xml);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	    Element root = document.getDocumentElement();
	    
	    Element BoardHeight = (Element) root.getElementsByTagName("BoardHeight").item(0);
	    GameVariables.BoardHeight = Integer.parseInt(BoardHeight.getTextContent());
	    Element BoardWidth = (Element) root.getElementsByTagName("BoardWidth").item(0);
	    GameVariables.BoardWidth = Integer.parseInt(BoardWidth.getTextContent());
	    Element BoardMines = (Element) root.getElementsByTagName("BoardMines").item(0);
	    GameVariables.BoardMines = Integer.parseInt(BoardMines.getTextContent());
	    Element cellSize = (Element) root.getElementsByTagName("CellSize").item(0);
	    GameVariables.cellSize = Integer.parseInt(cellSize.getTextContent());
	    Element ScreenX = (Element) root.getElementsByTagName("ScreenX").item(0);
	    GameVariables.ScreenX = Integer.parseInt(ScreenX.getTextContent());
	    Element ScreenY = (Element) root.getElementsByTagName("ScreenY").item(0);
	    GameVariables.ScreenY = Integer.parseInt(ScreenY.getTextContent());
	    
	    GameVariables.SetBoards();
	}
}
*/