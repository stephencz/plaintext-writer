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
		
		if(tokens.get(1).trim().toUpperCase() == "COMMAND")
		{
			
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
