package com.redbus.testing.stepdefinition;


import com.aventstack.extentreports.*;
import com.redbus.testing.utilities.AllUtilityFunction;
import com.redbus.testing.utilities.Base;
import com.redbus.testing.utilities.Pages;

import io.cucumber.java.Scenario;
import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.module.Browser;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends AllUtilityFunction {

	AllUtilityFunction util = new AllUtilityFunction();
	@Before
	public void setup(Scenario scenario) throws IOException {

		initPropertiesUtility("src/test/resources/Readers/CommonData.properties");

	    WebDriver driver = new ChromeDriver();
	    
	    Base.setDriver(driver);

	    String URL = getPropertyData("url");
	    Base.getDriver().get(URL);
	    setMaximizeBrowser(Base.getDriver());
	    implicitlyWait(driver, 15);

	    Pages.loadAllPages(driver);

	}

	@After
	public void tearDown(Scenario scenario) {

		Base.getDriver().quit();
		Base.removeDriver();
	}
}
