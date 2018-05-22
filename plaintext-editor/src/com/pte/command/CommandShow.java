package com.pte.command;

import java.util.ArrayList;

import com.pte.editor.Editor;
import com.pte.featurebar.FeatureBar;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class CommandShow extends Command
{

	public CommandShow(CommandLine commandLine, Editor editor, FeatureBar featureBar)
	{
		super("show", commandLine, editor, featureBar);
	}

	@Override
	public boolean event(Stage stage, Scene scene, ArrayList<String> tokens)
	{
		boolean success = false;
		
		switch(tokens.get(1).trim().toUpperCase())
		{
		case "COMMAND": 
			this.commandLine.setVisible(true);
			success = true;
			break;
			
		case "FEATURE":
			this.featurebar.setVisible(true);
			success = true;
			break;
			
		case "PARAGRAPHS":
			this.featurebar.getManager().getFeature("PARAGRAPHS").setVisible(true);
			success = true;
			break;
			
		case "WORDS":
			this.featurebar.getManager().getFeature("WORDS").setVisible(true);
			success = true;
			break;
			
		case "ALL":
			this.commandLine.setVisible(true);
			this.featurebar.setVisible(true);
			
			success = true;
			break;
			
		default: 
			break;
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
