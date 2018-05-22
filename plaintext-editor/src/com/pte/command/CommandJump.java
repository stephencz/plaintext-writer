package com.pte.command;

import java.util.ArrayList;

import com.pte.editor.Editor;
import com.pte.featurebar.FeatureBar;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class CommandJump extends Command
{

	public CommandJump(CommandLine commandLine, Editor editor, FeatureBar featureBar)
	{
		super("jump", commandLine, editor, featureBar);
	}

	@Override
	public boolean event(Stage stage, Scene scene, ArrayList<String> tokens)
	{
		boolean success = false;
		
		try
		{
			int paragraphNumber = Integer.parseInt(tokens.get(1));
			int position = 0;
			
			for(int i = 0; i < paragraphNumber - 1; i++)
			{
				CharSequence paragraph = this.editor.getParagraphs().get(i);
				if(!paragraph.toString().trim().equals(""))
				{
					position += paragraph.length() + 1;
				}
			}
			
			this.editor.requestFocus();
			this.editor.positionCaret(position);
				
			success = true;
		}
		catch(Exception e)
		{
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
		return null;
	}

}
