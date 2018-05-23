package com.pte.command;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The CommandParser classes responsibility is to parse the
 * text inside of a CommandLine's text field/input.
 * 
 * @author Stephen Czekalski
 *
 */
public class CommandParser
{

	/**The CommandLine object that will be parsed.*/
	private  CommandLine commandLine;
	
	/**
	 * Creates a new CommandParser object.
	 * @param commandLine The CommandLine object that will be parsed.
	 */
	public CommandParser(CommandLine commandLine)
	{
		this.commandLine = commandLine;
	}

	/**@return The CommandLine object that will be parsed.*/
	public CommandLine getCommandLine()
	{
		return commandLine;
	}
	
	/**@param commandLine The CommandLine object that will be parsed.*/
	public void setCommandLine(CommandLine commandLine)
	{
		this.commandLine = commandLine;
	}
	
	/**
	 * Parses the CommandLine and returns an ArrayList of String tokens.
	 * @return An ArrayList of Strings representing the parts of the command. If
	 * no tokens where found than null is returned instead.
	 */
	public ArrayList<String> parse()
	{
		ArrayList<String> tokens = new ArrayList<String>();		
		
		Pattern pattern = Pattern.compile("(\\w+)|(\"([^\"]*)\")");
		Matcher matcher = pattern.matcher(commandLine.getCommandLine().getText());
		while(matcher.find())
		{
			if(matcher.group().startsWith("\""))
			{
				tokens.add(matcher.group().substring(1, matcher.group().length() - 1));
			}
			else
			{
				tokens.add(matcher.group());
			}
		}
		
		if(tokens.isEmpty())
		{
			return null;
		}
		else
		{
			return tokens;
		}
	}
	
}
