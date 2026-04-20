package com.redbus.testing.utilities;

import org.openqa.selenium.WebDriver;

import com.redbus.testing.pages.BookingsPage;
import com.redbus.testing.pages.HelpPage;
import com.redbus.testing.pages.LoginPage;
import com.redbus.testing.pages.OffersPage;

import com.redbus.testing.pages.TrainTicket;

import org.openqa.selenium.support.PageFactory;

import com.redbus.testing.pages.DashboardPage;
import com.redbus.testing.pages.HotelSearchResultsPage;
import com.redbus.testing.pages.HotelsPage;

public class Pages {
	
	//Accounts
	public static LoginPage loginPage;
    public static BookingsPage bookingsPage;
    public static OffersPage offersPage;
    public static  HelpPage helpPage;
    
    // hotels
    public static DashboardPage dashboardPage;
	public static HotelSearchResultsPage hotelSearchResultsPage ;
	public static HotelsPage hotelsPage;
	
	// Train
	public static TrainTicket trainTicket;
	
	
	public static void loadAllPages(WebDriver driver) {
		 //Accounts
		 loginPage =PageFactory.initElements(driver, LoginPage.class);
	     bookingsPage = PageFactory.initElements(driver, BookingsPage.class);
	     offersPage=PageFactory.initElements(driver, OffersPage.class);
	     helpPage=PageFactory.initElements(driver, HelpPage.class);
	     
	     //Hotels
	     
	     dashboardPage=PageFactory.initElements(driver, DashboardPage.class);
		 hotelSearchResultsPage=PageFactory.initElements(driver, HotelSearchResultsPage.class);
		 hotelsPage=PageFactory.initElements(driver, HotelsPage.class);
		 
		 //Trains
		 trainTicket=PageFactory.initElements(driver, TrainTicket.class);
	 }
}