package com.redbus.testing.testrunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "F:\\Redbus_Selenium_UI_Framework\\src\\test\\java\\com\\redbus\\testing\\featurefiles\\BusTicket.feature", glue ="com.redbus.testing.stepdefinition", 
//		tags = "@SwapFeature", 	
		plugin = {
		"pretty", "html:target/cucumber-report.html", "json:target/cucumber.json",
		"com.redbus.testing.utilities.ExtentCucumberAdapter" },
		monochrome = true)

public class RunnerIO extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
