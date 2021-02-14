package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

	//declare 
	public static FileInputStream inputStream = null;
	public static Properties prop = null; //to load and read from properties file
	public static String ReadProperty(String PropertyName) throws IOException{
		String PropertyValue = null;
		String ProjectPath ="/home/khadkasnareshgm/eclipse-workspace/AmazonServlet/WebContent";
		inputStream = new FileInputStream(ProjectPath + "/WEB-INF/config.properties");
		prop = new Properties();
		prop.load(inputStream);
		PropertyValue = prop.getProperty(PropertyName);
		return PropertyValue;		
	}
	
	public static void main(String[] args) throws IOException{
		System.out.println(PropertyReader.ReadProperty("url"));
		System.out.println(PropertyReader.ReadProperty("userid"));
		System.out.println(PropertyReader.ReadProperty("password"));
	}
}
