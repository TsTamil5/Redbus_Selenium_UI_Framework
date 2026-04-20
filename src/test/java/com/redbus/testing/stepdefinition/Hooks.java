package com.redbus.testing.stepdefinition;

import java.io.IOException;

import org.openqa.selenium.edge.EdgeDriver;

import com.redbus.testing.utilities.AllUtilityFunction;
import com.redbus.testing.utilities.Base;
import com.redbus.testing.utilities.Pages;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends AllUtilityFunction {

	@Before
	public void openBrowser() throws IOException {

		// Launch Browser
		Base.driver = new EdgeDriver();

		// Read properties file
		initPropertiesUtility("src/test/resources/Readers/CommonData.properties");

		String URL = getPropertyData("url");

		// Browser Settings
		setMaximizeBrowser(Base.driver);
		implicitlyWait(Base.driver, 5);

		// Open Application
		Base.driver.get(URL);

		// Load Page Objects
		Pages.loadAllPages(Base.driver);
	}

	@After
	public void closeBrowser(Scenario scenario) {

//		 Close Browser
		if (Base.driver != null) {
			Base.driver.quit();
		}
	}
}