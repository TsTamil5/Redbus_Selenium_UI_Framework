package com.redbus.testing.utilities;

import org.openqa.selenium.WebDriver;

public class Base {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setDriver(WebDriver dr) {
        driver.set(dr);
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void unload() {
        driver.remove();
    }
}