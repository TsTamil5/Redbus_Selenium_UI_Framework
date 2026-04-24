package com.redbus.testing.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.redbus.testing.utilities.AllUtilityFunction;

public class TrainRestaurantsPage {

    // Driver and utility
    private WebDriver driver;
    private AllUtilityFunction util;

    // Locator for restaurant list
    private By restaurantLocator =
        By.xpath("//div[contains(@class,'flex flex-1 flex-col py-3')]/div/h5");

    // Constructor
    public TrainRestaurantsPage(WebDriver driver) {
        this.driver = driver;
        this.util = new AllUtilityFunction();
    }

    // Verify restaurant list is displayed
    public boolean isRestaurantListDisplayed() {

        // Wait until restaurants are loaded
        List<WebElement> list =
            util.waitForElementsMoreThan(driver, restaurantLocator, 0, 25);

        System.out.println("Number of restaurants: " + list.size());

        return list.size() > 0;
    }
}