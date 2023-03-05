package com.actitime.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.HomePage;
import com.actitime.qa.pages.LoginPage;
import com.actitime.qa.util.TestUtil;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	String sheetName = "Users";

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();

	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "actiTIME - Login");
	}

	@Test(priority = 2)
	public void loginPageLogoTest() {
		boolean flag = loginPage.validateActiTimeLogo();
		Assert.assertTrue(flag);
	}
	
	@DataProvider
	public Object[][] getactiTimeTestData() {
		Object data[][]= TestUtil.getTestData(sheetName);
		return data;
	}
	@Test(priority=3,dataProvider="getactiTimeTestData")
	public void loginTest(String userName, String password){
		homePage = loginPage.loging(userName, password);
//		homePage = loginPage.loging(properties.getProperty("username"), properties.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
