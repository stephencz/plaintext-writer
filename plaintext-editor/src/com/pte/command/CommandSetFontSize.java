package com.pte.command;

import java.util.ArrayList;

import com.pte.editor.Editor;
import com.pte.featurebar.FeatureBar;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The CommandSetFontSize class represents a command
 * that let's the user change the font size of the
 * editor view.
 * 
 * @command {@code set_fontsize <size>}
 * @argument {@code <size>} The size of the font.
 * @example <strong>set_fontsize 24</strong>
 * 
 * @author Stephen Czekalski
 *
 */
public class CommandSetFontSize extends Command
{

	/**
	 * Creates a new CommandSetFontSize object.
	 * @param commandLine The CommandLine that issued the command. 
	 * @param editor The editor that the command can manipulate. 
	 * @param featureBar The feature bar that the command can manipulate.
	 */
	public CommandSetFontSize(CommandLine commandLine, Editor editor, FeatureBar featureBar)
	{
		super("set_fontsize", commandLine, editor, featureBar);
	}

	@Override
	public boolean event(Stage stage, Scene scene, ArrayList<String> tokens)
	{
		boolean success = false;
		
		try
		{
			int fontSize = Integer.parseInt(tokens.get(1));
			this.editor.setFontSize(fontSize);
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
