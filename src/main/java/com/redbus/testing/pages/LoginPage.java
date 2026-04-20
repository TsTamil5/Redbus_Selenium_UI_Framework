package com.redbus.testing.pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); 
    }
    @FindBy(xpath="//button[@aria-label='Account']")
	private WebElement Accounts;
	
	@FindBy(xpath="//button[text()='Log in']")
	private WebElement LogIn;
	
	@FindBy(xpath="//input[@type='tel']")
	private WebElement Mobileno;
	
	@FindBy(css="[class='recaptcha-checkbox-border']")
	private WebElement captcha;
	
	
	@FindBy(xpath="//button[contains(text(),'Continue')]")
	private WebElement Continue;
	
	@FindBy(xpath = "//button[text()='Login with OTP']")
	private WebElement loginWithOtp;
	
	@FindBy(xpath="//button[text()='Verify OTP']")
	private WebElement verifyOtp;

	
	
	
	  public void clickAccounts() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        wait.until(ExpectedConditions.elementToBeClickable(Accounts)).click();
	    }
	
	 public void clickLogin() {
	        WebElement loginBtn = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(LogIn));
	        loginBtn.click();
	 }
	 
	 public void enterMobile(String number) {
	        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(Mobileno));

	        Mobileno.sendKeys(number);
	        
	  }
	 public void handleCaptcha() {

		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		    try {
		        
		        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
		                By.xpath("//iframe[contains(@title,'reCAPTCHA')]")));

		        
		        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(
		                By.cssSelector(".recaptcha-checkbox-border")));

		        checkbox.click();

		      
		        driver.switchTo().defaultContent();

		        System.out.println("Captcha clicked");

		    } catch (Exception e) {
		        System.out.println("Captcha not handled");
		    }
		    
		}
	 
	 
	 public void clickContinue() {
	        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(Continue)).click();
	 }
	 
	 public void clickVerifyOtp() throws InterruptedException {
		 Thread.sleep(30000);

		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		    wait.until(ExpectedConditions.elementToBeClickable(verifyOtp)).click();
		    
		    
		}
	
	 public void handleSecurityPopup() {

		    try {
		        Thread.sleep(10000); 

		        Robot robot = new Robot();

		        typeNumber(robot, KeyEvent.VK_2);
		        typeNumber(robot, KeyEvent.VK_0);
		        typeNumber(robot, KeyEvent.VK_0);
		        typeNumber(robot, KeyEvent.VK_3);

		        robot.keyPress(KeyEvent.VK_ENTER);
		        robot.keyRelease(KeyEvent.VK_ENTER);

		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}

	 private void typeNumber(Robot robot, int keyEvent) throws InterruptedException {
		    robot.keyPress(keyEvent);
		    robot.keyRelease(keyEvent);
		    Thread.sleep(500); 
		}

}