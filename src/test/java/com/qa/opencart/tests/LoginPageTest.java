package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.Base.BaseTest;
import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.utils.Constants;

public class LoginPageTest extends BaseTest{

	@Test(priority = 1)
	public void loginPageTitleTest() {
     String actualTitle = lp.getLoginPageTitle();	
	Assert.assertEquals(actualTitle, Constants.LOGIN_PAGE_TITLE);	
		
	}
	
@Test(priority = 2)
public void loginPageUrlTest() {
String actualUrl = 	lp.getLoginPageUrl();
Assert.assertEquals(actualUrl, Constants.LOGIN_PAGE_URL_FRACTION);	
}
	
@Test(priority=3)
public void forgotPwdLinkExistsTest() {
	
	Assert.assertTrue(lp.isForgotPwdLinkExists());
	
}


@Test(priority=5)
public void loginTest() throws Exception  {
	
	String uname = prop.getProperty("username");
	String passwd = prop.getProperty("password");
	String pin = prop.getProperty("pin");
	
	AccountPage accPage = lp.doLogin(uname, passwd, pin);


String accPageTitle = accPage.getAcctPageTitle();
System.out.println(accPageTitle);


Assert.assertEquals(accPageTitle, Constants.ACCOUNT_PAGE_TITLE);
Assert.assertTrue(accPage.isProfileLinkExist());

}

}
