package com.redbus.testing.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun;

import com.RedBus.testing.utilities.AllUtilityFunction;

public class BusPaymentPage {

	
	WebDriver driver;

    public BusPaymentPage(WebDriver driver) {
    
        this.driver = driver;
    }
	
	@FindBy(xpath = "//div[text()='Pay through QR code']")
	private WebElement payByAnyUPIApp;
	
	@FindBy(xpath = "//div[text()='Add credit/debit card']")
	private WebElement payByCreditCard;
	
	@FindBy(xpath = "//div[text()='Search all banks']")
	private WebElement payByNetBanking;
	
	@FindBy(xpath = "//div[text()='Have a coupon code']")
	private WebElement couponCode;
	
	@FindBy(css = "[aria-label=\"Back to all payment\"]")
	private WebElement backToAllPayment;
	
	@FindBy(css = "[placeholder=\"Select\"]")
	private WebElement bankSelect;
	
	@FindBy(xpath = "//div[@class='fare']/..")
	private WebElement totalPrice;
	
	@FindBy(xpath = "//h2[text()='Pay using QR code, scan it with any UPI App']")
	private WebElement verifyUPI;
	
	@FindBy(xpath = "//h2[text()='Enter card details']")
	private WebElement verifyCreditCard;
	
	public WebElement getVerifyCreditCard() {
		return verifyCreditCard;
	}
	
	public String verifyUPI() {
		return verifyUPI.getText();
	}
	
	public WebElement getPayByAnyUPIApp() {
		return payByAnyUPIApp;
	}
	
	public String verifyCreditCard() {
	
		return payByCreditCard.getText();
	}

	public void clickPayByAnyUPIApp() {
		getPayByAnyUPIApp().click();
	}

	public WebElement getPayByCreditCard() {
		return payByCreditCard;
	}

	public void clickPayByCreditCard() {
		getPayByCreditCard().click();;
	}

	public WebElement getPayByNetBanking() {
		return payByNetBanking;
	}

	public void clickPayByNetBanking() {
		getPayByNetBanking().click();
	}

	public WebElement getCouponCode() {
		return couponCode;
	}

	public void clickCouponCode() {
		getCouponCode().click();;
	}

	public WebElement getBackToAllPayment() throws InterruptedException {
		Thread.sleep(2000);
		return backToAllPayment;
	}

	public void clickBackToAllPayment() throws InterruptedException {
		getBackToAllPayment().click();
	}

	public WebElement getBankSelect() {
		return bankSelect;
	}

	public void clickBankSelect() {
		getBankSelect().click();
	}

	public WebElement getTotalPrice() {
		return totalPrice;
	}

	public String verifyPrice() {
		return totalPrice.getText();
	}
}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

