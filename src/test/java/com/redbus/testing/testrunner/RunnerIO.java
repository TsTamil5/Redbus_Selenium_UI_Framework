package com.redbus.testing.testrunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.testng.CucumberOptions;


<<<<<<< HEAD
@CucumberOptions(features = "F:\\Redbus_Selenium_UI_Framework\\src\\test\\java\\com\\redbus\\testing\\featurefiles\\BusTicket.feature", glue ="com.redbus.testing.stepdefinition", 
=======
@CucumberOptions(features =	{"./src/test/java/com/redbus/testing/featurefiles/BusTicket.feature",
"./src/test/java/com/redbus/testing/featurefiles/TrainTickets.feature",
"./src/test/java/com/redbus/testing/featurefiles/Accounts.feature"},

		glue ="com.redbus.testing.stepdefinition", 	
>>>>>>> a4541c2b54b1e2ec161fb62aa44165f8a09709dc
		plugin = {
		"pretty", "html:target/cucumber-report.html",
		"json:target/cucumber.json",
		"com.redbus.testing.utilities.ExtentCucumberAdapter" },
		monochrome = true,
		dryRun=false
		)

public class RunnerIO extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}

