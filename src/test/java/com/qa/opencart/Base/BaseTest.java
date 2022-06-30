package com.qa.opencart.Base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.MarketPlacePage;
import com.qa.opencart.pages.SearchResultPage;


public class BaseTest {

	DriverFactory df;
	
 protected Properties prop;
public WebDriver driver;

protected LoginPage lp;
protected AccountPage accPage;
protected MarketPlacePage mktPage;
protected SearchResultPage srcPage;

@BeforeTest
public void setup() {
	
	df = new DriverFactory();
   prop = df.init_prop(driver);
	driver = df.init_driver(prop);
    
	lp = new LoginPage(driver);
}

	
	public WebDriver getDriver() {
	return driver;
}

	@AfterTest
	public void tearDown() throws Exception {
Thread.sleep(1500);	
//  driver.quit();
	}
	
	
}
