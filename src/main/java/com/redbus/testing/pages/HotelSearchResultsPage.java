package com.redbus.testing.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HotelSearchResultsPage {

	@FindBy(xpath = "//div[contains(@class,'hotel')]")
	private WebElement hotelResultsPage;

	@FindBy(xpath = "//div[contains(@class,'hotel')]")
	private List<WebElement> hotelCards;
	
	@FindBy(xpath="//div[contains(@class,'tupleWrapper')]")
	private List<WebElement> hotelsCount;

	@FindBy(xpath = "//nav[@data-autoid='filters-hotels-desktop']")
	private WebElement filtersSection;

	@FindBy(id = "HOTEL_PRICE_BUCKET")
	private WebElement pricePerNight;

	@FindBy(xpath = "//div[@id='HOTEL_PRICE_BUCKET']//div[@role='checkbox']")
	private List<WebElement> priceFilterOptions;

	@FindBy(id = "USER_RATING_MMT_BRAND")
	private WebElement customerRatings;

	@FindBy(xpath = "//div[@id='USER_RATING_MMT_BRAND']//div[@role='checkbox']")
	private List<WebElement> customerRatingsOptions;

	@FindBy(id = "STAR_RATING")
	private WebElement starRatings;

	@FindBy(xpath = "//div[@id='STAR_RATING']//div[@role='checkbox']")
	private List<WebElement> ratingOptions;

	@FindBy(id = "DEALS")
	private WebElement deals;

	@FindBy(xpath = "//div[@id='DEALS']//div[@role='checkbox']")
	private List<WebElement> dealsOptions;

	@FindBy(id = "FREE_BREAKFAST_AVAIL")
	private WebElement mealPreference;

	@FindBy(xpath = "//div[@id='FREE_BREAKFAST_AVAIL']//div[@role='checkbox']")
	private List<WebElement> mealPreferenceOptions;

	@FindBy(id = "AMENITIES")
	private WebElement amenities;

	@FindBy(xpath = "//div[@id='AMENITIES']//div[@role='checkbox']")
	private List<WebElement> amenitiesOptions;

	@FindBy(id = "ROOM_AMENITIES")
	private WebElement roomAmenities;

	@FindBy(xpath = "//div[@id='ROOM_AMENITIES']//div[@role='checkbox']")
	private List<WebElement> roomAmenitiesOptions;

	@FindBy(id = "CHAIN_INFO")
	private WebElement hotelChain;

	@FindBy(xpath = "//div[@id='CHAIN_INFO']//div[@role='checkbox']")
	private List<WebElement> hotelChainOptions;

	@FindBy(id = "MERGE_PROPERTY_TYPE")
	private WebElement propertyType;

	@FindBy(xpath = "//div[@id='MERGE_PROPERTY_TYPE']//div[@role='checkbox']")
	private List<WebElement> propertyTypeOptions;

	@FindBy(id = "HOUSE_RULES")
	private WebElement policies;

	@FindBy(xpath = "//div[@id='HOUSE_RULES']//div[@role='checkbox']")
	private List<WebElement> policiesOptions;

	@FindBy(id = "PAY_AT_HOTEL_AVAIL")
	private WebElement payAtHotel;

	@FindBy(xpath = "//div[@id='PAY_AT_HOTEL_AVAIL']//div[@role='checkbox']")
	private List<WebElement> payAtHotelOptions;

	@FindBy(id = "LOCATION")
	private WebElement location;

	@FindBy(xpath = "//div[@id='LOCATION']//div[@role='checkbox']")
	private List<WebElement> locationOptions;

	@FindBy(css = "[aria-label='View all']")
	private WebElement viewAll;

	@FindBy(css = "[aria-label='Clear all filters']")
	private WebElement clearFilterButton;

	@FindBy(css = "[class='primaryButton___d6c460 selectRoomBtn___9b0759 ']")
	private WebElement selectRoom;
	
	@FindBy(css="[data-autoid='sortBarCount']")
	private WebElement propertyCount;
	
	@FindBy(xpath = "//*[contains(@class,'oopsInfoWrapper')]")
	private WebElement oopsMsg;
	
	public WebElement getHotelResultsPage() {
		return hotelResultsPage;
	}

	public List<WebElement> getHotelCards() {
		return hotelCards;
	}

	public WebElement getFiltersSection() {
		return filtersSection;
	}

	public WebElement getPricePerNight() {
		return pricePerNight;
	}

	public List<WebElement> getPriceFilterOptions() {
		return priceFilterOptions;
	}

	public WebElement getCustomerRatings() {
		return customerRatings;
	}

	public List<WebElement> getCustomerRatingsOptions() {
		return customerRatingsOptions;
	}

	public WebElement getStarRatings() {
		return starRatings;
	}

	public List<WebElement> getRatingOptions() {
		return ratingOptions;
	}

	public WebElement getDeals() {
		return deals;
	}

	public List<WebElement> getDealsOptions() {
		return dealsOptions;
	}

	public WebElement getMealPreference() {
		return mealPreference;
	}

	public List<WebElement> getMealPreferenceOptions() {
		return mealPreferenceOptions;
	}

	public WebElement getAmenities() {
		return amenities;
	}

	public List<WebElement> getAmenitiesOptions() {
		return amenitiesOptions;
	}

	public WebElement getRoomAmenities() {
		return roomAmenities;
	}

	public List<WebElement> getRoomAmenitiesOptions() {
		return roomAmenitiesOptions;
	}

	public WebElement getHotelChain() {
		return hotelChain;
	}

	public List<WebElement> getHotelChainOptions() {
		return hotelChainOptions;
	}

	public WebElement getPropertyType() {
		return propertyType;
	}

	public List<WebElement> getPropertyTypeOptions() {
		return propertyTypeOptions;
	}

	public WebElement getPolicies() {
		return policies;
	}

	public List<WebElement> getPoliciesOptions() {
		return policiesOptions;
	}

	public WebElement getPayAtHotel() {
		return payAtHotel;
	}

	public List<WebElement> getPayAtHotelOptions() {
		return payAtHotelOptions;
	}

	public WebElement getLocation() {
		return location;
	}

	public List<WebElement> getLocationOptions() {
		return locationOptions;
	}

	public WebElement getViewAll() {
		return viewAll;
	}

	public WebElement getClearFilterButton() {
		return clearFilterButton;
	}

	public WebElement getSelectRoom() {
		return selectRoom;
	}
	
	public boolean isResultsPageDisplayed() {
		return getHotelResultsPage().isDisplayed();
	}

	public int getHotelCardsCount() {
		return getHotelCards().size();
	}

	public boolean isClearFilterDisplayed() {
		return getClearFilterButton().isDisplayed();
	}
	
	public WebElement getPropertyCount() {
		return propertyCount;
	}

	public WebElement getOopsMsg() {
		return oopsMsg;
	}

	public String fetchPropertyCountText() {
		return getPropertyCount().getText();
	}

	public String fetchOopsMessageText() {

	    try {
	        return getOopsMsg().getText().trim();
	    } catch (Exception e) {
	        return "";
	    }
	}
	
	public boolean isPropertyCountMismatchBugDisplayed() {

		String countText = fetchPropertyCountText().trim();
		String oopsText = fetchOopsMessageText().trim();

		return countText.contains("1 property")
				&& oopsText.contains("No properties found");
	}
	
	public void selectOptionByText(List<WebElement> options, String value) {

	    for (WebElement option : options) {

	        String text = option.getAttribute("aria-label");

	        if (text != null && text.trim().equalsIgnoreCase(value.trim())) {

	            option.click();  
	            return;
	        }
	    }
	}
	
	
	public void selectPriceFilter(String value) {
	    getPricePerNight().click();
	    selectOptionByText(priceFilterOptions, value);
	}

	public void selectCustomerRating(String value) {
	    getCustomerRatings().click();
	    selectOptionByText(customerRatingsOptions, value);
	}

	public void selectStarRating(String value) {
	    getStarRatings().click();
	    selectOptionByText(ratingOptions, value);
	}

	public void selectDeals(String value) {
	    getDeals().click();
	    selectOptionByText(dealsOptions, value);
	}

	public void selectMealPreference(String value) {
	    getMealPreference().click();
	    selectOptionByText(mealPreferenceOptions, value);
	}

	public void selectAmenity(String value) {
	    getAmenities().click();
	    selectOptionByText(amenitiesOptions, value);
	}

	public void selectRoomAmenity(String value) {
	    getRoomAmenities().click();
	    selectOptionByText(roomAmenitiesOptions, value);
	}

	public void selectHotelChain(String value) {
	    getHotelChain().click();
	    selectOptionByText(hotelChainOptions, value);
	}

	public void selectPropertyType(String value) {
	    getPropertyType().click();
	    selectOptionByText(propertyTypeOptions, value);
	}

	public void selectPolicy(String value) {
	    getPolicies().click();
	    selectOptionByText(policiesOptions, value);
	}

	public void selectPayAtHotel(String value) {
	    getPayAtHotel().click();
	    selectOptionByText(payAtHotelOptions, value);
	}

	public void selectLocation(String value) {
	    getLocation().click();
	    selectOptionByText(locationOptions, value);
	}
	
	public boolean isResultsConsistent() {

	    int actualHotels = hotelsCount.size();

	    String countText = fetchPropertyCountText();

	    int displayedCount = 0;

	    try {
	        displayedCount = Integer.parseInt(
	            countText.replaceAll("[^0-9]", "")
	        );
	    } catch (Exception e) {
	        displayedCount = 0;
	    }

	    boolean oopsVisible = false;

	    try {
	        oopsVisible = getOopsMsg().isDisplayed();
	    } catch (Exception e) {
	        oopsVisible = false;
	    }

	    // Debug
	    System.out.println("Displayed Count: " + displayedCount);
	    System.out.println("Actual Hotels: " + actualHotels);
	    System.out.println("Oops Visible: " + oopsVisible);

	    boolean countCorrect =
	        displayedCount == actualHotels;

	    boolean messageCorrect =
	        (actualHotels == 0 && oopsVisible) ||
	        (actualHotels > 0 && !oopsVisible);

	    return countCorrect && messageCorrect;
	}
}
	

	