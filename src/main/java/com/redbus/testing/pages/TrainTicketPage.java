package com.redbus.testing.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.redbus.testing.utilities.AllUtilityFunction;

public class TrainTicketPage {
	
	// Driver and utility
    private WebDriver driver;
    private AllUtilityFunction util;
	
	// Constructor
    public TrainTicketPage(WebDriver driver) {
        this.driver = driver;
        this.util = new AllUtilityFunction();
    }
    
	@FindBy(partialLinkText = "Order Food")
	private WebElement orderFoodLink;

	@FindBy(xpath = "//div[text()='From']")
    WebElement fromField;
	
	public WebElement getOrderFoodLink() {
		return orderFoodLink;
	}

	//ScrollIntoView Method
    public void scrollIntoView(WebDriver driver, WebElement element) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
	}
	
    //Clicking on FoodOrder Element
	public void clickOrderFoodLink() {
	    scrollIntoView(driver, fromField);
	    util.waitForClickable(driver, fromField, 45);
	    fromField.click();

	    scrollIntoView(driver, orderFoodLink);
	    util.waitForClickable(driver, orderFoodLink, 45);
	    orderFoodLink.click();
	}

	
	
}
