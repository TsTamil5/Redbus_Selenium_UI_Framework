package com.redbus.testing.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.redbus.testing.utilities.AllUtilityFunction;

public class popularfood_restaurant_serving_page {

    // Driver & utility
    private WebDriver driver;
    private AllUtilityFunction util;

    // Locator for restaurant list
    private By restaurantLocator =
        By.xpath("//div[@class='mt-4 h-auto']/h1");

    // Constructor
    public popularfood_restaurant_serving_page(WebDriver driver) {
        this.driver = driver;
        this.util = new AllUtilityFunction();
    }

    // Check if restaurant list is visible
    public boolean isRestaurantListVisible() {

        List<WebElement> restaurants =
            util.waitForElementsMoreThan(driver, restaurantLocator, 0, 25);

        System.out.println("Number of restaurants: " + restaurants.size());

        return restaurants.size() > 0;
    }
}