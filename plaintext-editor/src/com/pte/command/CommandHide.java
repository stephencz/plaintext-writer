package com.pte.command;

import java.util.ArrayList;

import com.pte.editor.Editor;
import com.pte.featurebar.FeatureBar;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class CommandHide extends Command
{

	public CommandHide(CommandLine commandLine, Editor editor, FeatureBar featureBar)
	{
		super("hide", commandLine, editor, featureBar);
	}


	@Override
	public boolean event(Stage stage, Scene scene, ArrayList<String> tokens)
	{
		boolean success = false;
				
		switch(tokens.get(1).trim().toUpperCase())
		{
		case "COMMAND": 
			this.editor.requestFocus();
			this.commandLine.setVisible(false);
			success = true;
			break;
			
		case "FEATURE":
			this.featureBar.setVisible(false);
			success = true;
			break;
			
		case "COUNT":
			this.featureBar.getManager().getFeature("COUNT").setVisible(false);
			success = true;
			break;
			
		case "ALL":
			this.editor.requestFocus();
			this.commandLine.setVisible(false);
			this.featureBar.setVisible(false);
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
