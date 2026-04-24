package com.redbus.testing.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OffersPage {
	WebDriver driver;
	WebDriverWait wait;

	public OffersPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
	
	@FindBy(xpath="//div[contains(text(),'Offers')]")
	private WebElement offers;
	
	@FindBy(xpath="//span[@data-value=\"Use code FIRST\"]")
	private WebElement first;
	
	
	   // Method to click on Offers button
	public void clickOffers() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    WebElement offerBtn = wait.until(
	        ExpectedConditions.elementToBeClickable(
	            By.xpath("//div[text()='Offers']")
	        )
	    );

	    offerBtn.click();
	}
	
	// Method to verify if Offers page is displayed
	public boolean isOffersPageDisplayed() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    
	    // Wait until URL or Title contains "offer"
	    return wait.until(driver ->
	        driver.getCurrentUrl().toLowerCase().contains("offer")
	        || driver.getTitle().toLowerCase().contains("offer")
	    );
	}
	
	// Method to click on the first offer (Use code FIRST)
	public void clickFirstOffer() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    wait.until(ExpectedConditions.elementToBeClickable(first));

	    first.click();
	}
	
	 // Method to verify if offer popup/content is displayed
	public boolean isFirstOfferContentDisplayed() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    
	 // Wait for popup/dialogue to appear
	    WebElement popup = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(
	                By.xpath("//div[@id=\"offerTileDialogue\" or @class=\"modalpopup animated fadeIn\" or @class=\"dialogueHeader height-6em\"]")
	            )
	        );
	    
	 // Wait for content inside popup (multiple possible texts)
	    WebElement content = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//*[contains(text(),'Use code FIRST') or contains(text(),'Save up to Rs 250 on bus tickets') or contains(text(),'What is the Offer')]")
	        )
	    );

	    return content.isDisplayed();
	}
	  // Method to fetch offer content text
	public String getOfferContentText() {
		
		 // Find all elements containing Offer-related keywords
	    List<WebElement> content = driver.findElements(
	        By.xpath("//*[contains(text(),'Offer') or contains(text(),'Code') or contains(text(),'Valid')]")
	    );
	    
	 // If elements found, return first element's text
	    if (!content.isEmpty()) {
	        return content.get(0).getText();
	    } else {
	        return "No content found";
	    }
	}
}
