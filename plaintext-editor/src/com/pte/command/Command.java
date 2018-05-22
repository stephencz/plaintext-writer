package com.pte.command;

import java.util.ArrayList;

import com.pte.editor.Editor;
import com.pte.featurebar.FeatureBar;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * <p>The Command class represents a command that is entered into a 
 * command line. Every command has a unique identifier, a reference
 * to the command line it was entered into, and an Editor and FeatureBar
 * it can manipulate.</p>
 * 
 * 
 * <p>All Command objects must implement three methods: {@code event(...)}, 
 * {@code getSuccessMessage(..)}, and {@code getFailMessage(...)}.</p>
 * 
 * @author Stephen Czekalski
 *
 */
public abstract class Command
{

	/**The command's identifier.*/
	protected final String identifier;
	
	/**The Command line where the command was entered.*/
	protected final CommandLine commandLine;
	
	/**The Editor that the command can manipulate.*/
	protected final Editor editor;
	
	/**The FeatureBar the command can manipulate.*/
	protected final FeatureBar featurebar;

	/**
	 * Creates a new Command Object.
	 * @param identifier The commands identifier.
	 * @param commandLine The CommandLine the command was entered into.
	 * @param editor The Editor that the command can manipulate.
	 * @param featureBar The FeatureBar that the command can manipulate.
	 */
	public Command(String identifier, CommandLine commandLine, Editor editor, FeatureBar featureBar)
	{
		this.identifier = identifier;
		this.commandLine = commandLine;
		this.editor = editor;
		this.featurebar = featureBar;
		
	}

	/**
	 * 
	 * @param stage The primary stage.
	 * @param scene The current scene.
	 * @param tokens The contents of the CommandLine.
	 * @return True if the command was successful. Otherwise false.
	 */
	abstract public boolean event(Stage stage, Scene scene, ArrayList<String> tokens);
	
	/**
	 * Returns the message the command displays when successful.
	 * Return null if no message is desired.
	 * @param tokens The contents of the CommandLine.
	 * @return
	 */
	abstract public String getSuccessMessage(ArrayList<String> tokens);
	
	/**
	 * Returns the message the command displays when unsuccessful.
	 * Return null if no message is desired.
	 * @param tokens The contents of the CommandLine.
	 * @return
	 */
	abstract public String getFailMessage(ArrayList<String> tokens);
	
	/** @return The Command's identifier (its name). */
	public String getIdentifier()
	{
		return identifier;
	}
	
	/** @return The CommandLine the Command was entered into. */
	public CommandLine getCommandLine()
	{
		return commandLine;
	}
	
	/** @return The Editor the Command can manipulate. */
	public Editor getEditor()
	{
		return editor;
	}
}
