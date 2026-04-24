package com.redbus.testing.pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BusBoardDropPointPage {

	WebDriver driver;
	WebDriverWait wait;

	// Constructor
	public BusBoardDropPointPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Boarding points list
	@FindBy(xpath = "//div[@aria-label='Boarding points']//div[contains(@class,'bpdpSelection')]")
	private List<WebElement> boardingPoints;

	// Dropping points list
	@FindBy(xpath = "//div[@aria-label='Dropping points']//div[contains(@class,'bpdpSelection')]")
	private List<WebElement> droppingPoints;

	// Continue button
	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	private WebElement continueBtn;

	// Passenger page header
	@FindBy(xpath = "//h3[contains(text(),'Contact details')]")
	private WebElement passengerHeader;

	// Select boarding point
	public void selectBoardingPoint(String name) {
		for (WebElement point : boardingPoints) {
			if (point.getText().contains(name)) {
				point.click();
				break;
			}
		}
	}

	// Select dropping point
	public void selectDroppingPoint(String name) {
		for (WebElement point : droppingPoints) {
			if (point.getText().contains(name)) {
				point.click();
				break;
			}
		}
	}

	// Click continue
	public void clickNavigateToPassengerInfo() {
		continueBtn.click();
	}

	// Get header text
	public String getVerifyPassngerInfoPage() {
		return passengerHeader.getText();
	}
}