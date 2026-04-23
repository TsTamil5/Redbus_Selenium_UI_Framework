package com.redbus.testing.utilities;

import org.openqa.selenium.WebDriver;

import com.redbus.testing.pages.CancelPage;
import com.redbus.testing.pages.HelpPage;
import com.redbus.testing.pages.LoginCookies;
import com.redbus.testing.pages.LoginPage;
import com.redbus.testing.pages.OffersPage;
import com.redbus.testing.pages.Reshedule_TicketPage;
import com.redbus.testing.pages.SearchPage;

import org.openqa.selenium.support.PageFactory;



public class Pages {
	private static final ThreadLocal<Pages> pages = new ThreadLocal<>();
	
	 public  LoginPage login;
	 public  OffersPage offersPage;
	 public  HelpPage helpPage;
	 public  Reshedule_TicketPage reschedulePage;
	 public  CancelPage cancelPage;
	 public  SearchPage searchPage;
	 public  LoginCookies loginCookies;
	 
	 
	 public static void loadAllPages(WebDriver driver) {

			    Pages p = new Pages();
			    
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