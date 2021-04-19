package com.digitas.automation.utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class FirefoxDriverConfig
{
	private static FirefoxDriverConfig firefoxDriverConfig= null;
	private WebDriver firefoxDriver = null;
	
	private final String FIREBUG_VERSION = "1.8.4";
	private final String FIREBUG_ADDON = "firebug-"+FIREBUG_VERSION+".xpi";
	
	private FirefoxDriverConfig(){
		   try{
			   FirefoxProfile firefoxProfile = new FirefoxProfile();
			   File file = new File(FIREBUG_ADDON);
//		   	   firefoxProfile.setEnableNativeEvents(true);
//			   System.setProperty("webdriver.gecko.driver", "C://Users//deenadel//Desktop//geckodriver.exe");
			   ((FirefoxProfile) firefoxProfile).addExtension(file);
			   ((FirefoxProfile) firefoxProfile).setPreference("extensions.firebug.currentVersion", FIREBUG_VERSION); // Avoid startup screen	
			   firefoxDriver = new FirefoxDriver();
		   }catch(WebDriverException e){
			   firefoxDriver = new FirefoxDriver();
			   
		   }catch (IOException e) {
			 
		}
	}
	
	public static FirefoxDriverConfig getInstance(){
		if (firefoxDriverConfig == null){
			firefoxDriverConfig = new FirefoxDriverConfig();
		}
		return firefoxDriverConfig;
	}
	
	public WebDriver getFirefoxDriver(){
		return firefoxDriver;
	}
}
