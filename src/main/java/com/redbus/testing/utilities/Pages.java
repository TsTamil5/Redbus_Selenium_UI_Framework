package com.redbus.testing.utilities;

import org.openqa.selenium.WebDriver;

import com.redbus.testing.pages.TrainTicket;


public class Pages {
public static TrainTicket Tt;
	
	
	public static void initPages(WebDriver driver) {
		Tt= new TrainTicket(driver);
	}
}
