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
	        PageFactory.initElements(driver, this);
	    }
	
	
	
	@FindBy(xpath="//div[text()='Help']")
	private WebElement help;
	
	@FindBy(xpath="//div[contains(text(),'Bus FAQ')]")
	private WebElement bus;
	
	@FindBy(xpath="//div[text()='Bus Cancellation']")
	private WebElement cancel;
	
	@FindBy(xpath="//div[@class='listItemsBoldText lighten overFlow']")
	private WebElement query;
	
	

	public void clickHelp() {
	    wait.until(ExpectedConditions.elementToBeClickable(help)).click();

	    // Wait for any Help content to appear
	    wait.until(ExpectedConditions.presenceOfElementLocated(
	        By.xpath("//*[contains(text(),'FAQ')]")
	    ));
	}

	public void clickBusFAQ() {

	    WebElement busFaq = wait.until(ExpectedConditions.visibilityOfElementLocated(
	        By.xpath("(//*[contains(text(),'Bus') and contains(text(),'FAQ')])[last()]")
	    ));

	    busFaq.click();
	}

	
	public void clickBusCancellation() {
	    wait.until(ExpectedConditions.elementToBeClickable(cancel)).click();
	}

	public void clickAnyQuery() {
	    wait.until(ExpectedConditions.elementToBeClickable(query)).click();
	}

	
	public boolean isFAQPageDisplayed() {
	    return wait.until(ExpectedConditions.visibilityOf(query)).isDisplayed();
	}

	
	public String getFAQTitle() {
	    return wait.until(ExpectedConditions.visibilityOf(query)).getText();
	}
	
	
}
