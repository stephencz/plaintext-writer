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
 * @example <strong>show</strong> - shows the feature bar and command line.
 * @example <strong>show all</strong> - shows everything
 * @example <strong>show command</strong> - shows the command line.
 * @example <strong>show feature</strong> - shows the feature bar.
 * @example <strong>show count</strong> - shows the word count feature.
 * 
 * @shortcut Ctrl + Shift + H - Shows or hides all.
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
		
		if(tokens.size() >= 2)
		{
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
		}
		else
		{
			this.commandLine.setVisible(true);
			this.featureBar.setVisible(true);
			success = true;
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
