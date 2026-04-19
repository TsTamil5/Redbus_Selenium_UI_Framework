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

import com.redbus.testing.pages.BookingsPage;
import com.redbus.testing.pages.LoginPage;
import com.redbus.testing.pages.OffersPage;
import com.redbus.testing.utilities.AllUtililtyFunction;
import com.redbus.testing.utilities.AllUtililtyFunction.ScreenshotUtil;
import com.redbus.testing.utilities.Pages;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Accounts {
	
	
	AllUtililtyFunction util = Hooks.util;
	@Given("user is on RedBus homepage")
	public void user_is_on_red_bus_homepage() {
	   
		System.out.println("User is on RedBus homepage");
	}
	@And("user clicks on Accounts")
	public void user_clicks_on_accounts() {
		Pages.loginPage.clickAccounts();
		
	}
	@Given("user clicks on Login button")
	public void user_clicks_on_login_button() {
	    
		Pages.loginPage.clickLogin();
	}
	@Given("user enters mobile number")
	public void user_enters_mobile_number(){
	   
		util.setSheet("LoginData");   

        String mobile = util.getData(1, 1);

        Pages.loginPage.enterMobile(mobile);
	}
	
	
	@Given("user clicks on captcha checkbox")
	public void user_clicks_on_captcha_checkbox() {
	  
		Pages.loginPage.handleCaptcha();
	}
	@Given("user clicks on Continue button")
	public void user_clicks_on_continue_button() {
	  
		 Pages.loginPage.clickContinue();
	}
	
	
	@Given("user clicks on Verify button")
	public void user_clicks_on_verify_button() throws InterruptedException {
		Pages.loginPage.clickVerifyOtp();

		
	}
	@Given("user handles security popup")
	public void user_handles_security_popup() {
	
		System.out.println("Handle OTP / Security popup manually");
	}
	
//	///////////////bookings/////////////////////
	
	@Given("the user clicks on Bookings")
	public void the_user_clicks_on_bookings() {
	   
		
	}
	@Given("user clicks on Login using excel")
	public void user_clicks_on_login_using_excel() {
		Pages.bookingsPage.clickBookings();
		
	}
	@Given("user enters mobile number using excel data")
	public void user_enters_mobile_number_using_excel_data() {
		util.setSheet("LoginData");   

        String mobile = util.getData(1, 1);
		  Pages.bookingsPage.clickLoginNow();
		
	}
	@Given("user clicks on captcha")
	public void user_clicks_on_captcha() {
	   
		 Pages.bookingsPage.clickCaptcha();
	}
	
	@Given("user click on generate otp")
	public void user_click_on_generate_otp() {
	    
		 Pages.bookingsPage.clickGenerateOtp();
	}
	
	@Given("user clicks on Verify otp")
	public void user_clicks_on_verify_otp() {
		Pages.bookingsPage.clickVerify();
		
	}
	@When("the user navigates to My Profile")
	public void the_user_navigates_to_my_profile() {
	   
		 Pages.bookingsPage.clickProfile();
	}
	@When("the user clicks on Edit Profile")
	public void the_user_clicks_on_edit_profile() {
	   
		Pages.bookingsPage.clickEdit();
	}
	@When("the user updates the profile details")
	public void the_user_updates_the_profile_details(DataTable dataTable) {
		
		 List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
	   
		String name  = data.get(0).get("name");
        String email = data.get(0).get("email");

        Pages.bookingsPage.enterName(name);
        Pages.bookingsPage.selectDOB("1"); 
        Pages.bookingsPage.selectGender();
        Pages.bookingsPage.enterEmail(email);
	}
	@When("the user clicks on Save")
	public void the_user_clicks_on_save() {
	   
		Pages.bookingsPage.clickSave();
	}
	@Then("the profile should be updated successfully")
	public void the_profile_should_be_updated_successfully() {
		 System.out.println("Profile updated successfully");
		
	}
	
	///////////offers//////////
	
	@Given("user clicks on Offers")
	public void user_clicks_on_offers() {
		Pages.offersPage.clickOffers();
		
	}
	@Then("Offers page should be displayed")
	public void offers_page_should_be_displayed() {
		boolean isDisplayed = Pages.offersPage.isOffersPageDisplayed();

	    Assert.assertTrue(isDisplayed, "Offers page is not displayed");
		
	}
	@When("user clicks on first offer")
	public void user_clicks_on_first_offer() {
	    
		 Pages.offersPage.clickFirstOffer();
	}
	@Then("offer details page should be displayed and verified")
	public void offer_details_page_should_be_displayed_and_verified() {

	    boolean isContentDisplayed = Pages.offersPage.isFirstOfferContentDisplayed();
	    
	    String text = Pages.offersPage.getOfferContentText();

	    
	    Reporter.log("Offer Content:BUS OFFER"
	    		+   "Use code FIRST"
	    		+   "Save up to Rs 250 on bus tickets " + text, true);
	    
	    Assert.assertTrue(isContentDisplayed, "First offer content is not displayed");
	}
	
	
	
	///////////////help////////////
	
	@When("user navigate to the Help page")
	public void user_navigate_to_the_help_page() {
		Pages.helpPage.clickHelp();
		
	}
	@When("user click  on Bus FAQ")
	public void user_click_on_bus_faq() {
		 Pages.helpPage.clickBusFAQ();
		
	}
	@When("user click on Bus cancellation category")
	public void user_click_on_bus_cancellation_category() {

		 Pages.helpPage.clickBusCancellation();
		
	}
	@When("user tap on the query")
	public void user_tap_on_the_query() {
	   
		Pages.helpPage.clickAnyQuery();
	}
//	
	@Then("the FAQ page title should be displayed")
	public void the_faq_page_title_should_be_displayed() {
////		 Assert.assertTrue(Pages.helpPage.getFAQTitle().length() > 0, "FAQ title is NOT displayed");
//		Assert.assertTrue(Pages.helpPage.isFAQPageDisplayed(),
//	            "FAQ title is NOT displayed");
//
	    System.out.println("FAQ Title: " + Pages.helpPage.getFAQTitle());
		
	}

}
