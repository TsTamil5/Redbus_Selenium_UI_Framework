package com.redbus.testing.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class popularfood_restaurant_serving_page {
	private WebDriver driver;
    private WebDriverWait wait;
 // Locator for dynamic restaurant list
    private By restaurantLocator =
        By.xpath("//div[@class='mt-4 h-auto']/h1");

    public popularfood_restaurant_serving_page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        PageFactory.initElements(driver, this);
    }

    public boolean isRestaurantListVisible() {

        // Wait until at least 1 restaurant is loaded
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(restaurantLocator, 0));

        // Fetch fresh elements
        List<WebElement> restaurants = driver.findElements(restaurantLocator);

        int count = restaurants.size();
        System.out.println("Number of restaurants: " + count);

        return count > 0;
    }
}
