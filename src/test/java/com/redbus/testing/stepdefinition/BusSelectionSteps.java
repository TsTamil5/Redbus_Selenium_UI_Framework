package com.redbus.testing.stepdefinition;

import org.testng.Assert;

import com.redbus.testing.utilities.AllUtilityFunction;
import com.redbus.testing.utilities.Base;
import com.redbus.testing.utilities.Pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BusSelectionSteps {
	
	Hooks hook;

    private Base base;
    private AllUtilityFunction util;

    public BusSelectionSteps(Base base,Hooks hook) {
        this.base = base;
        this.hook=hook;
        util = new AllUtilityFunction();
        util.initExcel("src\\test\\resources\\Reader\\config.xlsx", "BusSearch");
    }

    @Given("User searches buses")
    public void user_searches_buses() throws InterruptedException {

        String source = util.getCellData(1, 0);
        String destination = util.getCellData(1, 1);

        Pages.busSearchPage.enterFrom(source);
        Pages.busSearchPage.enterDestination(destination);
        Pages.busSearchPage.clickDatePicker();
        Pages.busSearchPage.clickDate();
        Pages.busSearchPage.clickSearch();
    }

    @When("User selects FlixBus and route")
    public void user_selects_flix_bus_and_route() {
        Pages.busSelectionPage.clickFlixBus();
        Pages.busSelectionPage.clickBookNow();
        Pages.busSelectionPage.clickViewSeats();
    }

    @When("User selects an available seat")
    public void user_selects_an_available_seat() {
        Pages.busSeatSelectionPage.clickLowerDeckSeat();
    }

    @When("User clicks on proceed button")
    public void user_clicks_on_proceed_button() {		
       Pages.busSeatSelectionPage.clickProceedButton();
    }

    @Then("User should move to boarding and dropping page")
    public void user_should_move_to_boarding_and_dropping_page() {
    	
        String actual = Pages.busSeatSelectionPage.verifyBoardingPoint();
        String expected = "Boarding points";

        Assert.assertEquals(actual, expected);
        System.out.println("Navigated to Boarding point");
    }
}