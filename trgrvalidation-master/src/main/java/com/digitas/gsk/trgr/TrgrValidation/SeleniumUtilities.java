package com.digitas.gsk.trgr.TrgrValidation;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumUtilities {

	Logger log = LoggerHelper.getLogger(SeleniumUtilities.class);
	String projectPath = System.getProperty("user.dir");
	String resourcePath = "resources";
	String downloadPath = "downloads";

	final String driver_chrome_name_win = "chromedriver.exe";
	final String driver_chrome_name_osx = "chromedriver_osx";
	final String driver_chrome_name_linux = "chromedriver_linux";
	static int impicit_wait = 20;
	static TimeUnit default_time_unit = TimeUnit.SECONDS;
	private static WebDriver driver = null;
	WebDriverWait wdw = null;

	
	JavascriptExecutor JSexecutor = (JavascriptExecutor)driver;
	
	static int screenShotCounter = 0;
	static TakesScreenshot scrShot = null;

	public void setupDriver() throws JsonGenerationException, JsonMappingException, IOException {

		String driverExecutable = null;
		String osCheck = System.getProperty("os.name", "generic").toLowerCase();
		log.info("Setting Selenium driver for OS: " + osCheck);
		if (osCheck.startsWith("windows")) {
			driverExecutable = driver_chrome_name_win;
		} else if ((osCheck.indexOf("mac") >= 0) || (osCheck.indexOf("darwin") >= 0)) {
			driverExecutable = driver_chrome_name_osx;
		} else {
			driverExecutable = driver_chrome_name_linux;
		}
		System.setProperty("webdriver.chrome.driver", Paths.get(projectPath,  resourcePath, driverExecutable).toString());
		log.info("Selenium Chrome Driver exe Path : " + Paths.get(projectPath,  resourcePath, driverExecutable).toString());

		//WebDriverManager.chromedriver().setup();

		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", Paths.get(projectPath, downloadPath).toString());
		chromePrefs.put("profile.default_content_setting_values.geolocation",1);
		log.info("Selenium Download Path set to : " + Paths.get(projectPath, downloadPath).toString());
		ChromeOptions options = new ChromeOptions();		
		options.setExperimentalOption("prefs", chromePrefs);
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(impicit_wait, default_time_unit);
		driver.manage().window().maximize();
		//((LocationContext)driver).setLocation(new Location(37.774929,-122.419416,0));
		wdw = new WebDriverWait(driver, 240);
		scrShot = ((TakesScreenshot) driver);
		log.info("Selenium driver setup complete");

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		wdw = new WebDriverWait(driver, 240);
		scrShot = ((TakesScreenshot) driver);
		log.info("Selenium driver setup complete");

	}


	public void releaseResources() {

		if (driver != null) {

			try {
				driver.close();
				log.info("Selenium driver closed");
				driver.quit();
				log.info("Selenium driver quited");
			} catch (NoSuchSessionException e) {
				log.info("Selenium driver was not used in this scenario or feature");
			}
		} else {
			log.info("Selenium driver was not used in this scenario or feature");
		}

	}

	public String getDownloadPath() {
		log.info("Project downloadpath for chrome is " + Paths.get(projectPath, downloadPath).toString());
		return Paths.get(projectPath, downloadPath).toString();
	}

	public WebDriver getActiveDriverInstance() throws NullPointerException {
		if (driver == null) {
			log.info("Driver is not setup, THrowing nullpinter exception");
			throw new NullPointerException("driver not setup, invoke the setupDriver");
		} else {
			log.info("Returning the driver Instance");
			return driver;
		}
	}

	public boolean sendKeys(WebElement we, String text) {
		boolean keysSet = false;

		log.info("Selenium Action : Sending Keys : " + text + " Locator : ");

		try {
			this.waitForElement("visible", we);
			we.sendKeys(text);
			String temp = we.getText();
			if (temp.contains(text)) {
				keysSet = true;
			}

		} catch (Exception e) {
			log.warn("Selenium Action : Sending Keys : Failed due to following " + e.getMessage());
			e.printStackTrace();

		}
		sleep(1000);
		return keysSet;
	}

	public boolean click(WebElement we) {
		boolean objectClicked = false;

		// SeleniumUtilities.takeSnapShot();
		sleep(2000);
		log.info("Selenium Action : Click : Locator :");

		try {
			this.waitForElement("visible", we);
			we.click();
			objectClicked = true;
		} catch (Exception e) {
			log.info("Selenium Action : Click Failed : Locator : ");
			e.printStackTrace();
		}

		sleep(500);
		return objectClicked;
	}
	
	public boolean clear(WebElement we) {
		boolean objectCleared = false;

		// SeleniumUtilities.takeSnapShot();
		sleep(2000);
		log.info("Selenium Action : Clear : Locator :");

		try {
			this.waitForElement("visible", we);
			we.clear();
			objectCleared = true;
		} catch (Exception e) {
			log.info("Selenium Action : Clear Failed : Locator : ");
			e.printStackTrace();
		}

		sleep(500);
		return objectCleared;
	}
	
	public boolean JSclick(WebElement we) {
		boolean objectClicked = false;
		JSexecutor = (JavascriptExecutor)driver;
		
		sleep(2000);
		log.info("Selenium Action : JSClick : Locator :");

		try {						
			JSexecutor.executeScript("arguments[0].click();", we);
			objectClicked = true;
		} catch (Exception e) {
			log.info("Selenium Action : Click Failed : Locator : ");
			//e.printStackTrace();
		}

		sleep(500);
		return objectClicked;
	}

	public void click(String locator_type, String mainCammpaign_link) {

		if (locator_type.equalsIgnoreCase("xpath")) {
			WebElement we = driver.findElement(By.xpath(mainCammpaign_link));
			click(we);
		}

	}

	public void ActionTabLoader() {

		Actions a = new Actions(driver);

		for (int i = 1; i <= 100; i++)
			a.sendKeys(Keys.TAB).build().perform();
	}

	public void navigateTo(String url) {

		log.info("Selenium Action : Navigating To : " + url);
		String currentUrl = driver.getCurrentUrl();
		if (url.equalsIgnoreCase(currentUrl)) {
			driver.navigate().refresh();
			sleep(1000);
		} else {
			driver.navigate().to(url);
		}

		sleep(2000);
	}

	public void scrollDownToElement(WebElement we) {

		log.info("Selenium Action : Scrolling : ");
		this.waitForElement("visible", we);
		Actions actions = new Actions(driver);
		actions.moveToElement(we);
		actions.perform();
		sleep(2000);
	}

	public void scrollToBottomOfPage() {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public void scrollToBottomOfPageAction() {
		WebElement we = driver.findElement(By.xpath("//*[text()='Display OX Med']"));

		Actions a = new Actions(driver);
		a.sendKeys(we, Keys.END);

		// a.keyDown(Keys.END).keyUp(Keys.END).build().perform();

		we.sendKeys(Keys.END);

	}

	public boolean exists(WebElement we) {

		log.info("Selenium Action : Check if Exists : ");
		sleep(2000);

		boolean exists = true;
		try {
			// Causes the delay during the marking line items paused
			exists = we.findElements(By.xpath("..")).size() > 0;

		} catch (Exception e) {
			exists = false;
			log.info("Selenium Action : Exists : The locator does not Exits : " + exists);
		}

		log.info("Selenium Action : Check if Exists Passed : " + exists);
		return exists;
	}
	
	public boolean exists_Quick(WebElement we) {

		log.info("Selenium Action : Check if Exists : ");
		boolean exists = true;
		try {
			exists = we.findElements(By.xpath("..")).size() > 0;
		} catch (Exception e) {
			exists = false;
			log.info("Selenium Action : Exists : The locator does not Exits : " + exists);
		}
		log.info("Selenium Action : Check if Exists Passed : " + exists);
		return exists;
	}

	public boolean waitTillElementDisapers(WebElement we, int miliSeconds) {

		log.info("Selenium Action : Waiting for element to disaapear : ");
		sleep(2000);

		int incrementerWait = 0;
		boolean exists = true;

		while (miliSeconds > 0) {

			incrementerWait = incrementerWait + 100;
			sleep(incrementerWait);

			try {
				exists = we.findElements(By.xpath("..")).size() > 0;
				log.info("Selenium Action : The element is present now ? : " + exists);

			} catch (Exception e) {
				exists = false;
				log.info("Selenium Action : Exists : The locator does not Exits : " + exists);
			}

			if (exists == false) {
				log.info("Selenium Action : Element is disaaperaed : ");
				break;
			} else if (incrementerWait > miliSeconds) {
				log.info("Selenium Action : Element did not dissapear in given time : ");
				break;
			}

		}
		log.info("Selenium Action : Waited for element to disappear : ");
		return exists;
	}

	public String getText(WebElement we) {		
		this.waitForElement("visible", we);
		log.info("Selenium Action : Text Found : " + we.getText());
		return we.getText();
	}

	public boolean isPresent(WebElement we) {

		sleep(2000);
		log.info("Selenium Action : Check if Present : ");

		if (isPresent1(we)) {
			log.info("Selenium Action : Present : The locator Exits : ");
			return true;
		} else {
			log.info("Selenium Action : Present : The locator does not Exits : ");
			return false;
		}
	}

	public void sleep(int miliSeconds) {
		try {
			log.info("Selenium Action : Sleep : For: " + miliSeconds + " miliseconds");
			Thread.sleep(miliSeconds);
			log.info("Selenium Action : Wake from SLeep After : " + miliSeconds + " miliseconds");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public boolean waitToDisaapear(WebElement we) {

		log.info("Selenium Action : Wait to Disappear : The locator : ");

		while (!isPresent(we)) {

		}

		return true;
	}

	private boolean isPresent1(WebElement we) {
		return we.isDisplayed();
	}

	public ArrayList<String> getJSTextForEachElement(List<WebElement> allTableRows) {

		ArrayList<String> al_allTextInfo = new ArrayList<>();
		List<WebElement> list = allTableRows;
		JavascriptExecutor js = (JavascriptExecutor) driver;

		for (WebElement wb : list) {

			String textOfRow = js.executeScript("return arguments[0].innerText", wb).toString();
			al_allTextInfo.add(textOfRow);
		}

		return al_allTextInfo;
	}

	public void waitForElement(String condition, WebElement element) {

		if (condition.contains("visible")) {
			// SeleniumUtilities.takeSnapShot();
			log.info("Waiting for the element to be visible");
			// log.info(driver.getPageSource());
			wdw.until(ExpectedConditions.visibilityOf(element));
		}
	}

	public boolean waitForDefinedTime(WebElement we, int Seconds) {
		
		boolean elementPresent = false;
		try {
			WebDriverWait wdw1 = new WebDriverWait(driver, Seconds);
			wdw1.until(ExpectedConditions.visibilityOf(we));
			sleep(100);
			elementPresent = true;
		} catch (Exception e) {			
			log.error("Completed Wait for the element, The element does not exist on the DOM");
		}
		
		return elementPresent;
	}

	public void maximize() {
		driver.manage().window().maximize();

	}

	public boolean clickCheckBox(WebElement we) {
		boolean objectClicked = false;

		log.info("Selenium Action : Checkbox : Locator : ");

		try {
			this.waitForElement("visible", we);
			we.click();
			objectClicked = we.isSelected();
		} catch (Exception e) {
			log.info("Selenium Action : Click Failed : Locator : ");
			e.printStackTrace();
		}

		return objectClicked;
	}

	public void refresh() {
		log.info("Selenium Action : Refresh started ");
		driver.navigate().refresh();
		sleep(5000);
		log.info("Selenium Action : Refresh Ended ");
	}

	public boolean checkIfInDomYet(WebElement we) {
		log.info("Selenium Action : Check present in dom : ");
		sleep(2000);

		boolean exists = false;
		try {
			exists = we.findElements(By.xpath("..")).size() > 0;
		} catch (Exception e) {
			exists = false;
			log.info("Selenium Action : Exists : The locator does not Exits : " + exists);
		}

		log.info("Selenium Action : Check present in dom....is it present ? : " + exists);
		return exists;
	}

	public boolean waitTillElementAppear(WebElement we, int miliSeconds) {
		log.info("Selenium Action : Waiting for element to Appear : ");
		sleep(2000);

		int incrementerWait = 100;
		boolean exists = false;

		while (miliSeconds > 0) {

			miliSeconds = miliSeconds - 100;
			sleep(incrementerWait);

			try {
				exists = we.findElements(By.xpath("..")).size() > 0;
				log.info("Selenium Action : The element is present now ? : " + exists);

			} catch (Exception e) {
				exists = false;
				log.info("Selenium Action : Exists : The locator does not Exits : " + exists);
			}

			if (exists == true) {
				log.info("Selenium Action : Element is Appeared : ");
				break;
			} else if (incrementerWait > miliSeconds) {
				log.info("Selenium Action : Element does not appear in given time : ");
				break;
			}

		}
		log.info("Selenium Action : Waited for element to disappear : ");
		return exists;

	}

}