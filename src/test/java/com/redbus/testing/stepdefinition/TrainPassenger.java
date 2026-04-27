package com.redbus.testing.stepdefinition;

import org.testng.Assert;

import com.redbus.testing.utilities.AllUtilityFunction;
import com.redbus.testing.utilities.Pages;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class TrainPassenger {
	@When("User selects a train")
	public void user_selects_a_train() throws InterruptedException {
	    Pages.getInstance().trainpassengerpage.cickTrain();
	}
	@When("User fills passenger details")
	public void user_fills_passenger_details() throws InterruptedException {

	    AllUtilityFunction util = new AllUtilityFunction();

	    // Sheet name from your Excel
	    util.init("passenger_data");

	    // Row 1 = first data row, because row 0 is header
	    String username = util.getData(1, 0);
	    String passengerName = util.getData(1, 1);
	    String age = util.getData(1, 2);
	    String email = util.getData(1, 3);
	    String phoneNumber = util.getData(1, 4).replace(".0", "").trim();

	    Thread.sleep(2000);
	    Pages.getInstance().trainpassengerpage.clickUserName();
	    Thread.sleep(3000);

	    Pages.getInstance().trainpassengerpage.enterName(username);
	    Thread.sleep(3000);

	    Pages.getInstance().trainpassengerpage.clickCheckUserName();
	    Thread.sleep(3000);

	    Pages.getInstance().trainpassengerpage.clickClose();
	    Thread.sleep(3000);

	    Pages.getInstance().trainpassengerpage.enterPassengerName(passengerName);
	    Pages.getInstance().trainpassengerpage.clickMale();
	    Pages.getInstance().trainpassengerpage.enterAge(age);
	    Thread.sleep(2000);

//	    Pages.TP.enterFood();

	    Pages.getInstance().trainpassengerpage.clickAddToPassenger();

	    Pages.getInstance().trainpassengerpage.enterEmail(email);
	    Thread.sleep(2000);
	    Pages.getInstance().trainpassengerpage.enterPhoneNumber(phoneNumber);


	    Pages.getInstance().trainpassengerpage.clickContinue();
	    Pages.getInstance().trainpassengerpage.clickContinueWithoutAdding();
	}
	@Then("User should see free cancellation popup")
	public void user_should_see_free_cancellation_popup() throws InterruptedException {
		Thread.sleep(7000);
	   String creditCard =Pages.getInstance().trainpassengerpage.verifyCredit(); 

	   Assert.assertEquals(creditCard, "Add credit/debit card");
	   System.out.println("CreditCard payment option displayed");

	}
}