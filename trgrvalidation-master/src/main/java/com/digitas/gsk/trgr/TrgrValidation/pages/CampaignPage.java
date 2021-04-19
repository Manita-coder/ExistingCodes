package com.digitas.gsk.trgr.TrgrValidation.pages;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
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

public class CampaignPage {

	Logger log = LoggerHelper.getLogger(CampaignPage.class);
	SeleniumUtilities su = null;

	public CampaignPage(WebDriver driver) {
		su = projectUtilities.getSeleniumUtilities();
		PageFactory.initElements(driver, this);
	}

	public CampaignPage() {

	}

	@FindBy(how = How.XPATH, using = ".//div[text()='Status: Active or Draft']")
	WebElement defaultFilter_link;

	@FindBy(how = How.XPATH, using = "(.//*[text()='All']/preceding-sibling::div)[2]")
	WebElement filterALL_popup;

	@FindBy(how = How.XPATH, using = ".//*[text()='Active or Draft']/preceding-sibling::div")
	WebElement filterActiveOrDraft_popup;

	@FindBy(how = How.XPATH, using = ".//*[text()='Active']/preceding-sibling::div")
	WebElement filterActive_popup;

	@FindBy(how = How.XPATH, using = ".//*[text()='Archived']/preceding-sibling::div")
	WebElement filterArchived;

	@FindBy(how = How.XPATH, using = ".//*[text()='Paused']/preceding-sibling::div")
	WebElement filterPaused;

	@FindBy(how = How.XPATH, using = ".//*[text()='Draft']/preceding-sibling::div")
	WebElement filterDraft;

	@FindBy(how = How.XPATH, using = ".//*[text()='Apply']/..")
	WebElement filterApply_link;

	@FindBy(how = How.XPATH, using = ".//*[text()='Show rows:']")
	WebElement lastElementonPage;

	@FindBy(how = How.XPATH, using = ".//*[text()='Line item']/ancestor::div[@role='row']/..")
	WebElement tableWithinTable;

	@FindAll(@FindBy(how = How.XPATH, using = ".//*[text()='Line item']/ancestor::div[@role='row']/../div"))
	List<WebElement> tableRowsWithTable;

	@FindBy(how = How.XPATH, using = ".//material-button[@aria-label='Go to the next page' and @aria-disabled='false']")
	WebElement nextPageOfLineItem_true;

	@FindBy(how = How.XPATH, using = ".//material-button[@aria-label='Go to the next page' and @aria-disabled='false']")
	WebElement nextPageOfLineItem_false;

	@FindBy(how = How.XPATH, using = ".//*[contains(@class,'farRightDropdown')]")
	WebElement dropDown_button;

	@FindBy(how = How.XPATH, using = ".//*[contains(@class,'menu-item-label') and text()='Download']")
	WebElement firstDownloadOption_link;

	@FindAll(@FindBy(how = How.XPATH, using = ".//*[contains(@class,'download-button') and //*[text()='Download']]"))
	List<WebElement> secondDownloadConfiramtion_link;

	@FindAll(@FindBy(how = How.XPATH, using = " .//*[contains(@class,'download-button') and //*[text()='Download']]"))
	List<WebElement> finalDownloadConfirmation_link;

	@FindBy(how = How.XPATH, using = ".//*[text()='Your file is ready to download.']")
	WebElement downloadIsPossible_text;
	@FindBy(how = How.XPATH, using = ".//*[@guidedhelpid='daux-table-select-all-checkbox']")
	WebElement selectAll_checkBox;

	@FindBy(how = How.XPATH, using = ".//*[@buttontext='Action']")
	WebElement action_Link;

	@FindBy(how = How.XPATH, using = ".//*[@role='menuitem' and @aria-label='Pause' and  @aria-disabled='false']/*")
	WebElement pauseActive_Link;

	@FindBy(how = How.XPATH, using = ".//*[@debugid='daux-table-select-all-checkbox']//*[contains(@class,'checked')]")
	WebElement changeStausGoingOn;

	@FindBy(how = How.XPATH, using = ".//*[text()='No line items available']")
	WebElement noMoreLineItems;

	public void changeLineItemStatusToActive() {

		if (!su.exists(defaultFilter_link)) {
			System.out.println("will be done later");
		} else {
			su.click(defaultFilter_link);
			su.click(filterActive_popup);
			su.click(filterApply_link);

			if (su.exists(lastElementonPage)) {
				su.scrollDownToElement(lastElementonPage);
			}
		}
	}

