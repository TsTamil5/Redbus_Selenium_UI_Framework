package com.redbus.testing.pages;
	import java.time.Duration;
	import org.openqa.selenium.*;
	import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
	public class TrainTicket {

	    WebDriver driver;
	    WebDriverWait wait;

	    public TrainTicket(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        PageFactory.initElements(driver, this);
	    }

	    // ================= LOCATORS =================

	    @FindBy(xpath = "//div[@id='date-picker-grid']")
	    WebElement datePicker;

	    @FindBy(xpath = "//div[text()='From']")
	    WebElement fromField;

	    @FindBy(xpath = "//label[text()='From']/..//input")
	    WebElement fromInput;

	    @FindBy(xpath = "//label[text()='To']/..//input")
	    WebElement toField;

//	    @FindBy(xpath = "//input[@type='text' and not(@disabled)]")
//	    WebElement activeInput;
	    @FindBy(xpath = "//input[@type='text' and not(@disabled)]")
	    WebElement activeInput;
	    @FindBy(xpath = "//button[contains(text(),'Search Trains')]")
	    WebElement searchBtn;

	    // ================= ACTION METHODS =================

	    public void openUrl() {
	        driver.get("https://www.redbus.in/railways");
	        driver.manage().window().maximize();
	    }

	    public void openDatePicker() {
	        datePicker.click();
	    }

	    public void selectDate(String month, String day) {

	        while (true) {
	            try {
	                String monthXpath = "//div[contains(@class,'datepicker')]/..//p[text()='" + month + "']";

	                if (driver.findElement(By.xpath(monthXpath)).isDisplayed()) {
	                    break;
	                }
	            } catch (Exception e) {
	                driver.findElement(By.xpath("//button[text()='>']")).click();
	            }
	        }

	        String dayXpath = "//div[contains(@class,'datepicker')]/..//span[text()='" + day + "']";
	        driver.findElement(By.xpath(dayXpath)).click();
	        JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, 0);");
	    }

//	    public void enterFrom(String city) throws InterruptedException {
//	        fromField.click();
//	        Thread.sleep(2000);
//	        fromInput.sendKeys(city);
//	        Thread.sleep(2000);
//	        fromInput.sendKeys(Keys.DOWN, Keys.ENTER);
//	    }
	    public void enterFrom(String city) {
	        fromField.click();

	        wait.until(ExpectedConditions.visibilityOf(fromInput));
	        fromInput.sendKeys(city);

	        // Wait for suggestion and select
	        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
	                By.xpath("//li[contains(.,'" + city + "')]")));
	        option.click();

	        // IMPORTANT → wait for overlay to disappear
	       // wait.until(ExpectedConditions.invisibilityOfElementLocated(
	               // By.xpath("//ul")));   // dropdown disappears
	    }

//	    public void enterTo(String city) throws InterruptedException {
//	        toInput.sendKeys(city);
//	        Thread.sleep(2000);
//	        toInput.sendKeys(Keys.DOWN, Keys.ENTER);
//	    }
//	    public void enterTo(String city) throws InterruptedException {
//
//	        wait.until(ExpectedConditions.elementToBeClickable(toInput));
//	        toInput.click();   // 🔥 IMPORTANT
//
//	        toInput.clear();
//	        toInput.sendKeys(city);
//
//	        Thread.sleep(2000);
//	        toInput.sendKeys(Keys.DOWN, Keys.ENTER);
//	    }
	   

	    public void enterTo(String city) throws InterruptedException {
//
//	        JavascriptExecutor js = (JavascriptExecutor) driver;
//
//	        // Click To field
//	        js.executeScript("arguments[0].click();", toField);
//
//	        // Wait for input
//	     	toField.click();
	        wait.until(ExpectedConditions.elementToBeClickable(toField));
	        
	        toField.sendKeys(city);
	        
	        Thread.sleep(3000);
	        
	        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
	                By.xpath("//li[contains(.,'" + city + "')]")));
	        option.click();
//
//	        // Click input again
//	        js.executeScript("arguments[0].click();", toField);
//
//	        // Type using JS (React fix)
//	        js.executeScript("arguments[0].value='" + city + "';", activeInput);
//	        js.executeScript(
//	            "arguments[0].dispatchEvent(new Event('input',{bubbles:true}))",
//	            activeInput
//	        );
//
//	        // Select suggestion
//	        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
//	                By.xpath("(//li[contains(.,'" + city + "')])[1]")
//	        ));
//
//	        js.executeScript("arguments[0].click();", option);
	    }
	    public void selectCity(WebElement inputBox, String city) {

	        JavascriptExecutor js = (JavascriptExecutor) driver;

	        // Click input using JS
	        js.executeScript("arguments[0].click();", inputBox);

	        // Clear and type
	        inputBox.clear();
	        inputBox.sendKeys(city);

	        // Wait for dropdown and click EXACT match
	        String optionXpath = "//li[.//text()[contains(.,'" + city + "')]]";

	        WebElement option = wait.until(
	                ExpectedConditions.elementToBeClickable(By.xpath(optionXpath)));

	        option.click();
	    }
	    
	    
//	    public void enterFrom(String city) {
//	        selectCity(fromInput, city);
//	    }
//	    public void enterTo(String city) {
//	        selectCity(toInput, city);
//	    }
//	    
//	    public void clickSearch() {
//	        searchBtn.click();
//	    }
	    
	    
	    public void waitForSeconds(int sec) {
	        try {
	            Thread.sleep(sec * 1000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	    public void clickSearch() {

	        JavascriptExecutor js = (JavascriptExecutor) driver;

	        // Wait until button is clickable
	        WebElement btn = wait.until(
	                ExpectedConditions.elementToBeClickable(searchBtn));

	        // Scroll to button
	        js.executeScript("arguments[0].scrollIntoView(true);", btn);

	        // Click using JS (avoids interception issues)
	        js.executeScript("arguments[0].click();", btn);
	    }
	}