package com.redbus.testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.redbus.testing.utilities.AllUtilityFunction;

public class BusPaymentPage {

	WebDriver driver;
	AllUtilityFunction util= new AllUtilityFunction();

	// Constructor
	public BusPaymentPage(WebDriver driver) {
		this.driver = driver;
	}

	// UPI payment option
	@FindBy(xpath = "//div[text()='Pay through QR code']")
	private WebElement payByAnyUPIApp;

	// Credit/Debit card option
	@FindBy(xpath = "//div[text()='Add credit/debit card']")
	private WebElement payByCreditCard;

	// Net banking option
	@FindBy(xpath = "//div[text()='Search all banks']")
	private WebElement payByNetBanking;

	// Coupon code option
	@FindBy(xpath = "//div[text()='Have a coupon code']")
	private WebElement couponCode;

	// Back to payment options
	@FindBy(css = "[aria-label=\"Back to all payment\"]")
	private WebElement backToAllPayment;

	// Bank select dropdown
	@FindBy(css = "[placeholder=\"Select\"]")
	private WebElement bankSelect;

	// Total price element
	@FindBy(xpath = "//div[@class='fare']/..")
	private WebElement totalPrice;

	// UPI verification text
	@FindBy(xpath = "//h2[text()='Pay using QR code, scan it with any UPI App']")
	private WebElement verifyUPI;

	// Credit card verification text
	@FindBy(xpath = "//h2[text()='Enter card details']")
	private WebElement verifyCreditCard;

	// Get credit card header
	public WebElement getVerifyCreditCard() {
		return verifyCreditCard;
	}

	// Get UPI text
	public String verifyUPI() {
		return verifyUPI.getText();
	}

	// Get UPI option
	public WebElement getPayByAnyUPIApp() {
		util.waitForElementVisible(driver, payByAnyUPIApp, 20);
		return payByAnyUPIApp;
	}

	// Get credit card text
	public String verifyCreditCard() {
		return payByCreditCard.getText();
	}

	// Click UPI option
	public void clickPayByAnyUPIApp() {
		getPayByAnyUPIApp().click();
	}

	// Get credit card option
	public WebElement getPayByCreditCard() {
		return payByCreditCard;
	}

	// Click credit card option
	public void clickPayByCreditCard() {
		getPayByCreditCard().click();
	}

	// Get net banking option
	public WebElement getPayByNetBanking() {
		return payByNetBanking;
	}

	// Click net banking option
	public void clickPayByNetBanking() {
		getPayByNetBanking().click();
	}

	// Get coupon option
	public WebElement getCouponCode() {
		return couponCode;
	}

	// Click coupon option
	public void clickCouponCode() {
		getCouponCode().click();
	}

	// Get back button
	public WebElement getBackToAllPayment() throws InterruptedException {
		util.waitForElementClickable(driver, backToAllPayment, 30);
		return backToAllPayment;
	}

	// Click back button
	public void clickBackToAllPayment() throws InterruptedException {
		util.waitForClickable(driver, backToAllPayment, 30);
		getBackToAllPayment().click();
	}

	// Get bank dropdown
	public WebElement getBankSelect() {
		return bankSelect;
	}

	// Click bank dropdown
	public void clickBankSelect() {
		getBankSelect().click();
	}

	// Get total price
	public WebElement getTotalPrice() {
		return totalPrice;
	}

	// Get price text
	public String verifyPrice() {
		return totalPrice.getText();
	}
}