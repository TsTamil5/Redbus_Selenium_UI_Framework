package com.redbus.testing.testrunner;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

	// Feature file location
	features = "./src/test/java/com/redbus/testing/featurefiles/SearchHotels.feature",

	// Step definition package
	glue = "com.redbus.testing.stepdefinition",

	// Reporting plugins
	plugin = {
			"pretty",
			"html:target/cucumber-report.html",
			"json:target/cucumber.json",
			"com.redbus.testing.utilities.ExtentCucumberAdapter"
	},

	// Execute tests
	dryRun = false
)

public class RunnerIO extends AbstractTestNGCucumberTests {

	// Enable parallel execution
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
	    return super.scenarios();
	}
}