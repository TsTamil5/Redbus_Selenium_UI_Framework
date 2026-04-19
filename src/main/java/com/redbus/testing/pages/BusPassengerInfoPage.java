package com.redbus.testing.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BusPassengerInfoPage {

	@FindBy(css = "[placeholder=\"Phone\"]")
	private WebElement phoneField;

	@FindBy(css = "[placeholder=\"Enter email id\"]")
	private WebElement emailIDField;

	@FindBy(xpath = "(//div[.//label[contains(text(),'State of Residence')]])[9]")
	private WebElement stateOfResidence;

	@FindBy(css = "[placeholder=\"Search for state\"]")
	private WebElement searchForState;

	@FindBy(css = "[class=\"listItem___0b3206 \"]")
	private WebElement chooseState;

	@FindBy(css = "[placeholder=\"Enter your Name\"]")
	private WebElement nameField;

	@FindBy(css = "[placeholder=\"Enter Age\"]")
	private WebElement ageField;

	@FindBy(xpath = "//div[@role='radio' and .//span[text()='Male']]")
	private WebElement male;

	@FindBy(xpath = "//span[text()='Female']/..")
	private WebElement female;

	@FindBy(id = "insuranceConfirmText")
	private WebElement withInsurance;

	@FindBy(id = "insuranceRejectText")
	private WebElement withoutInsurance;

	@FindBy(xpath = "//button[text()='Continue booking']")
	private WebElement continueBooking;

	@FindBy(xpath = "//span[text()='View details']")
	private WebElement viewDetails;

	@FindBy(xpath = "//h2[contains(text(),'Booking')]/ancestor::div//button[@aria-label='Close']")
	private WebElement viewDetailsClose;

	public WebElement getPhoneField() {
		return phoneField;
	}

	public WebElement getEmailIDField() {
		return emailIDField;
	}

	public WebElement getStateOfResidence() {
		return stateOfResidence;
	}

	public WebElement getSearchForState() {
		return searchForState;
	}

	public WebElement getChooseState() {
		return chooseState;
	}

	public WebElement getNameField() {
		return nameField;
	}

	public WebElement getAgeField() {
		return ageField;
	}

	public WebElement getMale() {
		return male;
	}

	public WebElement getFemale() {
		return female;
	}

	public WebElement getWithInsurance() {
		return withInsurance;
	}

	public WebElement getWithoutInsurance() {
		return withoutInsurance;
	}

	public WebElement getContinueBooking() {
		return continueBooking;
	}

	public WebElement getViewDetails() {
		return viewDetails;
	}

	public WebElement getViewDetailsClose() {
		return viewDetailsClose;
	}

	public void enterPhone(String phone) {
		phoneField.sendKeys(phone);
	}

	public void enterEmail(String email) {
		emailIDField.sendKeys(email);
	}

	public void enterName(String name) {
		nameField.sendKeys(name);
	}

	public void enterAge(String age) {
		ageField.sendKeys(age);
	}

	public void clickStateOfResidence() {
		stateOfResidence.click();
	}

	public void clickStateOfResidence(String state) {
		searchForState.sendKeys(state);
	}

	public void clickChooseState() {
		chooseState.click();
	}

	public void selectMale() {
		male.click();
	}

	public void selectFemale() {
		female.click();
	}

	public void selectWithoutInsurance() {
		withoutInsurance.click();
	}

	public void clickContinueBooking() {
		continueBooking.click();
	}
}