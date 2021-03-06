package com.pte.command;

import java.util.ArrayList;

import com.pte.editor.Editor;
import com.pte.featurebar.FeatureBar;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The CommandBottom class represents a command that positions
 * the user's editor caret at the bottom of the document.
 * 
 * @command {@code bottom}
 * @example <strong>bottom</strong>
 * 
 * @author Stephen Czekalski
 *
 */
public class CommandBottom extends Command
{

	/**
	 * Creates a new CommandBottom object.
	 * @param commandLine The CommandLine that will issue the command.
	 * @param editor The Editor that can be manipulated by the command.
	 * @param featureBar The FeatureBar that can be manipulated by the command.
	 */
	public CommandBottom(CommandLine commandLine, Editor editor, FeatureBar featureBar)
	{
		super("bottom", commandLine, editor, featureBar);
	}

	@Override
	public boolean event(Stage stage, Scene scene, ArrayList<String> tokens)
	{
		this.editor.requestFocus();
		this.editor.positionCaret(this.editor.getLength());

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
