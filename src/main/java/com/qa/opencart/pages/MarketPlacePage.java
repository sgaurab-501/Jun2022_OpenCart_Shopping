package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class MarketPlacePage {

private	WebDriver driver;
private ElementUtil eleUtil;	
	
private By mktPalceHeader = By.xpath("//div[@class='col-sm-4 col-md-3']/section/h4");

private By searchBar = By.xpath("//div[@class='input-group']");	
private By searchIcon = By.xpath("//div[@class='input-group-btn']/button");


     public MarketPlacePage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		
		
	}
	


	public String getMktPlaceHeader() {
		
		eleUtil.waitForElementPresent(mktPalceHeader, Constants.DEFAULT_ELEMENT_WAIT_TIMEOUT);
	return	eleUtil.getElement(mktPalceHeader).getText();
		
	}
	
	public SearchResultPage doSearch(String searchItem) {
		
	WebElement srcElement = eleUtil.waitForElementVisible(searchBar, Constants.DEFAULT_ELEMENT_WAIT_TIMEOUT);
	       srcElement.clear();
	     srcElement.sendKeys(searchItem);
		eleUtil.doClick(searchIcon);
		return new SearchResultPage(driver);
	
}
}