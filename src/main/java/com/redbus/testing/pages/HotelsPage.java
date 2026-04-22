package com.redbus.testing.pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.redbus.testing.utilities.AllUtilityFunction;
import com.redbus.testing.utilities.Base;

public class HotelsPage extends AllUtilityFunction{

	// Locate city input field
	@FindBy(xpath="//span[.='City, area or hotel name']")
	private WebElement cityField;
	
	// Locate first city suggestion
	@FindBy(xpath="(//div[@role='option'])[1]")
	private WebElement firstCitySuggestion;
	
	// Locate check-in field
	@FindBy(xpath="//span[.='Check in']")
	private WebElement checkIn;
	
	// Locate check-out field
	@FindBy(xpath="//span[.='Check out']")
	private WebElement checkOut;
	
	// Locate rooms and guests field
	@FindBy(xpath="//span[.='No. of rooms & guests']")
	private WebElement roomsAndGuests;
	
	// Locate decrease rooms icon
	@FindBy(xpath="//div[.='Rooms']/..//i[@class='icon___4eb250 icon icon-remove']")
	private WebElement roomsMinusIcon;
	
	// Locate increase rooms icon
	@FindBy(xpath="//div[.='Rooms']/..//i[@class='icon___4eb250 icon icon-add']")
	private WebElement roomsPlusIcon;
	
	// Locate decrease adults icon
	@FindBy(xpath="//span[.='Adults']/../..//i[@class='icon___4eb250 icon icon-remove']")
	private WebElement adultsMinusIcon;
	
	// Locate increase adults icon
	@FindBy(xpath="//span[.='Adults']/../..//i[@class='icon___4eb250 icon icon-add']")
	private WebElement adultsPlusIcon;
	
	// Locate add children button
	@FindBy(css="[class='addBtn___168d65 ']")
	private WebElement addChildren;
	
	// Locate decrease children icon
	@FindBy(xpath="//span[.='Children']/../..//i[@class='icon___4eb250 icon icon-remove']")
	private WebElement minusChildrenIcon;
	
	// Locate increase children icon
	@FindBy(xpath="//span[.='Children']/../..//i[@class='icon___4eb250 icon icon-add']")
	private WebElement plusChildrenIcon;
	
	// Locate child age fields
	@FindBy(xpath="//div[contains(@class,'childField')]")
	List<WebElement> childFields;
	
	// Locate child age options
	@FindBy(xpath = "//div[@role='option']//span")
	private List<WebElement> ageOptions;

	// Locate flash deal cards
	@FindBy(xpath="//section[@data-autoid='flashDeals']//article[@role='button']")
	private List<WebElement> flashDealCards;
	
	// Return city field element
	public WebElement getCityField() {
		return cityField;
	}
	
	// Return first city suggestion
	public WebElement getFirstCitySuggestion() {
		return firstCitySuggestion;
	}
	
	// Click first city suggestion
	public void clickFirstCitySuggestion() {
		getFirstCitySuggestion().click();
	}
	
	// Click city field
	public void clickCityField() {
		getCityField().click();
	}
	
	// Return active input field
	public WebElement getInputField() {

		WebDriverWait wait = new WebDriverWait(Base.getDriver(), Duration.ofSeconds(15));

		return wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//input[not(@type='hidden') and not(@disabled)])[last()]")));
	}

	// Return check-in element
	public WebElement getCheckIn() {
		return checkIn;
	}
	
	// Click check-in field
	public void clickCheckIn() {
	    WebDriverWait wait = new WebDriverWait(Base.getDriver(), Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(checkIn)).click();
	}

	// Return check-out element
	public WebElement getCheckOut() {
		return checkOut;
	}
	
	// Click check-out field
	public void clickCheckOut() {
		getCheckOut().click();
	}
	
	// Return displayed month and year text
	public WebElement getMonthYearText() {
	    return Base.getDriver().findElement(
	        By.cssSelector("[class='monthYearHolidayWrap___248d1b']"));
	}

	// Return next month arrow
	public WebElement getNextMonthArrow() {
		return Base.getDriver().findElement(
				By.cssSelector("[class='icon icon-arrow arrow___d32c04 right___1dcefa ']"));
	}

	// Click next month arrow
	public void clickNextMonthArrow() {
		getNextMonthArrow().click();
	}

	// Return rooms and guests element
	public WebElement getRoomsAndGuests() {
		return roomsAndGuests;
	}
	
	// Click rooms and guests field
	public void clickRoomsAndGuests() {
		getRoomsAndGuests().click();
	}

