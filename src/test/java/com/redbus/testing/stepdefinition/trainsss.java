package com.redbus.testing.stepdefinition;

import org.openqa.selenium.By;

import com.redbus.testing.utilities.Base;
import com.redbus.testing.utilities.Pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class trainsss {

	 @Given("the user is on the RedBus homepage")
	    public void the_user_is_on_the_RedBus_homepage() {
	        // handled in Hook
	    }

	    @When("the user navigates to train ticket booking page")
	    public void the_user_navigates_to_train_ticket_booking_page() {
	        //Pages..clickTrainsTab(); // implement in POM
	    }

	    @When("user selects journey month {string} and day {string}")
	    public void user_selects_journey_month_and_day(String month, String day) {
	        Pages.trainTicket.openDatePicker();
	        Pages.trainTicket.selectDate(month, day);
	    }

	    @When("user enters source {string} and destination {string}")
	    public void user_enters_source_and_destination(String source, String destination) throws InterruptedException {
	        Pages.trainTicket.enterFrom(source);
	        Pages.trainTicket.enterTo(destination);
	    }

	    @When("user clicks on search trains")
	    public void user_clicks_on_search_trains() {
	        Pages.trainTicket.clickSearch();
	    }

	    @Then("the train results should be displayed")
	    public void the_train_results_should_be_displayed() {

	        boolean resultVisible = Base.driver
	                .findElements(By.xpath("//div[contains(@class,'train')]"))
	                .size() > 0;

	        if (resultVisible) {
	            System.out.println("✅ Train results displayed");
	        } else {
	            System.out.println("❌ Train results not displayed");
	        }
	    }
}
