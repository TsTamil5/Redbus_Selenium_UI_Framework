package com.redbus.testing.stepdefinition;

<<<<<<< HEAD
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
=======
import java.io.IOException;
>>>>>>> d4399ab3e8ca2447131fcae29e4ba59ab11ee582

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