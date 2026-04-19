package com.redbus.testing.pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

		WebDriverWait wait = new WebDriverWait(Base.driver, Duration.ofSeconds(15));

		return wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//input[not(@type='hidden') and not(@disabled)])[last()]")));
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
	    WebDriverWait wait = new WebDriverWait(Base.driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(checkIn)).click();
	}

	public WebElement getCheckOut() {
		return checkOut;
	}
	
	public void clickCheckOut() {
		getCheckOut().click();
	}
	
	public WebElement getMonthYearText() {
	    return Base.driver.findElement(
	        By.cssSelector("[class='monthYearHolidayWrap___248d1b']"));
	}

	public WebElement getNextMonthArrow() {
		return Base.driver.findElement(
				By.cssSelector("[class='icon icon-arrow arrow___d32c04 right___1dcefa ']"));
	}

	public void clickNextMonthArrow() {
		getNextMonthArrow().click();
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

		WebDriverWait wait = new WebDriverWait(Base.driver, Duration.ofSeconds(15));

		clickCityField();

		WebElement inputField = getInputField();

		Actions action = new Actions(Base.driver);

		action.click(inputField)
		      .sendKeys(inputField, cityNameValue).pause(Duration.ofSeconds(3))
		      .perform();

		wait.until(ExpectedConditions.elementToBeClickable(firstCitySuggestion));

		clickFirstCitySuggestion();
	}
	public void selectCheckInAndCheckOutDate(String checkInDate, String checkOutDate) throws InterruptedException {

		String[] inDate = checkInDate.split(" ");
		String[] outDate = checkOutDate.split(" ");

		clickCheckIn();

		navigateToMonthYear(inDate[1], inDate[2]);
		Base.driver.findElement(By.xpath("//span[text()='" + inDate[0] + "']")).click();

		Thread.sleep(2000);

		navigateToMonthYear(outDate[1], outDate[2]);
		Base.driver.findElement(By.xpath("//span[text()='" + outDate[0] + "']")).click();

		Thread.sleep(2000);
	}

	public void navigateToMonthYear(String month, String year) {

		while (true) {

			String currentMonthYear = getMonthYearText().getText();

			if (currentMonthYear.contains(month) && currentMonthYear.contains(year)) {
				break;
			}

			clickNextMonthArrow();
		}
	}
}
