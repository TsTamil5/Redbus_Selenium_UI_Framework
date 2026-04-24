package com.redbus.testing.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.redbus.testing.utilities.AllUtilityFunction;

public class RestaurantMenuPage {

    // Driver and utility
    private WebDriver driver;
    private AllUtilityFunction util;

    // Locator for Dish Name
    private By dishesLocator = By.xpath("//div[@class='w-full']/div/h6");
    
 // Locator for Restaurant Name
    private By restaurantNameLocator = By.xpath("//span[@class='flex']/div/h3");

    // Constructor
    public RestaurantMenuPage(WebDriver driver) {
        this.driver = driver;
        this.util = new AllUtilityFunction();
    }

    // Get restaurant name
    public String getRestaurantName() {
        return util.waitForVisibility(driver, restaurantNameLocator, 25).getText();
    }

    // Check if a dish exists in menu
    public boolean isDishPresent(String dishName) {
        try {
            // Wait for dishes to load
            util.waitForAllElementsPresence(driver, dishesLocator, 25);

            List<WebElement> dishes = driver.findElements(dishesLocator);

            for (int i = 0; i < dishes.size(); i++) {

                // Re-fetch to avoid stale element
                List<WebElement> fresh = driver.findElements(dishesLocator);

                if (fresh.get(i).getText().trim().equalsIgnoreCase(dishName)) {
                    return true;
                }
            }

        } catch (org.openqa.selenium.StaleElementReferenceException e) {
            return isDishPresent(dishName);
        }

        return false;
    }
}