package com.redbus.testing.stepdefinition;

import java.io.IOException;

import org.openqa.selenium.edge.EdgeDriver;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.ExtentTest;
import com.redbus.testing.utilities.AllUtilityFunction;
import com.redbus.testing.utilities.Base;
import com.redbus.testing.utilities.ExtentReportManager;
import com.redbus.testing.utilities.Pages;
import com.redbus.testing.utilities.ScreenshotUtility;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends AllUtilityFunction {

    @Before
    public void openBrowser(Scenario scenario) throws IOException {

        // Launch browser
        Base.setDriver(new EdgeDriver());

        // Report Node
        ExtentTest test = ExtentReportManager.getInstance()
                .createTest(scenario.getName());

        ExtentReportManager.setTest(test);

        // Read property file
        initPropertiesUtility("src/test/resources/Readers/CommonData.properties");

        String URL = getPropertyData("url");

        // Browser settings
        setMaximizeBrowser(Base.getDriver());
        implicitlyWait(Base.getDriver(), 5);

        // Open App
        Base.getDriver().get(URL);

        // Load Pages
        Pages.loadAllPages(Base.getDriver());
    }
    
    @After
    public void closeBrowser(Scenario scenario) {

        try {
        	
        	if (scenario.isFailed()) {

        	    String filePath =
        	        ScreenshotUtility.saveScreenshot(
        	            Base.getDriver(),
        	            scenario.getName().replaceAll(" ", "_")
        	        );

        	    ExtentReportManager.getTest().fail(
        	        "Scenario Failed",
        	        MediaEntityBuilder
        	            .createScreenCaptureFromPath(filePath)
        	            .build()
        	    );
        	}
        	
            else {

                ExtentReportManager.getTest().pass("Scenario Passed");
            }

        } catch (Exception e) {

            e.printStackTrace();   
            ExtentReportManager.getTest()
                .fail("Screenshot capture failed: " + e.getMessage());
        }

        try {
            if (Base.getDriver() != null) {
                Base.getDriver().quit();
            }
        } catch (Exception e) {
        }

        Base.unload();
        Pages.unload();
    }
}