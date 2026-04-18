package com.redbus.testing.pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.redbus.testing.utilities.Base;

public class HotelsPage {

	@FindBy(xpath="//span[.='City, area or hotel name']")
	private WebElement cityField;
	
	@FindBy(xpath="(//div[@role='option'])[1]")
	private WebElement firstCitySuggestion;
	
	@FindBy(xpath="//span[.='Check in']")
	private WebElement checkIn;
	
	@FindBy(xpath="//span[.='Check out']")
	private WebElement checkOut;
	
	@FindBy(xpath="//span[.='No. of rooms & guests']")
	private WebElement roomsAndGuests;
	
	@FindBy(xpath="//div[.='Rooms']/..//i[@class='icon___4eb250 icon icon-remove']")
	private WebElement roomsMinusIcon;
	
	@FindBy(xpath="//div[.='Rooms']/..//i[@class='icon___4eb250 icon icon-add']")
	private WebElement roomsPlusIcon;
	
	@FindBy(xpath="//span[.='Adults']/../..//i[@class='icon___4eb250 icon icon-remove']")
	private WebElement adultsMinusIcon;
	
	@FindBy(xpath="//span[.='Adults']/../..//i[@class='icon___4eb250 icon icon-add']")
	private WebElement adultsPlusIcon;
	
	@FindBy(css="[class='addBtn___168d65 ']")
	private WebElement addChildren;
	
	@FindBy(xpath="//span[.='Children']/../..//i[@class='icon___4eb250 icon icon-remove']")
	private WebElement minusChildrenIcon;
	
	@FindBy(xpath="//span[.='Children']/../..//i[@class='icon___4eb250 icon icon-add']")
	private WebElement plusChildrenIcon;
	
	@FindBy(xpath="//div[contains(@class,'childField')]")
	List<WebElement> childFields;
	
	@FindBy(xpath = "//div[@role='option']//span")
	private List<WebElement> ageOptions;

	@FindBy(xpath="//section[@data-autoid='flashDeals']//article[@role='button']")
	private List<WebElement> flashDealCards;
	
	public WebElement getCityField() {
		return cityField;
	}
	
	public WebElement getInputField() {
		return Base.driver.findElement(
			RelativeLocator.with(By.tagName("input")).below(cityField));
	}
	
	public WebElement getFirstCitySuggestion() {
		return firstCitySuggestion;
	}
	
	public void clickFirstCitySuggestion() {
		getFirstCitySuggestion().click();
	}
	
	public void clickCityField() {
		getCityField().click();
	}

	public WebElement getCheckIn() {
		return checkIn;
	}
	
	public void clickCheckIn() {
		getCheckIn().click();
	}

	public WebElement getCheckOut() {
		return checkOut;
	}
	
	public void clickCheckOut() {
		getCheckOut().click();
	}

	public WebElement getRoomsAndGuests() {
		return roomsAndGuests;
	}
	
	public void clickRoomsAndGuests() {
		getRoomsAndGuests().click();
	}

	public WebElement getRoomsMinusIcon() {
		return roomsMinusIcon;
	}
	
	public void decreaseRooms(int count) {
		for(int i = 1; i < count; i++) {
			getRoomsMinusIcon().click();
		}
	}

	public WebElement getRoomsPlusIcon() {
		return roomsPlusIcon;
	}
	
	public void increaseRooms(int count) {
		for(int i = 1; i < count; i++) {
			getRoomsPlusIcon().click();
		}
	}

	public WebElement getAdultsMinusIcon() {
		return adultsMinusIcon;
	}
	
	public void decreaseAdults(int count) {
		for(int i = 1; i < count; i++) {
			getAdultsMinusIcon().click();
		}
	}

	public WebElement getAdultsPlusIcon() {
		return adultsPlusIcon;
	}
	
	public void increaseAdults(int count) {
		for(int i = 1; i < count; i++) {
			getAdultsPlusIcon().click();
		}
	}

	public WebElement getAddChildren() {
		return addChildren;
	}
	
	public void addChildren(int count) {
		for(int i = 0; i < count; i++) {
			getAddChildren().click();
		}
	}
	
	public WebElement getMinusChildrenIcon() {
		return minusChildrenIcon;
	}
	
	public void decreaseChildren(int count) {
		for(int i = 0; i < count; i++) {
			getMinusChildrenIcon().click();
		}
	}
	
	public WebElement getPlusChildrenIcon() {
		return plusChildrenIcon;
	}
	
	public void increaseChildren(int count) {
		for(int i = 1; i < count; i++) {
			getPlusChildrenIcon().click();
		}
	}

	public List<WebElement> getChildFields() {
		return childFields;
	}
	
	public void clickChildField(int index) {
		getChildFields().get(index).click();
	}
	
	public int getChildFieldsCount() {
		return getChildFields().size();
	}
	
	public List<WebElement> getAgeOptions() {
	    return ageOptions;
	}
	
	public List<WebElement> getFlashDealCards() {
		return flashDealCards;
	}

	public void clickFlashDealCard(int index) {
		getFlashDealCards().get(index).click();
	}
	
	
	public void selectCity(String cityNameValue) {

		clickCityField();

		WebDriverWait wait = new WebDriverWait(Base.driver, Duration.ofSeconds(10));

		WebElement inputField = wait.until(
				ExpectedConditions.visibilityOf(getInputField()));

		Actions action = new Actions(Base.driver);

		action.sendKeys(inputField, cityNameValue).perform();

		WebElement firstSuggestion = wait.until(
				ExpectedConditions.elementToBeClickable(getFirstCitySuggestion()));

		clickFirstCitySuggestion();
	}
	
}
