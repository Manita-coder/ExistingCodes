package com.digitas.gsk.trgr.TrgrValidation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.digitas.gsk.trgr.TrgrValidation.db.DataBaseUtilities;

public class projectUtilities {

	static String S = File.separator;
	private static SeleniumUtilities su = null;
	private static DataBaseUtilities du = null;
	static Logger log = LoggerHelper.getLogger(projectUtilities.class);

	static boolean setUpCOmpleteSelenium = false;

	public static void setupProject() {

		log.info("Setting Up Project");

		su = new SeleniumUtilities();
		log.info("Seleium Utilities Loaded");

		du = new DataBaseUtilities();
		log.info("Data Base Utilites Loaded");

	}

	public static void setupSeleniumUtils() {

		try {
			su.setupDriver();
			setUpCOmpleteSelenium = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SeleniumUtilities getSeleniumUtilities() {

		if (setUpCOmpleteSelenium) {
			log.info("Returning Selenium Object");
			return su;
		} else {
			setupSeleniumUtils();
			return su;
		}

	}

	public static DataBaseUtilities getDatabaseUtilities() {
		log.info("Returning Database Object");
		return du;
	}

	public static void tearDown() {
		su.releaseResources();
		setUpCOmpleteSelenium = false;
		log.info("Releasing the Selenium resources");
		du.dropDatabase();
		log.info("Releasing the Database resources");
	}

	public static void tearDown_exceptBrowser() {
		du.dropDatabase();
		log.info("Releasing the Database resources");
	}

	public static String getPropertyValue(String key) {

		Properties prop = new Properties();
		InputStream input = null;
		String property = "";

		try {

			File f = new File(System.getProperty("user.dir") + S + "src" + S + "test" + S + "resources" + S
					+ "testConfig.properties");
			input = new FileInputStream(f);

			prop.load(input);
			property = prop.getProperty(key);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return property.trim();
	}

	public static String getPropertyValueSA360(String key) {

		Properties prop = new Properties();
		InputStream input = null;
		String property = "";

		try {

			File f = new File(System.getProperty("user.dir") + S + "resources" + S + "DMA_Mapping.properties");
			input = new FileInputStream(f);

			prop.load(input);
			property = prop.getProperty(key);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return property.trim();
	}
}
