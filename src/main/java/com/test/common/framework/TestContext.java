package com.test.common.framework;

import java.io.IOException;

public class TestContext {
	private static ConfigReader config;
	private static WebDriverFactory webdriverFactory;

	public TestContext() throws IOException{
		config = ConfigReader.getConfig();
		//webdriverFactory = new WebDriverFactory(config);
	}	
	
}
