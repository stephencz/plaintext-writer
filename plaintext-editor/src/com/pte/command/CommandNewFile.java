package com.pte.command;

import java.util.ArrayList;

import com.pte.editor.Editor;
import com.pte.editor.EditorUtil;
import com.pte.featurebar.FeatureBar;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The CommandNewFile class represents a command that
 * creates a new file.
 * 
 * @command {@code new}
 * @example <strong>new</strong>
 * 
 * @note None of the file manipulation commands warn the
 * user before executing. This means there is no check to
 * make sure you want to save the currently open file. 
 * This will be changed in a future update.
 * 
 * @author Stephen Czekalski
 *
 */
public class CommandNewFile extends Command
{

	/**
	 * Creates a new CommandNewFile object.
	 * @param commandLine The CommandLine that issued the command.
	 * @param editor The Editor that the command can manipulate.
	 * @param featureBar The FeatureBar that the command can manipulate/
	 */
	public CommandNewFile(CommandLine commandLine, Editor editor, FeatureBar featureBar)
	{
		super("new", commandLine, editor, featureBar);
	}

	@Override
	public boolean event(Stage stage, Scene scene, ArrayList<String> tokens)
	{
		if(editor.getFile() != null)
		{
			
		}
		
		return EditorUtil.newFile(stage, scene, editor);
	}

	@Override
	public String getSuccessMessage(ArrayList<String> tokens)
	{
		return "New file created!";
	}

	@Override
	public String getFailMessage(ArrayList<String> tokens)
	{
		return "Failed to create new file!";
	}

}
