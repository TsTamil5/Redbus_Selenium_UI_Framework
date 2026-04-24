package com.redbus.testing.stepdefinition;



import org.testng.Assert;

import com.redbus.testing.utilities.Pages;

import io.cucumber.java.en.*;


public class ViewResult {

    @Given("User enters {string} as source and {string} as destination on {string} {string}")
    public void user_enters_as_source_and_as_destination_on(String source, String destination, String month, String day) throws InterruptedException {

    	Pages.getInstance().trainticketpage.openDatePicker();
    	Pages.getInstance().trainticketpage.selectDate(month, day);
    	Pages.getInstance().trainticketpage.enterFrom(source);
    	Pages.getInstance().trainticketpage.enterTo(destination);
    }

    @When("User clicks on search trains")
    public void user_clicks_on_search_trains() {
    	Pages.getInstance().trainticketpage.clickSearch();
    }

    @Then("User should see train results")
    public void user_should_see_train_results() {
        Assert.assertTrue(Pages.getInstance().viewresultpage.isFilterDisplayed(),
                "❌ Filter Results header is NOT displayed");
    }

    @When("User verifies {string} as source and {string} as destination on {string} {string}")
    public void user_verifies_as_source_and_as_destination_on(String source, String destination, String month, String day) throws InterruptedException {

    	Pages.getInstance().viewresultpage.senddest(destination);
        Thread.sleep(2000);
        Pages.getInstance().viewresultpage.openDatePicker();
    }

    @When("User clicks on search trains again")
    public void user_clicks_on_search_trains_again() {
    	Pages.getInstance().viewresultpage.clickSearch();

        try {
            Thread.sleep(3000); // allow reload
        } catch (Exception e) {}
    }

    @Then("User should see updated train results")
    public void user_should_see_updated_train_results() {

        Assert.assertTrue(Pages.getInstance().viewresultpage.isTrainCountAboveZero());
    }
}
