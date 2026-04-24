package com.redbus.testing.stepdefinition;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.redbus.testing.utilities.Base;
import com.redbus.testing.utilities.Pages;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class TrainTicket {
	@Given("the user is on the RedBus homepage")
    public void the_user_is_on_the_red_bus_homepage() {

        System.out.println("user is on homepage");
    }

	@When("the user navigates to train ticket booking page")
	public void the_user_navigates_to_train_ticket_booking_page() {

	    Base.getDriver().get("https://www.redbus.in/railways");
	}

    @When("user selects journey month {string} and day {string}")
    public void user_selects_journey_month_and_day(String month, String day) {

        Pages.getInstance().trainticketpage.openDatePicker();
        Pages.getInstance().trainticketpage.selectDate(month, day);
    }
//    @When("the user enters journey month {string} and day {string}")
//    public void the_user_enters_journey_month_and_day(String month, String day) {
//    	     Pages.Tt.openDatePicker();
//         Pages.Tt.selectDate(month, day);
//    }


//    @When("user enters source {string} and destination {string}")
//    public void user_enters_source_and_destination1(String source, String destination) throws InterruptedException {
//
//        Train.Tt.enterFrom(source);
//        Train.Tt.enterTo(destination);
//    }`
    @When("user enters source {string} and destination {string}")
    public void user_enters_source_and_destination(String source, String destination) throws InterruptedException {
    	Pages.getInstance().sourceCity = source;
    	Pages.getInstance().destinationCity = destination;

    	Pages.getInstance().trainticketpage.enterFrom(source);
    	Pages.getInstance().trainticketpage.enterTo(destination);
//      Pages.Tt.enterFrom(source);
//
//        //Thread.sleep(10000);
//    
//       Pages.Tt.enterTo(destination);
       
    }

    @When("user clicks on search trains")
    public void user_clicks_on_search_trains() {

    	Pages.getInstance().trainticketpage.clickSearch();
    }

    @Then("the train results should be displayed")
    public void the_train_results_should_be_displayed() throws InterruptedException {
    	Thread.sleep(2000);
    		Assert.assertTrue(Pages.getInstance().trainticketpage.getValidate().isDisplayed());
     
    }
    @Then("the system should show an error message for each combination")
    public void the_system_should_show_an_error_message_for_each_combination() {
    	
    	
    	 boolean hasError = Pages.getInstance().trainticketpage.isErrorDisplayed();
         Assert.assertTrue(hasError,
                 "Error should be displayed for same source and destination: "
                         + Pages.sourceCity + " -> " + Pages.destinationCity);
      
    }
   
    @When("user enters source and destination")
    public void user_enters_source_and_destination(DataTable dataTable) throws InterruptedException {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> row : data) {

            String source = row.get("source");
            String destination = row.get("destination");

            System.out.println("Testing: " + source + " -> " + destination);

            Pages.getInstance().trainticketpage.enterFrom(source);
            Pages.getInstance().trainticketpage.enterTo(destination);
        }
    }
}
