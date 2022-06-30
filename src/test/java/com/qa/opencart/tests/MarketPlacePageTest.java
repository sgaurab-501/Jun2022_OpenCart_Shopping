package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.Base.BaseTest;
import com.qa.opencart.utils.Constants;

public class MarketPlacePageTest extends BaseTest {

	
	@BeforeClass
	public void mktPlacePageSetup() {
		
	try {
		accPage = lp.doLogin(prop.getProperty("username"), prop.getProperty("password"), prop.getProperty("pin"));
	   mktPage = accPage.clickOnMktPlaceLink();
	} catch (Exception e) {
	
		e.printStackTrace();
	}	
	
	
	}
	


@Test
public void mktPlaceHeaderTest() {
	
	Assert.assertEquals(mktPage.getMktPlaceHeader(), Constants.MARKET_PLACE_HEADER);
	
	
	
}
	
	
	
	
}
