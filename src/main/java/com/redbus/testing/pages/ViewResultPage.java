package com.redbus.testing.pages;

// Importing required Selenium and Java libraries
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class ViewResultPage {

    // WebDriver instance to control browser
    WebDriver driver;

    // Explicit wait for synchronization
    WebDriverWait wait;

    // Constructor to initialize driver, wait, and PageFactory elements
    public ViewResultPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this); // Initialize @FindBy elements
    }

    // ================= LOCATORS =================

    // Header element to verify filter section is displayed
    @FindBy(xpath = "//h2[text()='Filter results']")
    WebElement filterHeader;

    // Source wrapper container
    @FindBy(xpath = "(//div[contains(@class,'srcDestWrapper')])[1]")
    WebElement sourceWrapper;

    // Hardcoded source location (example)
    @FindBy(xpath = "//div[text()='MGR Chennai Central - MAS']")
    WebElement inputBox;

    // Date field element
    @FindBy(xpath = "//div[contains(@aria-label,'selected')]")
    WebElement dateField;

    // Search button
    @FindBy(xpath = "//button[@aria-label='Search']")
    WebElement searchButton;

    // Destination input box container
    @FindBy(xpath = "//div[.='Destination']/..//div[contains(@class,'srcDest')]")
    WebElement destbox;

    // List of all train result cards
    @FindBy(xpath = "//div[contains(@class,'cardWrap')]")
    List<WebElement> trainList;

    // Train count text (example: "79 Trains")
    @FindBy(xpath = "//span[@class='totalTrain___55e2b3']")
    WebElement trainCountText;

    // Message displayed when no trains are available
    @FindBy(xpath = "//*[contains(text(),'No trains') or contains(text(),'No Trains')]")
    WebElement noTrainsMsg;

    // ================= ACTION METHODS =================

    // Click search button after ensuring it is clickable
    public void clickSearch() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }

    // Open date picker by clicking on date field
    public void openDatePicker() {
        wait.until(ExpectedConditions.elementToBeClickable(dateField)).click();
    }

    // Enter destination city and select from dropdown
    public void senddest(String dest) throws InterruptedException {

        // Click destination box
        wait.until(ExpectedConditions.elementToBeClickable(destbox)).click();

        // Locate active input field
        WebElement input = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("srcDest"))
        );

        // Clear existing value using keyboard
        input.sendKeys(Keys.CONTROL + "a");
        input.sendKeys(Keys.DELETE);

        // Enter new destination
        input.sendKeys(dest);

        // Wait for suggestions to load
        Thread.sleep(2000);

        // Select first suggestion
        input.sendKeys(Keys.DOWN, Keys.ENTER);
    }

    // ================= VALIDATIONS =================

    // Check if filter section is displayed on result page
    public boolean isFilterDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(filterHeader));
        return filterHeader.isDisplayed();
    }

    // Validate whether trains are displayed OR no trains message appears
    public boolean isResultValid() {

        try {
            // Wait until either train list appears OR no train message appears
            wait.until(driver -> trainList.size() > 0 || isElementVisible(noTrainsMsg));

            if (trainList.size() > 0) {
                System.out.println("✅ Trains are available");
                return true;
            } else if (isElementVisible(noTrainsMsg)) {
                System.out.println("⚠️ No trains available");
                return true;
            }

        } catch (Exception e) {
            return false;
        }
        return false;
    }

    // Validate trains using count text + list size
    public boolean validateTrainsAvailable() {

        try {
            // Wait for train count text to appear
            wait.until(ExpectedConditions.visibilityOf(trainCountText));

            String text = trainCountText.getText();
            System.out.println("Train Count Text: " + text);

            // Extract numeric count from text
            int count = Integer.parseInt(text.split(" ")[0]);

            // Wait until train list is visible
            wait.until(ExpectedConditions.visibilityOfAllElements(trainList));

            System.out.println("Train List Size: " + trainList.size());

            // Validate both count and list size
            return count > 0 && trainList.size() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Utility method to safely check element visibility
    private boolean isElementVisible(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Check if train count is greater than zero
    public boolean isTrainCountAboveZero()
    {
        String trainCount = trainCountText.getText();

        // Extract first character (note: may not work correctly for multi-digit numbers)
        int trains = Integer.parseInt(trainCount.split("")[0]);

        if (trains > 0)
        {
            return true;
        }
        return false;
    }
}