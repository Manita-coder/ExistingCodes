package com.digitas.gsk.trgr.TrgrValidation;

import org.apache.log4j.PropertyConfigurator;

import java.io.File;

import org.apache.log4j.Logger;

public class LoggerHelper {

	static String S = File.separator;
	private static boolean root=false;
	
	public static Logger getLogger(Class<?> cls) {
		if(root) {
			return Logger.getLogger(cls);
		}
		PropertyConfigurator.configure(System.getProperty("user.dir") + S +"log4j.properties");
		root = true;
		return Logger.getLogger(cls);
	}
}
