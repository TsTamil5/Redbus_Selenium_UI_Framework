package com.redbus.testing.pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
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

import com.redbus.testing.utilities.Pages;

public class LoginPage {
	WebDriver driver;
	WebDriverWait wait;
	

	public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

   
	  // Profile icon element (used to check login status)
    @FindBy(css="[class='optionIcon___4a6702 icon icon-account']")
    private WebElement profileImg;

    public WebElement getProfileImg() {
		return profileImg;
	}

	@FindBy(xpath="//button[@aria-label='Account']")
    private WebElement accountBtn;
	
//	@FindBy(xpath="//a[contains(@href,'myprofile')]")
//    private WebElement bookingsBtn;

    @FindBy(xpath="//li[@id='Profile']")
    private WebElement profileBtn;

    @FindBy(xpath="//span[@class='editMode']")
    private WebElement editBtn;

    @FindBy(xpath="//input[@placeholder='YOUR NAME']")
    private WebElement nameField;
    
    @FindBy(xpath="//input[@id='profile-DOB']")
    private WebElement DOB;
    
    @FindBy(xpath="//input[@type='radio' and @id='male']")
    private WebElement male;
    
    @FindBy(xpath="//input[@type='radio' and @id='female']")
    private WebElement female;
    
    

    @FindBy(xpath="//input[@placeholder='EMAIL ID']")
    private WebElement emailField;

    @FindBy(xpath="//input[@id='Savebtn']")
    private WebElement saveBtn;

	
	
    public void clickAccount() {
      	 new WebDriverWait(driver, Duration.ofSeconds(5))
           .until(ExpectedConditions.elementToBeClickable(accountBtn))
           .click();
      	
       }

       public void clickBookings() {

           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
           

           // Wait for bookings element to be present
           WebElement element = wait.until(
                   ExpectedConditions.presenceOfElementLocated(
                           By.xpath("//a[contains(@href,'myprofile')]")
                   )
           );
           

        // Try normal click, fallback to JS click
           try {
               element.click();
           } catch (Exception e) {
              
               ((JavascriptExecutor) driver)
                       .executeScript("arguments[0].click();", element);
           }
           // Store current tab
           String parent = driver.getWindowHandle();

           // Wait for new tab
           wait.until(driver -> driver.getWindowHandles().size() > 1);

           // Switch to new tab
           for (String window : driver.getWindowHandles()) {
               if (!window.equals(parent)) {
                   driver.switchTo().window(window);
                   break;
               }
           }

           System.out.println("Switched to new tab");

       }

       public void clickProfile() {

           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

           // Step 1: Ensure we are on bookings page
           wait.until(ExpectedConditions.urlContains("myprofile"));

//            Step 2: Wait for Profile tab to be visible
           WebElement profile = wait.until(
                   ExpectedConditions.visibilityOfElementLocated(By.id("Profile"))
           );

           // Step 3: Wait a bit for React to attach events
           try { Thread.sleep(1000); 
           } catch (Exception e) {}

           // Step 4: Click using Actions (better than normal click)
           Actions actions = new Actions(driver);
           actions.moveToElement(profile).click().perform();

           // Step 5: Ensure tab switched
           wait.until(ExpectedConditions.urlContains("profile"));

           System.out.println("Switched to Profile tab");
       }
       
       public void clickEdit() {

           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

           WebElement edit = wait.until(
                   ExpectedConditions.elementToBeClickable(editBtn)
           );

           edit.click();
       }
       
       // Get name from input field
       public String getDisplayedName() {
    	    try {
    	        return nameField.getText().trim();
    	    } catch (Exception e) {
    	        return "";
    	    }
    	}
       
       // Enter name
       public void enterName(String name) {
           nameField.clear();
           nameField.sendKeys(name);
       }
       
       //select gender
       public String getSelectedGender() {

    	    try {
    	        if (male.isSelected()) {
    	            return "male";
    	        } else if (female.isSelected()) {
    	            return "female";
    	        } else {
    	            return "";
    	        }
    	    } catch (Exception e) {
    	        return "";
    	    }
    	}
       
       //select gender based on the input
       public void selectGender(String gender) {

           if (gender.equalsIgnoreCase("male")) {
               male.click();
           } else if (gender.equalsIgnoreCase("female")) {
               female.click();
           }
       }
       
    // Get email value
       public String getDisplayedEmail() {
   	    try {
   	        return emailField.getText().trim();
   	    } catch (Exception e) {
   	        return "";
   	    }
   	}

       public void enterEmail(String email) {
           emailField.clear();
           emailField.sendKeys(email);
       }

       public void clickSave() {
           saveBtn.click();
       }
       
    // Check if user is logged in via bookings link
       public boolean isLoggedIn() {
           return driver.findElements(
                   By.xpath("//a[contains(@href,'myprofile')]")
           ).size() > 0;
       }
       
    // Verify success message after profile update
       public boolean isProfileUpdatedSuccessfully() {
           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
           try {
               WebElement successBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(
                       By.xpath("//*[contains(text(),'Profile details updated successfully')]")
               ));
               System.out.println(" Banner: " + successBanner.getText());
               return successBanner.isDisplayed();
           } catch (Exception e) {
               System.out.println("Success banner not found");
               return false;
           }
       }
     
       // Check login using profile image visibility
    public boolean isUserLoggedIn() {
   	    try {
   	        // Use a 5-10 second wait instead of immediate check
   	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   	        return wait.until(ExpectedConditions.visibilityOf(getProfileImg())).isDisplayed();
   	    } catch (Exception e) {
   	        System.out.println(" Profile image not found - user not logged in.");
   	        return false;
   	    }
   	}

    

   }