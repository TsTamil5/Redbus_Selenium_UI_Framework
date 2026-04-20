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

public class restaurant_menu_page {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private By dishesLocator = By.xpath("//div[@class='w-full']/div/h6");

    @FindBy(xpath = "//span[@class='flex']/div/h3")
    private WebElement restaurantName;

    public restaurant_menu_page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        PageFactory.initElements(driver, this);
    }

    public String getRestaurantName() {
        wait.until(ExpectedConditions.visibilityOf(restaurantName));
        return restaurantName.getText();
    }

    public boolean isDishPresent(String dishName) {

        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(dishesLocator, 0));

        List<WebElement> dishes = driver.findElements(dishesLocator);

        for (WebElement dish : dishes) {

            String text = dish.getText().trim();

            if (text.equalsIgnoreCase(dishName)) {
                return true;
            }
        }

        return false;
    }
}
