package com.pte.command;

import java.util.ArrayList;

import com.pte.editor.Editor;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class CommandFullscreen extends Command
{

	public CommandFullscreen(Editor editor, CommandLine commandLine)
	{
		super(editor, commandLine, "fullscreen");
	}

	@Override
	public boolean event(Stage stage, Scene scene, ArrayList<String> tokens)
	{
		boolean success = false;
		
		if(stage.isFullScreen())
		{
			success = true;
			stage.setFullScreen(false);
		}
		else
		{
			success = true;
			stage.setFullScreen(true);
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
