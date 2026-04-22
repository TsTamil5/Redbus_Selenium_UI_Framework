package com.redbus.testing.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import com.redbus.testing.utilities.AllUtilityFunction;

public class food_order_page {

    // WebDriver instance used to interact with browser
    private WebDriver driver;

    // Utility class instance for reusable wait methods
    private AllUtilityFunction util;

    // Constructor to initialize driver and utility
    public food_order_page(WebDriver driver) {
        this.driver = driver;
        this.util = new AllUtilityFunction();
    }

    // Locator for popular food items displayed on homepage
    private By popularFoodLocator = By.xpath("//div[contains(@class,'pl-3')]");

    // Locator for search suggestions list
    private By suggestionLocator = By.cssSelector(
        ".text-sm.lg\\:text-base.font-medium.text-admin-onBackground.subtitle-3.ext-ellipsis.line-clamp-2.w-48"
    );

    // Locator for initial search input field
    private By searchInputLocator =
        By.cssSelector("input[placeholder='Search food, brand, station, etc.']");

    // Locator for actual search box after clicking input
    private By searchBoxLocator =
        By.cssSelector(".form-input.pl-12.text-sm");

    // Locator for "Find Food" button
    private By findFoodBtnLocator =
        By.xpath("//button[.='FIND FOOD']");

    // Locator for "No Results Found" header
    private By noResultsHeaderLocator =
        By.xpath("//h4[contains(text(),'No results for')]");

    // Locator for "No Results Found" sub text
    private By noResultsSubTextLocator =
        By.xpath("//p[contains(text(),'Please try again')]");

    // Locator for boarding date input field
    private By boardingDateLocator =
        By.cssSelector("input.custom-date-picker[type='date']");

    // Locator for boarding station dropdown
    private By boardingStationDropdownLocator =
        By.cssSelector("select[placeholder='Boarding Station']");


    // Clicks on search field to activate search input
    public void clickSearchField() {
        WebElement element = util.waitForRefreshedClickable(driver, searchInputLocator, 25);
        element.click();
    }

    // Enters text into search box after activating it
    public void enterSearchText(String text) {
        clickSearchField();
        WebElement searchBox = util.waitForRefreshedVisibility(driver, searchBoxLocator, 25);
        searchBox.clear();
        searchBox.sendKeys(text);
    }

    // Enters data into search box for datatable usage
    public void enterDataForDatatable(String text) {
        WebElement searchBox = util.waitForRefreshedVisibility(driver, searchBoxLocator, 25);
        searchBox.sendKeys(text);
    }

    // Retrieves all suggestions displayed in search dropdown
    public List<String> getAllSuggestions() {
        List<WebElement> elements = util.waitForElementsMoreThan(driver, suggestionLocator, 0, 25);

        List<String> list = new ArrayList<>();
        for (WebElement e : elements) {
            list.add(e.getText().trim());
        }

        return list;
    }

    // Clicks on a specific suggestion based on visible text
    public void clickOnSuggestion(String text) {
        List<WebElement> suggestionList = util.waitForElementsMoreThan(driver, suggestionLocator, 0, 25);

        for (WebElement element : suggestionList) {
            if (element.getText().trim().equalsIgnoreCase(text)) {
                util.waitForClickable(driver, element, 25).click();
                return;
            }
        }

        throw new RuntimeException("Suggestion not found: " + text);
    }

    // Checks whether suggestion list is empty
    public boolean isSuggestionListEmpty() {
        util.waitForInvisibility(driver, suggestionLocator, 25);
        return driver.findElements(suggestionLocator).isEmpty();
    }

    // Returns number of suggestions (used for defect validation)
    public int getSuggestionCount() {
        try {
            return util.waitForElementsMoreThan(driver, suggestionLocator, 0, 25).size();
        } catch (Exception e) {
            return 0;
        }
    }

    // Clicks on a specific popular food item
    public void clickOnPopularFood(String foodName) {

        List<WebElement> popularFoods = util.waitForElementsMoreThan(driver, popularFoodLocator, 0, 25);

        for (int i = 0; i < popularFoods.size(); i++) {

            // Re-fetch elements to avoid stale exception
            List<WebElement> freshList = driver.findElements(popularFoodLocator);
            WebElement food = freshList.get(i);

            if (food.getText().trim().equalsIgnoreCase(foodName)) {
                util.waitForClickable(driver, food, 25).click();
                return;
            }
        }

        throw new RuntimeException("Popular food not found: " + foodName);
    }

    // Selects boarding date using JavaScript (bypassing UI limitations)
    public void selectBoardingDate(String date) {

        WebElement dateField = util.waitForPresence(driver, boardingDateLocator, 25);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
            "var nativeInputValueSetter = Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype,'value').set;" +
            "nativeInputValueSetter.call(arguments[0], arguments[1]);" +
            "arguments[0].dispatchEvent(new Event('input',{bubbles:true}));" +
            "arguments[0].dispatchEvent(new Event('change',{bubbles:true}));",
            dateField, date
        );
    }

    // Selects a valid boarding station from dropdown
    public void selectBoardingStation() {

        WebElement dropdown = util.waitForPresence(driver, boardingStationDropdownLocator, 25);

        ((JavascriptExecutor) driver)
            .executeScript("arguments[0].scrollIntoView(true);", dropdown);

        ((JavascriptExecutor) driver)
            .executeScript("arguments[0].click();", dropdown);

        // Custom wait for dropdown options to load
        new WebDriverWait(driver, Duration.ofSeconds(25)).until((WebDriver d) -> {
            Select select = new Select(d.findElement(boardingStationDropdownLocator));
            return select.getOptions().size() > 1;
        });

        Select select = new Select(
            util.waitForPresence(driver, boardingStationDropdownLocator, 25)
        );

        for (WebElement option : select.getOptions()) {

            String text = option.getText().trim();

            if (!text.equalsIgnoreCase("Boarding Station") && !text.isEmpty()) {
                select.selectByVisibleText(text);
                System.out.println("Selected Boarding Station: " + text);
                return;
            }
        }

        throw new RuntimeException("No valid boarding station available");
    }

    // Returns "No Results" header text
    public String getNoResultsHeaderText() {
        return util.waitForVisibility(driver, noResultsHeaderLocator, 25).getText().trim();
    }

    // Returns "No Results" sub text
    public String getNoResultsSubText() {
        return util.waitForVisibility(driver, noResultsSubTextLocator, 25).getText().trim();
    }

    // Clicks on Find Food button
    public void clickOnFindFoodBtn() {
        util.waitForRefreshedClickable(driver, findFoodBtnLocator, 25).click();
    }

    // Verifies whether boarding station and date fields are enabled
    public boolean areBoardingAndDateFieldsEnabled() {
        try {
            WebElement boarding = util.waitForPresence(driver, boardingStationDropdownLocator, 25);
            WebElement date = util.waitForPresence(driver, boardingDateLocator, 25);

            return boarding.isEnabled() && date.isEnabled();

        } catch (Exception e) {
            return false;
        }
    }

    // Returns search box WebElement
    public WebElement getSearchBox() {
        return driver.findElement(searchBoxLocator);
    }
}