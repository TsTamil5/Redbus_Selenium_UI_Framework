package com.redbus.testing.testrunner;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = {
        "src/test/java/com/redbus/testing/featurefiles/BusTicket.feature",
        "src/test/java/com/redbus/testing/featurefiles/TrainTickets.feature",
        "src/test/java/com/redbus/testing/featurefiles/Accounts.feature",
        "src/test/java/com/redbus/testing/featurefiles/SearchHotels.feature",
        "src/test/java/com/redbus/testing/featurefiles/FoodOrder.feature"
    },

    glue = "com.redbus.testing.stepdefinition",

    plugin = {
        "pretty",
        "html:target/cucumber-report.html",
        "json:target/cucumber.json",
        "com.redbus.testing.utilities.ExtentCucumberAdapter"
    },

    monochrome = true,
    dryRun = false
)

public class RunnerIO extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false) // change to true if needed
    public Object[][] scenarios() {
        return super.scenarios();
    }
}