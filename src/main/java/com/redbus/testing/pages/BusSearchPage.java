package com.redbus.testing.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.redbus.testing.utilities.AllUtilityFunction;
import com.redbus.testing.utilities.Base;

public class BusSearchPage {

	AllUtilityFunction util;
	WebDriver driver;

	// Constructor
	public BusSearchPage(WebDriver driver) {
		this.driver = driver;
		this.util = new AllUtilityFunction();
	}

	// From input field
	@FindBy(id = "srcinput")
	private WebElement from;

	// Suggestion dropdown
	@FindBy(css = "[style=\"top: 5.5rem; left: 0px;\"]")
	private WebElement suggestion;

	// Destination input field
	@FindBy(id = "destinput")
	private WebElement destination;

	// Swap button
	@FindBy(css = "[src=\"/rpwassets/public/images/swap.svg\"]")
	private WebElement swapSourceDest;

	// Date element
	@FindBy(xpath = "//span[text()='30']")
	private WebElement date;

	// Date picker
	@FindBy(xpath = "//span[text()='Date of Journey']/../..")
	private WebElement datePicker;

	// Women booking checkbox
	@FindBy(css = "[type='checkbox']")
	private WebElement bookForWomen;

	// Search button
	@FindBy(xpath = "//button[contains(text(),'Search')]")
	private WebElement searchBuses;

	// Bookings tab
	@FindBy(linkText = "Bookings")
	private WebElement bookings;

	// Train tickets option
	@FindBy(xpath = "//span[text()='Train tickets']")
	private WebElement trainTickets;

	// Hotels option
	@FindBy(xpath = "//span[text()='Hotels']")
	private WebElement hotels;

	// Book trains button
	@FindBy(xpath = "//button[text()='Book trains now']")
	private WebElement bookTrainsNow;

	// Tomorrow button
	@FindBy(xpath = "//button[text()='Tomorrow']")
	private WebElement tomorrow;

	// Today button
	@FindBy(xpath = "//button[text()='Today']")
	private WebElement today;

	// Bus list
	@FindBy(xpath = "//ul[@data-autoid='exact']//li")
	private List<WebElement> verifyBusList;

	// Validation message
	@FindBy(xpath = "//div[text()='Please enter source and destination']")
	private WebElement validationMessage;

	// Error message
	@FindBy(xpath = "//div[text()='Source and Destination city cannot be same']")
	private WebElement errormessage;

	// Get from field
	public WebElement getFrom() {
		return from;
	}

	// Enter invalid input
	public void enterInvalid(String source) throws InterruptedException {
		getFrom().sendKeys(source);
	}

	// Enter source with suggestion select
	public void enterFrom(String source) throws InterruptedException {
		getFrom().sendKeys(source);
		Thread.sleep(2000);
		getFrom().sendKeys(Keys.DOWN);
		getFrom().sendKeys(Keys.ENTER);
	}

	// Get destination field
	public WebElement getDestination() {
		return destination;
	}

	// Enter destination with suggestion select
	public void enterDestination(String dest) throws InterruptedException {
		getDestination().sendKeys(dest);
		Thread.sleep(2000);
		getDestination().sendKeys(Keys.DOWN);
		getDestination().sendKeys(Keys.ENTER);
	}

	// Get swap button
	public WebElement getSwapSourceDest() {
		return swapSourceDest;
	}

	// Click swap
	public void clickSwapSourceDest() {
		getSwapSourceDest().click();
	}

	// Get date picker
	public WebElement getDatePicker() {
		return datePicker;
	}

	// Click date picker
	public void clickDatePicker() {
		getDatePicker().click();
	}

	// Get women checkbox
	public WebElement getBookForWomen() {
		return bookForWomen;
	}

	// Click women checkbox
	public void clickBookForWomen() {
		getBookForWomen().click();
	}

	// Get search button
	public WebElement getSearchBuses() {
		return searchBuses;
	}

	// Click search
	public void clickSearch() {
		getSearchBuses().click();
	}

	// Get bookings
	public WebElement getBookings() {
		return bookings;
	}

	// Click bookings
	public void clickBookings() {
		getBookings().click();
	}

	// Get train tickets
	public WebElement getTrainTickets() {
		return trainTickets;
	}

	// Click train tickets
	public void clickTrainTickets() {
		getTrainTickets().click();
	}

	// Select date dynamically
	public void selectDate(String month, String day) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement monthElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(@class,'monthYear')]")));

		while (!monthElement.getText().contains(month)) {

			driver.findElement(By.xpath("//i[contains(@aria-label,'Next month')]")).click();

			monthElement = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(@class,'monthYear')]")));
		}

		WebElement date = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='" + day + "']")));

		date.click();
	}

	// Get hotels
	public WebElement getHotels() {
		return hotels;
	}

	// Click hotels
	public void clickHotels() {
		getHotels().click();
	}

	// Get book trains
	public WebElement getBookTrainsNow() {
		return bookTrainsNow;
	}

	// Click book trains
	public void clickBookTrainsNow() {
		getBookTrainsNow().click();
	}

	// Get tomorrow
	public WebElement getTomorrow() {
		return tomorrow;
	}

	// Click tomorrow
	public void clickTomorrow() {
		getTomorrow().click();
	}

	// Get today
	public WebElement getToday() {
		return today;
	}

	// Click today
	public void clickToday() {
		getToday().click();
	}

	// Get date
	public WebElement getDate() {
		return date;
	}

	// Click date
	public void clickDate() {
		util.waitForElementClickable(driver, date, 10);
		getDate().click();
	}

	// Verify bus list present
	public boolean verifyBusList() {

		List<WebElement> buses = driver.findElements(By.xpath("//ul[@data-autoid='exact']//li"));

		return buses.size() > 0;
	}

	// Get number of buses
	public int getNumberOfBus() {

		List<WebElement> buses = driver.findElements(By.xpath("//ul[@data-autoid='exact']//li"));

		return buses.size();
	}

	// Get validation message
	public String getValidationMessage() {
		return validationMessage.getText();
	}

	// Get error message
	public String getErrorMessage() {
		return errormessage.getText();
	}
}