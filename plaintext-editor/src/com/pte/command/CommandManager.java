package com.pte.command;

import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class CommandManager
{	
	private CommandLine commandLine;
	
	private ArrayList<Command> commands;
	
	private boolean resolving;
	
	public CommandManager(CommandLine commandLine)
	{
		this.commandLine = commandLine; 
		commands = new ArrayList<Command>();
		this.resolving = false;

	}

	public ArrayList<Command> getCommands()
	{
		return commands;
	}

	public void setCommands(ArrayList<Command> commands)
	{
		this.commands = commands;
	}
	
	public boolean isResolving()
	{
		return this.resolving;
	}
	
	public void setResolving(boolean resolving)
	{
		this.resolving = resolving;
	}
	
	public void resolve(Stage stage, Scene scene, ArrayList<String> tokens)
	{	
		boolean found = false;
		
		Command target = null;
		
		try 
		{
			if(!this.isResolving())
			{
				this.setResolving(true);
				for(Command command : commands)
				{
					if(command.getIdentifier().toUpperCase().equals(tokens.get(0).toUpperCase().trim()))
					{
						found = true;
						target = command;
						if(command.event(stage, scene, tokens))
						{
							if(command.getSuccessMessage(tokens) != null)
							{
								commandLine.getCommandLine().setText(command.getSuccessMessage(tokens));
								commandLine.getCommandLine().selectAll();
							}
							else
							{
								commandLine.getCommandLine().setText("");
							}
						}
						else
						{
							if(command.getFailMessage(tokens) != null)
							{
								commandLine.getCommandLine().setText(command.getFailMessage(tokens));
								commandLine.getCommandLine().selectAll();
							}
							else
							{
								commandLine.getCommandLine().setText("");
							}
						}
					}
				}
				
				if(!found)
				{
					commandLine.getCommandLabel().setText("Enter Command: ");
					commandLine.getCommandLine().setText("INVALID COMMAND");
					commandLine.getCommandLine().selectAll();
				}
			}
		}
		catch(Exception e)
		{
			if(target != null)
			{
				target.getFailMessage(tokens);
			}
		}
			
		this.setResolving(false);
	}


}
