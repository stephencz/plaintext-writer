package com.pte.command;

import java.util.ArrayList;

import com.pte.editor.Editor;
import com.pte.featurebar.FeatureBar;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The CommandSetWidth class represents a command that
 * lets the user set the width of the editor's view.
 * 
 * @command {@code set_width <size>}
 * @argument {@code <size>} The size of the editor view in pixels.
 * @example <strong>set_width 1378</strong>
 * 
 * @author Stephen Czekalski
 *
 */
public class CommandSetWidth extends Command
{

	/**
	 * Creates a new CommandSetWidth object.
	 * @param commandLine The CommandLine that issued the command. 
	 * @param editor The editor that the command can manipulate. 
	 * @param featureBar The feature bar that the command can manipulate.
	 */
	public CommandSetWidth(CommandLine commandLine, Editor editor, FeatureBar featureBar)
	{
		super("set_width", commandLine, editor, featureBar);
	}
	
	@Override
	public boolean event(Stage stage, Scene scene, ArrayList<String> tokens)
	{
		boolean success = false;
		
		try
		{
			int width = Integer.parseInt(tokens.get(1));
			this.editor.setEditorWidth(width);
			success = true;
		}
		catch(NumberFormatException e)
		{
			success = false;
		}
		
		return success;
	}

	@Override
	public String getSuccessMessage(ArrayList<String> tokens)
	{
		return null;
	}

	@Override
	public String getFailMessage(ArrayList<String> tokens)
	{
		return null;
	}

	
	
}
