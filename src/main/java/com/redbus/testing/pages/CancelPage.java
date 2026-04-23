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

public class CancelPage {
	
	WebDriver driver;
	WebDriverWait wait;
	

	public CancelPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
	
		/** WebElement for the 'Cancel Ticket' button. */
		@FindBy(xpath="//div[text()='Cancel Ticket']")
		private WebElement cancel;
		
		/** WebElement for the ticket number input field. */
		@FindBy(css="[name='tin']")
		private WebElement ticket;
		
		/** WebElement for the mobile number input field. */
		@FindBy(css="[name='mobileno']")
		private WebElement mobile;
		
		/** WebElement for the 'Select Passengers' button. */
		@FindBy(xpath="//div[text()='Select Passengers']")
		private WebElement passengers;
		
		
		
		/**
		 * Clicks on the 'Cancel Ticket' button after waiting for it to be clickable.
		 */
		public void clickCancelTicket() {
		    wait.until(ExpectedConditions.elementToBeClickable(cancel)).click();
		}
		
		/**
		 * Enters the ticket number into the ticket input field.
		 * @param ticketNo The ticket number to enter.
		 */
		public void enterTicketNumber(String ticketNo) {

		    WebElement el = wait.until(
		            ExpectedConditions.visibilityOf(ticket)
		    );

		    el.clear();
		    el.sendKeys(ticketNo);
		}
		
		/**
		 * Enters the mobile number into the mobile input field.
		 * @param mobileNo The mobile number to enter.
		 */
		public void enterMobileNumber(String mobileNo) {

		    WebElement el = wait.until(
		            ExpectedConditions.visibilityOf(mobile)
		    );

		    el.clear();
		    el.sendKeys(mobileNo);
		}
		
		/**
		 * Clicks on the 'Select Passengers' button after waiting for it to be clickable.
		 */
		public void clickSelectPassengers() {
		    wait.until(ExpectedConditions.elementToBeClickable(passengers)).click();
		}
		
		/**
		 * Retrieves the error message displayed on the cancel page.
		 * @return The trimmed text of the error message element.
		 */
		public String getCancelErrorMessage() {

		    By msg = By.xpath("//*[contains(text(),'cancel') or contains(text(),'cannot') or contains(text(),'Please enter')]");

		    WebElement el = wait.until(
		            ExpectedConditions.visibilityOfElementLocated(msg)
		    );

		    return el.getText().trim();
		}
}
