package com.redbus.testing.stepdefinition;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.redbus.testing.utilities.AllUtilityFunction;
import com.redbus.testing.utilities.AllUtilityFunction.CookieUtil;
import com.redbus.testing.utilities.Base;
import com.redbus.testing.utilities.HandleCookies;
import com.redbus.testing.utilities.LaunchingBrowser;
import com.redbus.testing.utilities.Pages;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Hooks extends AllUtilityFunction {
	
	@Before
    public void openBrowser(Scenario scenario) throws IOException {

        initPropertiesUtility("src/test/resources/Readers/CommonData.properties");
        
        String browser = getPropertyData("browser");
        String URL = getPropertyData("url");
        
        // Launch browser from property file
        Base.setDriver(LaunchingBrowser.launchBrowser(browser));
        
       setMaximizeBrowser(Base.getDriver());
       implicitlyWait(Base.getDriver(),5);

       Base.getDriver().get(URL);
       Pages.loadAllPages(Base.getDriver());  
     

       // 🔹 Normal flow
       HandleCookies cookieUtil = new HandleCookies();
       String cookieFile = "Cookies.data";

       boolean loaded = cookieUtil.loadCookies(Base.getDriver(), cookieFile);

       if (!loaded || !Pages.getInstance().loginCookies.isUserLoggedIn()) {
           System.out.println("👉 Please login manually...");
           try {
               Thread.sleep(50000); // give time for manual login
           } catch (Exception e) {}

           if (Pages.getInstance().loginCookies.isUserLoggedIn()) {
               cookieUtil.saveCookies(Base.getDriver(), cookieFile);
           } else {
               throw new RuntimeException("Login required!");
           }
       } else {
           // Navigate to a protected page after loading cookies
           Base.getDriver().get(URL);
       }
   }
    

    @After
    public void closeBrowser(Scenario scenario) {
       Base.getDriver().quit();
       Base.removeDriver();
        }
    

}