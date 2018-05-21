package com.pte.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.pte.editor.Editor;
import javafx.scene.Scene;

public final class CSSUtil
{
	/**Keeps the Utility class from being instantiated.*/
	private CSSUtil() { }
	
	/**
	 * Clears the current theme and sets the new one.
	 * @param scene The current scene.
	 * @param name The name/directory of the new theme.
	 */
	public static void loadTheme(Scene scene, Editor editor, String theme)
	{
		scene.getStylesheets().clear();
		
		int fontSize = getFontSize(theme);
		int editorWidth = getEditorWidth(theme);
	
		editor.setFontSize(fontSize);
		editor.setEditorWidth(editorWidth);
		
		scene.getStylesheets().add("themes/" + theme + ".css");
	}
	
	public static int getFontSize(String theme)
	{
		return Integer.parseInt(getCSSFileProperty(theme, "FONT_SIZE"));
	}
	
	public static int getEditorWidth(String theme)
	{
		return Integer.parseInt(getCSSFileProperty(theme, "EDITOR_WIDTH"));
	}
	
	public static String getCSSFileProperty(String theme, String property)
	{
		String value = "";
		Properties prop = new Properties();
		InputStream in = ConfigUtil.class.getResourceAsStream("/themes/" + theme + ".css");
		
		try
		{
			prop.load(in);
			value = prop.getProperty(property);
			prop.clone();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return value;
	}
	
}
