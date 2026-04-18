package com.redbus.testing.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage {
	@FindBy(css="[href='/hotels']")
	private WebElement hotels;

	public WebElement getHotels() {
		return hotels;
	}

	public void clickHotels() {
		getHotels().click();
	}
}
