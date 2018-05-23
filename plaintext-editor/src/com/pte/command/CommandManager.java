package com.pte.command;

import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The CommandManager class is responsible for managing
 * a CommandLine object's available commands.
 * 
 * @author Stephen Czekalski
 *
 */
public class CommandManager
{	
	/**True when the manager is resolving a command. Otherwise false.*/
	private boolean resolving;
	
	/**The CommandLine the CommandManager belongs to.*/
	private CommandLine commandLine;
	
	/**An ArrayList of all available Command objects.*/
	private ArrayList<Command> commands;
	
	/**
	 * Creates a new CommandManager
	 * @param commandLine The CommandLine the CommandManager belongs to.
	 */
	public CommandManager(CommandLine commandLine)
	{
		this.resolving = false;
		
		this.commandLine = commandLine; 
		commands = new ArrayList<Command>();

	}

	/**@return An ArrayList of available Command objects.*/
	public ArrayList<Command> getCommands()
	{
		return commands;
	}

	/**@param commands An ArrayList of Commands objects.*/
	public void setCommands(ArrayList<Command> commands)
	{
		this.commands = commands;
	}
	
	/**@return True when the manager is resolving a command. Otherwise false.*/
	public boolean isResolving()
	{
		return this.resolving;
	}
	
	/**@param resolving Whether or not the manager is resolving a command.*/
	public void setResolving(boolean resolving)
	{
		this.resolving = resolving;
	}
	
	/**
	 * Resolves the command in the manager's CommandLine object from the
	 * passed in tokens.
	 * @param stage The primary stage.
	 * @param scene The current scene.
	 * @param tokens The parts of the command. Probably from a CommandParser.
	 */
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
