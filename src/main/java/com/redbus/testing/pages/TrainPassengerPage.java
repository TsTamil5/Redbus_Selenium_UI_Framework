package com.redbus.testing.pages;

// Importing required Selenium and Java libraries
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrainPassengerPage {

    // WebDriver instance to control browser
    private WebDriver driver;

    // Constructor to initialize driver and PageFactory elements
    public TrainPassengerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize @FindBy elements
    }

    // ================= PAYMENT VALIDATION ELEMENTS =================

    // Locator for UPI payment option
    @FindBy(xpath = "//div[text()='Pay through QR code']")
    private WebElement UPI;

    // Locator for Netbanking option
    @FindBy(xpath = "//h2[text()='Netbanking']")
    private WebElement NetBanking;

    // Locator for Credit/Debit card option
    @FindBy(xpath ="(//div[@aria-label='Add credit/debit card'])[2]")
    private WebElement creditCard;

    // Method to get UPI text
    public String verifyUPI() {
        return UPI.getText();
    }

    // Method to get Netbanking text
    public String verifyNetBanking() {
        return NetBanking.getText();
    }

    // Method to get Credit card text
    public String verifyCredit() {
        return creditCard.getText();
    }

    // ================= BUTTONS =================

    // Continue button
    @FindBy(xpath = "//button[text()='Continue']")
    private WebElement continueBtn;

    // Continue without adding passengers button
    @FindBy(xpath = "//button[text()='Continue without adding']")
    private WebElement continueWithoutAdding;

    // ================= TRAIN SELECTION =================

    // Locator for selecting a train from list
    @FindBy(xpath = "(//div[@data-autoid='srp_card'])[2]//div[@role='button']")
    private WebElement selectTrain;

    // ================= USERNAME SECTION =================

    // IRCTC username field (outer click)
    @FindBy(css = "[placeholder=\"IRCTC Username\"]")
    private WebElement userName;

    // Actual username input field
    @FindBy(xpath = "//input[@id='usernameInput']")
    private WebElement IRCTCName;

    // Close username popup
    @FindBy(css = "[aria-label=\"Close username verification\"]")
    private WebElement closeIRCTC;

    // Check username button
    @FindBy(xpath = "//button[text()='Check username']")
    private WebElement checkUserName;

    // ================= PASSENGER DETAILS =================

    // Passenger name field
    @FindBy(xpath = "//label[text()='Name']/following::input[1]")
    private WebElement passengerName;

    // Gender options
    @FindBy(xpath = "//span[text()='Female']/..")
    private WebElement female;

    @FindBy(xpath = "//span[text()='Male']/..")
    private WebElement male;

    @FindBy(xpath = "//span[text()='Others']/..")
    private WebElement others;

    // Email input field
    @FindBy(xpath = "//input[@id='email']")
    private WebElement email;

    // Phone number input field
    @FindBy(xpath = "//input[@id='phoneNumber']")
    private WebElement phoneNumber;

    // State picker dropdown
    @FindBy(xpath = "//input[@id='statePicker']")
    private WebElement stateOfResidence;

    // Search box for state
    @FindBy(css = "[placeholder=\"Search for state\"]")
    private WebElement searchForState;

    // Food preference dropdown
    @FindBy(xpath = "//label[text()='Food preferences']/parent::div")
    WebElement foodPreferenceDropdown;

    // Selecting a state from dropdown list
    @FindBy(xpath = "(//div[@class=\"listItem___120fe0 \" and @role=\"button\"])[2]")
    private WebElement selectState;

    // Add passenger button
    @FindBy(xpath = "//button[text()='Add to passengers list']")
    WebElement addToPassenger;

    // Age input field
    @FindBy(xpath = "//label[text()='Age']/following::input[1]")
    private WebElement age;

    // ================= METHODS =================

    // Enter passenger name using JS scroll and click
    public void enterPassengerName(String name) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement field = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='userInput']")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", field);

        wait.until(ExpectedConditions.elementToBeClickable(field));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", field);

        field.sendKeys(name);
    }

    // Select state from list
    public void chooseState() {
        selectState.click();
    }

    // Click "Add to passengers list" using JS to avoid click interception
    public void clickAddToPassenger() throws InterruptedException {
        Thread.sleep(2000);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView({block:'center'});", addToPassenger);

        Thread.sleep(1000);

        js.executeScript("arguments[0].click();", addToPassenger);
    }

    // Click check username button
    public void clickCheckUserName() {
        checkUserName.click();
    }

    // Click username field
    public void clickUserName() {
        userName.click();
    }

    // Enter IRCTC username
    public void enterName(String name) {
        IRCTCName.click();
        IRCTCName.sendKeys(name);
    }

    // Close username popup
    public void clickClose() {
        closeIRCTC.click();
    }

    // Select gender
    public void clickFemale() {
        female.click();
    }

    public void clickMale() {
        male.click();
    }

    public void clickothers() {
        others.click();
    }

    // Continue without adding passenger
    public void clickContinueWithoutAdding() {
        continueWithoutAdding.click();
    }

    // Select train
    public void cickTrain() throws InterruptedException {
        Thread.sleep(2000);
        selectTrain.click();
    }

    // Enter age
    public void enterAge(String Age) throws InterruptedException {
        Thread.sleep(2000);
        age.sendKeys(Age);
    }

    // Open food preference dropdown
    public void enterFood() throws InterruptedException {
        Thread.sleep(2000);
        foodPreferenceDropdown.click();
    }

    // Enter email with wait and JS scroll
    public void enterEmail(String mail) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']"))
        );

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);

        Thread.sleep(1000);

        element.click();
        element.clear();
        element.sendKeys(mail);
    }

    // Enter state search text
    public void enterSearchForState(String state) throws InterruptedException {
        Thread.sleep(2000);
        searchForState.sendKeys(state);
    }

    // Click continue button
    public void clickContinue() throws InterruptedException {
        Thread.sleep(2000);
        continueBtn.click();
    }

    // Click state dropdown
    public void clickStateOfResidence() throws InterruptedException {
        Thread.sleep(2000);
        stateOfResidence.click();
    }

    // Enter phone number slowly digit by digit to avoid UI blocking issues
    public void enterPhoneNumber(String number) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement element = wait.until(
            ExpectedConditions.elementToBeClickable(By.id("phoneNumber"))
        );

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);

        element.click();
        element.clear();

        // Sending digits one by one (handles dynamic input issues)
        for (char digit : number.toCharArray()) {
            element.sendKeys(String.valueOf(digit));
            Thread.sleep(200);
        }
    }
}