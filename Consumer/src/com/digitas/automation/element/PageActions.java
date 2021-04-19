package com.digitas.automation.element;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import jxl.CellView;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



@SuppressWarnings("unused")
public class PageActions {
	
    protected static WebDriver driver;
    
    

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		PageActions.driver = driver;
	}


	protected boolean isAvailable(String xPath) {		
		boolean found = false;		
		try{	
			 List<WebElement> lists = driver.findElements(By.cssSelector(xPath));
             System.out.println(lists.size());
			    if (lists.size() == 0)
			    {
			    	found = false;
			    }
			    else
			    	 found = true;			    
			 System.out.println(lists.size());
		} catch (NoSuchElementException e) {
			System.out.println("No Such Element Exception");
		}catch(ElementNotVisibleException e){
			System.out.println("Element Not Visible Exception");
		}
	    
	    return found;
	}
	
	protected void clickAt(String elementName) {
		
		try{
			WebElement link = driver.findElement(By.cssSelector(elementName));
			link.click();

	    }catch (NoSuchElementException e) {
			System.out.println("No Such Element Exception");
		}catch(ElementNotVisibleException e){
			System.out.println("Element Not Visible Exception");
	    }
	}
	
	protected void clickAtInIframe(String elementName) {
		
		try{
	
			driver.switchTo().frame(driver.findElement(By.id("videos")));
			WebElement link = driver.findElement(By.cssSelector(elementName));
			link.click();

	    }catch (NoSuchElementException e) {
			System.out.println("No Such Element Exception");
		}catch(ElementNotVisibleException e){
			System.out.println("Element Not Visible Exception");
	    }
	}
	
	
	protected void clickAtOne(String elementName, int order) {
		
		try{
			List<WebElement> links = driver.findElements(By.cssSelector(elementName));
			links.get(order).click();

	    }catch (NoSuchElementException e) {
			System.out.println("No Such Element Exception");
		}catch(ElementNotVisibleException e){
			System.out.println("Element Not Visible Exception");
	    }
	}
	
	protected String gettingElementAttri(String xPath, String attri) {
	    String text=null;
		try {
//			driver.switchTo().frame(driver.findElement(By.id("videos")));
			WebElement link = driver.findElement(By.cssSelector(xPath));
	
			text= link.getAttribute(attri); 	
			System.out.println(text);
			
		} catch (NoSuchElementException e) {
			text="No Such Element";
		}
		return text;
	}
	
	protected String gettingVisibleElementAttri(String xPath, String attri) {
	    String text="";
		try {
//			driver.switchTo().frame(driver.findElement(By.id("videos")));
			WebElement link = driver.findElement(By.cssSelector(xPath));
	
			if(link.isDisplayed()){
				text= link.getAttribute(attri); 	
				System.out.println(text);
			}
			
		} catch (NoSuchElementException e) {
			text="No Such Element";
		}
		return text;
	}
	
	protected String gettingElementsAttri(String xPath, String attri, int order) {
	    String text=null;
		try {
//			driver.switchTo().frame(driver.findElement(By.id("videos")));
			List<WebElement> links = driver.findElements(By.cssSelector(xPath));
	
			text= links.get(order).getAttribute(attri); 	
			System.out.println(links.get(order).getAttribute("name") );
			
		} catch (NoSuchElementException e) {
			text="No Such Element";
		}
		return text;
	}
	
	
	protected String gettingElementsDisplayedAttri(String xPath, String attri) {
	    String text=null;
		try {
			List<WebElement> links = driver.findElements(By.cssSelector(xPath));
			for(WebElement link:links){
				if(link.isDisplayed()){
					text= link.getAttribute(attri); 	
					System.out.println(text);
					break;
				}
			}
	
			
		} catch (NoSuchElementException e) {
			text="No Such Element";
		}
		return text;
	}
	
	protected String gettingOneOfElements(String xPath, int num) {
	    String text=null;
		try {
			List<WebElement> links = driver.findElements(By.cssSelector(xPath));
			text = links.get(num).getText();	
		} catch (NoSuchElementException e) {
			text="No Such Element";
		}
		return text;
	}
	
	
    protected String gettingElementText(String xPath){
    	  String text=null;
  		try {
  			WebElement link = driver.findElement(By.cssSelector(xPath));
  	
  			text= link.getText();
  			
  		} catch (NoSuchElementException e) {
  			text="No Such Element";
  		}
  		return text;
    }
	
    
    protected String gettingVisibleElementText(String xPath){
  	  String text="";
		try {
			WebElement link = driver.findElement(By.cssSelector(xPath));
	        if(link.isDisplayed()){
	        	text= link.getText();
	        }
			
			
		} catch (NoSuchElementException e) {
			text="No Such Element";
		}
		return text;
  }
	
	protected int NumberOfDisplayedList(String xPath) {
		int numberOflist=0;
		
		try {			
			List<WebElement> lists = driver.findElements(By.cssSelector(xPath));
			for(WebElement list: lists){
				if(list.isDisplayed()){
					numberOflist++;
				}
			}
				
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return numberOflist;
		
	}
	
	
    protected void waitForDisplay(String element)
    {
    	 new  WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(element)));
    }
    
    
    protected void waitForAttriDisplayed(String element, String attri, String value){
    	new WebDriverWait(driver, 20).until(ExpectedConditions.attributeContains(By.cssSelector(element), attri, value));
    }
    
    protected void waitForAttriDisplayedInIframe(String element, String attri, String value){
    	driver.switchTo().frame(driver.findElement(By.id("videos")));
    	new WebDriverWait(driver, 20).until(ExpectedConditions.attributeContains(By.cssSelector(element), attri, value));
    }
	
    
    protected List<String> getElementListText(String xPath){
    	List<String> dataList = new ArrayList<String>();
		List<WebElement> lists = driver.findElements(By.cssSelector(xPath));
		for(WebElement element:lists){
			dataList.add(element.getText());
		}
    	
    	return dataList;
    }
    
    
    protected List<String> getElementListAttri(String xPath){
    	List<String> dataList = new ArrayList<String>();
		List<WebElement> lists = driver.findElements(By.cssSelector(xPath));
		for(WebElement element:lists){
			dataList.add(element.getAttribute("class"));
		}
    	
    	return dataList;
    }

   
    protected void selectOptions(String selectionPath, String optionPath){  
    	String optionsName = null;
    	List<WebElement> optionsWebElementsList = driver.findElements(By.cssSelector(optionPath));
    	for (WebElement webElements : optionsWebElementsList) {
    		optionsName= webElements.getText();
			System.out.println(optionsName);
		
			Select select = new Select(driver.findElement(By.cssSelector(selectionPath)));        
			select.selectByVisibleText(optionsName);
		}
    }
    
    protected void selectSpecOptions(String selectionPath, String optionName){  				
    	Select select = new Select(driver.findElement(By.cssSelector(selectionPath)));        			
    	select.selectByVisibleText(optionName);
    }
    
    protected void SwitchToNewWindow(String elementname,String winHandleBefore) throws InterruptedException{
    	
    	SwitchToWindow();
   	 
   	    clickAt(elementname);
   	    SwitchToWindow();
	    driver.close();
	    driver.switchTo().window(winHandleBefore);
   	
   }
    
    protected String SwitchToWindow() throws InterruptedException{
    	String winHandleText=null;
    	 for(String winHandle : driver.getWindowHandles()){
    		    winHandleText=winHandle;
	            driver.switchTo().window(winHandle);
	            Thread.sleep(2000);	
	        }
    	 return winHandleText;
    }
    
    protected int ClickOneInstances(String xPath, String text) {
    	int count=1;
		try {
			List<WebElement> links = driver.findElements(By.cssSelector(xPath));
			for(WebElement link:links){
				if(link.isDisplayed()){
					if(link.getText().contentEquals(text)){
						link.click();						
						break;
					}
					count++;
				}				
			}			
		} catch (NoSuchElementException e) {
			text="No Such Element";
		}	
		return count;
	}
    
    
    protected int getSizeOfElements(String xPath){
    	List<WebElement> links = driver.findElements(By.cssSelector(xPath));
    	return links.size();
    }
    
    protected String gettingOneElementText(String xPath,int num){
  	  String text=null;
		try {
			List<WebElement> links = driver.findElements(By.cssSelector(xPath));
	
			text= links.get(num).getText();
			
		} catch (NoSuchElementException e) {
			text="No Such Element";
		}
		return text;
  }
    
    

    
    
}
