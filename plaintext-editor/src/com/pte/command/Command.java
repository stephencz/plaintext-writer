package com.pte.command;

import java.util.ArrayList;

import com.pte.editor.Editor;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The Command class represents a command that performs some function.
 * Every command has an identifier which acts as its trigger. For example,
 * a command which opens a file might have an identifier of 'open'.
 * @author stephen
 *
 */
public abstract class Command
{

	/**A reference to the editor that the command can manipulate.*/
	protected final Editor editor;
	
	/**A reference to the command line where the command was passed.*/
	protected final CommandLine commandLine;
	
	/**The command's identifier.*/
	protected final String identifier;

	public Command(Editor editor, CommandLine commandLine, String identifier)
	{
		this.editor = editor;
		this.commandLine = commandLine;
		this.identifier = identifier;
	}

	abstract public boolean event(Stage stage, Scene scene, ArrayList<String> tokens);
	abstract public String getSuccessMessage(ArrayList<String> tokens);
	abstract public String getFailMessage(ArrayList<String> tokens);
	
	public Editor getEditor()
	{
		return editor;
	}
	
	public CommandLine getCommandLine()
	{
		return commandLine;
	}
	
	public String getIdentifier()
	{
		return identifier;
	}

}