	// Return rooms minus icon
	public WebElement getRoomsMinusIcon() {
		return roomsMinusIcon;
	}
	
	// Decrease room count
	public void decreaseRooms(int count) {
		for(int i = 1; i < count; i++) {
			getRoomsMinusIcon().click();
		}
	}

	// Return rooms plus icon
	public WebElement getRoomsPlusIcon() {
		return roomsPlusIcon;
	}
	
	// Increase room count
	public void increaseRooms(int count) {
		for(int i = 1; i < count; i++) {
			getRoomsPlusIcon().click();
		}
	}

	// Return adults minus icon
	public WebElement getAdultsMinusIcon() {
		return adultsMinusIcon;
	}
	
	// Decrease adults count
	public void decreaseAdults(int count) {
		for(int i = 1; i < count; i++) {
			getAdultsMinusIcon().click();
		}
	}

	// Return adults plus icon
	public WebElement getAdultsPlusIcon() {
		return adultsPlusIcon;
	}
	
	// Increase adults count
	public void increaseAdults(int count) {
		for(int i = 1; i < count; i++) {
			getAdultsPlusIcon().click();
		}
	}

	// Return add children button
	public WebElement getAddChildren() {
		return addChildren;
	}
	
	// Add children count
	public void addChildren(int count) {
		for(int i = 0; i < count; i++) {
			getAddChildren().click();
		}
	}
	
	// Return minus children icon
	public WebElement getMinusChildrenIcon() {
		return minusChildrenIcon;
	}
	
	// Decrease children count
	public void decreaseChildren(int count) {
		for(int i = 0; i < count; i++) {
			getMinusChildrenIcon().click();
		}
	}
	
	// Return plus children icon
	public WebElement getPlusChildrenIcon() {
		return plusChildrenIcon;
	}
	
	// Increase children count
	public void increaseChildren(int count) {
		for(int i = 1; i < count; i++) {
			getPlusChildrenIcon().click();
		}
	}

	// Return child fields list
	public List<WebElement> getChildFields() {
		return childFields;
	}
	
	// Click child field by index
	public void clickChildField(int index) {
		getChildFields().get(index).click();
	}
	
	// Return child fields count
	public int getChildFieldsCount() {
		return getChildFields().size();
	}
	
	// Return age options
	public List<WebElement> getAgeOptions() {
	    return ageOptions;
	}
	
	// Return flash deal cards
	public List<WebElement> getFlashDealCards() {
		return flashDealCards;
	}

	// Click flash deal card by index
	public void clickFlashDealCard(int index) {
		getFlashDealCards().get(index).click();
	}

	// Select city from suggestions
	public void selectCity(String cityNameValue) {

		WebDriverWait wait = new WebDriverWait(Base.getDriver(), Duration.ofSeconds(15));

		clickCityField();

		WebElement inputField = getInputField();

		Actions action = new Actions(Base.getDriver());

		action.click(inputField)
		      .sendKeys(inputField, cityNameValue).pause(Duration.ofSeconds(3))
		      .perform();

		wait.until(ExpectedConditions.elementToBeClickable(firstCitySuggestion));

		clickFirstCitySuggestion();
	}

	// Select check-in and check-out dates
	public void selectCheckInAndCheckOutDate(String checkInDate, String checkOutDate) throws InterruptedException {

		String[] inDate = checkInDate.split(" ");
		String[] outDate = checkOutDate.split(" ");

		clickCheckIn();

		navigateToMonthYear(inDate[1], inDate[2]);
		Base.getDriver().findElement(By.xpath("//span[text()='" + inDate[0] + "']")).click();

		Thread.sleep(2000);

		navigateToMonthYear(outDate[1], outDate[2]);
		Base.getDriver().findElement(By.xpath("//span[text()='" + outDate[0] + "']")).click();

		Thread.sleep(2000);
	}

	// Navigate calendar to required month and year
	public void navigateToMonthYear(String month, String year) {

		while (true) {

			String currentMonthYear = getMonthYearText().getText();

			if (currentMonthYear.contains(month) && currentMonthYear.contains(year)) {
				break;
			}

			clickNextMonthArrow();
		}
	}
	
	// Check child age validation message displayed
	public boolean isChildAgeValidationDisplayed() {

		WebDriverWait wait = new WebDriverWait(Base.getDriver(), Duration.ofSeconds(10));

		WebElement message = wait.until(
			ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[contains(.,\"Select child's age to proceed\")]")));

		return message.isDisplayed();
	}
	
}