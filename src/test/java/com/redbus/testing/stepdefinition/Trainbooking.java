package com.redbus.testing.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.redbus.testing.utilities.Pages;

import io.cucumber.java.en.*;


public class Trainbooking {

    // ❌ REMOVE WebDriver driver;

    @Given("the user is on the RedBus homepage")
    public void the_user_is_on_the_red_bus_homepage() {

        // ❌ DO NOT create driver here
        // Hook already did everything

        // Optional (already opened in Hook)
        // Train.Tt.openUrl();
    }

    @When("the user navigates to train ticket booking page")
    public void the_user_navigates_to_train_ticket_booking_page() {
        // already handled
    }

    @When("user selects journey month {string} and day {string}")
    public void user_selects_journey_month_and_day(String month, String day) {

        Pages.Tt.openDatePicker();
        Pages.Tt.selectDate(month, day);
    }

//    @When("user enters source {string} and destination {string}")
//    public void user_enters_source_and_destination(String source, String destination) throws InterruptedException {
//
//        Train.Tt.enterFrom(source);
//        Train.Tt.enterTo(destination);
//    }
    @When("user enters source {string} and destination {string}")
    public void user_enters_source_and_destination(String source, String destination) throws InterruptedException {
  
        Pages.Tt.enterFrom(source);

   //Thread.sleep(10000);
    
       Pages.Tt.enterTo(destination);
       
    }

    @When("user clicks on search trains")
    public void user_clicks_on_search_trains() {

        Pages.Tt.clickSearch();
    }

    @Then("the train results should be displayed")
    public void the_train_results_should_be_displayed() {

        if (Hook.getDriver().getCurrentUrl().contains("trains")) {
            System.out.println("✅ Train results displayed");
        } else {
            System.out.println("❌ Train results not displayed");
        }
    }
}