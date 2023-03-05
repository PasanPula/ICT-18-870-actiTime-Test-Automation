package com.actitime.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.HomePage;
import com.actitime.qa.pages.LoginPage;
import com.actitime.qa.pages.ReportsPage;
import com.actitime.qa.pages.TasksPage;
import com.actitime.qa.pages.UsersPage;
import com.actitime.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TasksPage taskPage;
	ReportsPage reportsPage;
	UsersPage usersPage;
	LoginPage loginpage;
	TestUtil testUtil;
	String sheetName = "Users";

	public HomePageTest() {
		super();
	}

	@BeforeMethod()
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.loging(properties.getProperty("username"), properties.getProperty("password"));
	}

	@Test(priority = 1)
	public void homePageLogoTest() {
		boolean flag = homePage.validateActiTimeLogo();
		Assert.assertTrue(flag);
	}

	@Test(priority = 2)
	public void homePageLoggedTest() {
		boolean flag = homePage.validateLoggedUser();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 3)
	public void homePageUsersPageLinkTest() {
		usersPage = homePage.clickOnUsersLink();
	}

	@Test(priority = 4)
	public void homePagTasksPageLinkTest() {
		taskPage = homePage.clickOnTaskLink();
	}
	
	@Test(priority = 5)
	public void homePagReportsPageLinkTest() {
		reportsPage = homePage.clickOnReportsLink();
	}
	
	@Test(priority = 6)
	public void logoutButtonTest() {
		loginPage = homePage.clickLogOutbtn();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
