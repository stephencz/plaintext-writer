package com.pte.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtil
{

	public static final String CONFIG_FILE_NAME = "/config";
	
	public static String getDefaultTheme()
	{
		return getConfigProperty("DEFAULT_THEME");
	}
	
	public static String getConfigProperty(String property)
	{
		String value = "";
		Properties prop = new Properties();
		InputStream in = ConfigUtil.class.getResourceAsStream(CONFIG_FILE_NAME);
		
		try
		{
			prop.load(in);
			value = prop.getProperty(property);
			prop.clone();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return value;
	}
	
}
