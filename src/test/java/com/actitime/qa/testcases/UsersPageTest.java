package com.actitime.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.HomePage;
import com.actitime.qa.pages.LoginPage;
import com.actitime.qa.pages.UsersPage;
import com.actitime.qa.util.TestUtil;

public class UsersPageTest  extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	UsersPage usersPage;
	String sheetName = "NewUsers";
	
	public UsersPageTest() {
		super();
	}

	@BeforeMethod()
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.loging(properties.getProperty("username"), properties.getProperty("password"));
		usersPage = homePage.clickOnUsersLink();
	}
	
	@Test(priority = 1)
	public void validateUsersPage() throws InterruptedException {
		String title = usersPage.usersPageTitle();
		Assert.assertEquals(title, "actiTIME - User List");
	}

    @Test(priority = 2)
    public void validateUsersList() {
        boolean flag= usersPage.validateUsersList();
        Assert.assertTrue(flag);
    }

    @Test(priority = 3)
    public void validateUserProfileView() {
        boolean flag= usersPage.validateProfileAccess();
        Assert.assertTrue(flag);
    }
    
	@DataProvider
	public Object[][] getactiTimeTestData() {
		Object data[][]= TestUtil.getTestData(sheetName);
		return data;
	}

    @Test(priority = 4,dataProvider="getactiTimeTestData")
    public void validateAddUser(String FirstName, String LastName, String EMail) {
    	usersPage.addUserBtn();
        boolean flag= usersPage.addUserTest(FirstName, LastName, EMail);
        Assert.assertTrue(flag);
    }
    
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
