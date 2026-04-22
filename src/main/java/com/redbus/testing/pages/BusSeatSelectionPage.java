package com.redbus.testing.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BusSeatSelectionPage {

	WebDriver driver;
	WebDriverWait wait;

	// Constructor
	public BusSeatSelectionPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}

	// All available seats
	@FindBy(xpath = "//span[contains(@aria-label,'Seat number') and contains(@aria-label,'available')]")
	private List<WebElement> seats;

	// Lower deck seat
	@FindBy(xpath = "//h3[@id='lower-deck-heading']/following::span[contains(@aria-label,'available')][2]")
	private WebElement lowerDeckSeat;

	// Upper deck seat
	@FindBy(xpath = "//h3[@id='upper-deck-heading']/following::span[contains(@aria-label,'available')][3]")
	private WebElement upperDeckSeat;

	// Proceed button
	@FindBy(xpath = "//button[contains(text(),'Select boarding & dropping points')]")
	private WebElement proceedButton;

	// Boarding text
	@FindBy(xpath = "//div[text()='Boarding points']")
	private WebElement boardingText;

	// Click lower deck seat
	public void clickLowerDeckSeat() {
		wait.until(ExpectedConditions.elementToBeClickable(lowerDeckSeat)).click();
	}

	// Select general seat
	public void selectGeneralSeat() {
		for (WebElement seat : seats) {
			String label = seat.getAttribute("aria-label").toLowerCase();
			if (label.contains("available") && !label.contains("female") && !label.contains("male")) {
				seat.click();
				break;
			}
		}
	}

	// Click upper deck seat
	public void clickUpperDeckSeat() {
		wait.until(ExpectedConditions.elementToBeClickable(upperDeckSeat)).click();
	}

	// Select any available seat
	public void selectAnyAvailableSeat() {
		try {
			clickLowerDeckSeat();
		} catch (Exception e) {
			clickUpperDeckSeat();
		}
	}

	// Click proceed
	public void clickProceedButton() {
		wait.until(ExpectedConditions.elementToBeClickable(proceedButton)).click();
	}

	// Verify boarding page
	public String verifyBoardingPoint() {
		wait.until(ExpectedConditions.visibilityOf(boardingText));
		return boardingText.getText();
	}
}