package com.wuhulala.loginsystem.config;

import java.util.Properties;


public class Config {

	private static Properties config = new Properties();
	
	private static String path = "/config.properties";
	
	
	static{
		try {
			config.load(Config.class.getResourceAsStream(path));
		} catch (Exception e) {
		}
	}
	
	public static String getValue(String key) {
		String value = (String)config.get(key);
		return value;
	}
	
	public static void main(String[] args) {
		System.out.println(getValue("file.path"));
	}
}
