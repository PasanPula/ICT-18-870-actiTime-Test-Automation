package com.actitime.qa.stepdefinitions;

import org.junit.Assert;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.HomePage;
import com.actitime.qa.pages.LoginPage;
import com.actitime.qa.pages.UsersPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateUserStepDefenitions extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	UsersPage usersPage;

	// Login as Admin
	@Given("^I am on the Actitime Loging Page$")
	public void i_am_on_the_actitime_loging_page() {
		initialization();
		loginPage = new LoginPage();
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals("actiTIME - Login", title);
	}

	@When("^I Enter my Username as  \"([^\"]*)\"$")
	public void i_enter_my_username_as(String username) {
		loginPage.enterUsername(username);
	}

	@And("^I Enter my Password as  \"([^\"]*)\"$")
	public void i_enter_my_password_as(String password) {
		loginPage.enterPassword(password);
	}

	@And("^I click on Loging button$")
	public void i_click_on_loging_button() {
		homePage = loginPage.logingBtn();
	}

	@Then("^I should be able to successfuly loging to Actitime$")
	public void i_should_be_able_to_successfuly_loging_to_actitime() {
		Boolean flag = homePage.validateLoggedUser();
		Assert.assertTrue(flag);
	}

	// Switch User tab
	@When("^I Click on the Users tab$")
	public void i_click_on_the_users_tab() {
		usersPage = homePage.clickOnUsersLink();
	}

	@Then("^I should be able to successfuly switch Users Page$")
	public void i_should_be_able_to_successfuly_switch_users_page() {
		String title = usersPage.usersPageTitle();
		Assert.assertEquals("actiTIME - User List", title);
	}

	// Click new user create button
	@When("^I Click on the  New User button$")
	public void i_click_on_the_new_user_button() {
		usersPage.addUserBtn();
	}

	@Then("^I should see New user creation panel$")
	public void i_should_see_new_user_crestion_panel() {
		Boolean flag = usersPage.validateAddUserPanel();
		Assert.assertTrue(flag);
	}

	// Create new User
	@When("^I Enter my FirstName as  \"([^\"]*)\"$")
	public void i_enter_my_first_name_as(String firstname) {
		usersPage.enterFirstName(firstname);
	}

	@And("^I Enter my LastName as  \"([^\"]*)\"$")
	public void i_enter_my_last_name_as(String lastname) {
		usersPage.enterLastName(lastname);
	}

	@And("^I Enter my Email as  \"([^\"]*)\"$")
	public void i_enter_my_email_as(String email) {
		usersPage.enterEmail(email);
	}

	@And("^I click on submit button$")
	public void i_click_on_submit_button() {
		usersPage.clickSubmitBtn();
	}

	@Then("^I should be able to successfuly create new user$")
	public void i_should_be_able_to_successfuly_create_new_user() {
		Boolean flag = usersPage.sucessMessage();
		Assert.assertTrue(flag);
	}

	// Terminate
	@Then("Close the browser")
	public void close_the_browser() {
		driver.quit();
	}

}
