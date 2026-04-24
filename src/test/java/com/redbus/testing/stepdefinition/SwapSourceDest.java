package com.redbus.testing.stepdefinition;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.redbus.testing.utilities.Pages;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SwapSourceDest {
	
	@When("the user enters source and destination")
	public void the_user_enters_source_and_destination(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {

	    List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

	    String source = data.get(0).get("source");
	    String destination = data.get(0).get("destination");

	    Pages.getInstance().busSearchPage.enterFrom(source);
	    Pages.getInstance().busSearchPage.enterDestination(destination);

	    System.out.println("Entered Source: " + source);
	    System.out.println("Entered Destination: " + destination);
	}

	@When("the user clicks on swap button")
	public void user_clicks_swap_button() {

		String sourceBefore = Pages.getInstance().busSearchPage.getFrom().getText();
		String destBefore = Pages.getInstance().busSearchPage.getDestination().getText();

		Pages.getInstance().busSearchPage.clickSwapSourceDest();

		String sourceAfter = Pages.getInstance().busSearchPage.getFrom().getText();
		String destAfter = Pages.getInstance().busSearchPage.getDestination().getText();

		Assert.assertEquals(sourceAfter, destBefore, "Source not swapped correctly");
		Assert.assertEquals(destAfter, sourceBefore, "Destination not swapped correctly");

		System.out.println("Swap functionality working correctly");
	}


	@Then("the bus list should be displayed")
	public void bus_list_should_be_displayed() {
		int busList = Pages.getInstance().busSearchPage.getNumberOfBus();
		Assert.assertTrue(Pages.getInstance().busSearchPage.verifyBusList(), "Bus list is NOT displayed");
		System.out.println("Bus List shown");
		System.out.println("No. of Buses : " + busList);
	}
}
