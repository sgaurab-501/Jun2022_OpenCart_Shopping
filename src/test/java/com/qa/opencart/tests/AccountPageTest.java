package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.Base.BaseTest;
import com.qa.opencart.utils.Constants;

public class AccountPageTest extends BaseTest{

	@BeforeClass
	public void accPageSetup() {
		
		try {
			accPage = lp.doLogin(prop.getProperty("username"), prop.getProperty("password"), prop.getProperty("pin"));
		
		
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		
	}
	
@Test	
public void accPageHeaderTest() {
	
Assert.assertEquals(accPage.getAcctPageHeader(), Constants.ACCOUNT_PAGE_HEADER);
	
	
}
	


public void accPageTitleTest() {
	
	String accPageTitle = accPage.getAcctPageTitle();
	System.out.println(accPageTitle);
	
	Assert.assertEquals(accPageTitle, Constants.ACCOUNT_PAGE_TITLE);
}

public void isMktPlaceLinkExistsTest() {
	
	
	Assert.assertTrue(accPage.isMarketPlaceLinkExist());
	
}


	
	
	
	
	
}
