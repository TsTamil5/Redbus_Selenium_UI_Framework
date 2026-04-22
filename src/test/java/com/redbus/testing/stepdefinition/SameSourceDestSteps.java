package com.redbus.testing.stepdefinition;

import org.testng.Assert;

import com.redbus.testing.utilities.Pages;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SameSourceDestSteps {

	@When("the user enters source {string}")
	public void user_enters_source(String source) throws InterruptedException {

		Pages.getInstance().busSearchPage.enterFrom(source);
	}

	@When("the user enters destination {string}")
	public void user_enters_destination(String destination) throws InterruptedException {

		Pages.getInstance().busSearchPage.enterDestination(destination);
	}

	@When("the user clicks on search buses")
	public void user_clicks_search_buses() {
		Pages.getInstance().busSearchPage.clickDatePicker();
		Pages.getInstance().busSearchPage.clickDate();
		Pages.getInstance().busSearchPage.clickSearch();
	}

	@Then("the error message {string} should be displayed")
	public void error_message_should_be_displayed(String expectedMessage) {
		String message = Pages.getInstance().busSearchPage.getErrorMessage();
//		Assert.fail();
		Assert.assertEquals(message, "Source and Destination city cannot be same");
		System.out.println("Validation message Displayed");
	}
}