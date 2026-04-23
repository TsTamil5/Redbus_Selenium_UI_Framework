package com.redbus.testing.utilities;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;

import com.redbus.testing.pages.BusBoardDropPointPage;
import com.redbus.testing.pages.BusPassengerInfoPage;
import com.redbus.testing.pages.BusPaymentPage;
import com.redbus.testing.pages.BusSearchPage;
import com.redbus.testing.pages.BusSeatSelectionPage;
import com.redbus.testing.pages.BusSelectionPage;
import com.redbus.testing.pages.CancelPage;
import com.redbus.testing.pages.HelpPage;
import com.redbus.testing.pages.LoginCookies;
import com.redbus.testing.pages.LoginPage;
import com.redbus.testing.pages.OffersPage;
import com.redbus.testing.pages.Reshedule_TicketPage;
import com.redbus.testing.pages.SearchPage;

public class Pages {
	private static ThreadLocal<Pages> pages = new ThreadLocal<>();

	//// Bus tickets
	public BusSearchPage busSearchPage;
	public BusSelectionPage busSelectionPage;
	public BusSeatSelectionPage busSeatSelectionPage;
	public BusBoardDropPointPage busBoardDropPointPage;
	public BusPassengerInfoPage busPassengerInfoPage;
	public BusPaymentPage busPaymentPage;

	////// Accounts
	public LoginPage login;
	public OffersPage offersPage;
	public HelpPage helpPage;
	public Reshedule_TicketPage reschedulePage;
	public CancelPage cancelPage;
	public SearchPage searchPage;
	public LoginCookies loginCookies;

	public static void loadAllPages(WebDriver driver) {

		Pages p = new Pages();

		p.busSearchPage = PageFactory.initElements(driver, BusSearchPage.class);
		p.busSelectionPage = PageFactory.initElements(driver, BusSelectionPage.class);
		p.busSeatSelectionPage = PageFactory.initElements(driver, BusSeatSelectionPage.class);
		p.busBoardDropPointPage = PageFactory.initElements(driver, BusBoardDropPointPage.class);
		p.busPassengerInfoPage = PageFactory.initElements(driver, BusPassengerInfoPage.class);
		p.busPaymentPage = PageFactory.initElements(driver, BusPaymentPage.class);

//		Accounts
		p.login = PageFactory.initElements(driver, LoginPage.class);
		p.cancelPage = PageFactory.initElements(driver, CancelPage.class);
		p.offersPage = PageFactory.initElements(driver, OffersPage.class);
		p.helpPage = PageFactory.initElements(driver, HelpPage.class);
		p.reschedulePage = PageFactory.initElements(driver, Reshedule_TicketPage.class);
		p.searchPage = PageFactory.initElements(driver, SearchPage.class);
		p.loginCookies = PageFactory.initElements(driver, LoginCookies.class);

		pages.set(p);
	}

	public static Pages getInstance() {
		return pages.get();
	}
}
