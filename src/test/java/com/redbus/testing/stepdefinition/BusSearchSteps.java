package com.redbus.testing.stepdefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.redbus.testing.utilities.AllUtilityFunction;
import com.redbus.testing.utilities.Base;
import com.redbus.testing.utilities.Pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BusSearchSteps {

	private Base base;
	private AllUtilityFunction util;

	public BusSearchSteps(Base base) {

		this.base = base;
		util = new AllUtilityFunction();
		util.initExcel("F:\\Seleniumm training\\RedBusTesting\\src\\test\\resources\\Reader\\config.xlsx", "BusSearch");
	}

	@Given("User is on the RedBus home page")
	public void user_is_on_the_red_bus_home_page() {
	}

	@When("User enters source")
	public void user_enters_source() throws InterruptedException {

		String source = util.getCellData(1, 0);
		Pages.busSearchPage.enterFrom(source);
	}

	@When("User enters destination")
	public void user_enters_destination() throws InterruptedException {

		String destination = util.getCellData(1, 1);
		Pages.busSearchPage.enterDestination(destination);
	}

	@When("User selects travel date")
	public void user_selects_travel_date() {

		Pages.busSearchPage.clickDatePicker();
		Pages.busSearchPage.clickDate();
	}

	@When("User clicks on search button")
	public void user_clicks_on_search_button() {
		Pages.busSearchPage.clickSearch();
	}

	@Then("User should see list of available buses")
	public void user_should_see_list_of_available_buses() {

		String actual = Pages.busSearchPage.verifyBusListShown();
		String expected = "Filter buses";

		Assert.assertEquals(actual, expected);
		System.out.println("Bus List shown");
	}
}