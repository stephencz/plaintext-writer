package com.pte.command;

import java.io.File;
import java.util.ArrayList;
import com.pte.editor.Editor;
import com.pte.editor.EditorUtil;
import com.pte.featurebar.FeatureBar;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class CommandOpenFile extends Command
{

	public CommandOpenFile(CommandLine commandLine, Editor editor, FeatureBar featureBar)
	{
		super("open", commandLine, editor, featureBar);
	}

	@Override
	public boolean event(Stage stage, Scene scene, ArrayList<String> tokens)
	{
		/*
		boolean success = false;
		
		if(this.editor.getText().trim().equals(""))
		{
			this.editor.setFile(new File(tokens.get(1)));
			if(EditorUtil.open(stage, scene, this.editor))
			{
				success = true;
			}
			else
			{
				success = false;
			}
		}
		else
		{
			if(this.editor.getFile() == null)
			{
				success = EditorUtil.saveAs(stage, scene, this.editor);
			}
			else
			{
				success = EditorUtil.save(stage, scene, this.editor);
			}
			
			EditorUtil.open(stage, scene, editor);
		}*/
		
		this.editor.setFile(new File(tokens.get(1)));
		return EditorUtil.open(stage, scene, editor);
	}

	
	
	@Override
	public String getSuccessMessage(ArrayList<String> tokens)
	{
		// TODO Auto-generated method stub
		return "File open!";
	}

	@Override
	public String getFailMessage(ArrayList<String> tokens)
	{
		return "Failed to open file!";
	}
	
	

}
