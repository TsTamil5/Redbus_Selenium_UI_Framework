package com.redbus.testing.pages;

// Importing required Selenium and Java libraries
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrainListPage {

    // WebDriver instance to control browser
    WebDriver driver;

    // Explicit wait object for synchronization
    WebDriverWait wait;

    // Constructor to initialize driver, wait, and PageFactory elements
    public TrainListPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this); // Initialize @FindBy elements
    }

    // Locator for the first "View Route" button in train list
    @FindBy(xpath = "(//button[text()='View Route'])[1]")
    private WebElement viewRouteButton;

    // Method to click on "View Route" button
    public void clickViewRoute() throws InterruptedException {
        Thread.sleep(5000); // Static wait to allow page to load (not recommended in real-time)
        viewRouteButton.click(); // Clicking the button
    }

    // Locator to capture all stations listed in the route
    @FindBy(xpath = "//ul[contains(@class,'ts_station_list')]/li")
    private List<WebElement> stationList;

    // Method to return list of station WebElements
    public List<WebElement> getStationList() {
        return stationList; // Returns all station elements for validation or iteration
    }
}