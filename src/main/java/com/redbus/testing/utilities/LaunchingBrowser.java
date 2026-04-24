package com.redbus.testing.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchingBrowser {

	// Launch browser based on given name
	public static WebDriver launchBrowser(String browser) {

        WebDriver driver = null;

        if (browser.toLowerCase().contains("chrome")) {
            driver = new ChromeDriver();
        } 
        else if (browser.toLowerCase().contains("firefox")) {
            driver = new FirefoxDriver();
        } 
        else if (browser.toLowerCase().contains("edge")) {
            driver = new EdgeDriver();
        } 
        else {
            // Throw error for invalid browser name
            throw new RuntimeException("Invalid browser name in properties file");
        }

        return driver;
    }

}

