package com.pte.command;

import java.util.ArrayList;

import com.pte.editor.Editor;
import com.pte.featurebar.FeatureBar;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The CommandHide class represents a command that can hide
 * various parts of the GUI.
 * 
 * @command {@code hide <target>}
 * @argument {@code <target>} The part of the GUI to hide.
 * 
 * @example <strong>hide</strong> - hides the feature bar and the command line.
 * @example <strong>hide all</strong> - hides everything other than the editor.
 * @example <strong>hide command</strong> - hides the command bar.
 * @example <strong>hide feature</strong> - hides the feature bar.
 * @example <strong>hide count</strong> - hides the word count feature.
 * 
 * @shortcut Ctrl + Shift + H - Hides or shows all.
 * 
 * @author Stephen Czekalski
 *
 */
public class CommandHide extends Command
{

	/**
	 * Creates a new CommandHide object.
	 * @param commandLine The CommandLine that issued the command.
	 * @param editor The Editor that the command can manipulate.
	 * @param featureBar The FeatureBar that the command can manipulate.
	 */
	public CommandHide(CommandLine commandLine, Editor editor, FeatureBar featureBar)
	{
		super("hide", commandLine, editor, featureBar);
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
				this.editor.requestFocus();
				this.commandLine.setVisible(false);
				success = true;
				break;
				
			case "FEATURE":
				this.featureBar.setVisible(false);
				success = true;
				break;
				
			case "COUNT":
				this.featureBar.getManager().getFeature("COUNT").setVisible(false);
				success = true;
				break;
				
			case "ALL":
				this.editor.requestFocus();
				this.commandLine.setVisible(false);
				this.featureBar.setVisible(false);
				success = true;
				break;
				
			default: 
				break;
			}
		}
		else
		{
			this.editor.requestFocus();
			this.commandLine.setVisible(false);
			this.featureBar.setVisible(false);
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
		return "Unknown GUI Element: " + tokens.get(1);
	}

}
