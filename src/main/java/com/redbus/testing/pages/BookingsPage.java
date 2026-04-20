package com.redbus.testing.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingsPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public BookingsPage(WebDriver driver) {
		
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        PageFactory.initElements(driver, this);
	    }
	
		@FindBy(xpath="//div[text()='Bookings']")
		private WebElement bookimgs;
		
		@FindBy(xpath="//span[text()='Login Now']")
		private WebElement loginNow;
		
		@FindBy(id="mobileNoInp")
		private WebElement mobileNo;
		
		@FindBy(xpath="//div[@class='recaptcha-checkbox-border']")
		private WebElement captcha;
		
		
		
		@FindBy(css="[class='f-w-b']")
		private WebElement otp;
		
		@FindBy(css="[id='verifyUser']")
		private WebElement verify;
		
		@FindBy(xpath="//p[@class='Pro']")
		private WebElement profile;
		
		@FindBy(id="Editbtn")
		private WebElement edit;
		
		@FindBy(css="[placeholder='YOUR NAME']")
		private WebElement name;
		
		@FindBy(css="[id='profile-DOB']")
		private WebElement DOB;
		
		@FindBy(css="[id='female']")
		private WebElement gender;
		
		@FindBy(xpath="//input[@placeholder='EMAIL ID']")
		private WebElement email;
		
		@FindBy(css="[id='Savebtn']")
		private WebElement save;
		
		
		
		public void clickBookings() {
	        wait.until(ExpectedConditions.elementToBeClickable(bookimgs)).click();
	    }

	  
	    public void clickLoginNow() {
	        wait.until(ExpectedConditions.elementToBeClickable(loginNow)).click();
	    }

	    public void enterMobile(String number) {
	        wait.until(ExpectedConditions.visibilityOf(mobileNo));
	        mobileNo.clear();
	        mobileNo.sendKeys(number);
	    }

	    public void clickCaptcha() {
	        try {
	            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
	                    By.xpath("//iframe[contains(@title,'reCAPTCHA')]")));

	            WebElement checkbox = wait.until(
	                    ExpectedConditions.elementToBeClickable(
	                            By.cssSelector(".recaptcha-checkbox-border")));

	            checkbox.click();

	            driver.switchTo().defaultContent();

	        } catch (Exception e) {
	            System.out.println("Captcha handling failed");
	        }
	    }

	  
	    public void clickGenerateOtp() {
	    	wait.until(ExpectedConditions.visibilityOf(otp));
	        wait.until(ExpectedConditions.elementToBeClickable(otp)).click();
	    }

	    public void clickVerify() {
	        System.out.println("Enter OTP manually...");
	        wait.until(ExpectedConditions.elementToBeClickable(verify)).click();
	    }

	    public void clickProfile() {
	        wait.until(ExpectedConditions.elementToBeClickable(profile)).click();
	    }

	    public void clickEdit() {
	        wait.until(ExpectedConditions.elementToBeClickable(edit)).click();
	    }

	    public void enterName(String username) {
	        wait.until(ExpectedConditions.visibilityOf(name));
	        name.clear();
	        name.sendKeys(username);
	    }

	    public void selectDOB(String day) {
	        wait.until(ExpectedConditions.elementToBeClickable(DOB)).click();

	        String xpath = "//button[not(@disabled) and text()='" + day + "']";
	        WebElement date = wait.until(
	                ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

	        date.click();
	    }

	    public void selectGender() {
	        wait.until(ExpectedConditions.elementToBeClickable(gender)).click();
	    }

	    public void enterEmail(String mail) {
	        wait.until(ExpectedConditions.visibilityOf(email));
	        email.clear();
	        email.sendKeys(mail);
	    }

	    public void clickSave() {
	        wait.until(ExpectedConditions.elementToBeClickable(save)).click();
	    }
	}
		
		
	
	

