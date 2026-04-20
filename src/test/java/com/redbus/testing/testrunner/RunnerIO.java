package com.redbus.testing.testrunner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

	@CucumberOptions(
	        features = "./src/test/java/com/redbus/testing/featurefiles/TrainTickets.feature",

	        glue = {
	                "com.redbus.testing.stepdefinition"
	        },
	//
//	        plugin = {
//	                "pretty",
//	                "html:target/cucumber-report.html",
//	                "json:target/cucumber.json"
//	        },
	//
//	        tags = "@TrainSearch",

	        dryRun = false
//	        monochrome = true
	)
	public class RunnerIO extends AbstractTestNGCucumberTests {

//	    @Override
//	    @DataProvider(parallel = true)
//	    public Object[][] scenarios() {
//	        return super.scenarios();
//	    }
}
