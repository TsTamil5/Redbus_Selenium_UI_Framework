package com.redbus.testing.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class train_restaurants_page {
	private WebDriver driver;
	 private WebDriverWait wait;
	public train_restaurants_page(WebDriver driver) {
		 this.driver = driver;
		 this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		 PageFactory.initElements(driver, this);
	}
	private By restaurantLocator =
		    By.xpath("//div[contains(@class,'flex flex-1 flex-col py-3')]/div/h5");
	
	
	public boolean isRestaurantListDisplayed() {

	    wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(restaurantLocator, 0));

	    List<WebElement> restaurantList = driver.findElements(restaurantLocator);

	    int count = restaurantList.size();
	    System.out.println("Number of restaurants: " + count);

	    return count > 0;
	}
	
	
//	@FindBy(xpath = "//h4[contains(.,'NDLS')]")
//	private WebElement stationNameField;
//	
//	public String textOnRestaurantStation() {
//		wait.until(ExpectedConditions.visibilityOf(stationNameField));
//		return stationNameField.getText();
//	}
//	@FindBy(xpath = "//div[contains(@class,'flex flex-1 flex-col py-3')]/div/h5")
//	List<WebElement> restaurants;
	
//	public void displayRestaurantNames() {
//
//	    By restaurantLocator =
//	        By.xpath("//div[contains(@class,'flex flex-1 flex-col py-3')]/div/h5");
//
//	    wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(restaurantLocator));
//
//	    List<WebElement> elements = driver.findElements(restaurantLocator);
//
//	    for (WebElement e : elements) {
//	        System.out.println(e.getText().trim());
//	    }
//	}
}
