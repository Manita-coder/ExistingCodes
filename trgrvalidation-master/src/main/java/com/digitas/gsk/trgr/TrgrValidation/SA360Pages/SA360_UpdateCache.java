package com.digitas.gsk.trgr.TrgrValidation.SA360Pages;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.digitas.gsk.trgr.TrgrValidation.LoggerHelper;
import com.digitas.gsk.trgr.TrgrValidation.SeleniumUtilities;
import com.digitas.gsk.trgr.TrgrValidation.projectUtilities;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

public class SA360_UpdateCache {

	Logger log = LoggerHelper.getLogger(SA360_UpdateCache.class);
	SeleniumUtilities su = null;

	public SA360_UpdateCache(WebDriver driver) {
		su = projectUtilities.getSeleniumUtilities();
		PageFactory.initElements(driver, this);
	}

	public SA360_UpdateCache() 
	{

	}

	@FindBy(how = How.XPATH, using = ".//*[@type='submit']")
	WebElement uploadButton;

	public void navigateTo(String sA360_ForceUpload) {
		su.navigateTo(sA360_ForceUpload);
	}

	public void updateCache()
	{
		log.info("Update cache table");
		su.click(uploadButton);
		System.out.println("updated cache");
		su.sleep(3000);

	}

}
