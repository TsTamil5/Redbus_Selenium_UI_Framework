package com.redbus.testing.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.redbus.testing.pages.BusBoardDropPointPage;
import com.redbus.testing.pages.BusPassengerInfoPage;
import com.redbus.testing.pages.BusPaymentPage;
import com.redbus.testing.pages.BusSearchPage;
import com.redbus.testing.pages.BusSeatSelectionPage;
import com.redbus.testing.pages.BusSelectionPage;



public class Pages {
	private static ThreadLocal<Pages> pages = new ThreadLocal<>();

	public BusSearchPage busSearchPage;
	public BusSelectionPage busSelectionPage;
	public BusSeatSelectionPage busSeatSelectionPage;
	public BusBoardDropPointPage busBoardDropPointPage;
	public BusPassengerInfoPage busPassengerInfoPage;
	public BusPaymentPage busPaymentPage;


	public static void loadAllPages(WebDriver driver) {

		Pages p = new Pages();

		p.busSearchPage = PageFactory.initElements(driver, BusSearchPage.class);
		p.busSelectionPage = PageFactory.initElements(driver, BusSelectionPage.class);
		p.busSeatSelectionPage = PageFactory.initElements(driver, BusSeatSelectionPage.class);
		p.busBoardDropPointPage = PageFactory.initElements(driver, BusBoardDropPointPage.class);
		p.busPassengerInfoPage = PageFactory.initElements(driver, BusPassengerInfoPage.class);
		p.busPaymentPage = PageFactory.initElements(driver, BusPaymentPage.class);
		
		pages.set(p);
	}

	public static Pages getInstance() {
		return pages.get();
	}
}
