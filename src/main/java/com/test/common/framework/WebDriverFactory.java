package com.test.common.framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {
	
	private ConfigReader config= null;
	private static WebDriver driver = null;
	
	public WebDriverFactory(ConfigReader config){
		this.config = config;
	}
	
	public WebDriver getDriver(){
		switch(DriverType.valueOf(config.getBrowser().toUpperCase())){
		case CHROME:
			WebDriverManager.chromedriver();
			driver = (driver ==  null) ? new ChromeDriver() : driver;
			break;
		case FIREFOX:
			WebDriverManager.firefoxdriver();
			driver = (driver ==  null) ? new FirefoxDriver(): driver;
			break;
		case IE:
			driver = (driver ==  null) ? new InternetExplorerDriver(): driver;
			break;
		case REMOTE:
			driver = null;
			break;
		default:
			driver = null;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getImplicitwait()),TimeUnit.SECONDS);
		
		return driver;
	}
	
	

}
