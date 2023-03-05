package com.actitime.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.HomePage;
import com.actitime.qa.pages.LoginPage;
import com.actitime.qa.pages.ReportsPage;

public class ReportsPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ReportsPage reportsPage;

	public ReportsPageTest() {
		super();
	}

	@BeforeMethod()
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.loging(properties.getProperty("username"), properties.getProperty("password"));
		reportsPage = homePage.clickOnReportsLink();
	}

	@Test(priority = 1)
	public void validateReportsPage() throws InterruptedException {
		String title = reportsPage.reportsPageTitle();
		Assert.assertEquals(title, "actiTIME - Reports Dashboard");
	}
	
	@Test(priority = 2)
	public void validateReportList() throws InterruptedException {
		Assert.assertTrue(reportsPage.availableReports());
	}

	@Test(priority = 3)
	public void validateReport() {
		String reportType = reportsPage.reportType() + " Report";
		String reportName = reportsPage.reportName();
		reportsPage.clickReport();
		Assert.assertEquals(reportsPage.reportPageTitle(), reportType);
		Assert.assertEquals(reportsPage.reportPageName(), reportName);
	}

	@Test(priority = 4)
	public void validateCreateChartButton() {
		reportsPage.clickCreateChartBtn();
		;
		Assert.assertTrue(reportsPage.createChartTitle());
	}

	@Test(priority = 5)
	public void validateNewReportButton() {
		reportsPage.clickNewReportBtn();
		Assert.assertTrue(reportsPage.newReportTitle());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
