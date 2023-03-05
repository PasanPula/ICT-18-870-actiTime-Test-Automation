package com.actitime.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//a[@class='content tasks']")
	@CacheLookup
	WebElement taskLink;

	@FindBy(xpath = "//a[@class='content reports']")
	@CacheLookup
	WebElement reportsLink;

	@FindBy(xpath = "//a[@class='content users']")
	@CacheLookup
	WebElement usersLink;

	@FindBy(xpath = "//div[@id='logo_aT']")
	WebElement actitimeLogo;

	@FindBy(xpath = "//*[@id=\"topnav\"]/tbody/tr[1]/td[7]/table/tbody/tr/td/div/table/tbody/tr[1]/td[1]/a")
	WebElement profileName;
	
	@FindBy(xpath = "//a[@id = 'logoutLink']")
	WebElement logoutBtn;

	// initialization
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// Action
	public Boolean validateActiTimeLogo() {
		return actitimeLogo.isDisplayed();
	}

	public Boolean validateLoggedUser() {
		return profileName.isDisplayed();
	}

	public TasksPage clickOnTaskLink() {
		taskLink.click();
		return new TasksPage();
	}

	public ReportsPage clickOnReportsLink() {
		reportsLink.click();
		return new ReportsPage();
	}

	public UsersPage clickOnUsersLink() {
		usersLink.click();
		return new UsersPage();
	}
	
	public LoginPage clickLogOutbtn() {
		logoutBtn.click();
		return new LoginPage();
	}

}
