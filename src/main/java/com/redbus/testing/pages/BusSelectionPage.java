package com.redbus.testing.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.redbus.testing.utilities.AllUtilityFunction;

public class BusSelectionPage {

	private WebDriver driver;
	AllUtilityFunction util = new AllUtilityFunction();

	// Constructor
	public BusSelectionPage(WebDriver driver) {
		this.driver = driver;
	}

	// FlixBus option
	@FindBy(css = "[href=\"/travels/flixbus\"]")
	private WebElement flixBus;

	// Book now button
	@FindBy(xpath = "(//button[text()='Book now'])[1]")
	private WebElement bookNow;

	// View seats button
	@FindBy(xpath = "(//button[text()='View seats'])[1]")
	private WebElement viewSeats;

	// Get FlixBus
	public WebElement getFlixBus() {
		return flixBus;
	}

	// Get book now
	public WebElement getBookNow() {
		return bookNow;
	}

	// Get view seats
	public WebElement getViewSeats() {
		return viewSeats;
	}

	// Click FlixBus
	public void clickFlixBus() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		WebElement element = wait.until(ExpectedConditions.visibilityOf(flixBus));

		// Scroll to element
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

		// Wait until clickable
		wait.until(ExpectedConditions.elementToBeClickable(element));

		element.click();
	}

	// Click book now
	public void clickBookNow() {
		bookNow.click();
	}

	// Click view seats
	public void clickViewSeats() {
		util.waitForElementClickable(driver, viewSeats, 30);
		viewSeats.click();
	}
}