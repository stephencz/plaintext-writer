package com.pte.command;

import java.util.ArrayList;

import com.pte.editor.Editor;
import com.pte.featurebar.FeatureBar;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The CommandTop class represents a command that positions
 * the user's editor caret at the top of the document.
 * 
 * @command {@code top}
 * @example <strong>top</strong>
 * 
 * @author Stephen Czekalski
 *
 */
public class CommandTop extends Command
{

	/**
	 * Creates a new CommandTop object.
	 * @param commandLine The CommandLine that will issue the command.
	 * @param editor The Editor that can be manipulated by the command.
	 * @param featureBar The FeatureBar that can be manipulated by the command.
	 */
	public CommandTop(CommandLine commandLine, Editor editor, FeatureBar featureBar)
	{
		super("top", commandLine, editor, featureBar);
	}

	@Override
	public boolean event(Stage stage, Scene scene, ArrayList<String> tokens)
	{
		this.editor.requestFocus();
		this.editor.positionCaret(0);

		return true;
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
