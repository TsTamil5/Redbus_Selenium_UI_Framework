package com.redbus.testing.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BusSelectionPage{

    private WebDriver driver;

    public BusSelectionPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = "[href=\"/travels/flixbus\"]")
    private WebElement flixBus;

    @FindBy(xpath = "(//button[text()='Book now'])[1]")
    private WebElement bookNow;

    @FindBy(xpath = "(//button[text()='View seats'])[1]")
    private WebElement viewSeats;


    public WebElement getFlixBus() {
        return flixBus;
    }

    public WebElement getBookNow() {
        return bookNow;
    }

    public WebElement getViewSeats() {
        return viewSeats;
    }

    public void clickFlixBus() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    WebElement element = wait.until(
	        ExpectedConditions.visibilityOf(flixBus)
	    );

	    // scroll into view
	    ((JavascriptExecutor) driver)
	        .executeScript("arguments[0].scrollIntoView(true);", element);

	    // wait again for clickable
	    wait.until(ExpectedConditions.elementToBeClickable(element));

	    element.click();
	}

    public void clickBookNow() {
        bookNow.click();
    }

    public void clickViewSeats() {
        viewSeats.click();
    }
}