package com.test.stepdefs;

import org.testng.Assert;

import com.test.common.framework.AppUtils;
import com.test.common.framework.ReturnValue;
import com.test.common.framework.TestContext;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class CommonStepDef extends AppUtils{
		
	@Given("^user login into the app$")
	public void User_login_into_the_app() throws Exception{
		launch();
		login(config.getAppUserName(),config.getAppPassword());
	}
	
	@Then("^verify the page title \"([^\"]*)\"$")
	public void verify_the_page_title(String expTitle) throws Throwable {
		ReturnValue retVal = verifyPageTitle(expTitle);
		Assert.assertTrue(retVal.isMethodResult(),retVal.getMessage());
	}
	
	@Then("^Logout and close the browser$")
	public void logout_close_the_browser() throws Exception{
		logout();
		closeBrowsers();
	}

}
