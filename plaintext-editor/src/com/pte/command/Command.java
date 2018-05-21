package com.pte.command;

import java.util.ArrayList;

import com.pte.editor.Editor;

import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class Command
{

	protected final Editor editor;
	
	protected final CommandLine commandLine;
	
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
