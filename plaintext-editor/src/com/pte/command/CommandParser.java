package com.pte.command;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandParser
{

	private  CommandLine commandLine;
	
	public CommandParser(CommandLine commandLine)
	{
		this.commandLine = commandLine;
	}

	public ArrayList<String> parse()
	{
		ArrayList<String> parts = new ArrayList<String>();
		//StringTokenizer tokenizer = new StringTokenizer(commandLine.getCommandLine().getText(), " \"");
		
		Pattern pattern = Pattern.compile("(\\w+)|(\"([^\"]*)\")");
		Matcher matcher = pattern.matcher(commandLine.getCommandLine().getText());
		while(matcher.find())
		{
			parts.add(matcher.group().replaceAll("\"", ""));
		}
		
		/*while(tokenizer.hasMoreTokens())
		{
			parts.add(tokenizer.nextToken());
		}*/
		
		if(parts.isEmpty())
		{
			return null;
		}
		else
		{
			return parts;
		}
	}
	
	public CommandLine getCommandLine()
	{
		return commandLine;
	}
	
	public void setCommandLine(CommandLine commandLine)
	{
		this.commandLine = commandLine;
	}
	
}
