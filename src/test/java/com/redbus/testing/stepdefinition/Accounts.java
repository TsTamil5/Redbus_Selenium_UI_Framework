package com.redbus.testing.stepdefinition;

import java.awt.Robot;



import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.redbus.testing.pages.LoginPage;
import com.redbus.testing.pages.OffersPage;

import com.redbus.testing.utilities.AllUtilityFunction;
import com.redbus.testing.utilities.AllUtilityFunction.CookieUtil;
import com.redbus.testing.utilities.Base;
import com.redbus.testing.utilities.Pages;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Accounts {
	AllUtilityFunction util;
	
	
	@Given("user is on RedBus homepage")
    public void home() {
		
        System.out.println("Fresh session");
    }

    @When("user clicks on accounts")
    public void account() {
        Pages.getInstance().login.clickAccount();
    }
    
    @When("user clicks on bookings")
    public void user_clicks_on_bookings() {

        if (Pages.getInstance().login.isUserLoggedIn()) {
            Pages.getInstance().login.clickBookings();
            System.out.println("User is logged in - navigating to Bookings");
        } else {
            System.out.println("Session expired - login required");
        }
    }
    @And("user navigates to My Profile")
    public void profile() {
        Pages.getInstance().login.clickProfile();
    }

    @And("user clicks on Edit Profile")
    public void edit() {
        Pages.getInstance().login.clickEdit();
    }

    @And("user updates profile details {string} {string} {string}")
    public void update(String name, String email, String gender) {

        Pages.getInstance().login.enterName(name);
        Pages.getInstance().login.selectGender(gender);
        Pages.getInstance().login.enterEmail(email);
    }

    @And("user clicks on Save")
    public void save() {
        Pages.getInstance().login.clickSave();
    }

    @Then("profile should reflect updated details {string} {string} {string}")
    public void verify_profile_details(String expectedName, String expectedEmail, String expectedGender) {

        String actualName = Pages.getInstance().login.getDisplayedName();
        String actualEmail = Pages.getInstance().login.getDisplayedEmail();
        String actualGender = Pages.getInstance().login.getSelectedGender();

        System.out.println("Actual Name: " + actualName);
        System.out.println("Actual Email: " + actualEmail);
        System.out.println("Actual Gender: " + actualGender);

        Assert.assertEquals(actualName, expectedName, "❌ Name not updated");
        Assert.assertEquals(actualEmail, expectedEmail, "❌ Email not updated");
        Assert.assertEquals(actualGender.toLowerCase(), expectedGender.toLowerCase(), "❌ Gender not updated");
    }


//	///////////offers//////////
	
	@Given("user clicks on Offers")
	public void user_clicks_on_offers() {
		Pages.getInstance().offersPage.clickOffers();
		
	}
	@Then("Offers page should be displayed")
	public void offers_page_should_be_displayed() {
		boolean isDisplayed = Pages.getInstance().offersPage.isOffersPageDisplayed();

	    Assert.assertTrue(isDisplayed, "Offers page is not displayed");
		
	}
	@When("user clicks on first offer")
	public void user_clicks_on_first_offer() {
	    
		 Pages.getInstance().offersPage.clickFirstOffer();
	}
	@Then("offer details page should be displayed and verified")
	public void offer_details_page_should_be_displayed_and_verified() {

	    boolean isContentDisplayed = Pages.getInstance().offersPage.isFirstOfferContentDisplayed();
	    
	    String text = Pages.getInstance().offersPage.getOfferContentText();

	    
	    Reporter.log("Offer Content:BUS OFFER"
	    		+   "Use code FIRST"
	    		+   "Save up to Rs 250 on bus tickets " + text, true);
	    
	    Assert.assertTrue(isContentDisplayed, "First offer content is not displayed");
	}
	
	
//	///////////////help////////////

	@When("user navigate to the Help page")
	public void user_navigate_to_the_help_page() {
		Pages.getInstance().helpPage.clickHelp();
		
	}
	@And("user click  on Bus FAQ")
	public void user_click_on_bus_faq() {
		 Pages.getInstance().helpPage.clickBusFAQ();
		
	}
	@And("user click on Bus cancellation category")
	public void user_click_on_bus_cancellation_category() {

		 Pages.getInstance().helpPage.clickBusCancellation();
		
	}
	@And("user tap on the query")
	public void user_tap_on_the_query() {
	   
		Pages.getInstance().helpPage.clickAnyQuery();
	}
	

	@Then("the FAQ page title should be displayed")
	public void the_faq_page_title_should_be_displayed() {

	    String title = Pages.getInstance().helpPage.getFAQTitle();

	    Assert.assertTrue(title.length() > 0, "FAQ title is NOT displayed");

	    System.out.println("FAQ Title: " + title);
	}
	
	///////////////Reshedule Ticket/////////////
	
	@When("user clicks on Reshedule Ticket")
	public void user_clicks_on_reshedule_ticket() {
		 Pages.getInstance().reschedulePage.clickRescheduleTicket();
		
	}
	
	@And("Enter Ticket number and Mobile number from excel sheet {string} row {int}")
	public void enter_ticket_and_mobile_from_excel(String sheetName, Integer rowIndex) {

		util = new AllUtilityFunction();
            
	    util.init(sheetName);       

	    String ticket = util.getData(rowIndex, 0);
	    String mobile = util.getData(rowIndex, 1);

	    System.out.println("Row: " + rowIndex);
	    System.out.println("Ticket: " + ticket);
	    System.out.println("Mobile: " + mobile);

	    Pages.getInstance().reschedulePage.enterTicketNumber(ticket);
	    Pages.getInstance().reschedulePage.enterMobileNumber(mobile);
	}
	

	@And("user click on search")
	public void user_click_on_search() {
		
		Pages.getInstance().reschedulePage.clickSearch();
	    
		
	}
	
	@Then("verify the Reshedule page")
	public void verify_the_reshedule_page() {
	    
		 boolean result = Base.getDriver().findElements(
			        By.xpath("//*[contains(text(),'Reschedule') or contains(text(),'No booking')]")
			    ).size() > 0;

			    Assert.assertTrue(result, "Reschedule page not displayed");
	
	}
	
	
	//////////////cancel ticket/////////
	
	@When("user clicks on Cancel the Ticket")
	public void user_clicks_on_cancel_the_ticket() {
	    Pages.getInstance().cancelPage.clickCancelTicket();
		
	}
	@And("Enter Ticketnumber and Mobilenumber")
	public void enter_ticketnumber_and_mobilenumber(io.cucumber.datatable.DataTable dataTable) {
	    
		 List<Map<String, String>> data = dataTable.asMaps();

		    String ticket = data.get(0).get("Ticket number");
		    String mobile = data.get(0).get("Mobile number");

		    Pages.getInstance().cancelPage.enterTicketNumber(ticket);
		    Pages.getInstance().cancelPage.enterMobileNumber(mobile);
		
		
	}
	@And("click on select passengers")
	public void click_on_select_passengers() {
	   
		Pages.getInstance().cancelPage.clickSelectPassengers();
	}
	@Then("verify the cancel ticket page")
	public void verify_the_cancel_ticket_page() {
	   
		String message = Pages.getInstance().cancelPage.getCancelErrorMessage();

	    System.out.println("Success Message: " + message);

	    Assert.assertTrue(
	            message.contains("This ticket can not be cancelled as the date of journey has already passed"));
	            
	}
	
	@Then("verify the cancel ticket page with invalid number")
	public void verify_the_cancel_ticket_page_with_invalid_number() {

	    String message = Pages.getInstance().cancelPage.getCancelErrorMessage();

	    System.out.println("Error Message: " + message);

	    Assert.assertTrue(
	            message.contains("Please enter correct mobile no"));

}
	
	/////////////////search ticket////////////////

	@When("user click on Search Ticket")
	public void user_click_on_search_ticket() {
	    
		Pages.getInstance().searchPage.clickSearchTicket();
	}
	@When("Enter TicketNo and MobileNo from excel sheet {string} row {int}")
	public void enter_ticket_no_and_mobile_no_from_excel_sheet_row(String sheetName, Integer rowNum) throws InterruptedException {
	
			util = new AllUtilityFunction();
            
			util.init(sheetName); 
			
		    String ticketNo = util.getData(rowNum, 0);
		    String mobileNo = util.getData(rowNum, 1);

		 
		    Pages.getInstance().searchPage.enterTicketNumber(ticketNo);
		    Pages.getInstance().searchPage.enterMobileNumber(mobileNo);	

	}
	@When("click on searchButton")
	public void click_on_search_button() {
	    
		Pages.getInstance().searchPage.clickSearchButton();
	}
	@When("verify the Ticket")
	public void verify_the_ticket() {

	    boolean isDisplayed = Pages.getInstance().searchPage.isTicketPageDisplayed();
	    Assert.assertTrue(isDisplayed, "Ticket page not displayed");

	    String ticket = Pages.getInstance().searchPage.getTicketNumber();

	    Assert.assertTrue(!ticket.isEmpty(), "Ticket number not found");
	}
	@When("click on chat with RedBuddy")
	public void click_on_chat_with_red_buddy() {
	    Pages.getInstance().searchPage.clickRedBuddyChat();
		
	}
	@Then("Verify the help page")
	public void verify_the_help_page() {
	    Pages.getInstance().searchPage.switchToNewTab();

	    String url = Base.getDriver().getCurrentUrl();
	    Assert.assertNotNull(url, "help tab URL is null");
	    Assert.assertFalse(url.isEmpty(), "help tab did not open");

	}

}
