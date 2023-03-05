package com.actitime.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.qa.base.TestBase;

public class ReportsPage extends TestBase {

	@FindBy(xpath = "//div[@class='type-title']")
	@CacheLookup
	WebElement reportType;

	@FindBy(xpath = "//td[@class='configsTableRowCell']")
	@CacheLookup
	WebElement reportItem;

	@FindBy(xpath = "//div[@class='config-name']")
	@CacheLookup
	WebElement reportName;

	@FindBy(xpath = "//div[@class='reportName']")
	@CacheLookup
	WebElement reportPageName;

	@FindBy(xpath = "//div[@class='pagetitle']")
	@CacheLookup
	WebElement reportPageTitle;

	@FindBy(xpath = "//span[text()='Create Chart']")
	@CacheLookup
	WebElement newChartBtn;

	@FindBy(xpath = "//div[text()='Create Chart:']")
	WebElement createChartPopUpTitle;

	@FindBy(xpath = "//span[text()='New Report']")
	@CacheLookup
	WebElement newReportBtn;

	@FindBy(xpath = "//div[text()='Choose Report to Create']")
	WebElement newReportPopUpTitle;

	// initialization
	public ReportsPage() {
		PageFactory.initElements(driver, this);
	}

	//Actions
	public Boolean availableReports() {
		return reportItem.isDisplayed();
	}

	public void clickReport() {
		reportName.click();
	}

	public String reportType() {
		return reportType.getText();
	}

	public String reportName() {
		return reportName.getText();
	}

	public String reportsPageTitle() {
		return driver.getTitle();
	}

	public String reportPageTitle() {
		return reportPageTitle.getText();
	}

	public String reportPageName() {
		return reportPageName.getText();
	}

	public void clickCreateChartBtn() {
		newReportBtn.click();
	}

	public boolean createChartTitle() {
		return newReportPopUpTitle.isDisplayed();
	}

	public void clickNewReportBtn() {
		newReportBtn.click();
	}

	public boolean newReportTitle() {
		return newReportPopUpTitle.isDisplayed();
	}

}
