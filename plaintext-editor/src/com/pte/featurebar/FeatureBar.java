package com.pte.featurebar;

import com.pte.editor.Editor;

import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class FeatureBar extends HBox
{
	
	private Editor editor;
	
	private FeatureManager featureManager;
	
	private Feature wordCount;
	
	public FeatureBar(Editor editor)
	{
		this.editor = editor;
		
		featureManager = new FeatureManager(this);
		
		wordCount = new Feature("WORDS", "Words: 0");
		
		featureManager.getFeatures().add(wordCount);
		
		this.initLabels();
		this.initFeatureBar();
	}
	
	public Editor getEditor()
	{
		return this.editor;
	}
	
	public FeatureManager getManager()
	{
		return this.featureManager;
	}
	
	public void registerEvents(Stage stage, Scene scene)
	{
		hideFeatureBarEvent(stage, scene);
	}
	
	private void hideFeatureBarEvent(Stage stage, Scene scene)
	{
		scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
			if(event.getCode() == KeyCode.F && event.isShortcutDown() && event.isShiftDown())
			{	
				if(this.isVisible())
				{
					this.setVisible(false);
				}
				else
				{
					this.setVisible(true);
				}
			}
		});
	}
	
	private void initLabels()
	{
		this.getChildren().add(wordCount);

	}
	
	private void initFeatureBar()
	{
		this.setSpacing(6);
		this.setPadding(new Insets(5, 10, 5, 10));
		//HBox.setHgrow(commandLine, Priority.ALWAYS);
		this.setAlignment(Pos.CENTER_LEFT);
		this.getStyleClass().add("feature-bar");
		this.wordCount.getStyleClass().add("feature-bar-label");

	}
}
