package com.digitas.gsk.trgr.TrgrValidation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.digitas.gsk.trgr.TrgrValidation.SeleniumUtilities;
import com.digitas.gsk.trgr.TrgrValidation.projectUtilities;

public class GoogleAccountManager {

	public GoogleAccountManager(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	String commonLoginUrl = "https://accounts.google.com/";

	@FindBy(how = How.XPATH, using = ".//*[@type='email']")
	private WebElement emailLocator_text;

	@FindBy(how = How.XPATH, using = ".//*[@type='password']")
	private WebElement pwdLocator_text;

	@FindBy(how = How.XPATH, using = ".//*[@id='identifierNext']")
	private WebElement emailNext_btn;

	@FindBy(how = How.XPATH, using = ".//*[@id='passwordNext']")
	private WebElement pwdNext_btn;

	@FindBy(how = How.XPATH, using = ".//*[text()='Manage your info, privacy and security to make Google work better for you']")
	private WebElement loginSuccess;
	
	@FindBy(how = How.XPATH, using = ".//*[text()='Search Ads 360']")
	private WebElement loginSuccess_SA360;

	@FindBy(how = How.XPATH, using = ".//*[text()='Advertisers']/ancestor::li[@role='menuitem']")
	private WebElement advertiser_link;

	@FindBy(how = How.XPATH, using = ".//*[text()='Line Items']/..")
	private WebElement lineItems_link;

	String mainCammpaign_link = ".//a[text()='" + projectUtilities.getPropertyValue("Parent_campaign_Name") + "']";
	String UK_link = ".//*[text()='" + projectUtilities.getPropertyValue("UK_campaign_Name") + "']";
	String US_link = ".//*[text()='" + projectUtilities.getPropertyValue("US_campaign_Name") + "']";

	SeleniumUtilities su = projectUtilities.getSeleniumUtilities();

	public void enterEmail_next(String email) {
		su.sendKeys(emailLocator_text, email);
		su.click(emailNext_btn);
		su.sleep(2000);
	}

	public void enterPassword_next(String pwd) {
		su.sendKeys(pwdLocator_text, pwd);
		su.click(pwdNext_btn);
		su.sleep(2000);
	}

	public void goTo(String url) {
		su.navigateTo(url);
		su.sleep(3000);
	}

	public void gotoCampaignPage(String dv360_url, String campaingnName) {

		goTo(dv360_url);
		su.sleep(1000);

		
//===============================================================================>
		
		/*
		if (isAdvertisemsentLinkPresent()) {
			clickOnAdvertiserLink();
		} else {
			loadPagesByTabPower();
			su.click("xpath", mainCammpaign_link);
			// su.navigateTo(projectUtilities.getPropertyValue("Parent_campaign_Url"));
			su.sleep(2000);
		}
		*/
		
		loadPagesByTabPower();
		su.click("xpath", mainCammpaign_link);		
		su.sleep(2000);
//===============================================================================>
		if (campaingnName.contains("UK")) {
			clickOnUKCampaign();
		} else if (campaingnName.contains("US")) {
			clickOnUSCampaign();
		}
		su.sleep(2000);
		clickOnLineItemsTab();

	}

	public boolean isAdvertisemsentLinkPresent() {
		boolean test = false;
		su.waitForDefinedTime(advertiser_link, 1);
		// test = su.isPresent(advertiser_link);
		test = su.exists(advertiser_link);
		return test;
	}

	public void goToDefaultLoginPage() {
		su.maximize();
		su.navigateTo(commonLoginUrl);
	}

	public boolean isLoginSuccess() {
		return su.isPresent(loginSuccess);
	}
	
	public boolean isLoginSuccess_SA360() {
		return su.isPresent(loginSuccess);
	}

	public void clickOnAdvertiserLink() {
		su.click(advertiser_link);
		su.sleep(3000);
	}

	public void clickOnMainCampaign() {

		// su.click("xpath", mainCammpaign_link);
		// su.sleep(3000);
	}

	public void clickOnUKCampaign() {
		su.click("xpath", UK_link);
	}

	public void loadPagesByTabPower() {
		su.ActionTabLoader();
	}

	public void clickOnUSCampaign() {
		su.click("xpath", US_link);
	}

	public void clickOnLineItemsTab() {
		su.click(lineItems_link);
		su.sleep(3000);
	}

	public void login( String username, String password) {
		goToDefaultLoginPage();	
		enterEmail_next(username);
		su.sleep(2000);
		enterPassword_next(password);
	}
}
