package com.pte.command;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.pte.editor.Editor;
import com.pte.featurebar.Feature;
import com.pte.featurebar.FeatureBar;
import com.pte.featurebar.FeatureUtil;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class CommandUpdate extends Command
{

	public CommandUpdate(CommandLine commandLine, Editor editor, FeatureBar featureBar)
	{
		super("update", commandLine, editor, featureBar);
	}

	@Override
	public boolean event(Stage stage, Scene scene, ArrayList<String> tokens)
	{
		boolean success = false;
		
		if(tokens.size() > 1)
		{
			switch(tokens.get(1).trim().toUpperCase())
			{	
			case "FEATURE":
				FeatureUtil.updateWords(featureBar, editor);
				success = true;
				break;
				
			case "COUNT":
				FeatureUtil.updateWords(featureBar, editor);
				success = true;
				break;
				
			case "ALL":
				FeatureUtil.updateWords(featureBar, editor);
				success = true;
				break;
				
			default:
				break;
			}
		}
		else if(tokens.size() <= 1)
		{
			FeatureUtil.updateWords(featureBar, editor);
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
		return null;
	}
}
