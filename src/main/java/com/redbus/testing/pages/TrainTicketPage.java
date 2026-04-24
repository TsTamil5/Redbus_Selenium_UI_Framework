package com.redbus.testing.pages;

// Importing required Selenium and Java libraries
import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrainTicketPage {

    // WebDriver instance to control browser
    WebDriver driver;

    // Explicit wait for synchronization
    WebDriverWait wait;

    // Constructor to initialize driver, wait, and PageFactory elements
    public TrainTicketPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this); // Initialize @FindBy elements
    }

    // ================= LOCATORS =================

    // Date picker element
    @FindBy(xpath = "//div[@id='date-picker-grid']")
    WebElement datePicker;

    // From field container
    @FindBy(xpath = "//div[text()='From']")
    WebElement fromField;

    // Input box inside From field
    @FindBy(xpath = "//label[text()='From']/..//input")
    WebElement fromInput;
    
    // To field container
    @FindBy(css="[aria-label='To']")
    WebElement toField;
    
    // Input box inside To field
    @FindBy(xpath="//label[text()='To']/..//input")
    WebElement toInput;
    
    // Active input (generic locator for enabled text input)
    @FindBy(xpath = "//input[@type='text' and not(@disabled)]")
    WebElement activeInput;

    // Search button
    @FindBy(xpath = "//button[contains(text(),'Search Trains')]")
    WebElement searchBtn;

    // Validation element (used to check result page or UI state)
    @FindBy(xpath="//div[@role='radiogroup']")
    WebElement validate;

    // ================= ACTION METHODS =================

    // Launch RedBus train booking page and maximize window
    public void openUrl() {
        driver.get("https://www.redbus.in/railways");
        driver.manage().window().maximize();
    }

    // Click to open date picker
    public void openDatePicker() {
        datePicker.click();
    }

    // Select month and date dynamically from calendar
    public void selectDate(String month, String day) {

        // Loop until desired month is visible
        while (true) {
            try {
                String monthXpath = "//div[contains(@class,'datepicker')]/..//p[text()='" + month + "']";

                if (driver.findElement(By.xpath(monthXpath)).isDisplayed()) {
                    break; // Stop when month is found
                }
            } catch (Exception e) {
                // Click next button if month not found
                driver.findElement(By.xpath("//button[text()='>']")).click();
            }
        }

        // Select the specific day
        String dayXpath = "//div[contains(@class,'datepicker')]/..//span[text()='" + day + "']";
        driver.findElement(By.xpath(dayXpath)).click();

        // Scroll page to top after date selection
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0);");
    }

    // Enter source city in From field
    public void enterFrom(String city) throws InterruptedException {
        fromField.click(); // Click container
        Thread.sleep(2000); // Wait for input to activate
        fromInput.sendKeys(city); // Type city
        Thread.sleep(2000); // Wait for suggestions
        fromInput.sendKeys(Keys.DOWN, Keys.ENTER); // Select first suggestion
    }

    // Enter destination city in To field
    public void enterTo(String city) throws InterruptedException {

        // Wait until input is visible
        WebElement input = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='To']/..//input"))
        );

        input.sendKeys(city); // Type destination
        Thread.sleep(2000); // Wait for suggestions

        // Use Actions class to select from dropdown
        Actions actions = new Actions(driver);

        actions.sendKeys(Keys.DOWN)
               .sendKeys(Keys.ENTER)
               .perform();
    }

    // Generic method to select city from dropdown using exact match
    public void selectCity(WebElement inputBox, String city) {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Click input using JavaScript (avoids click issues)
        js.executeScript("arguments[0].click();", inputBox);

        // Clear existing text and type new city
        inputBox.clear();
        inputBox.sendKeys(city);

        // Dynamic XPath for matching option
        String optionXpath = "//li[.//text()[contains(.,'" + city + "')]]";

        // Wait for option to be clickable and click it
        WebElement option = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath(optionXpath)));

        option.click();
    }

    // Custom wait method using Thread.sleep
    public void waitForSeconds(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Click Search button using JavaScript
    public void clickSearch() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Wait until button is clickable
        WebElement btn = wait.until(
                ExpectedConditions.elementToBeClickable(searchBtn));

        // Scroll to button
        js.executeScript("arguments[0].scrollIntoView(true);", btn);

        // Click using JS (avoids interception issues)
        js.executeScript("arguments[0].click();", btn);
    }

    // Getter for validation element
    public WebElement getValidate()
    {
        return validate;
    }

    // ================= ERROR VALIDATION =================

    // Method to check if error message is displayed
    public boolean isErrorDisplayed() {
        try {
            Thread.sleep(2000);

            // Different possible error messages
            String[] errorXpaths = {
                "//*[contains(text(),'Source and Destination are same')]",
                "//*[contains(text(),'cannot be same')]",
                "//*[contains(text(),'same source and destination')]",
                "//*[contains(text(),'different cities')]",
                "//*[contains(text(),'same')]",
                "//div[contains(@class,'errorToast')]",
                "//div[@class='errorToast']",
                "//div[contains(@class,'error-message')]"
            };

            // Loop through all locators
            for (String xpath : errorXpaths) {
                try {
                    WebElement error = driver.findElement(By.xpath(xpath));
                    if (error.isDisplayed()) {
                        System.out.println("Found error: " + error.getText());
                        return true; // Error found
                    }
                } catch (Exception e) {
                    // Continue checking next locator
                }
            }

            return false; // No error found

        } catch (Exception e) {
            return false;
        }
    }
}