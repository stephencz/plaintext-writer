package com.pte.editor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public final class EditorUtil
{

	private EditorUtil() { }
	
	public static boolean save(Stage stage, Scene scene, Editor editor)
	{
		boolean success = false;
		
		ObservableList<CharSequence> paragraph = editor.getParagraphs();
		Iterator<CharSequence>  iter = paragraph.iterator();
		try
		{
			BufferedWriter bf = new BufferedWriter(new FileWriter(editor.getFile()));
		    while(iter.hasNext())
		    {
		    	CharSequence seq = iter.next();
		        bf.append(seq);
		        bf.newLine();
		    }
		    
		    bf.flush();
		    bf.close();
		    
		    success = true;
		}
		catch (IOException e)
		{
			success = false;
		}
		
		return success;
	}
	
	public static boolean saveAs(Stage stage, Scene scene, Editor editor, String file)
	{
		boolean success = false;
		
		File outputFile = new File(file);
		if(outputFile != null)
		{
			editor.setFile(outputFile);

			ObservableList<CharSequence> paragraph = editor.getParagraphs();
			Iterator<CharSequence>  iter = paragraph.iterator();
			try
			{
				BufferedWriter buffer = new BufferedWriter(new FileWriter(editor.getFile()));
			    while(iter.hasNext())
			    {
			    	CharSequence seq = iter.next();
			        buffer.append(seq);
			        buffer.newLine();
			    }
			    
			    buffer.flush();
			    buffer.close();
			    
				stage.setTitle(editor.getFile().getName());
				
				success = true;
			}
			catch (IOException e)
			{
				success = false;
			}
		}
		
		return success;
	}
	
	public static boolean open(Stage stage, Scene scene, Editor editor)
	{			
		boolean success = false;
		
		if(editor.getFile() != null)
		{				
			try
			{
				//Creates a BufferedReader and String builder for reading and
				//storing the contents of the file that is being opened.
				final BufferedReader buffer = new BufferedReader(new FileReader(editor.getFile()));
				StringBuilder builder = new StringBuilder();
						
				//Reads the next line as long as line is not null and appends the
				//line to the String builder.
				String line = buffer.readLine();
				while(line != null)
				{
					builder.append(line).append("\n");
					line = buffer.readLine();
				}
						
				buffer.close();
						
				//Sets the text to the StringBuilder String and changes the title
				//to the file's name.
				editor.setText(builder.toString());
				stage.setTitle(editor.getFile().getName());
				
				success = true;
			} 
			catch (Exception e)
			{
				success = false;
			}
		}
		
		return success;
	}
	
	public static boolean newFile(Stage stage, Scene scene, Editor editor)
	{
		boolean success = false;
		
		editor.setFile(null);
		editor.setText("");
		stage.setTitle("untitled");
		
		if(editor.getFile() == null)
		{
			success = true;
		}
		
		return success;
	}
}
