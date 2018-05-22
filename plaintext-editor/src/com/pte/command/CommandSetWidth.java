package com.pte.command;

import java.util.ArrayList;

import com.pte.editor.Editor;
import com.pte.featurebar.FeatureBar;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class CommandSetWidth extends Command
{

	public CommandSetWidth(CommandLine commandLine, Editor editor, FeatureBar featureBar)
	{
		super("set_width", commandLine, editor, featureBar);
	}
	
	@Override
	public boolean event(Stage stage, Scene scene, ArrayList<String> tokens)
	{
		boolean success = false;
		
		try
		{
			int width = Integer.parseInt(tokens.get(1));
			this.editor.setEditorWidth(width);
			success = true;
		}
		catch(NumberFormatException e)
		{
			success = false;
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
		return "Failed to change width! Try set_width <width>.";
	}

	
	
}
