package com.pte.command;

import java.util.ArrayList;

import com.pte.editor.Editor;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class CommandHide extends Command
{

	public CommandHide(Editor editor, CommandLine commandLine)
	{
		super(editor, commandLine, "hide");
	}

	@Override
	public boolean event(Stage stage, Scene scene, ArrayList<String> tokens)
	{
		boolean success = false;
				
		switch(tokens.get(1).trim().toUpperCase())
		{
		case "COMMAND": 
			editor.requestFocus();
			this.commandLine.setVisible(false);
			success = true;
			break;
			
		case "FEATURE":
			//HAVE TO FINISH IMPLEMENTING FEATURE BAR
			break;
			
		case "ALL":
			editor.requestFocus();
			this.commandLine.setVisible(false);
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
