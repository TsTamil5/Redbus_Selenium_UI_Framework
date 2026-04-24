package com.redbus.testing.stepdefinition;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.redbus.testing.utilities.Base;
import com.redbus.testing.utilities.Pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class TrainList {
	@Given("User searches trains from {string} to {string} on {string} {string}")
    public void user_searches_trains(String source, String destination, String month, String day) throws InterruptedException {
		Base.getDriver().get("https://www.redbus.in/railways");
	    Pages.getInstance().trainticketpage.openDatePicker();
        Pages.getInstance().trainticketpage.selectDate(month, day);
        Pages.getInstance().trainticketpage.enterFrom(source);
        Pages.getInstance().trainticketpage.enterTo(destination);

//        Pages.Tt.openDatePicker();
//        Pages.Tt.selectDate(month, day);

        Pages.getInstance().trainticketpage.clickSearch();
        	
	}
	
	
    @When("User clicks on view route for a train")
    public void user_clicks_on_view_route_for_a_train() throws InterruptedException {

        Pages.getInstance().trainlistpage.clickViewRoute();
    }
    
    

    @Then("User should see train route details")
    public void user_should_see_train_route_details() {
        List<WebElement> stations = Pages.getInstance().trainlistpage.getStationList();

        Assert.assertTrue(stations.size() >= 2, "Station list should contain at least two stations");

        String firstStation = stations.get(0).getText();
        String lastStation = stations.get(stations.size() - 1).getText();

        Assert.assertTrue(!firstStation.isEmpty() && !lastStation.isEmpty(),
                "First or last station name is empty");

        System.out.println("===== Train Route Summary =====");
//        System.out.println("Start Station : " + firstStation);
//        System.out.println("End Station   : " + lastStation);
        System.out.println("Total Stops   : " + stations.size());
    }

}
