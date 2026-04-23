package com.redbus.testing.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelpPage {
	WebDriver driver;
	WebDriverWait wait;

	public HelpPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
	
	@FindBy(xpath="//div[text()='Help']")
	private WebElement help;
	
//	@FindBy(xpath="//div[contains(@class,'faq') or contains(.,'Bus FAQ')]")
//	private WebElement bus;
	
	@FindBy(xpath="//div[text()='Bus Cancellation']")
	private WebElement cancel;
	
	@FindBy(xpath="//div[@class='listItemsBoldText lighten overFlow']")
	private WebElement query;
	
	
	 // Method to click Help and switch to iframe
	public void clickHelp() {
		
		 // Wait until Help button is clickable and click it
	    wait.until(ExpectedConditions.elementToBeClickable(help)).click();
	    
	    // Wait until iframe is present in DOM
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("iframe")));
	    
	 // Switch to first iframe (index 0)
	   
	    driver.switchTo().frame(0);
	}

	 // Method to click "Bus FAQ" with scroll handling
	public void clickBusFAQ() {

		By busFaq = By.xpath("//div[normalize-space()='Bus FAQ']");

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	 // Loop to attempt finding element with scrolling
	    for (int i = 0; i < 8; i++) {

	        try {
	            WebElement el = driver.findElement(busFaq);
	            
	         // If displayed, click it
	            if (el.isDisplayed()) {
	                wait.until(ExpectedConditions.elementToBeClickable(el)).click();
	                return;
	            }

	        } catch (Exception e) {

	        	// If not found, scroll inside all scrollable divs using JavaScript
	            ((JavascriptExecutor) driver).executeScript(
	                "document.querySelectorAll('div').forEach(e => {" +
	                "if(e.scrollHeight > e.clientHeight) e.scrollTop += 200;" +
	                "});"
	            );
	        }
	    }
	    
	 // Throw exception if element not found after attempts
	    throw new RuntimeException("Bus FAQ not found in Help panel");
	}
	
	
	// Method to click "Bus Cancellation" option
	
	public void clickBusCancellation() {
	    wait.until(ExpectedConditions.elementToBeClickable(cancel)).click();
	}
	
	// Method to click any FAQ query
	public void clickAnyQuery() {
	    wait.until(ExpectedConditions.elementToBeClickable(query)).click();
	}

	 // Method to get FAQ title text
	public String getFAQTitle() {
		
		// Ensure switching to correct iframe
		  switchToHelpFrame();

		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		    
		 // Wait for FAQ element containing class or text 'Cancellation'
		    WebElement el = wait.until(
		        ExpectedConditions.presenceOfElementLocated(

		        		By.xpath("//div[contains(@class,'faq') or contains(text(),'Cancellation')]")
		        )
		    );
		 // Scroll element into view using JavaScript

		    ((JavascriptExecutor) driver)
		        .executeScript("arguments[0].scrollIntoView(true);", el);

		 // Return the text of the FAQ element
		    return el.getText();
		}
	
	  // Method to switch to Help iframe safely
	public void switchToHelpFrame() {
		
		// Switch back to main page
	    driver.switchTo().defaultContent();

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
	}
	
	
	
}
