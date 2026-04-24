//package com.redbus.testing.stepdefinition;
//
//import com.redbus.testing.utilities.Pages;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class Login {
//	
//	@Given("user is on RedBus homepage")
//    public void home() {
////	 Base.driver.manage().deleteAllCookies();
//        System.out.println("Fresh session");
//    }
//
//    @When("user clicks on accounts")
//    public void account() {
//       Pages.getInstance().loginCookies.clickAccount();
//    }
//
//	@When("user clicks on login button")
//	public void user_clicks_on_login_button() throws InterruptedException {
//		Pages.getInstance().loginCookies.clickLogin();
//		System.out.println("login manually");
//		Thread.sleep(80000);
//	}
//
//	@Then("user should be logged in successfully")
//	public void user_should_be_logged_in_successfully() {
//		System.out.println("loaded");
//	}
//
//	@Then("cookies should be saved for future use")
//	public void cookies_should_be_saved_for_future_use() {
//		
//	}
//}
