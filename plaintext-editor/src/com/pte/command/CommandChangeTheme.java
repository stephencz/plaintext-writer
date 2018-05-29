package com.pte.command;

import java.util.ArrayList;

import com.pte.editor.Editor;
import com.pte.featurebar.FeatureBar;
import com.pte.featurebar.FeatureUtil;
import com.pte.util.CSSUtil;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The CommandChangeTheme class represents a command that
 * changes the editor's theme.
 * 
 * @command {@code theme <name>}
 * @argument {@code<name>} The name of the theme to change to.
 * @example <strong>theme light</strong>
 * @example <strong>theme dark</strong>
 * @example <strong>theme hacker</strong>
 * @example <strong>theme relaxed</strong>
 * 
 * @author Stephen Czekalski
 *
 */
public class CommandChangeTheme extends Command
{
	/**
	 * Creates a new CommandChangeTheme object.
	 * @param commandLine The CommandLine that issued the command.
	 * @param editor The Editor that the command can manipulate.
	 * @param featureBar The FeatureBar that the command can manipulate. 
	 */
	public CommandChangeTheme(CommandLine commandLine, Editor editor, FeatureBar featureBar)
	{
		super("theme", commandLine, editor, featureBar);
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
			FeatureUtil.updateThemeDisplay(featureBar, editor);
			success = true;
		}
		catch(Exception e)
		{
			this.editor.setTheme(tokens.get(1));
			CSSUtil.loadTheme(scene, this.editor, tokens.get(1));
			FeatureUtil.updateThemeDisplay(featureBar, editor);
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
