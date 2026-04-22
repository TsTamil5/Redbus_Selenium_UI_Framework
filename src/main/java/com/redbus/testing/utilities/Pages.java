package com.redbus.testing.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.redbus.testing.pages.DashboardPage;
import com.redbus.testing.pages.HotelSearchResultsPage;
import com.redbus.testing.pages.HotelsPage;

public class Pages {

    // ThreadLocal object for parallel execution
    private static final ThreadLocal<Pages> pages = new ThreadLocal<>();

    // Page object references
    public DashboardPage dashboardPage;
    public HotelSearchResultsPage hotelSearchResultsPage;
    public HotelsPage hotelsPage;

    // Initialize all page classes
    public static void loadAllPages(WebDriver driver) {

        Pages p = new Pages();

        p.dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
        p.hotelSearchResultsPage = PageFactory.initElements(driver, HotelSearchResultsPage.class);
        p.hotelsPage = PageFactory.initElements(driver, HotelsPage.class);

        pages.set(p);
    }

    // Return current thread page instance
    public static Pages getInstance() {
        return pages.get();
    }
}