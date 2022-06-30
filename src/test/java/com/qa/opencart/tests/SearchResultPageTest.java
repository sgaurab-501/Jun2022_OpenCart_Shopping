package com.qa.opencart.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.Base.BaseTest;

public class SearchResultPageTest extends BaseTest{

	
	
	@BeforeClass
	public void srcResPageSetup() {
   
	try {
		accPage = lp.doLogin(prop.getProperty("username"), prop.getProperty("password"), prop.getProperty("pin"));
		mktPage = accPage.clickOnMktPlaceLink();
	    
		
	
	} catch (Exception e) {
	e.printStackTrace();
	}	
}
	
	@DataProvider
  public Object[][] getItemName() {
   return new Object[][] { 
	   {"snapchat"},
	   {"facebook"},
	   {"twitter"}
   };
	   
   }
	
@Test(dataProvider = "getItemName")
public void searchTest(String itemName) throws Exception {
	
	 Thread.sleep(10000);  
	srcPage = mktPage.doSearch(itemName);
	



}
	
	
		
	}
	
	
	
