package com.redbus.testing.stepdefinition;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;

import com.redbus.testing.utilities.Pages;

import io.cucumber.java.Before;
	import io.cucumber.java.After;
	

	public class Hook {

	    private static WebDriver driver;

	    @Before
	    public void setUp() {

	        driver = new ChromeDriver();
	        driver.manage().window().maximize();

	        // ✅ Initialize POM here
	        Pages.initPages(driver);

	        driver.get("https://www.redbus.in/railways");  // better URL
	    }

	    @After
	    public void tearDown() {
	        if (driver != null) {
	           // driver.quit();
	        }
	    }

	    public static WebDriver getDriver() {
	        return driver;
	    }
	}

