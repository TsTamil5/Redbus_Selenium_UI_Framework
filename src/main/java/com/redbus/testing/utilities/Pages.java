package com.redbus.testing.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.redbus.testing.pages.*;

public class Pages {

    private static ThreadLocal<Pages> pages = new ThreadLocal<>();

    public FoodOrderPage fp;
    public RestaurantMenuPage rmp;
    public PopularFoodRestaurantServingPage pp;
    public TrainRestaurantsPage tp;
    public DashboardPage dp;
    public TrainTicketPage ttp;

    public static void loadAllPages(WebDriver driver) {

        Pages p = new Pages();
        
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