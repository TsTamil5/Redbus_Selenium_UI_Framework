package com.redbus.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BusPassengerInfoPage {
	WebDriver driver;

	// Constructor
	public BusPassengerInfoPage(WebDriver driver) {
		this.driver = driver;
	}

	// Trip Reward popup 
	@FindBy(xpath = "//button[text()='Remind me later']")
	private WebElement tripReward;

	
	// Phone input
	@FindBy(css = "[placeholder=\"Phone\"]")
	private WebElement phoneField;

	// Email input
	@FindBy(css = "[placeholder=\"Enter email id\"]")
	private WebElement emailIDField;

	// State dropdown
	@FindBy(xpath = "(//div[.//label[contains(text(),'State of Residence')]])[9]")
	private WebElement stateOfResidence;

	// State search field
	@FindBy(css = "[placeholder=\"Search for state\"]")
	private WebElement searchForState;

	// Name input
	@FindBy(css = "[placeholder=\"Enter your Name\"]")
	private WebElement nameField;

	// Age input
	@FindBy(css = "[placeholder=\"Enter Age\"]")
	private WebElement ageField;

	// Male option
	@FindBy(xpath = "//div[@role='radio' and .//span[text()='Male']]")
	private WebElement male;

	// Female option
	@FindBy(xpath = "//span[text()='Female']/..")
	private WebElement female;

	// With insurance option
	@FindBy(id = "insuranceConfirmText")
	private WebElement withInsurance;

	// Without insurance option
	@FindBy(id = "insuranceRejectText")
	private WebElement withoutInsurance;

	// Continue booking button
	@FindBy(xpath = "//button[text()='Continue booking']")
	private WebElement continueBooking;

	// View details button
	@FindBy(xpath = "//span[text()='View details']")
	private WebElement viewDetails;

	// Close details popup
	@FindBy(xpath = "//h2[contains(text(),'Booking')]/ancestor::div//button[@aria-label='Close']")
	private WebElement viewDetailsClose;

	// Get phone field
	public WebElement getPhoneField() {
		return phoneField;
	}

	// Get email field
	public WebElement getEmailIDField() {
		return emailIDField;
	}

	// Get state dropdown
	public WebElement getStateOfResidence() {
		return stateOfResidence;
	}

	// Get state search
	public WebElement getSearchForState() {
		return searchForState;
	}

	// Get name field
	public WebElement getNameField() {
		return nameField;
	}

	// Get age field
	public WebElement getAgeField() {
		return ageField;
	}

	// Get male option
	public WebElement getMale() {
		return male;
	}

	// Get female option
	public WebElement getFemale() {
		return female;
	}

	// Get insurance yes
	public WebElement getWithInsurance() {
		return withInsurance;
	}

	// Get insurance no
	public WebElement getWithoutInsurance() {
		return withoutInsurance;
	}

	// Get continue button
	public WebElement getContinueBooking() {
		return continueBooking;
	}

	// Get view details
	public WebElement getViewDetails() {
		return viewDetails;
	}

	// Get close button
	public WebElement getViewDetailsClose() {
		return viewDetailsClose;
	}

	// Enter phone
	public void enterPhone(String phone) {
		phoneField.clear();
		phoneField.sendKeys(phone);
	}

	// Enter email
	public void enterEmail(String email) {
		emailIDField.sendKeys(email);
	}

	// Enter name
	public void enterName(String name) {
		nameField.sendKeys(name);
	}

	// Enter age
	public void enterAge(String age) {
		ageField.sendKeys(age);
	}

	// Click state dropdown
	public void clickStateOfResidence() {
		stateOfResidence.click();
	}

	// Search state
	public void clickStateOfResidence(String state) {
		searchForState.sendKeys(state);
	}

	// Select state
	public void selectState(String state) {
		driver.findElement(By.xpath("//div[text()='" + state + "']")).click();
	}

	// Select male
	public void selectMale() {
		male.click();
	}

	// Select female
	public void selectFemale() {
		female.click();
	}

	// Select without insurance
	public void selectWithoutInsurance() {
		withoutInsurance.click();
	}

	// Click continue booking
	public void clickContinueBooking() {
		continueBooking.click();
	}
	
	// Trip Reward popup handling
		public void clickRemindMeLater() {
			tripReward.click();
		}
}