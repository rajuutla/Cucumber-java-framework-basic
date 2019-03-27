package com.test.common.framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonUtils {
	
	public static WebDriver driver = null;
	public ConfigReader config = null;
	
	public CommonUtils(){
		config = ConfigReader.getConfig();
		WebDriverFactory webdriverFactory = new WebDriverFactory(config);
		driver = webdriverFactory.getDriver();
	}
	
	public WebDriver launch(){
		driver.get(config.getAppUrl());		
		return driver;
	}
	
	public String getCurrentPageTitle(){
		return driver.getTitle();
	}
	
	public String getCurrentPageUrl(){
		return driver.getCurrentUrl();
	}
	
	public ReturnValue verifyPageTitle(String expectedTitle){
		String message= "";
		boolean flag = false;
		if (getCurrentPageTitle().equalsIgnoreCase(expectedTitle)){
			flag = true;
		}else{
			message = "Expected Page tilte not found : \n\tActual Title = "+driver.getTitle()+"\n\tExpected Title = "+expectedTitle;
		}
		return new ReturnValue(flag, message);
	}
	
	public WebElement getElement(LocatorType type, String locatorValue) throws Exception{
		return getElements(type, locatorValue).get(0);
	}
	
	public List<WebElement> getElements(LocatorType type, String locatorValue) throws Exception{
		List<WebElement> elements= driver.findElements(getByObject(type, locatorValue));
		if (elements.size() > 0)
			return elements;
		else
			throw new Exception("Couldn't find any elements for the locator provided.");
	}
	
	private By getByObject(LocatorType type, String locatorValue) throws Exception{
		switch (type){
		case ID:
			return By.id(locatorValue);
		case NAME:
			return By.name(locatorValue);
		case TAGNAME:
			return By.tagName(locatorValue);
		case LINKTEXT:
			return By.linkText(locatorValue);
		case PARTIALLINKTEXT:
			return By.partialLinkText(locatorValue);
		case CSS:
			return By.cssSelector(locatorValue);
		case XPATH:
			return By.xpath(locatorValue);
		default:
			throw new Exception("Locator Type not found");		
		}
	}
	
	public void type(LocatorType type, String locatorValue, String text) throws Exception{
		getElement(type, locatorValue).sendKeys(text);
	}
	
	public void click(LocatorType type, String locatorValue) throws Exception{
		getElement(type, locatorValue).click();
	}
	
	public void closeBrowsers(){
		driver.quit();
	}
}
