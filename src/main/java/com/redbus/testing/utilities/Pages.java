package com.redbus.testing.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

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