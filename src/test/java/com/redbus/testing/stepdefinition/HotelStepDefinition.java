package com.redbus.testing.stepdefinition;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.redbus.testing.utilities.AllUtilityFunction;
import com.redbus.testing.utilities.Base;
import com.redbus.testing.utilities.Pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HotelStepDefinition extends AllUtilityFunction{

	@Given("Open the Browser")
	public void open_the_browser() {
		System.out.println("Browser launched");
	}

	@Given("Navigate to RedBus Application {string}")
	public void navigate_to_red_bus_application(String url) throws Exception {
		
		Base.getDriver().get(url);
		System.out.println("Sucessfully navigated to redbus application");
	}

	@When("Click on Hotels tab")
	public void click_on_hotels_tab() {

		Pages.getInstance().dashboardPage.clickHotels();

		WebDriverWait wait = new WebDriverWait(Base.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlContains("hotels"));
	}

	@Then("Verify Hotels page is displayed")
	public void verify_hotels_page_is_displayed() throws Exception {

		Assert.assertTrue(Base.getDriver().getCurrentUrl().contains("hotels"));

		if (Base.getDriver().getCurrentUrl().contains("hotels")) {
			System.out.println("Hotels page navigation successful");
		} else {
			System.out.println("Navigation failed");
		}
	}

	@When("Click hotel card from Flash Deals section by index {string}")
	public void click_hotel_card_from_flash_deals_section_by_index(String index) throws Exception {

		Pages.getInstance().hotelsPage.clickFlashDealCard(Integer.parseInt(index));
	}

	@Then("Verify Download App popup is displayed")
	public void verify_download_app_popup_is_displayed() throws Exception {

		Thread.sleep(3000);

		Assert.assertTrue(Base.getDriver().getCurrentUrl().contains("download-app"));

		if (Base.getDriver().getCurrentUrl().contains("download-app")) {
			System.out.println("Popup displayed successfully");
		} else {
			System.out.println("Popup display failed");
		}
	}

	@When("Enter city name from excel sheet {string} row {int}")
	public void enter_city_name_from_excel_sheet_row(String sheetName, Integer rowNum) {

		init(sheetName);

		String cityName = getData(rowNum, 0);

		if (cityName == null || cityName.trim().isEmpty()) {
			throw new RuntimeException("Excel City Name is NULL or EMPTY");
		}

		Pages.getInstance().hotelsPage.selectCity(cityName);
	}

	@When("Select check-in and check-out dates from excel sheet {string} row {int}")
	public void select_check_in_and_check_out_dates_from_excel_sheet_row(String sheetName, Integer rowNum)
			throws Exception {

		init(sheetName);

		String checkInDate = getData(rowNum, 1);
		String checkOutDate = getData(rowNum, 2);

		if (checkInDate == null || checkInDate.trim().isEmpty()) {
			throw new RuntimeException("Excel CheckIn Date is NULL or EMPTY");
		}

		if (checkOutDate == null || checkOutDate.trim().isEmpty()) {
			throw new RuntimeException("Excel CheckOut Date is NULL or EMPTY");
		}

		Pages.getInstance().hotelsPage.selectCheckInAndCheckOutDate(checkInDate, checkOutDate);
	}

	@When("Click on rooms and guests field")
	public void click_on_rooms_and_guests_field() throws Exception {

		Pages.getInstance().hotelsPage.clickRoomsAndGuests();
	}

	@When("Select rooms count from excel sheet {string} row {int}")
	public void select_rooms_count_from_excel_sheet_row(String sheet, Integer row) throws InterruptedException {

		Pages.getInstance().hotelsPage.increaseRooms(2);
	}

	@When("Select adults count from excel sheet {string} row {int}")
	public void select_adults_count_from_excel_sheet_row(String sheet, Integer row) {

		Pages.getInstance().hotelsPage.increaseAdults(2);
	}

	@When("Add children count from excel sheet {string} row {int}")
	public void add_children_count_from_excel_sheet_row(String sheet, Integer row) {

		Pages.getInstance().hotelsPage.addChildren(1);
	}

	@When("Select child age from excel sheet {string} row {int}")
	public void select_child_age_from_excel_sheet_row(String sheet, Integer row) {

		Pages.getInstance().hotelsPage.clickChildField(0);
		Pages.getInstance().hotelsPage.getAgeOptions().get(2).click();
	}

	@When("Click on Search button")
	public void click_on_search_button() throws Exception {

		Base.getDriver().findElement(By.xpath("//button[contains(.,'Search')]")).click();
	}

	@Then("Verify hotel results page is displayed")
	public void verify_hotel_results_page_is_displayed() throws Exception {

		Assert.assertTrue(Pages.getInstance().hotelSearchResultsPage.isResultsPageDisplayed());
	}

	@Then("Verify searched city results are displayed")
	public void verify_searched_city_results_are_displayed() {
		
		Assert.assertTrue(Base.getDriver().getCurrentUrl().contains("hotels/search"));

		if (Base.getDriver().getCurrentUrl().contains("hotels/search")) {
			System.out.println("Hotels results page navigation successful");
		} else {
			System.out.println("Navigation failed");
		}
		
	}

	@Then("Verify child age selection validation message is displayed")
	public void verify_child_age_selection_validation_message_is_displayed() {

		Assert.assertTrue(
			Pages.getInstance().hotelsPage.isChildAgeValidationDisplayed());
	}
	
	@When("Apply hotel filters:")
	public void apply_hotel_filters(io.cucumber.datatable.DataTable dataTable) throws Exception {

	    List<Map<String, String>> filters = dataTable.asMaps(String.class, String.class);

	    for (Map<String, String> row : filters) {

	        String type = row.get("FilterType");
	        String value = row.get("FilterValue");

	        switch (type) {

	        case "Price":
	            Pages.getInstance().hotelSearchResultsPage.selectPriceFilter(value);
	            break;

	        case "Meal Preference":
	            Pages.getInstance().hotelSearchResultsPage.selectMealPreference(value);
	            break;

	        case "Customer Rating":
	            Pages.getInstance().hotelSearchResultsPage.selectCustomerRating(value);
	            break;

	        case "Star Rating":
	            Pages.getInstance().hotelSearchResultsPage.selectStarRating(value);
	            break;

	        case "Amenities":
	            Pages.getInstance().hotelSearchResultsPage.selectAmenity(value);
	            break;

	        case "Property Type":
	            Pages.getInstance().hotelSearchResultsPage.selectPropertyType(value);
	            break;
	        }
	    }
	}

	@Then("Verify Clear Filter button is displayed")
	public void verify_clear_filter_button_is_displayed() {

		Assert.assertTrue(Pages.getInstance().hotelSearchResultsPage.isClearFilterDisplayed());
	}
	
	@Then("Verify hotel results count and message behavior are correct")
	public void verify_hotel_results_count_and_message_behavior_are_correct() {

	    Assert.assertTrue(
	        Pages.getInstance().hotelSearchResultsPage.isResultsConsistent()
	    );
	}
}