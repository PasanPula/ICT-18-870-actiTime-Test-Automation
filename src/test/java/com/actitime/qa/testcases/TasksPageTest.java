package com.actitime.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.HomePage;
import com.actitime.qa.pages.LoginPage;
import com.actitime.qa.pages.TasksPage;

public class TasksPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TasksPage tasksPage;

	public TasksPageTest() {
		super();
	}

	@BeforeMethod()
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.loging(properties.getProperty("username"), properties.getProperty("password"));
		tasksPage = homePage.clickOnTaskLink();
	}

	@Test(priority = 1)
	public void validateTasksPage() throws InterruptedException {
		String title = tasksPage.tasksPageTitle();
		Assert.assertEquals(title, "actiTIME - Task List");
	}

	@Test(priority = 2)
	public void validateAddNewCustomerBtn() {
		tasksPage.clickAddNewBtn();
		tasksPage.clickAddNewCustomer();
		Assert.assertTrue(tasksPage.isAddNewUserPopUpDisplayed());
	}

	@Test(priority = 3)
	public void validateAddNewProjectBtn() {
		tasksPage.clickAddNewBtn();
		tasksPage.clickAddNewProject();
		;
		Assert.assertTrue(tasksPage.isAddNewProjectPopUpDisplayed());
	}

	@Test(priority = 4)
	public void validateAddNewTaskBtn() {
		tasksPage.clickAddNewBtn();
		tasksPage.clickAddNewTask();
		Assert.assertTrue(tasksPage.isAddNewTaskPopUpDisplayed());
	}

	@Test(priority = 5)
	public void validateImportCSVBtn() {
		tasksPage.clickAddNewBtn();
		tasksPage.clickImportCSVProject();
		;
		Assert.assertTrue(tasksPage.isImportCSVPopUpDisplayed());
	}

	@Test(priority = 6)
	public void validateTaskList() throws InterruptedException {
		Assert.assertTrue(tasksPage.availableTasks());
	}
	
	@Test(priority = 7)
	public void validateTaskEdit() {
		Assert.assertTrue(tasksPage.validateTaskFunctionality());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
