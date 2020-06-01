package com.ddf.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class  Utility {

	public static Object fetchPropertyValue(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream("./config/config.properties");
		Properties prop=new Properties();
	    prop.load(fis);
	    return prop.getProperty(key);
	}
	
	public static String fetchLocatorValue(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream("./config/element.properties");
		Properties prop=new Properties();
	    prop.load(fis);
	    return prop.getProperty(key).toString();
	}

}
