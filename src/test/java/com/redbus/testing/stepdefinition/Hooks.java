package com.redbus.testing.stepdefinition;

import org.openqa.selenium.chrome.ChromeDriver;



import com.redbus.testing.utilities.AllUtilityFunction;
import com.redbus.testing.utilities.Base;
import com.redbus.testing.utilities.Pages;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends Base {
	public static AllUtilityFunction util = new AllUtilityFunction();
	 @Before
	    public void setUp() {

	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://www.redbus.in");

	        // initialize all pages
	        Pages.initPages(driver);
	        
	        util.initWorkbook();
	    }

	    @After
	    public void tearDown() {
//	        driver.quit();
	        driver = null;  
	    }

}
