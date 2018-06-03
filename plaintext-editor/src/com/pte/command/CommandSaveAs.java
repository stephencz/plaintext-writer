package com.pte.command;

import java.util.ArrayList;
import com.pte.editor.Editor;
import com.pte.editor.EditorUtil;
import com.pte.featurebar.FeatureBar;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The CommandSaveAs class represents a command that
 * let's the user save the open file under whatever
 * name they want.
 * 
 * @command {@code saveas <path>}
 * @argument {@code <path>} The path of the file.
 * 
 * @example <strong>saveas "/home/stephen/Desktop/test.txt"</strong>
 * 
 * @note None of the file manipulation commands warn the
 * user before executing. This means there is no check to
 * make sure you want to save the currently open file. 
 * This will be changed in a future update.
 * 
 * @author Stephen Czekalski
 *
 */
public class CommandSaveAs extends Command
{

	/**
	 * Creates a new CommandSaveAs object.
	 * @param commandLine The CommandLine that issued the command. 
	 * @param editor The editor that the command can manipulate. 
	 * @param featureBar The feature bar that the command can manipulate.
	 */
	public CommandSaveAs(CommandLine commandLine, Editor editor, FeatureBar featureBar)
	{
		super("saveas", commandLine, editor, featureBar);
	}

	@Override
	public boolean event(Stage stage, Scene scene, ArrayList<String> tokens)
	{			
		boolean success = false;
		
		if(tokens.size() == 2)
		{
			success = EditorUtil.saveAs(stage, scene, editor, tokens.get(1));
		}
		
		return success;
	}

	@Override
	public String getSuccessMessage(ArrayList<String> tokens)
	{
		return "File Saved: " + tokens.get(1);
	}

	@Override
	public String getFailMessage(ArrayList<String> tokens)
	{
		if(tokens.size() == 2)
		{
			return "Invalid path: " + tokens.get(1);
		}
		else
		{
			return "Enter a path!";
		}
		
	}

}
