package com.pte.command;

import java.util.ArrayList;
import com.pte.editor.Editor;
import com.pte.featurebar.FeatureBar;
import com.pte.featurebar.FeatureUtil;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The CommandUpdate class updates a part of the GUI.
 * This is useful for manually updating parts of the
 * feature bar such as word count.
 * 
 * @command {@code update <target>}
 * @argument <@code <target> The part of the GUI to update.
 * 
 * @example <strong>update</strong> 
 * @example <strong>update all</strong>
 * @example <strong>update feature</strong>
 * @example <strong>update count</strong>
 * 
 * @author Stephen Czekalski
 *
 */
public class CommandUpdate extends Command
{

	/**
	 * Creates a new CommandUpdate object.
	 * @param commandLine The CommandLine that issued the command.
	 * @param editor The Editor the command can manipulate.
	 * @param featureBar The FeatureBar the command can manipulate.
	 */
	public CommandUpdate(CommandLine commandLine, Editor editor, FeatureBar featureBar)
	{
		super("update", commandLine, editor, featureBar);
	}

	@Override
	public boolean event(Stage stage, Scene scene, ArrayList<String> tokens)
	{
		boolean success = false;
		
		if(tokens.size() >= 2)
		{
			switch(tokens.get(1).trim().toUpperCase())
			{	
			case "FEATURE":
				FeatureUtil.updateWords(featureBar, editor);
				success = true;
				break;
				
			case "COUNT":
				FeatureUtil.updateWords(featureBar, editor);
				success = true;
				break;
				
			case "ALL":
				FeatureUtil.updateWords(featureBar, editor);
				success = true;
				break;
				
			default:
				break;
			}
		}
		else
		{
			FeatureUtil.updateWords(featureBar, editor);
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
		return "Update failed: " + tokens.get(1);
	}
}
