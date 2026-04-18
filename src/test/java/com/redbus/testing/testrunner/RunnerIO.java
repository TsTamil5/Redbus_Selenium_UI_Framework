package com.redbus.testing.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	features = "./src/test/java/com/redbus/testing/featurefiles/SearchHotels.feature",
	glue = "com.redbus.testing.stepdefinition",
//	plugin = {
//			"pretty",
//			"html:target/cucumber-report.html",
//			"json:target/cucumber.json"
//	},
	dryRun = false
)
public class RunnerIO extends AbstractTestNGCucumberTests {

}