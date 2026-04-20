package com.redbus.testing.utilities;

import org.openqa.selenium.WebDriver;
import com.redbus.testing.pages.BookingsPage;
import com.redbus.testing.pages.HelpPage;
import com.redbus.testing.pages.LoginPage;
import com.redbus.testing.pages.OffersPage;
import org.openqa.selenium.support.PageFactory;

import com.redbus.testing.pages.TrainTicket;


public class Pages {
	public static LoginPage loginPage;
    public static BookingsPage bookingsPage;
    public static OffersPage offersPage;
    public static  HelpPage helpPage;
    public static TrainTicket Tt;
    
	 public static void loadAllPages(WebDriver driver) {
		 
		 loginPage = new LoginPage(driver);
	     bookingsPage = new BookingsPage(driver);
	     offersPage=new OffersPage(driver);
	     helpPage=new HelpPage(driver);
	     
	     Tt= new TrainTicket(driver);
	 }

