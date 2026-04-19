package com.redbus.testing.stepdefinition;

//import static org.junit.Assert.assertTrue;
import java.util.List;

import org.testng.Assert;

import com.redbus.testing.utilities.AllUtililtyFunction;
import com.redbus.testing.utilities.Pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FoodOrder {
	@Given("user is on the food ordering page")
	public void user_is_on_the_food_ordering_page() {
	    
	}
	@When("user enters data {string} in the search field")
	public void user_enters_in_the_search_field(String string) {
	    Pages.get().fp.enterSearchText(string);
	}
	@When("user selects {string} from the suggestions")
	public void user_selects_from_the_suggestions(String string) {
	    Pages.get().fp.clickOnSuggestion(string);
	}
	@Then("user should be navigated to the restaurant page")
	public void user_should_be_navigated_to_the_restaurant_page() {
	    
	}
	@Then("restaurant name {string} should be displayed")
	public void restaurant_name_should_be_displayed(String expected) {

	    String actual = Pages.get().rmp.getRestaurantName();
	    Assert.assertEquals(actual, expected, "Restaurant name mismatch");
	}
	
	@When("user enters partial data {string} in the search field")
	public void user_enters_partial_data_in_the_search_field(String partialData) {
	    Pages.get().fp.enterSearchText(partialData);
	}
	@Then("suggestions should be displayed")
	public void suggestions_should_be_displayed() {

	    List<String> suggestions = Pages.get().fp.getAllSuggestions();
	    Assert.assertTrue(suggestions.size() > 0, "Suggestions are not displayed");
	}
	@Then("suggestions should contain {string}")
	public void suggestions_should_contain(String expected) {

	    List<String> suggestions = Pages.get().fp.getAllSuggestions();

	    boolean found = false;

	    for (String s : suggestions) {
	        if (s.equalsIgnoreCase(expected)) {
	            found = true;
	            break;
	        }
	    }

	    Assert.assertTrue(found, "Expected suggestion not found: " + expected);
	}
	
	@When("user clicks on {string} from Popular Foods section")
	public void user_clicks_on_from_popular_foods_section(String popularFood) {
		Pages.get().fp.clickSearchField();
	    Pages.get().fp.clickOnPopularFood(popularFood);
	}
	@Then("user should be navigated to the restaurant listing page")
	public void user_should_be_navigated_to_the_restaurant_listing_page() {
	    
	}
	@Then("restaurant list should be displayed")
	public void restaurant_list_should_be_displayed() {

	    Assert.assertTrue(
	        Pages.get().pp.isRestaurantListVisible(),
	        "Restaurant list not visible"
	    );
	}
	
	@When("user searches train number {string}")
	public void user_searches_train_number(String trainNO) {
	   Pages.get().fp.enterSearchText(trainNO);
	}
	@When("user selects train {string} from suggestions")
	public void user_selects_train_from_suggestions(String trainName) {
	    Pages.get().fp.clickOnSuggestion(trainName);
	}
	@Then("boarding station and date fields should be enabled")
	public void boarding_station_and_date_fields_should_be_enabled() {
	    
	}
	@When("user selects valid boarding date {string}")
	public void user_selects_valid_boarding_date(String trainDate) {
	    Pages.get().fp.selectBoardingDate(trainDate);
	}
	@When("user selects valid boarding station")
	public void user_selects_valid_boarding_station() throws InterruptedException {
	    Pages.get().fp.selectBoardingStation();
	}
	@When("user clicks on Find Food button")
	public void user_clicks_on_find_food_button() {
	    Pages.get().fp.clickOnFindFoodBtn();
	}
	@Then("user is navigated to train restaurant results page")
	public void user_is_navigated_to_train_restaurant_results_page() {
	    
	}
	@Then("restaurant list should be visible")
	public void restaurant_list_should_be_visible() {

	    Assert.assertTrue(
	        Pages.get().tp.isRestaurantListDisplayed(),
	        "Train restaurant list not visible"
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
		    Pages.get().fp.enterSearchText(restaurantName);
		    Pages.get().fp.clickOnSuggestion(restaurantName);
	}
	@Then("user should be navigated to that restaurant menu page")
	public void user_should_be_navigated_to_that_restaurant_menu_page() {
	    
	}
	@Then("user checks whether dish is present in the menu")
	public void user_checks_whether_dish_is_present_in_the_menu() {
		 AllUtililtyFunction excel = new AllUtililtyFunction();

		    excel.initExcel("src/test/resources/Readers/Config.xlsx", "DishData");

		    int rowCount = excel.getRowCount();

		    for (int i = 1; i < rowCount; i++) {

		        String dishName = excel.getCellData(i, 1);

		        boolean isPresent = Pages.get().rmp.isDishPresent(dishName);

		        Assert.assertTrue(isPresent, "Dish not found: " + dishName);

		        System.out.println("Verified dish: " + dishName);
		    }
	}
	
	@When("user enters invalid data {string} in the search field")
	public void user_enters_invalid_data_in_the_search_field(String invalidData) {
	   Pages.get().fp.enterSearchText(invalidData);
	}
	@When("user clicks search button")
	public void user_clicks_search_button() {
	    
	}
	@Then("no results message should be displayed")
	public void no_results_message_should_be_displayed() {

	    String header = Pages.get().fp.getNoResultsHeaderText();
	    String subText = Pages.get().fp.getNoResultsSubText();

	    Assert.assertTrue(
	        header.contains("No results"),
	        "Header text is incorrect: " + header
	    );

	    Assert.assertTrue(
	        subText.contains("Please try again"),
	        "Subtext is incorrect: " + subText
	    );
	}

}
