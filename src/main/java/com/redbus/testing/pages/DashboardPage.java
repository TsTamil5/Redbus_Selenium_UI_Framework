package com.redbus.testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.redbus.testing.utilities.AllUtilityFunction;

public class DashboardPage {
	 // Driver & utility
	 private WebDriver driver;
	 private AllUtilityFunction util;
	 
	// Constructor to initialize driver and utility
	 public DashboardPage(WebDriver driver) {
	        this.driver = driver;
	        this.util = new AllUtilityFunction();
	    }
	// Locate Hotels menu using CSS selector
	@FindBy(css = "[href='/hotels']")
	private WebElement hotels;
	
	@FindBy(partialLinkText = "Train tickets")
	private WebElement trainLink;
	
	// Return Hotels web element
		public WebElement getHotels() {
			return hotels;
		}

		// Click on Hotels menu
		public void clickHotels() {
			getHotels().click();
		}
		
		// Return Train link web element
		public WebElement getTrainLink() {
			return trainLink;
		}

		// Click on Train link
		public void clickTrainLink() {
			util.waitForClickable(driver, trainLink, 45);
			getTrainLink().click();
		}
}
