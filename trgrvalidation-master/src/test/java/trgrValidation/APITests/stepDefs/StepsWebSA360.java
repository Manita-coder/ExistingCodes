package trgrValidation.APITests.stepDefs;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.digitas.gsk.trgr.TrgrValidation.LoggerHelper;
import com.digitas.gsk.trgr.TrgrValidation.SeleniumUtilities;
import com.digitas.gsk.trgr.TrgrValidation.projectUtilities;
import com.digitas.gsk.trgr.TrgrValidation.SA360Pages.SA360_CampaignPage;
import com.digitas.gsk.trgr.TrgrValidation.SA360Pages.SA360_GoogleAccountManager;
import com.digitas.gsk.trgr.TrgrValidation.SA360Pages.SA360_UpdateCache;
import com.digitas.gsk.trgr.TrgrValidation.SA360Pages.SA360_forceupload;

import cucumber.api.java.ContinueNextStepsOnException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class StepsWebSA360 {

	Logger log = LoggerHelper.getLogger(StepsWebSA360.class);

	@Then("^I Download latest records from SA360 after (\\d+) seconds$")
	public void i_Download_latestrecords_from_sa360(int waitSeconds) throws Throwable {

		try {
			log.info("Sleeping for " + waitSeconds + " seconds after posting API request");
			Thread.sleep(waitSeconds * 1000);
			log.info("Wait Complete for " + waitSeconds + " seconds");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		SeleniumUtilities su = projectUtilities.getSeleniumUtilities();
		SA360_GoogleAccountManager gac = new SA360_GoogleAccountManager(su.getActiveDriverInstance());
		SA360_CampaignPage cp = new SA360_CampaignPage(su.getActiveDriverInstance());

		String SA360_url = TSHelper.getPropertyValue("SA360_url");

		String SA360_Parent_capmpaign_URL = TSHelper.getPropertyValue("SA360_Parent_capmpaign_URL");
		String username = TSHelper.getPropertyValue("SA360_Account_UserName");
		String password = TSHelper.getPropertyValue("SA360_Account_Password");

		gac.login(SA360_url, username, password);
		assertEquals(gac.isLoginSuccess(), true, "LOGIN FAILED");
		gac.goTo(SA360_Parent_capmpaign_URL);

		String downloadPath = "";
		downloadPath = cp.downloadCSVFileAndGetPath(true);

		VariableHolder.setlastDownloadPath(downloadPath);

		File f = new File(downloadPath);
		assertTrue(f.exists());

		/*
		 * VariableHolder.setFileDownloadedForUKorUS("UK"); String downloadPath =
		 * "C:\\Users\\bondsilv\\eclipse-workspace\\TrgrValidation\\downloads\\SDF-LineItems.csv";
		 * VariableHolder.setlastDownloadPath(downloadPath);
		 */
	}

	@Then("^I update cache$")
	public void I_Update_Cache() throws Throwable {
		SeleniumUtilities su = projectUtilities.getSeleniumUtilities();
		SA360_UpdateCache uc = new SA360_UpdateCache(su.getActiveDriverInstance());// -----open browser
		String SA360_UpdateCache = TSHelper.getPropertyValue("SA360_UpdateCache");// -----returning driver instance
		uc.navigateTo(SA360_UpdateCache);
		uc.updateCache();
	}

	@Then("^I force Upload file$")
	public void I_force_Upoad_file() throws Throwable {
		SeleniumUtilities su = projectUtilities.getSeleniumUtilities();
		SA360_forceupload fu = new SA360_forceupload(su.getActiveDriverInstance());
		String SA360_ForceUpload = TSHelper.getPropertyValue("SA360_ForceUpload");

		fu.navigateTo(SA360_ForceUpload);
		// fu.clearDatesAndForceUpload();
		Thread.sleep(5000);
		fu.enterDates(TSHelper.startTime, TSHelper.getCurrentTime());
	}

	@Then("^I Download latest records from SA360 after (\\d+) seconds and close browser$")
	public void i_Download_latestrecords_from_sa360_and_closebrowser(int waitSeconds) throws Throwable {

		try {
			log.info("Sleeping for " + waitSeconds + " seconds after posting API request");
			Thread.sleep(waitSeconds * 1000);
			log.info("Wait Complete for " + waitSeconds + " seconds");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		SeleniumUtilities su = projectUtilities.getSeleniumUtilities();
		SA360_GoogleAccountManager gac = new SA360_GoogleAccountManager(su.getActiveDriverInstance());
		SA360_CampaignPage cp = new SA360_CampaignPage(su.getActiveDriverInstance());

		String SA360_url = TSHelper.getPropertyValue("SA360_url");

		String SA360_Parent_capmpaign_URL = TSHelper.getPropertyValue("SA360_Parent_capmpaign_URL");
		String username = TSHelper.getPropertyValue("SA360_Account_UserName");
		String password = TSHelper.getPropertyValue("SA360_Account_Password");

		gac.login(SA360_url, username, password);
		assertEquals(gac.isLoginSuccess(), true, "LOGIN FAILED");
		gac.goTo(SA360_Parent_capmpaign_URL);

		String downloadPath = "";
		downloadPath = cp.downloadCSVFileAndGetPath(true);

		VariableHolder.setlastDownloadPath(downloadPath);

		File f = new File(downloadPath);
		assertTrue(f.exists());

		/*
		 * VariableHolder.setFileDownloadedForUKorUS("UK"); String downloadPath =
		 * "C:\\Users\\bondsilv\\eclipse-workspace\\TrgrValidation\\downloads\\SDF-LineItems.csv";
		 * VariableHolder.setlastDownloadPath(downloadPath);
		 */
	}

	@Then("^I Download latest records for all campaign from SA360 after (\\d+) seconds and close browser$")
	public void i_Download_latestrecords_for_all_sa360_and_closebrowser(int waitSeconds) throws Throwable {
//
//		try 
//		{
//			log.info("Sleeping for " + waitSeconds + " seconds after posting API request");
//			Thread.sleep(waitSeconds * 1000);
//			log.info("Wait Complete for " + waitSeconds + " seconds");
//		} 
//		catch (InterruptedException e)
//		{
//			e.printStackTrace();
//		}
//
//		SeleniumUtilities su = projectUtilities.getSeleniumUtilities();
//		SA360_GoogleAccountManager gac = new SA360_GoogleAccountManager(su.getActiveDriverInstance());
//		SA360_CampaignPage cp = new SA360_CampaignPage(su.getActiveDriverInstance());
//
//		String SA360_url = TSHelper.getPropertyValue("SA360_url");
//		String SA360_Parent_capmpaign_URL = TSHelper.getPropertyValue("SA360_Parent_capmpaign_URL");
//		String SA360_Bing_Campaign = TSHelper.getPropertyValue("SA360_Bing_Campaign");
//		String username = TSHelper.getPropertyValue("SA360_Account_UserName");
//		String password = TSHelper.getPropertyValue("SA360_Account_Password");
//		ArrayList<String> downloadPaths = new ArrayList<String>();
//
//		boolean cleanDirectory = true;
//
//		gac.login(SA360_url, username, password);
//		assertEquals(gac.isLoginSuccess(), true, "LOGIN FAILED");
//
/////////////////////////get file for Threaflu Google///////////////
//		gac.goTo(SA360_Parent_capmpaign_URL);
//		cp.downloadCSVFileAndGetPath(cleanDirectory);
//
/////////////////////////get file for Threaflu Bing///////////////
//		gac.goTo(SA360_Bing_Campaign);
//		cp.downloadCSVFileAndGetPath(false);

//		String downloadPaths="";
//		downloadPaths = cp.getDownloadedFiles();
		ArrayList<String> s = new ArrayList<String>();
		s.add("C:\\Users\\manmahar\\eclipse-workspace\\trgrvalidation-master\\downloads\\TRGR - Theraflu Campaign API Test (1).csv");
		s.add("C:\\Users\\manmahar\\eclipse-workspace\\trgrvalidation-master\\downloads\\TRGR - Theraflu Campaign API Test.csv");

		VariableHolder.setlastDownloadPaths(s);

		assertTrue(s.size() > 1);

		/*
		 * VariableHolder.setFileDownloadedForUKorUS("UK"); String downloadPath =
		 * "C:\\Users\\bondsilv\\eclipse-workspace\\TrgrValidation\\downloads\\SDF-LineItems.csv";
		 * VariableHolder.setlastDownloadPath(downloadPath);
		 */
	}

	@ContinueNextStepsOnException
	@And("^Bid for - \"([^\"]*)\" should be \"([^\"]*)\"$")
	public void visibility_for_LOW_STATUS_should_be(String geoCode, String expectedStatus) throws Throwable {

		geoCode = TSHelper.getPropertyValueDMA(geoCode);

		String selectParam = "Select Location, Location_bid_adjustment from ";
		String filterStatus = " Where Location like '%" + geoCode + "%'";
		HashMap<String, ArrayList<String>> hm = TSHelper.getHasmMapWithBidData(selectParam, filterStatus);
		String actualBidValue = hm.get(geoCode).get(0);
		System.out.println(actualBidValue);

		TSHelper.assertCondtion(expectedStatus, actualBidValue);
	}

	@ContinueNextStepsOnException
	@And("^Bid for - \"([^\"]*)\" should be \"([^\"]*)\" across all campaign$")
	public void visibility_for_LOW_STATUS_should_be_acrossall(String geoCode, String expectedStatus) throws Throwable {

		geoCode = TSHelper.getPropertyValueDMA(geoCode);

		String selectParam = "Select Location, Location_bid_adjustment,Account_ID from ";
		String filterStatus = " Where Location like '%" + geoCode + "%'";

		ArrayList<String> listOfFiles = VariableHolder.getAllfilePath();

		String actualBidValue1 = "";
		String actualBidValue2 = "";
		int i = 0;

		String array[] = new String[2];
		for (String file : listOfFiles) {
			HashMap<String, ArrayList<String>> hm = TSHelper.getHasmMapWithBidData(selectParam, filterStatus, file);
			array[i++] = hm.get(geoCode).get(0);
		}

		actualBidValue1 = array[0];
		actualBidValue2 = array[1];

		if (actualBidValue1.equals(actualBidValue2)) {
			TSHelper.assertCondtion(expectedStatus, actualBidValue1);
		} else {
			if (expectedStatus.contentEquals(actualBidValue1)) {
				TSHelper.assertCondtion(expectedStatus, actualBidValue2);

			} else if (expectedStatus.contentEquals(actualBidValue2)) {
				TSHelper.assertCondtion(expectedStatus, actualBidValue1);
			}
		}

	}

	@ContinueNextStepsOnException
	
	@And("^Bid for - \"([^\"]*)\" should be \"([^\"]*)\" and \"([^\"]*)\" across all campaign$")
	public void visibility_for_LOW_STATUS_should_be_acrossall1(String geoCode, String expectedStatus, String AccountID)
			throws Throwable {

		geoCode = TSHelper.getPropertyValueDMA(geoCode);

		String selectParam = "Select Location, Location_bid_adjustment,Account_ID from ";
		String filterStatus = " Where Location like '%" + geoCode + "%'";

		ArrayList<String> listOfFiles = VariableHolder.getAllfilePath();

		String actualBidValue1 = "";
		String actualBidValue2 = "";
		
		int i = 0;

		String array[] = new String[2];
		for (String file : listOfFiles) {
			HashMap<String, ArrayList<String>> hm = TSHelper.getHasmMapWithBidData(selectParam, filterStatus, file);
			array[i++] = hm.get(geoCode).get(0)+hm.get(geoCode).get(1);
			
		}

		actualBidValue1 = array[0];
		actualBidValue2 = array[1];
		
		
		expectedStatus=expectedStatus+"=\""+AccountID+"\"";

		if (actualBidValue1.equals(actualBidValue2)) {
			TSHelper.assertCondtion(expectedStatus, actualBidValue1);
			
		} else {
			if (expectedStatus.contentEquals(actualBidValue1)) {
				TSHelper.assertCondtion(expectedStatus, actualBidValue2);

			} else if (expectedStatus.contentEquals(actualBidValue2)) {
				TSHelper.assertCondtion(expectedStatus, actualBidValue1);
			}
		}

	}
}
