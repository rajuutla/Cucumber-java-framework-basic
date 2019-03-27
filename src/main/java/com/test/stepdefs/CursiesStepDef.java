package com.test.stepdefs;

import com.test.common.framework.AppUtils;
import com.test.common.framework.LocatorType;

import cucumber.api.java.en.When;

public class CursiesStepDef extends AppUtils{	
	
	@When("^user clicks on Cursies link$")
	public void user_clicks_on_Cursies_link() throws Exception{
		click(LocatorType.LINKTEXT,"Cruises");
	}

}
