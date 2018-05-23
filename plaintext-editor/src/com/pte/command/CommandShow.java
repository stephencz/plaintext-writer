package com.pte.command;

import java.util.ArrayList;

import com.pte.editor.Editor;
import com.pte.featurebar.FeatureBar;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The CommandShow class represents a command that can hide
 * various parts of the GUI.
 * 
 * @command {@code show <target>}
 * @argument {@code <target>} The part of the GUI to show.
 * 
 * @example <strong>show all</strong> - shows the command bar and the feature bar.
 * @example <strong>show command</strong> - shows the command bar.
 * @example <strong>show feature</strong> - shows the feature bar.
 * @example <strong>show count</strong> - shows the word count feature.
 * 
 * @shortcut Ctrl + Shift + H - Shows or hides all.
 * @shortcut Ctrl + Shift + G - Shows or hides the command line.
 * @shortcut Ctrl + Shift + F - Shows or hides the feature bar.
 * 
 * @author Stephen Czekalski
 *
 */
public class CommandShow extends Command
{

	/**
	 * Creates a new CommandShow object.
	 * @param commandLine The CommandLine that issued the command. 
	 * @param editor The editor that the command can manipulate. 
	 * @param featureBar The feature bar that the command can manipulate.
	 */
	public CommandShow(CommandLine commandLine, Editor editor, FeatureBar featureBar)
	{
		super("show", commandLine, editor, featureBar);
	}

	@Override
	public boolean event(Stage stage, Scene scene, ArrayList<String> tokens)
	{
		boolean success = false;
		
		switch(tokens.get(1).trim().toUpperCase())
		{
		case "COMMAND": 
			this.commandLine.setVisible(true);
			success = true;
			break;
			
		case "FEATURE":
			this.featureBar.setVisible(true);
			success = true;
			break;
			
		case "WORDS":
			this.featureBar.getManager().getFeature("COUNT").setVisible(true);
			success = true;
			break;
			
		case "ALL":
			this.commandLine.setVisible(true);
			this.featureBar.setVisible(true);
			
			success = true;
			break;
			
		default: 
			break;
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
