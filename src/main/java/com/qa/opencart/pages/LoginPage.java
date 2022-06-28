package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	
// 1. private By locators: OR
	
private By emailField = By.id("input-email");
private By pwdField = By.id("input-password");
private By logintButton = By.xpath("//div[@class='col-sm-6']/button[@type='submit']");
private By forgotPwdLink = By.xpath("//div[@class='form-group']/a");

private By secPin = By.id("input-pin");
private By contButton = By.xpath("//div[@class='form-group']/button");
private By createAccLink = By.xpath("//div[@class='well']/a[contains(text(),'Continue')]");
private By accLogoutMsg = By.xpath("//div[@class='inner']/h1[contains(text(),'On your way')]");


// 2. public page class constructor

public LoginPage(WebDriver driver) {
	this.driver=driver;
	eleUtil = new ElementUtil(driver);
}

// 3. public page actions
// using the private data members - encapsulation

public String getLoginPageTitle() {
	String title = eleUtil.waitForTitleIs(Constants.LOGIN_PAGE_TITLE, Constants.DEFAULT_TIMEOUT);
	System.out.println("Login page title: "+title);
return title;

}

public String getLoginPageUrl() {
	String url = eleUtil.waitForUrlContains(Constants.LOGIN_PAGE_URL_FRACTION, Constants.DEFAULT_TIMEOUT);
	System.out.println("Login page url is: "+url);
return url;
}

public boolean isForgotPwdLinkExists() {
	return eleUtil.waitForElementVisible(forgotPwdLink, Constants.DEFAULT_ELEMENT_WAIT_TIMEOUT).isDisplayed();
}


public AccountPage doLogin(String uname, String pwd, String pin) throws Exception {
	
	eleUtil.getElement(emailField).sendKeys(uname);
	eleUtil.getElement(pwdField).sendKeys(pwd);
	eleUtil.getElement(logintButton).click();	
	
	eleUtil.waitForElementVisible(secPin, Constants.DEFAULT_ELEMENT_WAIT_TIMEOUT).sendKeys(pin);;
	
	eleUtil.getElement(contButton).click();

	return new AccountPage(driver);
		
}

public String getLogoutMsg() {
	
	String logoutMsg = eleUtil.waitForElementVisible(accLogoutMsg, Constants.DEFAULT_ELEMENT_WAIT_TIMEOUT).getText();
	
	System.out.println("Logout Successful message: "+logoutMsg);
	return logoutMsg;
	
}


	
}
