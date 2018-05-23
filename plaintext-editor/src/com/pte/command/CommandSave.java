package com.pte.command;

import java.util.ArrayList;
import com.pte.editor.Editor;
import com.pte.editor.EditorUtil;
import com.pte.featurebar.FeatureBar;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The CommandSave class represents a command that saves
 * the currently open file.
 * 
 * @command {@code save}
 * 
 * @example <strong>save</strong>
 * 
 * @shortcut Ctrl + S - Saves the file.
 * 
 * @note None of the file manipulation commands warn the
 * user before executing. This means there is no check to
 * make sure you want to save the currently open file. 
 * This will be changed in a future update.
 * 
 * @author Stephen Czekalski
 *
 */
public class CommandSave extends Command
{

	/**
	 * Creates a new CommandSave object.
	 * @param commandLine The CommandLine that issued the command. 
	 * @param editor The editor that the command can manipulate. 
	 * @param featureBar The feature bar that the command can manipulate.
	 */
	public CommandSave(CommandLine commandLine, Editor editor, FeatureBar featureBar)
	{
		super("save", commandLine, editor, featureBar);
	}

	@Override
	public boolean event(Stage stage, Scene scene, ArrayList<String> tokens)
	{
		boolean success = false;
						
		if(editor.getFile() != null)
		{
			success = EditorUtil.save(stage, scene, editor);
		}
		
		return success;
	}

	@Override
	public String getSuccessMessage(ArrayList<String> tokens)
	{
		return "File Saved!";
	}

	@Override
	public String getFailMessage(ArrayList<String> tokens)
	{
		return "No file open! Try 'saveas <path>' to save current work.";
	}

}
