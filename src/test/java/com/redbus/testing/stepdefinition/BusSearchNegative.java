package com.redbus.testing.stepdefinition;

import org.testng.Assert;

import com.redbus.testing.utilities.Pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BusSearchNegative {

	@Given("User is on the RedBus homepage")
	public void user_is_on_the_red_bus_homepage() {
	    // No need to open browser here (already in Hooks)
	}
	
	
    @When("User clicks on search button without entering source and destination")
    public void user_clicks_on_search_without_data() {
        Pages.getInstance().busSearchPage.clickSearch();
    }

	@Then("User should see validation error message")
    public void user_should_see_validation_error_message() {
        String actualMessage = Pages.getInstance().busSearchPage.getValidationMessage();
        Assert.assertTrue(actualMessage.contains("Please enter"), "Validation message not displayed");
    }

   
}