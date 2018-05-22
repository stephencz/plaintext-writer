package com.pte.command;

import java.util.ArrayList;
import com.pte.editor.Editor;
import com.pte.editor.EditorUtil;
import com.pte.featurebar.FeatureBar;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class CommandSave extends Command
{

	public CommandSave(CommandLine commandLine, Editor editor, FeatureBar featureBar)
	{
		super("save", commandLine, editor, featureBar);
	}

	@Override
	public boolean event(Stage stage, Scene scene, ArrayList<String> tokens)
	{
		boolean success = false;
						
		if(editor.getFile() != null)
		{
			success = EditorUtil.save(stage, scene, editor);
		}
		
		return success;
	}

	@Override
	public String getSuccessMessage(ArrayList<String> tokens)
	{
		return "File Saved!";
	}

	@Override
	public String getFailMessage(ArrayList<String> tokens)
	{
		return "No file open! Try 'saveas <destination>' to save current work.";
	}

}
