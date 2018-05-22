package com.pte.command;

import java.util.ArrayList;

import com.pte.editor.Editor;
import com.pte.featurebar.FeatureBar;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class CommandSetFontSize extends Command
{

	public CommandSetFontSize(CommandLine commandLine, Editor editor, FeatureBar featureBar)
	{
		super("set_fontsize", commandLine, editor, featureBar);
	}

	@Override
	public boolean event(Stage stage, Scene scene, ArrayList<String> tokens)
	{
		boolean success = false;
		
		try
		{
			int fontSize = Integer.parseInt(tokens.get(1));
			this.editor.setFontSize(fontSize);
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
		return "Failed to change font size! Try set_fontsize <size>.";
	}
	
	
	
}
