package com.redbus.testing.stepdefinition;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.redbus.testing.utilities.Base;
import com.redbus.testing.utilities.Pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HotelsStepDefinition {

	@Given("Open the Browser")
	public void open_the_browser() {

		// Browser already launched from Hooks.java
		System.out.println("Browser launched from Hooks");
	}

	@Given("Navigate to RedBus Application {string}")
	public void navigate_to_red_bus_application(String url) throws Exception {

		Base.driver.get(url);
		Thread.sleep(3000);
	}

	@When("Click on Hotels tab")
	public void click_on_hotels_tab() throws Exception {

		Thread.sleep(3000);
		Pages.dashboardPage.clickHotels();
		Thread.sleep(3000);
	}

	@Then("Verify Hotels page is displayed")
	public void verify_hotels_page_is_displayed() throws Exception {

		Thread.sleep(3000);

		Assert.assertTrue(Base.driver.getCurrentUrl().contains("hotels"));

		if (Base.driver.getCurrentUrl().contains("hotels")) {
			System.out.println("Hotels page navigation successful");
		} else {
			System.out.println("Navigation failed");
		}
	}

	@When("Click hotel card from Flash Deals section by index {string}")
	public void click_hotel_card_from_flash_deals_section_by_index(String index) throws Exception {

		Thread.sleep(3000);
		Pages.hotelsPage.clickFlashDealCard(Integer.parseInt(index));
	}

	@Then("Verify Download App popup is displayed")
	public void verify_download_app_popup_is_displayed() throws Exception {

		Thread.sleep(3000);

		Assert.assertTrue(Base.driver.getCurrentUrl().contains("download-app"));

		if (Base.driver.getCurrentUrl().contains("download-app")) {
			System.out.println("Popup displayed successfully");
		} else {
			System.out.println("Popup display failed");
		}
	}

	@When("Enter city name from excel sheet {string} row {int}")
	public void enter_city_name_from_excel_sheet_row(String sheet, Integer row) throws Exception {

		Pages.hotelsPage.selectCity("Chennai");
	}

	@When("Select check-in date from excel sheet {string} row {int}")
	public void select_check_in_date_from_excel_sheet_row(String sheet, Integer row) throws Exception {

		Thread.sleep(2000);
		Pages.hotelsPage.clickCheckIn();
	}

	@When("Select check-out date from excel sheet {string} row {int}")
	public void select_check_out_date_from_excel_sheet_row(String sheet, Integer row) throws Exception {

		Thread.sleep(2000);
		Pages.hotelsPage.clickCheckOut();
	}

	@When("Click on rooms and guests field")
	public void click_on_rooms_and_guests_field() throws Exception {

		Thread.sleep(2000);
		Pages.hotelsPage.clickRoomsAndGuests();
	}

	@When("Select rooms count from excel sheet {string} row {int}")
	public void select_rooms_count_from_excel_sheet_row(String sheet, Integer row) {

		Pages.hotelsPage.increaseRooms(2);
	}

	@When("Select adults count from excel sheet {string} row {int}")
	public void select_adults_count_from_excel_sheet_row(String sheet, Integer row) {

		Pages.hotelsPage.increaseAdults(2);
	}

	@When("Add children count from excel sheet {string} row {int}")
	public void add_children_count_from_excel_sheet_row(String sheet, Integer row) {

		Pages.hotelsPage.addChildren(1);
	}

	@When("Select child age from excel sheet {string} row {int}")
	public void select_child_age_from_excel_sheet_row(String sheet, Integer row) {

		Pages.hotelsPage.clickChildField(0);
		Pages.hotelsPage.getAgeOptions().get(2).click();
	}

	@When("Click on Search button")
	public void click_on_search_button() throws Exception {

		Thread.sleep(2000);
		Base.driver.findElement(By.xpath("//button[contains(.,'Search')]")).click();
	}

	@Then("Verify hotel results page is displayed")
	public void verify_hotel_results_page_is_displayed() throws Exception {

		Thread.sleep(4000);
		Assert.assertTrue(Pages.hotelSearchResultsPage.isResultsPageDisplayed());
	}

	@Then("Verify searched city results are displayed")
	public void verify_searched_city_results_are_displayed() {

		Assert.assertTrue(Pages.hotelSearchResultsPage.getHotelCardsCount() > 0);
	}

	@Then("Verify child age selection validation message is displayed")
	public void verify_child_age_selection_validation_message_is_displayed() {

		Assert.assertTrue(Base.driver.getPageSource().contains("Select child age"));
	}

	@When("Apply hotel filter {string} with value {string}")
	public void apply_hotel_filter_with_value(String type, String value) throws Exception {

		Thread.sleep(3000);

		switch (type) {

		case "Meal Preference":
			Pages.hotelSearchResultsPage.selectMealPreference(value);
			break;

		case "Customer Rating":
			Pages.hotelSearchResultsPage.selectCustomerRating(value);
			break;

		case "Star Rating":
			Pages.hotelSearchResultsPage.selectStarRating(value);
			break;

		case "Amenities":
			Pages.hotelSearchResultsPage.selectAmenity(value);
			break;

		case "Property Type":
			Pages.hotelSearchResultsPage.selectPropertyType(value);
			break;
		}
	}

	@Then("Verify Clear Filter button is displayed")
	public void verify_clear_filter_button_is_displayed() {

		Assert.assertTrue(Pages.hotelSearchResultsPage.isClearFilterDisplayed());
	}

	@Then("Verify property count mismatch bug is displayed")
	public void verify_property_count_mismatch_bug_is_displayed() {

		Assert.assertTrue(Pages.hotelSearchResultsPage.isPropertyCountMismatchBugDisplayed());
	}
}