Feature: Food Search

  Background:
    Given user is on the food ordering page

@foodsearch
Scenario Outline: Verify user can search for a restaurant and navigate to its page

  When user enters data "<restaurant>" in the search field
  And user selects "<restaurant>" from the suggestions
  Then user should be navigated to the restaurant page
  And restaurant name "<restaurant>" should be displayed

Examples:
  | restaurant        |
  | Aasife Biriyani   |
  | Hotplate Xpress    |
  | Royal Caterers   |

@suggestionVerification
Scenario Outline: Verify suggestions appear and contain relevant data while typing
 When user enters partial data and validates suggestions
    | input  | expected            |
    | Aasif  | Aasife Biriyani    |
    | shawa | Shawarma  |
    | chine  | Chinese            |
    
    
   @popularfoodrestaurant 
  Scenario: Verify restaurant list is displayed after selecting a popular food item
    When user clicks on "Pizza" from Popular Foods section
    Then restaurant listing page should be displayed
    
    @trainrestaurant
  Scenario: Verify restaurant list is displayed after selecting train details
    When user searches train number "12622"
    And user selects train "TAMILNADU EXP" from suggestions
    Then boarding station and date fields should be enabled
    When user selects valid boarding date "2026-04-30"
    And user selects valid boarding station
    And user clicks on Find Food button
   Then train restaurant results page should be displayed
    
    @dishverification
    Scenario: Verify dish is available in restaurant menu
    When user searches for restaurant name and selects it from suggestions
    Then user should be navigated to that restaurant menu page
    Then user checks whether dish is present in the menu
    
    @invaliddata
    Scenario: Verify invalid search input shows no results message
    When user enters invalid data "/////" in the search field
    Then no results message should be displayed
    
    
	@defectScenario
    Scenario:Verify invalid search input always shows no results message
    When user enters invalid data "@@@@@"
    Then no results found message has to be displayed