package com.test.common.framework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;

public class ConfigReader {
	private Properties properties = new Properties();
	String configPropertiesFile = "config/configuration.properties";
	private static ConfigReader config = null;
	
	private ConfigReader(){
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(configPropertiesFile));
			properties.load(br);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
	
	public static ConfigReader getConfig(){
		if (config == null)
			return new ConfigReader();
		else
			return config;
	}
	
	public String getEnvironment(){
		return properties.getProperty("environment");
	}
	
	public String getBrowser(){
		return properties.getProperty("browser");
	}
	
	public  String getImplicitwait(){
		return properties.getProperty("implicitlyWait");
	}
	
	public  String getAppUrl(){
		return properties.getProperty("url");
	}
	
	public String getAppUserName(){
		return properties.getProperty("app.username");
	}
	
	public String getAppPassword(){
		return properties.getProperty("app.password");
	}

}
