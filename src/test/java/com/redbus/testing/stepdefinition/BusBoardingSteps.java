package com.redbus.testing.stepdefinition;

import org.testng.Assert;

import com.redbus.testing.utilities.AllUtilityFunction;
import com.redbus.testing.utilities.Base;
import com.redbus.testing.utilities.Pages;

import io.cucumber.java.en.*;

public class BusBoardingSteps {

	private Base base;
	private AllUtilityFunction util;

	public BusBoardingSteps(Base base) {
		this.base = base;

		util = new AllUtilityFunction();
		util.init("BusTickets");
	}

	@Given("User has selected seat")
	public void user_has_selected_seat() throws InterruptedException {

		String source = util.getData(1, 0);
		String destination = util.getData(1, 1);

		Pages.getInstance().busSearchPage.enterFrom(source);
		Pages.getInstance().busSearchPage.enterDestination(destination);
		Pages.getInstance().busSearchPage.clickDatePicker();

		String date = util.getData(1, 4);
		String month = util.getData(1, 5);
		Pages.getInstance().busSearchPage.selectDate(month, date);
		Pages.getInstance().busSearchPage.clickSearch();

		Pages.getInstance().busSelectionPage.clickFlixBus();
		Pages.getInstance().busSelectionPage.clickBookNow();
		Pages.getInstance().busSelectionPage.clickViewSeats();

		Pages.getInstance().busSeatSelectionPage.selectAnyAvailableSeat();
		Pages.getInstance().busSeatSelectionPage.clickProceedButton();

	}

	@When("User selects boarding point")
	public void user_selects_boarding_point() {
		String boardingPoint = util.getData(1, 2);

		Pages.getInstance().busBoardDropPointPage.selectBoardingPoint(boardingPoint);
	}

	@When("User selects dropping point")
	public void user_selects_dropping_point() {
		String droppingpoint = util.getData(1, 3);

		Pages.getInstance().busBoardDropPointPage.selectDroppingPoint(droppingpoint);
	}

	@When("User clicks on continue")
	public void user_clicks_on_continue() {
		System.out.println("User navigated to Passenger Page");

	}

	@Then("User should move to passenger details page")
	public void user_should_move_to_passenger_details_page() {

		String actual = Pages.getInstance().busBoardDropPointPage.getVerifyPassngerInfoPage();
		String expected = "Contact details";

		Assert.assertEquals(actual, expected);
		System.out.println("Navigated To Passenger Info Page");
	}
}