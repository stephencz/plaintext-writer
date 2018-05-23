package com.pte.command;

import java.util.ArrayList;

import com.pte.editor.Editor;
import com.pte.featurebar.FeatureBar;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The CommandFullscreen class represents a command that can
 * make the window enter or exit fullscreen mode. 
 * 
 * @command {@code fullscreen}
 * @example <strong>fullscreen</strong>
 * @shortcut F11
 * 
 * @author Stephen Czekalski
 *
 */
public class CommandFullscreen extends Command
{

	/**
	 * Creates a new CommandFullscreen Object.
	 * @param commandLine The CommandLine that issued the command.
	 * @param editor The Editor that the command can manipulate.
	 * @param featureBar The FeatureBar that the command can manipulate.
	 */
	public CommandFullscreen(CommandLine commandLine, Editor editor, FeatureBar featureBar)
	{
		super("fullscreen", commandLine, editor, featureBar);
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
