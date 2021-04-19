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

public class SA360_forceupload {

	Logger log = LoggerHelper.getLogger(SA360_forceupload.class);
	SeleniumUtilities su = null;

	public SA360_forceupload(WebDriver driver) {
		su = projectUtilities.getSeleniumUtilities();
		PageFactory.initElements(driver, this);
	}

	public SA360_forceupload() {

	}


	@FindBy(how = How.XPATH, using = ".//*[@id='start_date']")
	WebElement startDate;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='end_date']")
	WebElement endDate;
	
	@FindBy(how = How.XPATH, using = ".//*[@type='submit']")
	WebElement uploadButton;

	
	public void clearDatesAndForceUpload() {
		log.info("Clear the date information");
		su.clear(startDate);
		su.clear(endDate);
		log.info("Click upload button");
		su.click(uploadButton);
	}

	public void navigateTo(String sA360_ForceUpload) 
	{
		su.navigateTo(sA360_ForceUpload);
	}

	public void enterDates(String startTime, String currentTime) {
		
		su.clear(startDate);
		su.clear(endDate);
		
		
		log.info("Enter the date information");
		
		log.info("*******************^^^^**************************  startTime " + startTime);
		su.sendKeys(startDate,startTime);
		
		log.info("*********************&^^^***********************  currentTime " + currentTime);
		su.sendKeys(endDate,currentTime);
		
		log.info("Click upload button");
		su.click(uploadButton);
		
	}

}
