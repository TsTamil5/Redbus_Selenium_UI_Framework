package com.redbus.testing.stepdefinition;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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

        Base.driver = new EdgeDriver();

        initPropertiesUtility("src/test/resources/Readers/CommonData.properties");

        String URL = getPropertyData("url");

        setMaximizeBrowser(Base.driver);
        implicitlyWait(Base.driver, 5);

        Base.driver.get(URL);

        Pages.loadAllPages(Base.driver);
    }

    @After
    public void closeBrowser(Scenario scenario) {

        // Screenshot on failure
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Base.driver)
                    .getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png", "Failed Screenshot");
        }

        // Safe browser close
        if (Base.driver != null) {
            Base.driver.quit();
            Base.driver = null;
        }
    }
}