package com.actitime.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.qa.base.TestBase;

public class TasksPage extends TestBase {

	@FindBy(xpath = "//tr[@class='taskRow']")
	WebElement tasksList;
	
	@FindBy(xpath = "(//td[@class='names'])[2]")
	WebElement task;

	@FindBy(xpath = "//div[contains(@class, 'edit_task_sliding_panel')]")
	WebElement editSlider;

	@FindBy(xpath = "//div[@class='addNewButton']")
	WebElement addNewBtn;

	@FindBy(xpath = "//div[text()='+ New Customer']")
	@CacheLookup
	WebElement addNewCustomerBtn;

	@FindBy(xpath = "//span[text()='Create New Customer']")
	WebElement addNewCustomerPopup;
	
	@FindBy(xpath = "//div[text()='+ New Project']")
	@CacheLookup
	WebElement addNewProjectBtn;
	
	@FindBy(xpath = "//span[text()='Create New Project']")
	WebElement addNewProjectPopup;
	
	@FindBy(xpath = "//div[text()='+ New Tasks']")
	@CacheLookup
	WebElement addNewTaskBtn;
	
	@FindBy(xpath = "//*[@id=\"createTasksPopup_content\"]/table/tbody/tr/td/div[2]")
	WebElement addNewTasksPopup;
	
	@FindBy(xpath = "//div[text()='Import Tasks from CSV']")
	@CacheLookup
	WebElement importCSVBtn;
	
	@FindBy(xpath = "//*[@id=\"loadTasksFromCSVPopup_content\"]/table/tbody/tr/td/div[2]")
	WebElement importCSVPopup;

	// initialization
	public TasksPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String tasksPageTitle() {
		return driver.getTitle();
	}

	public Boolean availableTasks() {
		return tasksList.isDisplayed();
	}

	public Boolean validateTaskFunctionality() {
		task.click();
		return editSlider.isDisplayed();
	}

	public void clickAddNewBtn() {
		addNewBtn.click();
	}

	public void clickAddNewCustomer() {
		addNewCustomerBtn.click();
	}

	public boolean isAddNewUserPopUpDisplayed() {
		return addNewCustomerPopup.isDisplayed();
	}
	
	public void clickAddNewTask() {
		addNewTaskBtn.click();
	}

	public boolean isAddNewTaskPopUpDisplayed() {
		return addNewTasksPopup.isDisplayed();
	}
	
	public void clickAddNewProject() {
		addNewProjectBtn.click();
	}

	public boolean isAddNewProjectPopUpDisplayed() {
		return addNewProjectPopup.isDisplayed();
	}
	
	public void clickImportCSVProject() {
		importCSVBtn.click();
	}

	public boolean isImportCSVPopUpDisplayed() {
		return importCSVPopup.isDisplayed();
	}

}
