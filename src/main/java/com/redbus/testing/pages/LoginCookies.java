package com.redbus.testing.pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginCookies {
	WebDriver driver;
	WebDriverWait wait;

	public LoginCookies(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @FindBy(css="[class=\"optionIcon___0444a3 icon icon-account\"]")
    private WebElement profileImg;

    public WebElement getProfileImg() {
		return profileImg;
	}
    
    @FindBy(xpath="//button[@aria-label='Account']")
    private WebElement accountBtn;
    
    @FindBy(xpath="//button[text()='Log in']")
  private WebElement loginBtn;

    
  public void clickAccount() {
    new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.elementToBeClickable(accountBtn))
            .click();
}

public void clickLogin() {
    new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.elementToBeClickable(loginBtn))
            .click();
}


public boolean isUserLoggedIn() {
    try {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // safer check: profile icon OR account button state
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("[class*='account']")));

        return true;

    } catch (Exception e) {
        System.out.println("⚠️ User not logged in");
        return false;
    }
}


}
