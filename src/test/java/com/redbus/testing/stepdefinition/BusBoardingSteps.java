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
		util.initExcel("src\\test\\resources\\Reader\\config.xlsx", "BusSearch");
	}

	@Given("User has selected seat")
	public void user_has_selected_seat() throws InterruptedException {

		String source = util.getCellData(1, 0);
		String destination = util.getCellData(1, 1);

		Pages.busSearchPage.enterFrom(source);
		Pages.busSearchPage.enterDestination(destination);
		Pages.busSearchPage.clickDatePicker();
		Pages.busSearchPage.clickDate();
		Pages.busSearchPage.clickSearch();

		Pages.busSelectionPage.clickFlixBus();
		Pages.busSelectionPage.clickBookNow();
		Pages.busSelectionPage.clickViewSeats();

		Pages.busSeatSelectionPage.clickLowerDeckSeat();
		Pages.busSeatSelectionPage.clickProceedButton();
	}

	@When("User selects boarding point")
	public void user_selects_boarding_point() {
		String boardingPoint = util.getCellData(1, 2);

		Pages.busBoardDropPointPage.selectBoardingPoint(boardingPoint);
	}

	@When("User selects dropping point")
	public void user_selects_dropping_point() {
		String droppingpoint = util.getCellData(1, 3);

		Pages.busBoardDropPointPage.selectDroppingPoint(droppingpoint); 
	}

	@When("User clicks on continue")
	public void user_clicks_on_continue() {

//        Pages.busBoardDropPointPage.clickNavigateToPassengerInfo(); 
	}

	@Then("User should move to passenger details page")
	public void user_should_move_to_passenger_details_page() {

		String actual = Pages.busBoardDropPointPage.getVerifyPassngerInfoPage();
		String expected = "Contact details";

		Assert.assertEquals(actual, expected);
		System.out.println("Navigated To Passenger Info Page");
	}
}