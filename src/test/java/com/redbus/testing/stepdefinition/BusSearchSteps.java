package com.redbus.testing.stepdefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.RedBus.testing.utilities.AllUtilityFunction;
import com.RedBus.testing.utilities.Base;
import com.RedBus.testing.utilities.Pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BusSearchSteps {

	private Base base;
	private AllUtilityFunction util;

	public BusSearchSteps(Base base) {

		this.base = base;
		util = new AllUtilityFunction();
		util.init("Sheet1");
	}

	@Given("User is on the RedBus home page")
	public void user_is_on_the_red_bus_home_page() {

	}

	@When("User enters source")
	public void user_enters_source() throws InterruptedException {

		String source = util.getData(1, 0);
		Pages.getInstance().busSearchPage.enterFrom(source);
	}

	@When("User enters destination")
	public void user_enters_destination() throws InterruptedException {

		String destination = util.getData(1, 1);
		Pages.getInstance().busSearchPage.enterDestination(destination);
	}

	@When("User selects travel date")
	public void user_selects_travel_date() {

		Pages.getInstance().busSearchPage.clickDatePicker();
		String date = util.getData(1, 4);
		String month = util.getData(1, 5);
		Pages.getInstance().busSearchPage.selectDate(month, date);
	}

	@When("User clicks on search button")
	public void user_clicks_on_search_button() {
		Pages.getInstance().busSearchPage.clickSearch();
	}

	@Then("User should see list of available buses")
	public void user_should_see_list_of_available_buses() {
		int busList = Pages.getInstance().busSearchPage.getNumberOfBus();
		Assert.assertTrue(Pages.getInstance().busSearchPage.verifyBusList(), "Bus list is NOT displayed");
		System.out.println("Bus List shown");
		System.out.println("No. of Buses : " + busList);
	}
}