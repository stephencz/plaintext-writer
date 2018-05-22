package com.pte.featurebar;

import javafx.scene.control.Label;

public class Feature extends Label
{
	private final String name;
	
	public Feature(String name, String text)
	{
		super(text);
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}

}
