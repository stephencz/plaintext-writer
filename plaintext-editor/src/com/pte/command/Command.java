package com.pte.command;

import java.util.ArrayList;

import com.pte.editor.Editor;
import com.pte.featurebar.FeatureBar;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The Command class represents a command that performs some function.
 * Every command has an identifier which acts as its trigger. For example,
 * a command which opens a file might have an identifier of 'open'. Each
 * Command object also has a reference to a CommandLine, Editor, and FeatureBar
 * so commands can actually be useful.
 * @author Stephen Czekalski
 *
 */
public abstract class Command
{

	/**The command's identifier.*/
	protected final String identifier;
	
	/**A reference to the command line where the command was passed.*/
	protected final CommandLine commandLine;
	
	/**A reference to the editor that the command can manipulate.*/
	protected final Editor editor;

	public Command(String identifier, CommandLine commandLine, Editor editor, FeatureBar featureBar)
	{
		this.commandLine = commandLine;
		this.editor = editor;
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
