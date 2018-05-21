package com.pte.featurebar;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class FeatureBar extends HBox
{
	
	public FeatureBar()
	{
		this.initFeatureBar();
		this.setVisible(false);
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
	
	private void initFeatureBar()
	{
		this.setSpacing(6);
		this.setPadding(new Insets(5, 10, 5, 10));
		//HBox.setHgrow(commandLine, Priority.ALWAYS);
		this.setAlignment(Pos.CENTER_LEFT);
		this.getStyleClass().add("feature-bar");
	}
	
}
