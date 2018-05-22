package com.pte.main;

import com.pte.command.CommandLine;
import com.pte.editor.Editor;
import com.pte.featurebar.FeatureBar;
import com.pte.util.CSSUtil;
import com.pte.util.ConfigUtil;

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Driver extends Application
{
	/**The initial width of the stage.*/
	private static final int INITIAL_STAGE_WIDTH = 800;
	
	/**The initial height of the stage.*/
	private static final int INITIAL_STAGE_HEIGHT = 600;
			
	/**The default font size of the text area's editor.*/
	private static final int DEFAULT_FONT_SIZE = 16;
	
	/**The default width of the editor.*/
	private static final int DEFAULT_EDITOR_WIDTH = 800;
	
	/**The current scene of the Stage.*/
	private static Scene scene;
	
	/**The BorderPane that holds the StackPane*/
	private static BorderPane root;
	
	/**The StackPane that holds the TextArea.*/
	private static StackPane stackPane;
	
	/**The TextArea object used to edit files.*/
	private static Editor editor;
	
	private static CommandLine commandLine;
	
	private static FeatureBar featureBar;
	
	public static void main(String[] args)
	{	
		launch(args);
	}
	
	@Override
	public void init()
	{
		root = new BorderPane();
		stackPane = new StackPane();
		scene = new Scene(root, INITIAL_STAGE_WIDTH, INITIAL_STAGE_HEIGHT);
		editor = new Editor(DEFAULT_FONT_SIZE, DEFAULT_EDITOR_WIDTH);
		featureBar = new FeatureBar(editor);
		commandLine = new CommandLine(editor, featureBar);

	}
	
	@Override
	public void start(Stage stage) throws Exception
	{  		
		initPane(stage);
		initCSS(stage);
		initScene(stage);
		initStage(stage);
		
		initEditor(stage);
		initCommandLine(stage);
		initFeatureBar(stage);
	}
	
	/**Initializes the Stack Pane.*/
	private void initPane(Stage stage)
	{
		//Set up BorderPane
		root.setTop(commandLine);
		root.setCenter(stackPane);
		root.setBottom(featureBar);
		
		//Set up Stack Pane
		stackPane.getChildren().add(editor);	
	}

	/**Initializes the CSS.*/
	private void initCSS(Stage stage)
	{
		CSSUtil.loadTheme(scene, editor, ConfigUtil.getDefaultTheme());
		
		root.getStyleClass().add("border-pane");
		stackPane.getStyleClass().add("stack-pane");
		editor.getStyleClass().add("editor");
	}
	
	private void initScene(Stage stage)
	{
		scene.setCursor(Cursor.NONE);
	}
	
	/**
	 * Initializes the Stage.
	 * @param stage A reference to the primary stage.
	 */
	private void initStage(Stage stage)
	{
	    stage.setScene(scene);
	    stage.setMinWidth(800);
	    stage.setMinHeight(600);
	    stage.setTitle("untitled");
	    stage.show();	
	}
	
	private void initEditor(Stage stage)
	{
		editor.registerEvents(stage, scene);
		editor.hideVScrollBar();	
	}
	
	private void initCommandLine(Stage stage)
	{
		commandLine.registerEvents(stage, scene);
	}
	
	private void initFeatureBar(Stage stage)
	{
		featureBar.registerEvents(stage, scene);
	}
}
