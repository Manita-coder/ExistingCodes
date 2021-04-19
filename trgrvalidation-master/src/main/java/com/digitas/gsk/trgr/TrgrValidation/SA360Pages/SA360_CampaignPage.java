package com.digitas.gsk.trgr.TrgrValidation.SA360Pages;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
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
//import trgrValidation.APITests.stepDefs.$missing$;

public class SA360_CampaignPage {

	Logger log = LoggerHelper.getLogger(SA360_CampaignPage.class);
	SeleniumUtilities su = null;

	public SA360_CampaignPage(WebDriver driver) {
		su = projectUtilities.getSeleniumUtilities();
		PageFactory.initElements(driver, this);
	}

	public SA360_CampaignPage() {

	}

	// @FindAll(@FindBy(how = How.XPATH, using = "
	// .//*[contains(@class,'download-button') and //*[text()='Download']]"))
	// List<WebElement> finalDownloadConfirmation_link;

	@FindBy(how = How.XPATH, using = ".//*[text()='Download']")
	WebElement downloadButton;

	@FindBy(how = How.XPATH, using = ".//*[contains(text(),'Format:')]//../..//td[2]//*")
	WebElement selectFormatDropDown;

	@FindBy(how = How.XPATH, using = ".//*[text()='Comma-separated text file (.csv)']")
	WebElement selectCSV;

	@FindBy(how = How.XPATH, using = "(.//*[text()='Download'])[2]")
	WebElement finalDownload;
	
	

	public String downloadCSVFileAndGetPath(boolean cleanDirectory) {

		String downloadPath = su.getDownloadPath();

		log.info("THe Download path for chrome is set at " + downloadPath);
		File directory = new File(downloadPath);

		if (cleanDirectory) {
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

		}

		su.click(downloadButton);
		log.info("Download button clicked ");
		su.click(selectFormatDropDown);

		su.sleep(4000);
		su.click(selectCSV);
		log.info("Download second click ");

		su.click(finalDownload);
		su.sleep(32000);

		File[] listOfFiles = directory.listFiles();

		String FilePath = "";
		for (File f : listOfFiles) {
			log.info("Files available  " + f.getAbsolutePath());

			if (f.getName().contains("csv"))
			{

				String source = f.getAbsolutePath();
				String destination = downloadPath;

				log.info("source " + source);
				log.info("destination " + destination);

				FilePath = source;

			} 
			else 
			{
				log.info("Failed to download File");
				log.info("THE very Common reason for this is");
				log.info("The Excel File Downloaded earlier is open");
				log.info("The Program cant explicitly close open files just to be catious of data loss");
				log.info("Failed to download File");
				// System.exit(0);
			}
		}

		log.info("File Downloaded at following path : " + FilePath);
		return FilePath;
	}

	public ArrayList<String> getDownloadedFiles() {
		
		String downloadPath = su.getDownloadPath();

		log.info("THe Download path for chrome is set at " + downloadPath);
		File directory = new File(downloadPath);
		
		
		File[] listOfFiles = directory.listFiles();
		ArrayList<String> allFiles = new ArrayList<String>();
		

			for (File f : listOfFiles) {
			log.info("Files available  " + f.getAbsolutePath());

			if (f.getName().contains("csv")) {

				String source = f.getAbsolutePath();
				String destination = downloadPath;

				allFiles.add(source);
				log.info("source " + source);
				log.info("destination " + destination);


			} else {
				log.info("Failed to download File");
				log.info("THE very Common reason for this is");
				log.info("The Excel File Downloaded earlier is open");
				log.info("The Program cant explicitly close open files just to be catious of data loss");
				log.info("Failed to download File");
				// System.exit(0);
			}
		}
		return allFiles;
	}
//	public String DownloadLink()
//	{
//		((WebElement) su.getActiveDriverInstance().findElements(By.xpath("//*[@id=\"gwt-debug--leftnav-full-panel\"]/div/div[1]/div/div[2]/div/div/button[11]"))).click();
//		List<WebElement> we=su.getActiveDriverInstance().findElements(By.xpath("//table[@class='O4RP3QB-b-ic']"));
//		WebElement tableRow = ((WebElement) we).findElement(By.xpath("//*[@id=\"gwt-debug-\"]/td[1]/div/a"));
//		int count=0;
//		//for(int i=0;i<5;i++)
//		//{
//			System.out.println("All the link present on table:"+tableRow.getText());
//			String l=tableRow.getText();
//			tableRow.click();
//			
//		//count++;
//		//System.out.println("no. of link clicked:"+count);
//		//	if(count >5)
//		//		break;
//		//}
//		return l;
//		
//		
//	}

}
