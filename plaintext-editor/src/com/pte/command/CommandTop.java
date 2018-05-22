package com.pte.command;

import java.util.ArrayList;

import com.pte.editor.Editor;
import com.pte.featurebar.FeatureBar;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class CommandTop extends Command
{

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFailMessage(ArrayList<String> tokens)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
