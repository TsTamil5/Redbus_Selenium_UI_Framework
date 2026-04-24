package com.redbus.testing.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


import com.redbus.testing.pages.TrainListPage;
import com.redbus.testing.pages.TrainPassengerPage;
import com.redbus.testing.pages.TrainTicketPage;
import com.redbus.testing.pages.ViewResultPage;



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
	    //Trains
	    public TrainTicketPage trainticketpage;
	    public TrainListPage trainlistpage;
	    public TrainPassengerPage trainpassengerpage;
	    public ViewResultPage viewresultpage;
	    
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
	        //Trains
	        p.trainticketpage=PageFactory.initElements(driver, TrainTicketPage.class);
	        p.trainlistpage=PageFactory.initElements(driver, TrainListPage.class);
	        p.trainpassengerpage=PageFactory.initElements(driver, TrainPassengerPage.class);
	        p.viewresultpage=PageFactory.initElements(driver, ViewResultPage.class);
	        pages.set(p);
	    }

	    public static Pages getInstance() {
	        return pages.get();
	 }
}



