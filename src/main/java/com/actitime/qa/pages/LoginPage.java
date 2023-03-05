package com.actitime.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	Logger log = Logger.getLogger(LoginPage.class);

	@FindBy(xpath = "//input[@name='username']")
	@CacheLookup
	WebElement userName;

	@FindBy(xpath = "//input[@type='password'and @name='pwd']")
	@CacheLookup
	WebElement passWord;

	@FindBy(xpath = "//a[@id='loginButton']")
	@CacheLookup
	WebElement loginButton;

	@FindBy(xpath = "//div[@class='atLogoImg']")
	WebElement actiTimeLogo;

	// initialization:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String validateLoginPageTitle() {
		log.info("Validated Title");
		return driver.getTitle();
	}

	public Boolean validateActiTimeLogo() {
		log.info("Validated Title");
		return actiTimeLogo.isDisplayed();
	}

	public HomePage loging(String uName, String pword) {
		log.info("Validated Login");
		userName.sendKeys(uName);
		passWord.sendKeys(pword);
		loginButton.click();
		return new HomePage();
	}

}
