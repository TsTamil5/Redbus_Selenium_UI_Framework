package com.redbus.testing.utilities;

import org.openqa.selenium.WebDriver;
<<<<<<< HEAD

import com.redbus.testing.pages.BookingsPage;
import com.redbus.testing.pages.HelpPage;
import com.redbus.testing.pages.LoginPage;
import com.redbus.testing.pages.OffersPage;

public class Pages {
	public static LoginPage loginPage;
    public static BookingsPage bookingsPage;
    public static OffersPage offersPage;
    public static  HelpPage helpPage;
    
	 public static void initPages(WebDriver driver) {
		 
		 loginPage = new LoginPage(driver);
	     bookingsPage = new BookingsPage(driver);
	     offersPage=new OffersPage(driver);
	     helpPage=new HelpPage(driver);
	 }
=======
import org.openqa.selenium.support.PageFactory;
>>>>>>> d4399ab3e8ca2447131fcae29e4ba59ab11ee582

import com.redbus.testing.pages.DashboardPage;
import com.redbus.testing.pages.HotelSearchResultsPage;
import com.redbus.testing.pages.HotelsPage;

public class Pages {
	public static DashboardPage dashboardPage;
	public static HotelSearchResultsPage hotelSearchResultsPage ;
	public static HotelsPage hotelsPage;
	
	public static void loadAllPages(WebDriver driver) {
		dashboardPage=PageFactory.initElements(driver, DashboardPage.class);
		hotelSearchResultsPage=PageFactory.initElements(driver, HotelSearchResultsPage.class);
		hotelsPage=PageFactory.initElements(driver, HotelsPage.class);
	}
}