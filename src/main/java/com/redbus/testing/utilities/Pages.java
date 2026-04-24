package com.redbus.testing.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.redbus.testing.pages.TrainListPage;
import com.redbus.testing.pages.TrainPassengerPage;
import com.redbus.testing.pages.TrainRestaurantsPage;
import com.redbus.testing.pages.TrainTicketPage;
import com.redbus.testing.pages.ViewResultPage;
import com.redbus.testing.pages.BusBoardDropPointPage;
import com.redbus.testing.pages.BusPassengerInfoPage;
import com.redbus.testing.pages.BusPaymentPage;
import com.redbus.testing.pages.BusSearchPage;
import com.redbus.testing.pages.BusSeatSelectionPage;
import com.redbus.testing.pages.BusSelectionPage;
import com.redbus.testing.pages.CancelPage;
import com.redbus.testing.pages.DashboardPage;
import com.redbus.testing.pages.FoodOrderPage;
import com.redbus.testing.pages.HelpPage;
import com.redbus.testing.pages.LoginCookies;
import com.redbus.testing.pages.LoginPage;
import com.redbus.testing.pages.OffersPage;
import com.redbus.testing.pages.PopularFoodRestaurantServingPage;
import com.redbus.testing.pages.Reshedule_TicketPage;
import com.redbus.testing.pages.RestaurantMenuPage;
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

	// Trains
	public TrainTicketPage trainticketpage;
	public TrainListPage trainlistpage;
	public TrainPassengerPage trainpassengerpage;
	public ViewResultPage viewresultpage;
	
	//FoodOrder
	public FoodOrderPage fp;
    public RestaurantMenuPage rmp;
    public PopularFoodRestaurantServingPage pp;
    public TrainRestaurantsPage tp;
    public DashboardPage dp;
    public TrainTicketPage ttp;

	public static String sourceCity;
	public static String destinationCity;

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

		// Trains
		p.trainticketpage = PageFactory.initElements(driver, TrainTicketPage.class);
		p.trainlistpage = PageFactory.initElements(driver, TrainListPage.class);
		p.trainpassengerpage = PageFactory.initElements(driver, TrainPassengerPage.class);
		p.viewresultpage = PageFactory.initElements(driver, ViewResultPage.class);
		
		//FoodOrder
        p.fp=PageFactory.initElements(driver, FoodOrderPage.class);
        p.rmp=PageFactory.initElements(driver, RestaurantMenuPage.class);
        p.pp=PageFactory.initElements(driver, PopularFoodRestaurantServingPage.class);
        p.tp=PageFactory.initElements(driver, TrainRestaurantsPage.class);
        p.ttp=PageFactory.initElements(driver, TrainTicketPage.class);
        p.dp=PageFactory.initElements(driver, DashboardPage.class);

		pages.set(p);
	}

	public static Pages getInstance() {
		return pages.get();
	}
}

   
