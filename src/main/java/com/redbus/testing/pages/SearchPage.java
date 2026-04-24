package com.redbus.testing.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.redbus.testing.utilities.Base;

public class SearchPage {
	WebDriver driver;
	WebDriverWait wait;
	

	public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
	
	
	@FindBy(xpath="//div[text()='Search ticket']")
	private WebElement search;
	
	@FindBy(id="searchTicketTIN")
	private WebElement ticket;
	
	@FindBy(name="mobileno")
	private WebElement phone;
	
	@FindBy(id="ticketSearch")
	private WebElement searchBtn;
	
	@FindBy(partialLinkText = "CHAT")
	private WebElement redBuddy;
	
	@FindBy(xpath = "//span[contains(text(),'Ticket Number')]")
	private WebElement ticketNumberLabel;
	
	@FindBy(xpath = "//*[contains(text(),'RedBuddy') or contains(text(),'chat')]")
	private WebElement helpText;
	
	// Method to click on Search Ticket option
	public void clickSearchTicket() {
	    wait.until(ExpectedConditions.elementToBeClickable(search)).click();
	}
	
	// Method to enter mobile number
	public void enterTicketNumber(String ticketNo) {
	    wait.until(ExpectedConditions.visibilityOf(ticket));
	    ticket.clear();
	    ticket.sendKeys(ticketNo);
	}
	
	
	public void enterMobileNumber(String mobileNo) throws InterruptedException {
	    wait.until(ExpectedConditions.visibilityOf(phone));
	    phone.clear();
	    Thread.sleep(2000);
	    phone.sendKeys(mobileNo);
	    Thread.sleep(2000);
	    
	}
	
	
	// Method to click Search button and wait for result page
	public void clickSearchButton() {
	    wait.until(ExpectedConditions.elementToBeClickable(searchBtn)).click();

	    new WebDriverWait(driver, Duration.ofSeconds(30))
	        .until(d -> !d.getCurrentUrl().equals("https://www.redbus.in") 
	                 || d.getPageSource().contains("TV4H")
	                 || d.getPageSource().contains("No booking"));
	}
	
	
	// Method to extract ticket number from page source
	public String getTicketNumber() {
	    try {
	        new WebDriverWait(driver, Duration.ofSeconds(30))
	            .until(d -> d.getPageSource().contains("TV4H"));

	        String source = driver.getPageSource();
	        int bStart = source.indexOf("<b>TV4H");
	        int bEnd = source.indexOf("</b>", bStart);

	        String ticketNumber = source.substring(bStart + 3, bEnd).trim();
	        System.out.println("Ticket Number: " + ticketNumber);
	        return ticketNumber;

	    } catch (Exception e) {
	        System.out.println("Ticket number not found: " + e.getMessage());
	        return "";
	    }
	}
	
	// Method to verify if ticket page is displayed
	public boolean isTicketPageDisplayed() {
	    try {
	        new WebDriverWait(driver, Duration.ofSeconds(30))
	            .until(d -> d.getPageSource().contains("TV4H"));
	        return true;
	    } catch (Exception e) {
	        System.out.println("Ticket page never loaded: " + e.getMessage());
	        return false;
	    }
	}
	
	// Method to click RedBuddy chat
	public void clickRedBuddyChat() {
	    wait.until(ExpectedConditions.elementToBeClickable(redBuddy)).click();
	}
	
	// Method to switch to newly opened browser tab
	public void switchToNewTab() {

	    String parent = driver.getWindowHandle();
	    
	 // Loop through all open windows
	    for (String handle : driver.getWindowHandles()) {
	    	 // Switch to the new window (not parent)
	        if (!handle.equals(parent)) {
	            driver.switchTo().window(handle);
	            break;
	        }
	    }
	}
	
	// Method to verify if help/chat window is opened
	public boolean ishelpOpened() {
	    try {
	        wait.until(ExpectedConditions.visibilityOf(helpText));
	        return helpText.isDisplayed();
	    } catch (Exception e) {
	        return false;
	    }
	}

}
