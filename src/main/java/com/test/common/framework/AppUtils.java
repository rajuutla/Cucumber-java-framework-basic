package com.test.common.framework;

public class AppUtils extends CommonUtils{
	
	public void login(String userName, String password) throws Exception{
		
		type(LocatorType.NAME, "userName", userName);
		
		type(LocatorType.NAME, "password", password);
		click(LocatorType.NAME, "login");
		
	}
	
	public void logout() throws Exception{
		click(LocatorType.LINKTEXT,"SIGN-OFF");
	}
	

}
