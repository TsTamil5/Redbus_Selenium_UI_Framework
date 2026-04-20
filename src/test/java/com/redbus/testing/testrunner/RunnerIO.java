package com.redbus.testing.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/java/Feature/TrainTickets.feature",
	    glue = {"stepdefinition", "Hook"},
	    plugin = {"pretty"},
	    dryRun=false
		)

	public class RunnerIO extends AbstractTestNGCucumberTests {
	}


