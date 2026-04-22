package com.redbus.testing.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.RedBus.testing.utilities.AllUtilityFunction;
import com.RedBus.testing.utilities.Base;

public class BusSearchPage {

	AllUtilityFunction util;
	WebDriver driver;

	public BusSearchPage(WebDriver driver) {
		this.driver = Base.getDriver();
		this.util = new AllUtilityFunction();
	}

	@FindBy(id = "srcinput")
	private WebElement from;

	@FindBy(css = "[style=\"top: 5.5rem; left: 0px;\"]")
	private WebElement suggestion;

	@FindBy(id = "destinput")
	private WebElement destination;

	@FindBy(css = "[src=\"/rpwassets/public/images/swap.svg\"]")
	private WebElement swapSourceDest;

	@FindBy(xpath = "//span[text()='30']")
	private WebElement date;

	@FindBy(xpath = "//span[text()='Date of Journey']/../..")
	private WebElement datePicker;

	@FindBy(css = "[type='checkbox']")
	private WebElement bookForWomen;

	@FindBy(xpath = "//button[contains(text(),'Search')]")
	private WebElement searchBuses;

	@FindBy(linkText = "Bookings")
	private WebElement bookings;

	@FindBy(xpath = "//span[text()='Train tickets']")
	private WebElement trainTickets;

	@FindBy(xpath = "//span[text()='Hotels']")
	private WebElement hotels;

	@FindBy(xpath = "//button[text()='Book trains now']")
	private WebElement bookTrainsNow;

	@FindBy(xpath = "//button[text()='Tomorrow']")
	private WebElement tomorrow;

	@FindBy(xpath = "//button[text()='Today']")
	private WebElement today;

	@FindBy(xpath = "//ul[@data-autoid='exact']//li")
	private List<WebElement> verifyBusList;

	@FindBy(xpath = "//div[text()='Please enter source and destination']")
	private WebElement validationMessage;

	@FindBy(xpath = "//div[text()='Source and Destination city cannot be same']")
	private WebElement errormessage;

	public WebElement getFrom() {
		return from;
	}
	
	public void enterInvalid(String source) throws InterruptedException {
		getFrom().sendKeys(source);
	}

	public void enterFrom(String source) throws InterruptedException {
		getFrom().sendKeys(source);
		Thread.sleep(2000);
		getFrom().sendKeys(Keys.DOWN);
		getFrom().sendKeys(Keys.ENTER);

	}

	public WebElement getDestination() {
		return destination;
	}

	public void enterDestination(String dest) throws InterruptedException {
		getDestination().sendKeys(dest);
		Thread.sleep(2000);
		getDestination().sendKeys(Keys.DOWN);
		getDestination().sendKeys(Keys.ENTER);

	}

	public WebElement getSwapSourceDest() {
		return swapSourceDest;
	}

	public void clickSwapSourceDest() {
		getSwapSourceDest().click();
	}

	public WebElement getDatePicker() {
		return datePicker;
	}

	public void clickDatePicker() {
		getDatePicker().click();
	}

	public WebElement getBookForWomen() {
		return bookForWomen;
	}

	public void clickBookForWomen() {
		getBookForWomen().click();
	}

	public WebElement getSearchBuses() {
		return searchBuses;
	}

	public void clickSearch() {
		getSearchBuses().click();
	}

	public WebElement getBookings() {
		return bookings;
	}

	public void clickBookings() {
		getBookings().click();
	}

	public WebElement getTrainTickets() {
		return trainTickets;
	}

	public void clickTrainTickets() {
		getTrainTickets().click();
		;
	}

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

	public WebElement getHotels() {
		return hotels;
	}

	public void clickHotels() {
		getHotels().click();
	}

	public WebElement getBookTrainsNow() {
		return bookTrainsNow;
	}

	public void clickBookTrainsNow() {
		getBookTrainsNow().click();
	}

	public WebElement getTomorrow() {
		return tomorrow;
	}

	public void clickTomorrow() {
		getTomorrow().click();
	}

	public WebElement getToday() {
		return today;
	}

	public void clickToday() {
		getToday().click();
	}

	public WebElement getDate() {
		return date;
	}

	public void clickDate() {
		util.waitForElementClickable(driver, date, 10);
		getDate().click();
	}

	public boolean verifyBusList() {

		List<WebElement> buses = driver.findElements(By.xpath("//ul[@data-autoid='exact']//li"));

		return buses.size() > 0;
	}

	public int getNumberOfBus() {

		List<WebElement> buses = driver.findElements(By.xpath("//ul[@data-autoid='exact']//li"));

		return buses.size();
	}

	public String getValidationMessage() {

		return validationMessage.getText();
	}

	public String getErrorMessage() {

		return errormessage.getText();
	}

}
