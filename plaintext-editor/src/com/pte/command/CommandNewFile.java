package com.pte.command;

import java.util.ArrayList;

import com.pte.editor.Editor;
import com.pte.editor.EditorUtil;
import com.pte.featurebar.FeatureBar;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class CommandNewFile extends Command
{

	public CommandNewFile(CommandLine commandLine, Editor editor, FeatureBar featureBar)
	{
		super("new", commandLine, editor, featureBar);
	}

	@Override
	public boolean event(Stage stage, Scene scene, ArrayList<String> tokens)
	{
		return EditorUtil.newFile(stage, scene, editor);
	}

	@Override
	public String getSuccessMessage(ArrayList<String> tokens)
	{
		return "New file created!";
	}

	@Override
	public String getFailMessage(ArrayList<String> tokens)
	{
		return "Failed to create new file!";
	}

}
