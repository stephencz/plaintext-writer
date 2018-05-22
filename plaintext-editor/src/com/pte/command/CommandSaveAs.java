package com.pte.command;

import java.util.ArrayList;
import com.pte.editor.Editor;
import com.pte.editor.EditorUtil;
import com.pte.featurebar.FeatureBar;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class CommandSaveAs extends Command
{

	public CommandSaveAs(CommandLine commandLine, Editor editor, FeatureBar featureBar)
	{
		super("saveas", commandLine, editor, featureBar);
	}

	@Override
	public boolean event(Stage stage, Scene scene, ArrayList<String> tokens)
	{				
		return EditorUtil.saveAs(stage, scene, editor, tokens.get(1));
	}

	@Override
	public String getSuccessMessage(ArrayList<String> tokens)
	{
		return "File Saved!";
	}

	@Override
	public String getFailMessage(ArrayList<String> tokens)
	{
		return "Invalid destination!";
	}

}
