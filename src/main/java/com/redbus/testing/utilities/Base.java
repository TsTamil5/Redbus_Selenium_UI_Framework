package com.redbus.testing.utilities;

import org.openqa.selenium.WebDriver;

public class Base {

    // ThreadLocal driver for parallel execution
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Set driver instance for current thread
    public static void setDriver(WebDriver driverInstance) {
        driver.set(driverInstance);
    }

    // Get driver instance of current thread
    public static WebDriver getDriver() {
        return driver.get();
    }
    
    // Remove driver instance after execution
    public static void removeDriver() {
        driver.remove();
    }
   
}
