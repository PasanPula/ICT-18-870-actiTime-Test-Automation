package com.actitime.qa.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "/Users/Pasan/Desktop/ICT_18_870/HRTestAutomation/src/main/java/com/actitime/qa/feature/NewUserCreate.feature", 
		glue = {"com/actitime/qa/stepdefinitions" }, 
		monochrome = true, 
		strict = true, 
		dryRun = false, 
		stepNotifications = true
)

public class TestRunner {

}
