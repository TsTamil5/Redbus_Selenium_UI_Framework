package com.redbus.testing.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class food_order_page {
	 private WebDriver driver;
	 private WebDriverWait wait;
	 private Actions actions;
	public food_order_page(WebDriver driver) {
		 this.driver = driver;
		 this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		 this.actions = new Actions(driver);
		 PageFactory.initElements(driver, this);
	}
	
	private By popularFoodLocator = By.xpath("//div[contains(@class,'pl-3')]");
	
	private By suggestionLocator = By.cssSelector(
		    ".text-sm.lg\\:text-base.font-medium.text-admin-onBackground.subtitle-3.ext-ellipsis.line-clamp-2.w-48"
		);
	
	@FindBy(css = "input[placeholder='Search food, brand, station, etc.']")
	private WebElement  foodInputField;
	
	@FindBy(css = ".form-input.pl-12.text-sm")
	private WebElement foodSearchField;

	@FindBy(css = "input.custom-date-picker[type='date']")
	private WebElement boardingDateField;
	
	@FindBy(css = "select[placeholder='Boarding Station'], .form-Input")
	private WebElement boardingStationField;
	
	@FindBy(xpath = "//button[.='FIND FOOD']")
	private WebElement findFoodButton;
	
	@FindBy(xpath = "//h4[contains(text(),'No results for')]")
	private WebElement noResultsHeader;

	@FindBy(xpath = "//p[contains(text(),'Please try again')]")
	private WebElement noResultsSubText;
	
	public WebElement getFoodInputField() {
		return foodInputField;
	}

	public WebElement getFoodSearchField() {
		return foodSearchField;
	}
	public void clickSearchField() {
		foodInputField.click();
	}
	//Entering data in search field
	public void enterSearchText(String text) {
	    WebElement searchBox = driver.findElement(
	        By.cssSelector(".form-input.pl-12.text-sm")
	    );
	    clickSearchField();
	    searchBox.sendKeys(text);
	}
	
	public List<String> getAllSuggestions() {

	    wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(suggestionLocator, 0));

	    List<WebElement> elements = driver.findElements(suggestionLocator);

	    List<String> list = new ArrayList<>();

	    for (WebElement e : elements) {
	        list.add(e.getText().trim());
	    }

	    return list;
	}
	
	// Dynamic suggestion click 
	public void clickOnSuggestion(String text) {

	    wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(suggestionLocator, 0));

	    List<WebElement> suggestionList = driver.findElements(suggestionLocator);

	    for (WebElement element : suggestionList) {

	        String suggestionText = element.getText().trim();

	        if (suggestionText.equalsIgnoreCase(text)) {

	            wait.until(ExpectedConditions.elementToBeClickable(element));
	            element.click();
	            return;
	        }
	    }

	    throw new RuntimeException("Suggestion not found: " + text);
	}
	
	
	public boolean isSuggestionListEmpty() {

	    wait.until(ExpectedConditions.invisibilityOfElementLocated(suggestionLocator));

	    return driver.findElements(suggestionLocator).isEmpty();
	}
	
	public void clickOnPopularFood(String foodName) {

	    wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(popularFoodLocator, 0));

	    List<WebElement> popularFoods = driver.findElements(popularFoodLocator);

	    for (int i = 0; i < popularFoods.size(); i++) {

	        // re-fetch element every iteration (avoids stale)
	        List<WebElement> freshList = driver.findElements(popularFoodLocator);

	        WebElement food = freshList.get(i);

	        String text = food.getText().trim();

	        if (text.equalsIgnoreCase(foodName)) {

	            wait.until(ExpectedConditions.elementToBeClickable(food));
	            food.click();
	            return;
	        }
	    }

	    throw new RuntimeException("Popular food not found: " + foodName);
	}
	
	public void selectBoardingDate(String date) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    js.executeScript(
	        "var nativeInputValueSetter = Object.getOwnPropertyDescriptor(" +
	        "window.HTMLInputElement.prototype, 'value').set;" +
	        "nativeInputValueSetter.call(arguments[0], arguments[1]);" +
	        "arguments[0].dispatchEvent(new Event('input', { bubbles: true }));" +
	        "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));",
	        boardingDateField, date
	    );
	}
	
	public void selectBoardingStation() {

	    By dropdownLocator = By.cssSelector("select[placeholder='Boarding Station']");

	    // 1. wait for dropdown
	    WebElement dropdown = wait.until(
	        ExpectedConditions.presenceOfElementLocated(dropdownLocator)
	    );

	    // 2. scroll + force click (avoids intercept issue)
	    ((JavascriptExecutor) driver)
	        .executeScript("arguments[0].scrollIntoView(true);", dropdown);

	    ((JavascriptExecutor) driver)
	        .executeScript("arguments[0].click();", dropdown);

	    // 3. wait until options are loaded (VERY IMPORTANT)
	    wait.until(driver -> {
	        Select select = new Select(driver.findElement(dropdownLocator));
	        return select.getOptions().size() > 1;
	    });

	    // 4. select first valid option (skip placeholder)
	    Select select = new Select(driver.findElement(dropdownLocator));

	    for (WebElement option : select.getOptions()) {

	        String text = option.getText().trim();

	        if (!text.equalsIgnoreCase("Boarding Station") && !text.isEmpty()) {
	            select.selectByVisibleText(text);
	            System.out.println("Selected Boarding Station: " + text);
	            return;
	        }
	    }

	    throw new RuntimeException("No valid boarding station available to select");
	}
	
	public String getNoResultsHeaderText() {
	    wait.until(ExpectedConditions.visibilityOf(noResultsHeader));
	    return noResultsHeader.getText().trim();
	}

	public String getNoResultsSubText() {
	    wait.until(ExpectedConditions.visibilityOf(noResultsSubText));
	    return noResultsSubText.getText().trim();
	}
	
	public void clickOnFindFoodBtn() {
		findFoodButton.click();
	}

}