	public void changeLineItemStatusToAll() {

		if (!su.exists(defaultFilter_link)) {
			System.out.println("will be done later");
		} else {
			su.click(defaultFilter_link);
			su.click(filterALL_popup);
			su.click(filterApply_link);
			if (su.exists(lastElementonPage)) {
				su.scrollDownToElement(lastElementonPage);
			}
		}
	}

	public HashMap<String, ArrayList<String>> getlistOfItemsforEachTable() {
		CampaignPage_addFeatures cp = new CampaignPage_addFeatures();
		HashMap<String, ArrayList<String>> hm = cp.getAlltheLineItemforSelectedStatus(tableRowsWithTable,
				nextPageOfLineItem_true);
		return hm;
	}

	public String downloadCSVFileAndGetPath() {

		String downloadPath = su.getDownloadPath();

		log.info("THe Download path for chrome is set at " + downloadPath);
		File directory = new File(downloadPath);

		if (!directory.exists()) {
			directory.mkdir();
			log.info("The directory did not exist so created " + downloadPath);
		}

		try {
			FileUtils.cleanDirectory(directory);
			log.info("The directory had files which were deleted " + downloadPath);
		} catch (Exception e) {
			log.info("The directory did not allow file deletion " + downloadPath);
			System.out.println("all files were not deleted");
		}

		su.click(dropDown_button);
		log.info("Download button clicked ");
		su.click(firstDownloadOption_link);
		log.info("Download second click ");
		// get last element
		su.click(secondDownloadConfiramtion_link.get(secondDownloadConfiramtion_link.size() - 1));
		// su.click(secondDownloadConfiramtion_link);
		log.info("Download second confirmation ");

		su.waitForDefinedTime(downloadIsPossible_text, 30);

		log.info("waiting for the download button ");
		su.sleep(2000);
		// get last element
		su.click(finalDownloadConfirmation_link.get(finalDownloadConfirmation_link.size() - 1));
		// su.click(finalDownloadConfirmation_link);
		log.info("Download second click ");
		su.sleep(10000);
		File[] listOfFiles = directory.listFiles();

		for (File f : listOfFiles) {
			log.info("Files available  " + f.getAbsolutePath());

			log.info("Waiting for SDF.zip ");
			if (f.getName().contains("SDF.zip")) {

				String source = f.getAbsolutePath();
				String destination = downloadPath;

				log.info("source " + source);
				log.info("destination " + destination);
				try {
					ZipFile zipFile = new ZipFile(source);
					zipFile.extractAll(destination);
					log.info("Zip File Extracted");
					break;
				} catch (ZipException e) {

					log.info("Zip Extraction Failed");
					e.printStackTrace();
				}

			} else {
				log.info("Failed to download File");
				log.info("THE very Common reason for this is");
				log.info("The Excel File Downloaded earlier is open");
				log.info("The Program cant explicitly close open files just to be catious of data loss");
				log.info("Failed to download File");
				// System.exit(0);
			}
		}

		log.info("File Downloaded at following path : " + downloadPath + "SDF-LineItems.csv");
		return downloadPath + "SDF-LineItems.csv";
	}

	/*
	 * public HashMap<String, ArrayList<String>>
	 * getlistOfItemsforEachTable_CSV(String selectParam, String filterStatus,
	 * String countryCode, String downloadPath) {
	 * 
	 * CampaignPage_addFeatures cp = new CampaignPage_addFeatures(); HashMap<String,
	 * ArrayList<String>> hm = cp.getAlltheLineItemInCSV(selectParam, filterStatus,
	 * countryCode, downloadPath);
	 * 
	 * return hm; }
	 */

	public boolean selectAllAndMarkAsPaused() {
		log.info("Started to select all");
		su.sleep(2000);

		if (!su.exists(noMoreLineItems)) {

			if (selectAll_checkBox.isDisplayed()) {

				do {
					su.clickCheckBox(selectAll_checkBox);
					su.waitTillElementAppear(selectAll_checkBox, 18000);
					su.click(action_Link);

					if (su.isPresent(pauseActive_Link)) {
						su.click(pauseActive_Link);
						su.waitTillElementDisapers(changeStausGoingOn, 18000);
					}
				} while (!su.exists(noMoreLineItems));

				return true;

			} else {
				log.info("Nothing Active to be marked as Paused");
				su.sleep(100);
				return true;
			}
		} else if (su.isPresent(noMoreLineItems)) {
			log.info("Nothing Active to be marked as Paused");
			su.sleep(100);
			return true;
		} else {
			return false;
		}

	}

}
