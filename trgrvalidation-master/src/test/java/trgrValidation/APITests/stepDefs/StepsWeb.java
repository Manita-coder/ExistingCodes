package trgrValidation.APITests.stepDefs;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TimeZone;

import org.apache.log4j.Logger;

import com.digitas.gsk.trgr.TrgrValidation.APICaller;
import com.digitas.gsk.trgr.TrgrValidation.LoggerHelper;
import com.digitas.gsk.trgr.TrgrValidation.SeleniumUtilities;
import com.digitas.gsk.trgr.TrgrValidation.myAssertionException;
import com.digitas.gsk.trgr.TrgrValidation.projectUtilities;
import com.digitas.gsk.trgr.TrgrValidation.pages.CampaignPage;
import com.digitas.gsk.trgr.TrgrValidation.pages.GoogleAccountManager;
import com.digitas.gsk.trgr.TrgrValidation.pages.TrueViewBuilderUploader;

import cucumber.api.java.ContinueNextStepsOnException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepsWeb {

	
	Logger log = LoggerHelper.getLogger(StepsWeb.class);

	@Given("^All Line Items are paused in DV360 for \"([^\"]*)\"$")
	public void all_line_items_are_paused(String campaingnName) {

		SeleniumUtilities su = projectUtilities.getSeleniumUtilities();
		GoogleAccountManager gac = new GoogleAccountManager(su.getActiveDriverInstance());
		CampaignPage cp = new CampaignPage(su.getActiveDriverInstance());
		String username = TSHelper.getPropertyValue("DV360_Account_UserName");
		String password = TSHelper.getPropertyValue("DV360_Account_Password");
		String dv360_url = TSHelper.getPropertyValue("DV360_url");

		gac.login(username, password);
		assertEquals(gac.isLoginSuccess(), true, "LOGIN FAILED");

		gac.gotoCampaignPage(dv360_url, campaingnName);

		// gac.goTo(dv360_url);
		// su.sleep(1000);
		// gac.clickOnAdvertiserLink();
		// su.sleep(2000);
		// gac.clickOnMainCampaign();
		// su.sleep(2000);

		// if (campaingnName.contains("UK")) {
		// gac.clickOnUKCampaign();
		// } else {
		// gac.clickOnUSCampaign();
		// }
		// su.sleep(2000);
		// gac.clickOnLineItemsTab();

		cp.changeLineItemStatusToActive();
		assertTrue(cp.selectAllAndMarkAsPaused());
	}

	@Given("^Force trueview Downloader Service$")
	public void Force_trueview_Downloader_Service() throws IOException, myAssertionException {
		String trueviewServiceURL = TSHelper.getPropertyValue("Force_True_View_Downloader_Service");
		SeleniumUtilities su = projectUtilities.getSeleniumUtilities();
		su.navigateTo(trueviewServiceURL);

		TrueViewBuilderUploader buildAndUploadPage = new TrueViewBuilderUploader(su.getActiveDriverInstance());
		buildAndUploadPage.clickforceTrueViewDownloaderService();

		if (buildAndUploadPage.waitUntillResponseReceived()) {
			assertEquals(buildAndUploadPage.getStatusForForceStart(), "200");
		} else {
			throw new myAssertionException("\n\n" + "Page Not Loaded");
		}

	}

	@Given("^Force start of True View Sdf Service$")
	public void Force_start_of_True_View_Sdf_Service() throws IOException, myAssertionException {
		String trueviewServiceURL = TSHelper.getPropertyValue("Force_start_of_True_View_Sdf_Service");
		SeleniumUtilities su = projectUtilities.getSeleniumUtilities();
		su.navigateTo(trueviewServiceURL);

		TrueViewBuilderUploader buildAndUploadPage = new TrueViewBuilderUploader(su.getActiveDriverInstance());
		buildAndUploadPage.clickforceStartTrueViewSDF();
		if (buildAndUploadPage.waitUntillResponseReceived()) {
			assertEquals(buildAndUploadPage.getStatusSdfService(), "200");
		} else {
			throw new myAssertionException("\n\n" + "Page Not Loaded");
		}
	}

	@Given("^Force start of TrueView File Builder$")
	public void Force_start_of_TrueView_File_Builder() throws IOException, myAssertionException {
		String trueviewServiceURL = TSHelper.getPropertyValue("Force_start_of_TrueView_File_Builder");
		SeleniumUtilities su = projectUtilities.getSeleniumUtilities();
		su.navigateTo(trueviewServiceURL);

		TrueViewBuilderUploader buildAndUploadPage = new TrueViewBuilderUploader(su.getActiveDriverInstance());
		buildAndUploadPage.clickStartTrueViewFileBuilder();
		if (buildAndUploadPage.waitUntillResponseReceived()) {
			assertEquals(buildAndUploadPage.getStatusForForceStart(), "200");
		} else {
			throw new myAssertionException("\n\n" + "Page Not Loaded");
		}
	}

	@Given("^Force trueview Uploader Service$")
	public void Force_trueview_Uploader_Service() throws IOException, myAssertionException {
		String trueviewServiceURL = TSHelper.getPropertyValue("Force_trueview_Uploader_Service");
		SeleniumUtilities su = projectUtilities.getSeleniumUtilities();
		su.navigateTo(trueviewServiceURL);

		TrueViewBuilderUploader buildAndUploadPage = new TrueViewBuilderUploader(su.getActiveDriverInstance());
		buildAndUploadPage.clickTrueViewUploaderService();

		if (buildAndUploadPage.waitUntillResponseReceived()) {
			assertEquals(buildAndUploadPage.getStatusForForceStart(), "200");
		} else {
			throw new myAssertionException("\n\n" + "Page Not Loaded");
		}
	}

	@Then("^I Download latest CSV for \"([^\"]*)\"$")
	public void i_download_latest_csv(String campaingnName) {

		SeleniumUtilities su = projectUtilities.getSeleniumUtilities();
		GoogleAccountManager gac = new GoogleAccountManager(su.getActiveDriverInstance());
		CampaignPage cp = new CampaignPage(su.getActiveDriverInstance());

		String dv360_url = TSHelper.getPropertyValue("DV360_url");
		String username = TSHelper.getPropertyValue("DV360_Account_UserName");
		String password = TSHelper.getPropertyValue("DV360_Account_Password");

		gac.login(username, password);
		assertEquals(gac.isLoginSuccess(), true, "LOGIN FAILED");
		gac.gotoCampaignPage(dv360_url, campaingnName);

		// gac.goTo(dv360_url); // gac.clickOnAdvertiserLink(); //
		gac.clickOnMainCampaign();

		if (campaingnName.contains("UK")) { // gac.clickOnUKCampaign();
			VariableHolder.setFileDownloadedForUKorUS("UK");
		} else if (campaingnName.contains("US")) { // gac.clickOnUSCampaign();
			VariableHolder.setFileDownloadedForUKorUS("US");
		} else {
			assertTrue(false);
		} // gac.clickOnLineItemsTab();

		String downloadPath = "";
		downloadPath = cp.downloadCSVFileAndGetPath();
		VariableHolder.setlastDownloadPath(downloadPath);

		File f = new File(downloadPath);
		assertTrue(f.exists());

		/*
		 * VariableHolder.setFileDownloadedForUKorUS("UK"); String downloadPath =
		 * "C:\\Users\\bondsilv\\eclipse-workspace\\TrgrValidation\\downloads\\SDF-LineItems.csv";
		 * VariableHolder.setlastDownloadPath(downloadPath);
		 */

	}

	@When("^I send an API request with geocode = \"([^\"]*)\", sickscore = (\\d+) and rulesetId = (\\d+)$")
	public void i_send_an_API_request_with_geocode_sickscore_and_rulesetId(String geoCode, int sickScore, int rulesetId) throws Throwable {
		log.info("\n\n\nPosting API request - ***********************************************\n\n\n");
		log.info("\n\n\nPosting API request - ***********************************************\n\n\n" + geoCode + "\n"
				+ sickScore + "\n" + rulesetId);

		APICaller ap = new APICaller();
		int actualStatusCode = ap.callAPI(geoCode, sickScore, rulesetId);

		assertEquals(actualStatusCode, 200);

		log.info("\nPosting API request completed- ***********************************************\n\n\n");
	}
	
	@When("^I send an API request with geocode = \"([^\"]*)\", sickscore = (\\d+) and rulesetId = (\\d+) for SA360$")
	public void i_send_an_API_request_with_geocode_sickscore_and_rulesetId_sa360(String geoCode, int sickScore, int rulesetId) throws Throwable {
		
		TSHelper.setFirstStart();
		
		
		log.info("\n\n\nPosting API request - ***********************************************\n\n\n");
		log.info("\n\n\nPosting API request - ***********************************************\n\n\n" + geoCode + "\n"
				+ sickScore + "\n" + rulesetId);

		APICaller ap = new APICaller();
		int actualStatusCode = ap.callAPI(geoCode, sickScore, rulesetId);

		assertEquals(actualStatusCode, 200);

		log.info("\nPosting API request completed- ***********************************************\n\n\n");
	}
	
	@When("^I send an API request with geocode = \"([^\"]*)\", sickscore = (\\d+) for SA360$")
	public void i_send_an_API_request_with_geocode_sickscore_sa360(String geoCode, int sickScore) throws Throwable {
		
		int rulesetId = 5;
		
		TSHelper.setFirstStart();
		
		Thread.sleep(3000);
		
		log.info("\n\n\nPosting API request - ***********************************************\n\n\n");
		log.info("\n\n\nPosting API request - ***********************************************\n\n\n" + geoCode + "\n"
				+ sickScore + "\n" + rulesetId);

		APICaller ap = new APICaller();
		int actualStatusCode = ap.callAPI(geoCode, sickScore, rulesetId);

		assertEquals(actualStatusCode, 200);

		log.info("\nPosting API request completed- ***********************************************\n\n\n");
	}
	
	@Given("^For UK I send an API request with geocode = \"([^\"]*)\", sickscore = (\\d+) and rulesetId = (\\d+)")
	public void For_Uk_i_send_aa_api_request_with_geocode_equalto_sickscore_equalto_andrulesetid_equalto(String geoCode,
			int sickScore, int rulesetId) throws Throwable {

		log.info("\n\n\nPosting API request - ***********************************************\n\n\n");
		log.info("\n\n\nPosting API request - ***********************************************\n\n\n" + geoCode + "\n"
				+ sickScore + "\n" + rulesetId);

		APICaller ap = new APICaller();
		int actualStatusCode = ap.callAPIUK(geoCode, sickScore, rulesetId);

		assertEquals(actualStatusCode, 200);

		log.info("\nPosting API request completed- ***********************************************\n\n\n");
	}

	@When("^I login in to my google account using username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void i_login_in_to_my_google_account_using_username_and_password(String username, String password)
			throws Throwable {

		// projectUtilities.setupSeleniumUtils();
		SeleniumUtilities su = projectUtilities.getSeleniumUtilities();
		GoogleAccountManager gac = new GoogleAccountManager(su.getActiveDriverInstance());

		log.info("\n\n\nGoing to Default Page - ***********************************************\n\n\n");
		gac.goToDefaultLoginPage();

		log.info("\n\n\nEnter UserName - *********************************************\n\n\n");
		gac.enterEmail_next(username);
		Thread.sleep(2000);

		log.info("\n\n\nEnter Password - ********************************************\n\n\n");
		gac.enterPassword_next(password);
		assertEquals(gac.isLoginSuccess(), true, "LOGIN FAILED");

	}

	@When("^I login in to my google account$")
	public void i_login_in_to_my_google_account() throws Throwable {

		String username = TSHelper.getPropertyValue("DV360_Account_UserName");
		String password = TSHelper.getPropertyValue("DV360_Account_Password");
		// projectUtilities.setupSeleniumUtils();
		SeleniumUtilities su = projectUtilities.getSeleniumUtilities();
		GoogleAccountManager gac = new GoogleAccountManager(su.getActiveDriverInstance());

		log.info("\n\n\nGoing to Default Page - ***********************************************\n\n\n");
		gac.goToDefaultLoginPage();

		log.info("\n\n\nEnter UserName - *********************************************\n\n\n");
		gac.enterEmail_next(username);
		Thread.sleep(2000);

		log.info("\n\n\nEnter Password - ********************************************\n\n\n");
		gac.enterPassword_next(password);
		assertEquals(gac.isLoginSuccess(), true, "LOGIN FAILED");

	}

	@Then("^Navigate to DV360 url")
	public void navigate_to_DV360_url() throws Throwable {
		SeleniumUtilities su = projectUtilities.getSeleniumUtilities();
		GoogleAccountManager gac = new GoogleAccountManager(su.getActiveDriverInstance());
		String dv360_url = TSHelper.getPropertyValue("DV360_url");
		gac.goTo(dv360_url);
	}

	@Then("^I download a consolidated CSV file with the current status$")
	public void i_download_a_consolidated_CSV_file_with_the_current_status() throws Throwable {

		SeleniumUtilities su = projectUtilities.getSeleniumUtilities();
		CampaignPage cp = new CampaignPage(su.getActiveDriverInstance());

		String downloadPath = "";

		log.info("\n\n\nDownload CSV File from  URl- ********************************************\n\n\n");
		downloadPath = cp.downloadCSVFileAndGetPath();

		log.info("\n\n\nDownLoad path ********************************************\n\n" + downloadPath);
		VariableHolder.setlastDownloadPath(downloadPath);

		File f = new File(downloadPath);
		assertTrue(f.exists());

		/*
		 * String downloadPath =
		 * "C:\\Users\\bondsilv\\eclipse-workspace\\TrgrValidation\\downloads\\SDF-LineItems.csv";
		 * VariableHolder.setlastDownloadPath(downloadPath);
		 */

	}

	@ContinueNextStepsOnException
	@And("^LOW STATUS for - \"([^\"]*)\" should be \"([^\"]*)\"$")
	public void visibility_for_LOW_STATUS_should_be(String geoCode, String expectedStatus) throws Throwable {

		String campaign = VariableHolder.getFileDownloadedForUKorUS();
		String low_Identifier = "";

		if (campaign.equalsIgnoreCase("UK")) {
			low_Identifier = TSHelper.getPropertyValue("Low_Identifier_UK");
		} else {
			low_Identifier = TSHelper.getPropertyValue("Low_Identifier");
		}

		String selectParam = "Select Type, Name, Status from ";
		String filterStatus = " Where Name like '%" + geoCode + "%' and name like '%" + low_Identifier + "%' ";

		HashMap<String, ArrayList<String>> hm = TSHelper.getHasmMapWithLevelandStatusForGeoCode(selectParam,
				filterStatus, geoCode);

		ArrayList<String> rs = TSHelper.TestStatus(hm, expectedStatus, "low");

		String actual = rs.get(0).trim();
		String expected = rs.get(1).trim();

		TSHelper.assertCondtion(expected, actual);
	}

	@ContinueNextStepsOnException
	@And("^MEDIUM STATUS for - \"([^\"]*)\" should be \"([^\"]*)\"$")
	public void visibility_for_MEDIUM_STATUS_should_be(String geoCode, String expectedStatus) throws Throwable {

		// String medium_Identifier = TSHelper.getPropertyValue("Medium_Identifier");

		String campaign = VariableHolder.getFileDownloadedForUKorUS();
		String medium_Identifier = "";

		if (campaign.equalsIgnoreCase("UK")) {
			medium_Identifier = TSHelper.getPropertyValue("Medium_Identifier_UK");
		} else {
			medium_Identifier = TSHelper.getPropertyValue("Medium_Identifier");
		}

		String selectParam = "Select Type, Name, Status from ";
		String filterStatus = " Where Name like '%" + geoCode + "%' and name like '%" + medium_Identifier + "%' ";

		HashMap<String, ArrayList<String>> hm = TSHelper.getHasmMapWithLevelandStatusForGeoCode(selectParam,
				filterStatus, geoCode);

		ArrayList<String> rs = TSHelper.TestStatus(hm, expectedStatus, "medium");

		String actual = rs.get(0).trim();
		String expected = rs.get(1).trim();

		TSHelper.assertCondtion(expected, actual);
	}

	@ContinueNextStepsOnException
	@And("^HIGH STATUS for - \"([^\"]*)\" should be \"([^\"]*)\"$")
	public void visibility_for_HIGH_STATUS_should_be(String geoCode, String expectedStatus) throws Throwable {

		// String high_Identifier = TSHelper.getPropertyValue("High_Identifier");

		String campaign = VariableHolder.getFileDownloadedForUKorUS();
		String high_Identifier = "";

		if (campaign.equalsIgnoreCase("UK")) {
			high_Identifier = TSHelper.getPropertyValue("High_Identifier_UK");
		} else {
			high_Identifier = TSHelper.getPropertyValue("High_Identifier");
		}

		String selectParam = "Select Type, Name, Status from ";
		String filterStatus = " Where Name like '%" + geoCode + "%' and name like '%" + high_Identifier + "%' ";

		HashMap<String, ArrayList<String>> hm = TSHelper.getHasmMapWithLevelandStatusForGeoCode(selectParam,
				filterStatus, geoCode);

		ArrayList<String> rs = TSHelper.TestStatus(hm, expectedStatus, "high");

		String actual = rs.get(0).trim();
		String expected = rs.get(1).trim();

		TSHelper.assertCondtion(expected, actual);
	}

	@Then("^Select Only \"([^\"]*)\" Line Items$")
	public void select_Only_Line_Items(String stausToSelect) throws Throwable {

		SeleniumUtilities su = projectUtilities.getSeleniumUtilities();
		CampaignPage cp = new CampaignPage(su.getActiveDriverInstance());

		log.info("Set Filter to have Status as Active - ************************************************* ");
		cp.changeLineItemStatusToActive();

	}

	@Then("^Change status of the active line items to paused$")
	public void change_status_of_the_active_line_items_to_paused() throws Throwable {

		SeleniumUtilities su = projectUtilities.getSeleniumUtilities();
		CampaignPage cp = new CampaignPage(su.getActiveDriverInstance());

		log.info("Mark all the Selected Line Items as Paused - ************************************************* ");
		cp.selectAllAndMarkAsPaused();
	}

}
