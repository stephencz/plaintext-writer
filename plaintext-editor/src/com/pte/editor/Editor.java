package com.pte.editor;

import java.io.File;

import com.pte.featurebar.FeatureUtil;
import com.pte.util.ConfigUtil;

import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Editor extends TextArea
{
	
	/**The file currently open in the editor.*/
	private File file;
	
	/**Keeps track of the font size in the editor.*/
	private int fontSize;
	
	/**The width of the editor.*/
	private int editorWidth;
	
	private String theme;

	/**Creates a new Editor.*/
	public Editor(int fontSize, int editorWidth)
	{	
		this.setMaxWidth(800);
		this.setPrefWidth(800);
		this.setWrapText(true);
		this.setFontSize(fontSize);
		this.setEditorWidth(editorWidth);
		this.setTheme(ConfigUtil.getDefaultTheme());
		this.setClip(getShape());
		
		file = null;
	}
	
	/**
	 * Gets the current open file. 
	 * @return The currently open file.
	 */
	public File getFile()
	{
		return file;
	}
	
	public void setFile(File file)
	{
		this.file = file;
	}
	
	/**
	 * Gets the size of the editor's font.
	 * @return The size of the editor's font.
	 */
	public int getFontSize()
	{
		return fontSize;
	}

	/**
	 * Sets the size of the editor's font.
	 * @param fontSize The new size of the font.
	 */
	public void setFontSize(int fontSize)
	{
		this.fontSize = fontSize;
		this.setStyle("-fx-font-size: " + this.fontSize + "px");
	}
	
	/**
	 * Gets the width of the editor. 
	 * @return The width of the editor.
	 */
	public int getEditorWidth()
	{
		return editorWidth;
	}
	
	/**
	 * Sets the width of the editor.
	 * @param editorWidth The new width of the editor.
	 */
	public void setEditorWidth(int editorWidth)
	{
		this.editorWidth = editorWidth;
		this.setMaxWidth(editorWidth);
		this.setPrefWidth(editorWidth);
	}
	
	public String getTheme()
	{
		return this.theme;
	}
	
	public void setTheme(String name)
	{
		this.theme = name;
	}
		
	/**Hides the TextArea's vertical scroll bar.*/
	public void hideVScrollBar()
	{
		ScrollBar scrollBar = (ScrollBar) this.lookup(".scroll-bar:vertical");
	    scrollBar.setDisable(true);
	}
	
	/***
	 * Registers all events.
	 * @param stage The primary stage.
	 * @param scene The current scene.
	 */
	public void registerEvents(Stage stage, Scene scene)
	{
		this.saveEvent(stage, scene);
		this.fullscreenEvent(stage, scene);
	}
	
	private void saveEvent(Stage stage, Scene scene)
	{
		scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
			if(event.getCode() == KeyCode.S && event.isShortcutDown())
			{
				if(this.file != null)
				{
					EditorUtil.save(stage, scene, this);
				}
			}
		});
	}
	
	/**
	 * Registers an event that makes the screen enter or leave full screen
	 * @KeyCode F11
	 * @param stage A reference to the primary stage.
	 * @param scene The current scene.
	 */
	private void fullscreenEvent(Stage stage, Scene scene)
	{
		scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
			if(event.getCode() == KeyCode.F11)
			{
				if(stage.isFullScreen())
				{
					stage.setFullScreen(false);
				}
				else
				{
					stage.setFullScreen(true);
				}
			}
		});
	}
	
}
