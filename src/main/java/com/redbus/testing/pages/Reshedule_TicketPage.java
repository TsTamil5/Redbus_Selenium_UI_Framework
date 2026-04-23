package com.redbus.testing.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Reshedule_TicketPage {
	
	WebDriver driver;
	WebDriverWait wait;

	public Reshedule_TicketPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
	
//	@FindBy(xpath="//div[text()='Reschedule ticket']")
//	private WebElement reshedule;
//	
//	@FindBy(css="[id='searchTicket']")
//	private WebElement ticketno;
	
//	@FindBy(css="[id='searchPhone']")
//	private WebElement phoneno;
	
//	@FindBy(id="ticketSearch")
//	private WebElement search;
	
	
	 // Method to click on "Reschedule Ticket" option
	public void clickRescheduleTicket() {
		
		  // Locator for Reschedule option (using partial text match)
	    By reschedule = By.xpath("//*[contains(text(),'Reschedule')]");
	    wait.until(ExpectedConditions.elementToBeClickable(reschedule)).click();
	}

	// Method to enter ticket number
	public void enterTicketNumber(String ticket) {

	    By ticketInput = By.xpath("//input[@id='searchTicket']");
	    
	 // Wait until input field is present in DOM
	    WebElement el = wait.until(
	            ExpectedConditions.presenceOfElementLocated(ticketInput)
	    );
	    
	 // Using Actions class to interact with element
	    Actions actions = new Actions(driver);

	    actions.moveToElement(el)
	           .click()
	           .doubleClick()  
	           .sendKeys(ticket)
	           .perform();
	}
	

	 // Method to enter mobile number
	public void enterMobileNumber(String mobile) {

	    By mobileInput = By.xpath("//input[@id='searchPhone' or @class='dbPhone']");

	    WebElement el = wait.until(
	            ExpectedConditions.presenceOfElementLocated(mobileInput)
	    );

	    Actions actions = new Actions(driver);

	    actions.moveToElement(el)
	           .click()
	           .doubleClick()
	           .sendKeys(mobile)
	           .perform();
	}
	
	// Method to click on Search button
	public void clickSearch() {
	    By searchBtn = By.xpath("//input[@class='search_btn' or @type='submit']");
	    wait.until(ExpectedConditions.elementToBeClickable(searchBtn)).click();
	}
	
	

}
