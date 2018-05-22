package com.pte.command;

import java.util.ArrayList;

import com.pte.editor.Editor;
import com.pte.featurebar.FeatureBar;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class CommandBottom extends Command
{

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
