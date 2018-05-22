package com.pte.command;

import java.util.ArrayList;

import com.pte.editor.Editor;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

/**
 * The CommandLine class represents a command line that
 * allows the user to issue commands. 
 * 
 * @author Stephen Czekalski
 *
 */
public class CommandLine extends HBox
{
	/**A reference to the primary editor.*/
	private Editor editor;
	
	/**The command line's label.*/
	private Label commandLabel;
	
	/**A text field representing the command line itself.*/
	private TextField commandLine;
	
	private CommandParser parser;
	private CommandManager manager;
	
	private CommandSave saveCommand;
	private CommandSaveAs saveAsCommand;
	private CommandOpenFile openFileCommand;
	private CommandNewFile newFileCommand;
	private CommandSetWidth setWidthCommand;
	private CommandSetFontSize setFontSizeCommand;
	private CommandChangeTheme changeThemeCommand;
	private CommandFullscreen fullscreenCommand;
	private CommandHide hideCommand;

	/**
	 * Creates a new CommandLine object.
	 * @param editor The primary editor.
	 */
	public CommandLine(Editor editor)
	{
		this.editor = editor;
		
		commandLabel = new Label("Enter Command:");
		commandLine = new TextField();
		
		parser = new CommandParser(this);
		manager = new CommandManager(this);
		
		saveCommand = new CommandSave(editor, this);
		saveAsCommand = new CommandSaveAs(editor, this);
		openFileCommand = new CommandOpenFile(editor, this);
		newFileCommand = new CommandNewFile(editor, this);
		setWidthCommand = new CommandSetWidth(editor, this);
		setFontSizeCommand = new CommandSetFontSize(editor, this);
		changeThemeCommand = new CommandChangeTheme(editor, this);
		fullscreenCommand = new CommandFullscreen(editor, this);
		hideCommand = new CommandHide(editor, this);
		
		manager.getCommands().add(saveCommand);
		manager.getCommands().add(saveAsCommand);
		manager.getCommands().add(openFileCommand);
		manager.getCommands().add(newFileCommand);
		manager.getCommands().add(setWidthCommand);
		manager.getCommands().add(setFontSizeCommand);
		manager.getCommands().add(changeThemeCommand);
		manager.getCommands().add(fullscreenCommand);
		manager.getCommands().add(hideCommand);
		
		initCommandLine();
		initCommandLabel();
		initCommandInput();
	}
	
	public Editor getEditor()
	{
		return this.editor;
	}
	
	public Label getCommandLabel()
	{
		return this.commandLabel;
	}
	
	public TextField getCommandLine()
	{
		return this.commandLine;
	}
	
	public CommandManager getCommandManager()
	{
		return this.manager;
	}
	
	/**
	 * Registers events related to the command line.
	 * @param stage The primary stage.
	 * @param scene The current scene.
	 */
	public void registerEvents(Stage stage, Scene scene)
	{
		hideCommandLineEvent(stage, scene);
		parseCommandEvent(stage, scene);
	}
	
	/**
	 * An event which lets the user show and hide the command line.
	 * @KeyCode Ctrl + Shift + H - Hides or shows the command line.
	 * @param stage The primary stage.
	 * @param scene The current scene.
	 */
	private void hideCommandLineEvent(Stage stage, Scene scene)
	{
		scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
			if(event.getCode() == KeyCode.H && event.isShortcutDown() && event.isShiftDown())
			{	
				if(this.isVisible())
				{
					this.setVisible(false);
				}
				else
				{
					this.setVisible(true);
					this.commandLine.requestFocus();
					this.commandLine.selectAll();
				}
			}
		});
	}
	
	private void parseCommandEvent(Stage stage, Scene scene)
	{
		this.commandLine.setOnKeyReleased(event -> {
			if(event.getCode() == KeyCode.ENTER  && !manager.isResolving())
			{
				ArrayList<String> tokens = parser.parse();
				if(tokens != null)
				{
					manager.resolve(stage, scene, tokens);
				}
			}
		});
	}
	
	/**Initializes the CommandLine object.*/
	private void initCommandLine()
	{
		this.setSpacing(6);
		this.setPadding(new Insets(5, 10, 5, 10));
		HBox.setHgrow(commandLine, Priority.ALWAYS);
		this.setAlignment(Pos.CENTER_LEFT);
		this.getStyleClass().add("command-line-box");
		commandLabel.getStyleClass().add("command-label");
		commandLine.getStyleClass().add("command-input");
	}
	
	/**Initializes the command line's label.*/
	private void initCommandLabel()
	{
		this.getChildren().add(commandLabel);
	}
	
	/**Initializes the command line's text field.*/
	private void initCommandInput()
	{
		this.getChildren().add(commandLine);
	}
}
