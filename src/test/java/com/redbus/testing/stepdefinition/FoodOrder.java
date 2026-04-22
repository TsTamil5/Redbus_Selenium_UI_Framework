package com.redbus.testing.stepdefinition;

//import static org.junit.Assert.assertTrue;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.redbus.testing.utilities.AllUtililtyFunction;
import com.redbus.testing.utilities.AllUtilityFunction;
import com.redbus.testing.utilities.Base;
import com.redbus.testing.utilities.Pages;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FoodOrder {
	@Given("user is on the food ordering page")
	public void user_is_on_the_food_ordering_page() {
		Assert.assertTrue(
			    Base.getDriver().getCurrentUrl().contains("ecatering"),
			    "User is not on food ordering page"
			);
	}
	@When("user enters data {string} in the search field")
	public void user_enters_in_the_search_field(String string) {
	    Pages.getInstance().fp.enterSearchText(string);
	}
	@When("user selects {string} from the suggestions")
	public void user_selects_from_the_suggestions(String string) {
	    Pages.getInstance().fp.clickOnSuggestion(string);
	}
	@Then("user should be navigated to the restaurant page")
	public void user_should_be_navigated_to_the_restaurant_page() {
		String name = Pages.getInstance().rmp.getRestaurantName();

		Assert.assertNotNull(name, "Restaurant page not loaded");
		Assert.assertFalse(name.isEmpty(), "Restaurant name is empty");
	}
	@Then("restaurant name {string} should be displayed")
	public void restaurant_name_should_be_displayed(String expected) {

	    String actual = Pages.getInstance().rmp.getRestaurantName();
	    Assert.assertEquals(actual, expected, "Restaurant name mismatch");
	}
	
	@When("user enters partial data and validates suggestions")
	public void user_enters_partial_data_and_validates_suggestions(DataTable dataTable) {

	    List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
	    Pages.getInstance().fp.clickSearchField();
	    for (Map<String, String> row : data) {

	        String input = row.get("input");
	        String expected = row.get("expected");

	        // Enter text
	        Pages.getInstance().fp.enterDataForDatatable(expected);

	        // Get suggestions
	        List<String> suggestions = Pages.getInstance().fp.getAllSuggestions();

	        // Validate suggestions displayed
	        Assert.assertTrue(suggestions.size() > 0, "No suggestions displayed for input: " + input);

	        // Validate expected item present
	        boolean found = suggestions.stream()
	                .anyMatch(s -> s.equalsIgnoreCase(expected));

	        Assert.assertTrue(found, "Expected suggestion not found: " + expected);

	        // Clear field for next iteration
	        Pages.getInstance().fp.getSearchBox().clear();
	    }
	}
	
	@When("user clicks on {string} from Popular Foods section")
	public void user_clicks_on_from_popular_foods_section(String popularFood) {
		Pages.getInstance().fp.clickSearchField();
	    Pages.getInstance().fp.clickOnPopularFood(popularFood);
	}
	@Then("restaurant listing page should be displayed")
	public void restaurant_listing_page_should_be_displayed() {

	    Assert.assertTrue(
	        Pages.getInstance().pp.isRestaurantListVisible(),
	        "Restaurant listing page not displayed"
	    );
	}
	
	@When("user searches train number {string}")
	public void user_searches_train_number(String trainNO) {
	   Pages.getInstance().fp.enterSearchText(trainNO);
	}
	@When("user selects train {string} from suggestions")
	public void user_selects_train_from_suggestions(String trainName) {
	    Pages.getInstance().fp.clickOnSuggestion(trainName);
	}
	@Then("boarding station and date fields should be enabled")
	public void boarding_station_and_date_fields_should_be_enabled() {

	    Assert.assertTrue(
	        Pages.getInstance().fp.areBoardingAndDateFieldsEnabled(),
	        "Boarding station or date field is not enabled"
	    );
	}
	@When("user selects valid boarding date {string}")
	public void user_selects_valid_boarding_date(String trainDate) {
	    Pages.getInstance().fp.selectBoardingDate(trainDate);
	}
	@When("user selects valid boarding station")
	public void user_selects_valid_boarding_station() throws InterruptedException {
	    Pages.getInstance().fp.selectBoardingStation();
	}
	@When("user clicks on Find Food button")
	public void user_clicks_on_find_food_button() {
	    Pages.getInstance().fp.clickOnFindFoodBtn();
	}
	@Then("train restaurant results page should be displayed")
	public void train_restaurant_results_page_should_be_displayed() {

	    Assert.assertTrue(
	        Pages.getInstance().tp.isRestaurantListDisplayed(),
	        "Train restaurant results not displayed"
	    );
	}
	
	@When("user searches for restaurant name and selects it from suggestions")
	public void user_searches_for_restaurant_name_and_selects_it_from_suggestions() {
		 AllUtililtyFunction excel = new AllUtililtyFunction();

		    // Load Excel
		    excel.initExcel("src/test/resources/Readers/Config.xlsx", "DishData");

		    // Read restaurant name (row 1, col 0)
		    String restaurantName = excel.getCellData(1, 0);

		    // Use it
		    Pages.getInstance().fp.enterSearchText(restaurantName);
		    Pages.getInstance().fp.clickOnSuggestion(restaurantName);
	}
	@Then("user should be navigated to that restaurant menu page")
	public void user_should_be_navigated_to_that_restaurant_menu_page() {
		String name = Pages.getInstance().rmp.getRestaurantName();

		Assert.assertNotNull(name, "Menu page not loaded");
		Assert.assertFalse(name.isEmpty(), "Menu page invalid");
	}
	@Then("user checks whether dish is present in the menu")
	public void user_checks_whether_dish_is_present_in_the_menu() {
		 AllUtilityFunction excel = new AllUtilityFunction();

		    excel.init("DishData");

		    int rowCount = excel.getNumberOfRows();

		    for (int i = 1; i < rowCount; i++) {

		        String dishName = excel.getData(i, 1);

		        boolean isPresent = Pages.getInstance().rmp.isDishPresent(dishName);

		        Assert.assertTrue(isPresent, "Dish not found: " + dishName);

		        System.out.println("Verified dish: " + dishName);
		    }
	}
	
	@When("user enters invalid data {string} in the search field")
	public void user_enters_invalid_data_in_the_search_field(String invalidData) {
	   Pages.getInstance().fp.enterSearchText(invalidData);
	}

	@Then("no results message should be displayed")
	public void no_results_message_should_be_displayed() {

	    String header = Pages.getInstance().fp.getNoResultsHeaderText();
	    String subText = Pages.getInstance().fp.getNoResultsSubText();

	    Assert.assertTrue(
	        header.contains("No results"),
	        "Header text is incorrect: " + header
	    );

	    Assert.assertTrue(
	        subText.contains("Please try again"),
	        "Subtext is incorrect: " + subText
	    );
	}
	
	@When("user enters invalid data {string}")
	public void user_enters_invalid_data(String data) {
	    Pages.getInstance().fp.enterSearchText(data);
	}
	@Then("no results found message has to be displayed")
	public void no_results_found_message_has_to_be_displayed() {
		int count = Pages.getInstance().fp.getSuggestionCount();
		Assert.assertEquals(count, 0, "Defect: Suggestions are displayed for invalid input");
	}

}
