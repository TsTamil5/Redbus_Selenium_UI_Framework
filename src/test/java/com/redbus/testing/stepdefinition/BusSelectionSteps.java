package com.redbus.testing.stepdefinition;

import org.testng.Assert;
import com.RedBus.testing.utilities.AllUtilityFunction;
import com.RedBus.testing.utilities.Base;
import com.RedBus.testing.utilities.Pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BusSelectionSteps {

	private Base base;
	private AllUtilityFunction util;

	public BusSelectionSteps(Base base) {
		this.base = base;

		util = new AllUtilityFunction();
		util.init("Sheet1");
	}

	@Given("User searches buses")
	public void user_searches_buses() throws InterruptedException {

		String source = util.getData(1, 0);
		String destination = util.getData(1, 1);

		Pages.getInstance().busSearchPage.enterFrom(source);
		Pages.getInstance().busSearchPage.enterDestination(destination);
		Pages.getInstance().busSearchPage.clickDatePicker();
		String date = util.getData(1, 4);
		String month = util.getData(1, 5);
		Pages.getInstance().busSearchPage.selectDate(month, date);
		Pages.getInstance().busSearchPage.clickSearch();
	}

	@When("User selects FlixBus and route")
	public void user_selects_flix_bus_and_route() {
		Pages.getInstance().busSelectionPage.clickFlixBus();
		Pages.getInstance().busSelectionPage.clickBookNow();
		Pages.getInstance().busSelectionPage.clickViewSeats();
	}

	@When("User selects an available seat")
	public void user_selects_an_available_seat() {
		Pages.getInstance().busSeatSelectionPage.clickLowerDeckSeat();
	}

	@When("User clicks on proceed button")
	public void user_clicks_on_proceed_button() {
		Pages.getInstance().busSeatSelectionPage.clickProceedButton();
	}

	@Then("User should move to boarding and dropping page")
	public void user_should_move_to_boarding_and_dropping_page() {

		String actual = Pages.getInstance().busSeatSelectionPage.verifyBoardingPoint();
		String expected = "Boarding points";

		Assert.assertEquals(actual, expected);
		System.out.println("Navigated to Boarding point");
	}
}