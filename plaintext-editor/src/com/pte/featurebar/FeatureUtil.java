package com.pte.featurebar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.pte.editor.Editor;

public class FeatureUtil
{

	public static void updateParagraphs(FeatureBar featureBar, Editor editor)
	{
		Feature feature = featureBar.getManager().getFeature("PARAGRAPHS");
		
		int paragraphCount = 0;
		
		for(CharSequence paragraph : editor.getParagraphs())
		{
			if(!paragraph.toString().trim().isEmpty())
			{
				paragraphCount++;
			}
		}
		
		feature.setText("Paragraphs: " + paragraphCount);
	}
	
	public static void updateWords(FeatureBar featureBar, Editor editor)
	{
		Feature feature = featureBar.getManager().getFeature("WORDS");
		Pattern pattern = Pattern.compile("(\\b[A-z])");
		
		int wordCount = 0;
		
		for(CharSequence paragraph : editor.getParagraphs())
		{
			Matcher matcher = pattern.matcher(paragraph);
			while(matcher.find())
			{
				wordCount++;
			}
		}
		
		feature.setText("Words: " + wordCount);	
	}
	
}
