package com.redbus.testing.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
	        PageFactory.initElements(driver, this);
	    }
	
	
	
	@FindBy(xpath="//div[text()='Help']")
	private WebElement help;
	
	@FindBy(xpath="//div[contains(@class,'faq') or contains(.,'Bus FAQ')]")
	private WebElement bus;
	
	@FindBy(xpath="//div[text()='Bus Cancellation']")
	private WebElement cancel;
	
	@FindBy(xpath="//div[@class='listItemsBoldText lighten overFlow']")
	private WebElement query;
	
	

	public void clickHelp() {
	    wait.until(ExpectedConditions.elementToBeClickable(help)).click();

	    // Wait for iframe to appear
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("iframe")));

	    // Switch to iframe (usually only one)
	    driver.switchTo().frame(0);
	}

	public void clickBusFAQ() {

	    By busFaq = By.xpath("//div[normalize-space()='Bus FAQ']");

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	    // Step 1: locate element dynamically
	    for (int i = 0; i < 8; i++) {

	        try {
	            WebElement el = driver.findElement(busFaq);

	            if (el.isDisplayed()) {
	                wait.until(ExpectedConditions.elementToBeClickable(el)).click();
	                return;
	            }

	        } catch (Exception e) {

	            // Step 2: scroll INSIDE left Help panel
	            ((JavascriptExecutor) driver).executeScript(
	                "document.querySelectorAll('div').forEach(e => {" +
	                "if(e.scrollHeight > e.clientHeight) e.scrollTop += 200;" +
	                "});"
	            );
	        }
	    }

	    throw new RuntimeException("Bus FAQ not found in Help panel");
	}
	public void clickBusCancellation() {
	    wait.until(ExpectedConditions.elementToBeClickable(cancel)).click();
	}

	public void clickAnyQuery() {
	    wait.until(ExpectedConditions.elementToBeClickable(query)).click();
	}

	
//	public boolean isFAQPageDisplayed() {
//	    return wait.until(ExpectedConditions.visibilityOf(query)).isDisplayed();
//	}

	
	public String getFAQTitle() {
//	    return wait.until(ExpectedConditions.visibilityOf(query)).getText();
		  switchToHelpFrame();

		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		    WebElement el = wait.until(
		        ExpectedConditions.presenceOfElementLocated(
//		            By.xpath("//div[contains(@class,'listItemsBoldText') and contains(@class,'overFlow')]")
		        		By.xpath("//div[contains(@class,'faq') or contains(text(),'Cancellation')]")
		        )
		    );

		    ((JavascriptExecutor) driver)
		        .executeScript("arguments[0].scrollIntoView(true);", el);

		    return el.getText();
		}
	public void switchToHelpFrame() {
	    driver.switchTo().defaultContent();

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
	}
	
	
	
}
