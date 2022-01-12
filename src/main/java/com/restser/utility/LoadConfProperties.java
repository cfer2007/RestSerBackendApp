package com.restser.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadConfProperties {
	
	//private String value;
	
	public String getValue(String name) {
		Properties prop = new Properties();
		if(prop.isEmpty()) {
			try (InputStream input = new FileInputStream("src/main/resources/conf.properties")) {	            	
	            prop.load(input);	            
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
		}
		return prop.getProperty(name);
		
	}
}
