package com.redbus.testing.testrunner;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//Feature file location
@CucumberOptions(features =	{//"./src/test/java/com/redbus/testing/featurefiles/BusTicket.feature",
		//"./src/test/java/com/redbus/testing/featurefiles/TrainTickets.feature",
		"./src/test/java/com/redbus/testing/featurefiles/Accounts.feature",
		//"./src/test/java/com/redbus/testing/featurefiles/SearchHotels.feature",
		//"./src/test/java/com/redbus/testing/featurefiles/FoodOrder.feature"
		},

		//Step definition package
		glue ="com.redbus.testing.stepdefinition", 
		
		// Reporting plugins
		plugin = {
		"pretty", "html:target/cucumber-report.html",
		"json:target/cucumber.json",
		"com.redbus.testing.utilities.ExtentCucumberAdapter" },
		
		monochrome = true,
		
		// Execute tests
		dryRun=false
		)

public class RunnerIO extends AbstractTestNGCucumberTests {
	
	// Enable parallel execution
	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
