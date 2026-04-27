package com.redbus.testing.stepdefinition;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import com.redbus.testing.utilities.*;
import com.redbus.testing.utilities.Base;
import com.redbus.testing.utilities.Pages;

import io.cucumber.java.en.*;

public class BusPassengerSteps {

	private Base base;
	private AllUtilityFunction util;

	public BusPassengerSteps() {
		util = new AllUtilityFunction();
		util.init("BusTickets");
	}

	@Given("User is on passenger details page")
	public void user_is_on_passenger_details_page() throws InterruptedException {

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

		Pages.getInstance().busSeatSelectionPage.selectGeneralSeat();
		Pages.getInstance().busSeatSelectionPage.clickProceedButton();

		String boardingPoint = util.getData(1, 2);
		String droppingPoint = util.getData(1, 3);

		Pages.getInstance().busBoardDropPointPage.selectBoardingPoint(boardingPoint);
		Pages.getInstance().busBoardDropPointPage.selectDroppingPoint(droppingPoint);
	}

	@When("User enters basic passenger details")
	public void user_enters_basic_passenger_details(io.cucumber.datatable.DataTable dataTable) {

		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

		
		String phone = data.get(0).get("phone");
		String email = data.get(0).get("email");
		String state = data.get(0).get("state");

		Pages.getInstance().busPassengerInfoPage.enterPhone(phone);
		Pages.getInstance().busPassengerInfoPage.enterEmail(email);

		Pages.getInstance().busPassengerInfoPage.clickStateOfResidence();
		Pages.getInstance().busPassengerInfoPage.clickStateOfResidence(state);
		Pages.getInstance().busPassengerInfoPage.selectState(state);
	}

	@When("User enters personal details {string} {string} {string}")
	public void user_enters_personal_details(String name, String age, String gender) {

		Pages.getInstance().busPassengerInfoPage.enterName(name);
		Pages.getInstance().busPassengerInfoPage.enterAge(age);

		if (gender.equalsIgnoreCase("male")) {
			Pages.getInstance().busPassengerInfoPage.selectMale();
		} else if (gender.equalsIgnoreCase("female")) {
			Pages.getInstance().busPassengerInfoPage.selectFemale();
		}
		
		Pages.getInstance().busPassengerInfoPage.selectWithoutInsurance();
		Pages.getInstance().busPassengerInfoPage.clickContinueBooking();
		Pages.getInstance().busPassengerInfoPage.clickRemindMeLater();

	}

	@Then("User should see payment options")
	public void user_should_see_payment_options() throws InterruptedException {

		Pages.getInstance().busPaymentPage.clickPayByAnyUPIApp();
		String actualUPI = Pages.getInstance().busPaymentPage.verifyUPI();
		Assert.assertEquals(actualUPI, "Pay using QR code, scan it with any UPI App");
		System.out.println("UPI page displayed successfully ");
		Pages.getInstance().busPaymentPage.clickBackToAllPayment();

		String Price = Pages.getInstance().busPaymentPage.verifyPrice();
		System.out.println(Price);

	}
}