package com.pte.command;

import java.io.File;
import java.util.ArrayList;
import com.pte.editor.Editor;
import com.pte.editor.EditorUtil;
import com.pte.featurebar.FeatureBar;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The CommandOpenFile class represents a command
 * that opens the passed in file.
 * 
 * @command {@code open <path>}
 * @argument {@code <path>} The path to the file.
 * @example <strong>open "/home/stephen/Desktop/test.txt"</strong>
 * 
 * @note None of the file manipulation commands warn the
 * user before executing. This means there is no check to
 * make sure you want to save the currently open file. 
 * This will be changed in a future update.
 * 
 * @author Stephen Czekalski
 *
 */
public class CommandOpenFile extends Command
{

	/**
	 * Creates a new CommandOpenFile object. 
	 * @param commandLine The CommandLine that issued the command.
	 * @param editor The Editor that the command can manipulate.
	 * @param featureBar The FeatureBar that the command can manipulate.
	 */
	public CommandOpenFile(CommandLine commandLine, Editor editor, FeatureBar featureBar)
	{
		super("open", commandLine, editor, featureBar);
	}

	@Override
	public boolean event(Stage stage, Scene scene, ArrayList<String> tokens)
	{
		this.editor.setFile(new File(tokens.get(1)));
		return EditorUtil.open(stage, scene, editor);
	}
	
	@Override
	public String getSuccessMessage(ArrayList<String> tokens)
	{
		return "Opened file: " + tokens.get(1);
	}

	@Override
	public String getFailMessage(ArrayList<String> tokens)
	{
		return "Failed to open file: " + tokens.get(1);
	}
}
