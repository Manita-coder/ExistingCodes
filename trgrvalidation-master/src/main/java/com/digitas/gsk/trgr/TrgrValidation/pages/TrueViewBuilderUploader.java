package com.digitas.gsk.trgr.TrgrValidation.pages;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.digitas.gsk.trgr.TrgrValidation.LoggerHelper;
import com.digitas.gsk.trgr.TrgrValidation.SeleniumUtilities;
import com.digitas.gsk.trgr.TrgrValidation.projectUtilities;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TrueViewBuilderUploader {
	Logger log = LoggerHelper.getLogger(TrueViewBuilderUploader.class);
	SeleniumUtilities su = null;

	public TrueViewBuilderUploader(WebDriver driver) {
		su = projectUtilities.getSeleniumUtilities();
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.LINK_TEXT, using = "Force True View Downloader Service")
	WebElement forceTrueViewDownloaderService;

	@FindBy(how = How.LINK_TEXT, using = "Force start of True View Sdf Service")
	WebElement forceStartTrueViewSDF;

	@FindBy(how = How.LINK_TEXT, using = "Force start of TrueView File Builder")
	WebElement forceStartTrueViewFileBuilder;

	@FindBy(how = How.LINK_TEXT, using = "Force True View Uploader Service")
	WebElement forceTrueViewUploaderService;

	@FindBy(how = How.XPATH, using = ".//body/*")
	WebElement statusMesssage;

	public boolean clickforceTrueViewDownloaderService() {
		boolean status = true;

		try {
			su.JSclick(forceTrueViewDownloaderService);
		} catch (Exception e) {
			status = false;
		}
		return status;
	}

	public boolean clickforceStartTrueViewSDF() {
		boolean status = true;

		try {
			su.JSclick(forceStartTrueViewSDF);
		} catch (Exception e) {
			status = false;
		}
		return status;
	}

	public boolean clickStartTrueViewFileBuilder() {
		boolean status = true;

		try {
			su.JSclick(forceStartTrueViewFileBuilder);
		} catch (Exception e) {
			status = false;
		}
		return status;
	}

	public boolean clickTrueViewUploaderService() {
		boolean status = true;

		try {
			status = su.waitForDefinedTime(forceTrueViewUploaderService, 10);
			if (status == true) {
				su.JSclick(forceTrueViewUploaderService);
			}
		} catch (Exception e) {

			status = false;
		}
		return status;
	}

	public String getStatusUploadService() throws IOException {
		String jsonData = "";
		jsonData = su.getText(statusMesssage);
		return jsonData;
	}

	public String getStatusForForceStart() throws IOException {
		String status = "";
		String jsonData = "";
		jsonData = su.getText(statusMesssage);

		JsonNode rootNode;
		ObjectMapper objectMapper;
		objectMapper = new ObjectMapper();
		rootNode = objectMapper.readTree(jsonData);

		status = rootNode.get("statusCode").asText();

		return status;
	}

	public String getStatusSdfService() throws IOException {
		String status = "";
		String jsonData = "";
		jsonData = su.getText(statusMesssage);

		JsonNode rootNode;
		ObjectMapper objectMapper;
		objectMapper = new ObjectMapper();
		rootNode = objectMapper.readTree(jsonData);

		status = rootNode.get("httpCode").asText();

		return status;
	}

	public boolean waitUntillResponseReceived() throws IOException {

		boolean pageLoaded = false;
		String loadMeassage = "";

		while (!pageLoaded) {
			loadMeassage = getStatusUploadService();

			if (loadMeassage.contains("statusCode") || loadMeassage.contains("httpCode")) {
				System.out.println("Success");
				System.out.println("Success");
				System.out.println("Success");
				System.out.println("Success");
				pageLoaded = true;
				break;
			} else if (loadMeassage.contentEquals("ERR_CONNECTION_TIMED_OUT")
					|| loadMeassage.contains("ERR_CONNECTION_REFUSED")) {

				break;
			}
		}

		return pageLoaded;

	}

}
