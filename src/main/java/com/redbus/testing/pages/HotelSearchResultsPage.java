package com.redbus.testing.pages;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HotelSearchResultsPage {

	// Locate hotel results page container
	@FindBy(xpath = "//div[contains(@class,'hotel')]")
	private WebElement hotelResultsPage;

	// Locate all hotel cards
	@FindBy(xpath = "//div[contains(@class,'hotel')]")
	private List<WebElement> hotelCards;
	
	// Locate hotel count elements
	@FindBy(xpath="//div[contains(@class,'tupleWrapper')]")
	private List<WebElement> hotelsCount;

	// Locate filters section
	@FindBy(xpath = "//nav[@data-autoid='filters-hotels-desktop']")
	private WebElement filtersSection;

	// Locate price per night filter
	@FindBy(id = "HOTEL_PRICE_BUCKET")
	private WebElement pricePerNight;

	// Locate price filter options
	@FindBy(xpath = "//div[@id='HOTEL_PRICE_BUCKET']//div[@role='checkbox']")
	private List<WebElement> priceFilterOptions;

	// Locate customer ratings filter
	@FindBy(id = "USER_RATING_MMT_BRAND")
	private WebElement customerRatings;

	// Locate customer ratings options
	@FindBy(xpath = "//div[@id='USER_RATING_MMT_BRAND']//div[@role='checkbox']")
	private List<WebElement> customerRatingsOptions;

	// Locate star ratings filter
	@FindBy(id = "STAR_RATING")
	private WebElement starRatings;

	// Locate star rating options
	@FindBy(xpath = "//div[@id='STAR_RATING']//div[@role='checkbox']")
	private List<WebElement> ratingOptions;

	// Locate deals filter
	@FindBy(id = "DEALS")
	private WebElement deals;

	// Locate deals options
	@FindBy(xpath = "//div[@id='DEALS']//div[@role='checkbox']")
	private List<WebElement> dealsOptions;

	// Locate meal preference filter
	@FindBy(id = "FREE_BREAKFAST_AVAIL")
	private WebElement mealPreference;

	// Locate meal preference options
	@FindBy(xpath = "//div[@id='FREE_BREAKFAST_AVAIL']//div[@role='checkbox']")
	private List<WebElement> mealPreferenceOptions;

	// Locate amenities filter
	@FindBy(id = "AMENITIES")
	private WebElement amenities;

	// Locate amenities options
	@FindBy(xpath = "//div[@id='AMENITIES']//div[@role='checkbox']")
	private List<WebElement> amenitiesOptions;

	// Locate room amenities filter
	@FindBy(id = "ROOM_AMENITIES")
	private WebElement roomAmenities;

	// Locate room amenities options
	@FindBy(xpath = "//div[@id='ROOM_AMENITIES']//div[@role='checkbox']")
	private List<WebElement> roomAmenitiesOptions;

	// Locate hotel chain filter
	@FindBy(id = "CHAIN_INFO")
	private WebElement hotelChain;

	// Locate hotel chain options
	@FindBy(xpath = "//div[@id='CHAIN_INFO']//div[@role='checkbox']")
	private List<WebElement> hotelChainOptions;

	// Locate property type filter
	@FindBy(id = "MERGE_PROPERTY_TYPE")
	private WebElement propertyType;

	// Locate property type options
	@FindBy(xpath = "//div[@id='MERGE_PROPERTY_TYPE']//div[@role='checkbox']")
	private List<WebElement> propertyTypeOptions;

	// Locate policies filter
	@FindBy(id = "HOUSE_RULES")
	private WebElement policies;

	// Locate policies options
	@FindBy(xpath = "//div[@id='HOUSE_RULES']//div[@role='checkbox']")
	private List<WebElement> policiesOptions;

	// Locate pay at hotel filter
	@FindBy(id = "PAY_AT_HOTEL_AVAIL")
	private WebElement payAtHotel;

	// Locate pay at hotel options
	@FindBy(xpath = "//div[@id='PAY_AT_HOTEL_AVAIL']//div[@role='checkbox']")
	private List<WebElement> payAtHotelOptions;

	// Locate location filter
	@FindBy(id = "LOCATION")
	private WebElement location;

	// Locate location options
	@FindBy(xpath = "//div[@id='LOCATION']//div[@role='checkbox']")
	private List<WebElement> locationOptions;

	// Locate view all button
	@FindBy(css = "[aria-label='View all']")
	private WebElement viewAll;

	// Locate clear filter button
	@FindBy(css = "[aria-label='Clear all filters']")
	private WebElement clearFilterButton;

	// Locate select room button
	@FindBy(css = "[class='primaryButton___d6c460 selectRoomBtn___9b0759 ']")
	private WebElement selectRoom;
	
	// Locate property count text
	@FindBy(css="[data-autoid='sortBarCount']")
	private WebElement propertyCount;
	
	// Locate no results message
	@FindBy(xpath = "//*[contains(@class,'oopsInfoWrapper')]")
	private WebElement oopsMsg;
	
	// Return hotel results page element
	public WebElement getHotelResultsPage() {
		return hotelResultsPage;
	}

	// Return hotel cards list
	public List<WebElement> getHotelCards() {
		return hotelCards;
	}

	// Return filters section
	public WebElement getFiltersSection() {
		return filtersSection;
	}

	// Return price filter element
	public WebElement getPricePerNight() {
		return pricePerNight;
	}

	// Return price filter options
	public List<WebElement> getPriceFilterOptions() {
		return priceFilterOptions;
	}

	// Return customer ratings filter
	public WebElement getCustomerRatings() {
		return customerRatings;
	}

	// Return customer ratings options
	public List<WebElement> getCustomerRatingsOptions() {
		return customerRatingsOptions;
	}

	// Return star ratings filter
	public WebElement getStarRatings() {
		return starRatings;
	}

	// Return rating options
	public List<WebElement> getRatingOptions() {
		return ratingOptions;
	}

	// Return deals filter
	public WebElement getDeals() {
		return deals;
	}

	// Return deals options
	public List<WebElement> getDealsOptions() {
		return dealsOptions;
	}

	// Return meal preference filter
	public WebElement getMealPreference() {
		return mealPreference;
	}

	// Return meal preference options
	public List<WebElement> getMealPreferenceOptions() {
		return mealPreferenceOptions;
	}

	// Return amenities filter
	public WebElement getAmenities() {
		return amenities;
	}

	// Return amenities options
	public List<WebElement> getAmenitiesOptions() {
		return amenitiesOptions;
	}

	// Return room amenities filter
	public WebElement getRoomAmenities() {
		return roomAmenities;
	}

	// Return room amenities options
	public List<WebElement> getRoomAmenitiesOptions() {
		return roomAmenitiesOptions;
	}

	// Return hotel chain filter
	public WebElement getHotelChain() {
		return hotelChain;
	}

	// Return hotel chain options
	public List<WebElement> getHotelChainOptions() {
		return hotelChainOptions;
	}

	// Return property type filter
	public WebElement getPropertyType() {
		return propertyType;
	}

	// Return property type options
	public List<WebElement> getPropertyTypeOptions() {
		return propertyTypeOptions;
	}

	// Return policies filter
	public WebElement getPolicies() {
		return policies;
	}

	// Return policies options
	public List<WebElement> getPoliciesOptions() {
		return policiesOptions;
	}

	// Return pay at hotel filter
	public WebElement getPayAtHotel() {
		return payAtHotel;
	}

	// Return pay at hotel options
	public List<WebElement> getPayAtHotelOptions() {
		return payAtHotelOptions;
	}

	// Return location filter
	public WebElement getLocation() {
		return location;
	}

	// Return location options
	public List<WebElement> getLocationOptions() {
		return locationOptions;
	}

	// Return view all button
	public WebElement getViewAll() {
		return viewAll;
	}

	// Return clear filter button
	public WebElement getClearFilterButton() {
		return clearFilterButton;
	}

	// Return select room button
	public WebElement getSelectRoom() {
		return selectRoom;
	}
	
	// Check results page is displayed
	public boolean isResultsPageDisplayed() {
		return getHotelResultsPage().isDisplayed();
	}

	// Return total hotel cards count
	public int getHotelCardsCount() {
		return getHotelCards().size();
	}

	// Check clear filter button is displayed
	public boolean isClearFilterDisplayed() {
		return getClearFilterButton().isDisplayed();
	}
	
	// Return property count element
	public WebElement getPropertyCount() {
		return propertyCount;
	}

	// Return oops message element
	public WebElement getOopsMsg() {
		return oopsMsg;
	}

	// Fetch property count text
	public String fetchPropertyCountText() {
		return getPropertyCount().getText();
	}

	// Fetch oops message text
	public String fetchOopsMessageText() {

	    try {
	        return getOopsMsg().getText().trim();
	    } catch (Exception e) {
	        return "";
	    }
	}
	
	// Select checkbox option by text
	public void selectOptionByText(List<WebElement> options, String value) {

	    for (WebElement option : options) {

	        String text = option.getAttribute("aria-label");

	        if (text != null && text.trim().equalsIgnoreCase(value.trim())) {

	            option.click();  
	            return;
	        }
	    }
	}
	
	// Select price filter option
	public void selectPriceFilter(String value) {
	    getPricePerNight().click();
	    selectOptionByText(priceFilterOptions, value);
	}

	// Select customer rating option
	public void selectCustomerRating(String value) {
	    getCustomerRatings().click();
	    selectOptionByText(customerRatingsOptions, value);
	}

	// Select star rating option
	public void selectStarRating(String value) {
	    getStarRatings().click();
	    selectOptionByText(ratingOptions, value);
	}

	// Select deals option
	public void selectDeals(String value) {
	    getDeals().click();
	    selectOptionByText(dealsOptions, value);
	}

	// Select meal preference option
	public void selectMealPreference(String value) {
	    getMealPreference().click();
	    selectOptionByText(mealPreferenceOptions, value);
	}

	// Select amenity option
	public void selectAmenity(String value) {
	    getAmenities().click();
	    selectOptionByText(amenitiesOptions, value);
	}

	// Select room amenity option
	public void selectRoomAmenity(String value) {
	    getRoomAmenities().click();
	    selectOptionByText(roomAmenitiesOptions, value);
	}

	// Select hotel chain option
	public void selectHotelChain(String value) {
	    getHotelChain().click();
	    selectOptionByText(hotelChainOptions, value);
	}

	// Select property type option
	public void selectPropertyType(String value) {
	    getPropertyType().click();
	    selectOptionByText(propertyTypeOptions, value);
	}

	// Select policy option
	public void selectPolicy(String value) {
	    getPolicies().click();
	    selectOptionByText(policiesOptions, value);
	}

	// Select pay at hotel option
	public void selectPayAtHotel(String value) {
	    getPayAtHotel().click();
	    selectOptionByText(payAtHotelOptions, value);
	}

	// Select location option
	public void selectLocation(String value) {
	    getLocation().click();
	    selectOptionByText(locationOptions, value);
	}
	
	// Validate displayed count matches actual results
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

	    // Debug values
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