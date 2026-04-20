package com.redbus.testing.stepdefinition;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.redbus.testing.utilities.AllUtilityFunction;
import com.redbus.testing.utilities.Base;
import com.redbus.testing.utilities.Pages;

import io.cucumber.java.en.*;

public class BusPassengerSteps {

	private Base base;
	private AllUtilityFunction util;

	public BusPassengerSteps(Base base) {
		this.base = base;

		util = new AllUtilityFunction();
		util.initExcel("src\\test\\resources\\Reader\\config.xlsx", "BusSearch");
	}

	@Given("User is on passenger details page")
	public void user_is_on_passenger_details_page() throws InterruptedException {

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

//		Pages.busSeatSelectionPage.clickLowerDeckSeat();
//		Pages.busSeatSelectionPage.clickUpperDeckSeat();
		Pages.busSeatSelectionPage.selectGeneralSeat();
		Pages.busSeatSelectionPage.clickProceedButton();

		String boardingPoint = util.getCellData(1, 2);
		String droppingPoint = util.getCellData(1, 3);

		Pages.busBoardDropPointPage.selectBoardingPoint(boardingPoint);
		Pages.busBoardDropPointPage.selectDroppingPoint(droppingPoint);
	}

	@When("User enters basic passenger details")
	public void user_enters_basic_passenger_details(io.cucumber.datatable.DataTable dataTable) {

		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

		String phone = data.get(0).get("phone");
		String email = data.get(0).get("email");
		String state = data.get(0).get("state");

		Pages.busPassengerInfoPage.enterPhone(phone);
		Pages.busPassengerInfoPage.enterEmail(email);

		Pages.busPassengerInfoPage.clickStateOfResidence();
		Pages.busPassengerInfoPage.clickStateOfResidence(state);
		Pages.busPassengerInfoPage.clickChooseState();
	}

	@When("User enters personal details {string} {string} {string}")
	public void user_enters_personal_details(String name, String age, String gender) {

		Pages.busPassengerInfoPage.enterName(name);
		Pages.busPassengerInfoPage.enterAge(age);

		if (gender.equalsIgnoreCase("male")) {
			Pages.busPassengerInfoPage.selectMale();
		} else if (gender.equalsIgnoreCase("female")) {
			Pages.busPassengerInfoPage.selectFemale();

		}
		Pages.busPassengerInfoPage.selectWithoutInsurance();
		Pages.busPassengerInfoPage.clickContinueBooking();

	}

	@Then("User should see payment options")
	public void user_should_see_payment_options() throws InterruptedException {
		
		Pages.busPaymentPage.clickPayByAnyUPIApp();
		String actualUPI = Pages.busPaymentPage.verifyUPI();
		Assert.assertEquals(actualUPI, "Pay using QR code, scan it with any UPI App");
		System.out.println("UPI page displayed successfully ");
		Pages.busPaymentPage.clickBackToAllPayment();
		
		String actualCredit = Pages.busPaymentPage.verifyCreditCard();
		Assert.assertEquals(actualCredit, "Add credit/debit card");
		System.out.println("Credit Card Details Page Displayed ");

		String Price = Pages.busPaymentPage.verifyPrice();
		System.out.println(Price);

		
	
	}
}