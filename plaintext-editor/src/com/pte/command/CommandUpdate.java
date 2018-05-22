package com.pte.command;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.pte.editor.Editor;
import com.pte.featurebar.Feature;
import com.pte.featurebar.FeatureBar;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class CommandUpdate extends Command
{

	public CommandUpdate(CommandLine commandLine, Editor editor, FeatureBar featureBar)
	{
		super("update", commandLine, editor, featureBar);
	}

	@Override
	public boolean event(Stage stage, Scene scene, ArrayList<String> tokens)
	{
		boolean success = false;
		
		if(tokens.size() > 1)
		{
			switch(tokens.get(1).trim().toUpperCase())
			{	
			case "FEATURE":
				this.updateAllFeatures();
				success = true;
				break;
				
			case "PARAGRAPHS":
				this.updateParagraphs();
				success = true;
				break;
				
			case "WORDS":
				this.updateWords();
				success = true;
				break;
				
			case "ALL":
				this.updateAll();
				success = true;
				break;
				
			default: 
				this.updateAll();
				success = true;
				break;
			}
		}
		else if(tokens.size() <= 1)
		{
			this.updateAll();
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
	
	private void updateParagraphs()
	{
		Feature feature = this.featurebar.getManager().getFeature("PARAGRAPHS");
		
		int paragraphCount = 0;
		
		for(CharSequence paragraph : this.editor.getParagraphs())
		{
			if(!paragraph.toString().trim().isEmpty())
			{
				paragraphCount++;
			}
		}
		
		feature.setText("Paragraphs: " + paragraphCount);
	}
	
	private void updateWords()
	{
		Feature feature = this.featurebar.getManager().getFeature("WORDS");
		Pattern pattern = Pattern.compile("(\\b[A-z])");
		
		int wordCount = 0;
		
		for(CharSequence paragraph : this.editor.getParagraphs())
		{
			Matcher matcher = pattern.matcher(paragraph);
			while(matcher.find())
			{
				wordCount++;
			}
		}
		
		feature.setText("Words: " + wordCount);
		
	}
	
	private void updateAllFeatures()
	{
		this.updateParagraphs();
		this.updateWords();
	}
	
	private void updateAll()
	{
		this.updateAllFeatures();
	}
}
