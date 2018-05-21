package com.pte.command;

import java.util.ArrayList;

import com.pte.editor.Editor;
import com.pte.util.CSSUtil;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class CommandChangeTheme extends Command
{
	public CommandChangeTheme(Editor editor, CommandLine commandLine)
	{
		super(editor, commandLine, "theme");
	}

	@Override
	public boolean event(Stage stage, Scene scene, ArrayList<String> tokens)
	{
		boolean success = false;
		
		String temp = this.editor.getTheme();
		
		try
		{
			this.editor.setTheme(tokens.get(1));
			CSSUtil.loadTheme(scene, this.editor, tokens.get(1));
			success = true;
		}
		catch(Exception e)
		{
			this.editor.setTheme(temp);
			CSSUtil.loadTheme(scene, this.editor, temp);
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
		return "Failed to load theme: " + tokens.get(1);
	}	
}
