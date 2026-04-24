package com.redbus.testing.stepdefinition;


import com.aventstack.extentreports.*;
import java.io.IOException;
import com.redbus.testing.utilities.AllUtilityFunction;
import com.redbus.testing.utilities.Base;
import com.redbus.testing.utilities.LaunchingBrowser;
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
    public void openBrowser(Scenario scenario) throws IOException {

        // Read property file
        initPropertiesUtility("src/test/resources/Readers/CommonData.properties");

        String browser = getPropertyData("browser");
        String URL = getPropertyData("url");
        // Launch browser from property file
        Base.setDriver(LaunchingBrowser.launchBrowser(browser));

        // Browser settings
        setMaximizeBrowser(Base.getDriver());
        implicitlyWait(Base.getDriver(), 5);

        // Open application
        Base.getDriver().get(URL);

        // Load pages
        Pages.loadAllPages(Base.getDriver());
    }

    @After
    public void closeBrowser(Scenario scenario) {
    	Base.getDriver().quit();
    	Base.removeDriver();
    }
}

