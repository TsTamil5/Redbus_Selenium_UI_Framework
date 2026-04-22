package com.redbus.testing.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage {

	// Locate Hotels menu using CSS selector
	@FindBy(css = "[href='/hotels']")
	private WebElement hotels;

	// Return Hotels web element
	public WebElement getHotels() {
		return hotels;
	}

	// Click on Hotels menu
	public void clickHotels() {
		getHotels().click();
	}
}