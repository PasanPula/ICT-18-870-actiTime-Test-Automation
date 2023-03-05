package com.actitime.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.actitime.qa.base.TestBase;

public class UsersPage extends TestBase {

	@FindBy(xpath = "//table[@class='userNameContainer']")
	WebElement userRow;

	@FindBy(xpath = "//div[@id='editUserPanel']")
	WebElement userProfile;

	@FindBy(xpath = "//div[@class='components_button withPlusIcon']")
	WebElement addUserButton;

	@FindBy(xpath = "//div[text()='Add User']")
	WebElement addUserPanal;

	@FindBy(xpath = "//input[@id='createUserPanel_firstNameField']")
	WebElement firstNameInput;

	@FindBy(xpath = "//input[@id='createUserPanel_lastNameField']")
	WebElement lastNameInput;

	@FindBy(xpath = "//input[@id='createUserPanel_emailField']")
	WebElement emailInput;

	@FindBy(xpath = "//*[@id=\"createUserPanel\"]/div[3]/div/div[3]/div[1]")
	WebElement submitButton;

	@FindBy(xpath = "//div[@class='invitationInfoHeader']")
	WebElement successMessage;

	// initialization
	public UsersPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String usersPageTitle() {
		return driver.getTitle();
	}

	public Boolean validateUsersList() {
		return userRow.isDisplayed();
	}

	public Boolean validateProfileAccess() {
		userRow.click();
		return userProfile.isDisplayed();
	}
	
	public void addUserBtn() {
		addUserButton.click();
	}

	public Boolean addUserTest(String fName, String lName, String eMail) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(firstNameInput)).sendKeys(fName);
		wait.until(ExpectedConditions.elementToBeClickable(lastNameInput)).sendKeys(lName);
		wait.until(ExpectedConditions.elementToBeClickable(emailInput)).sendKeys(eMail);
		wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
		return wait.until(ExpectedConditions.visibilityOf(successMessage)).isDisplayed();
	}

}
