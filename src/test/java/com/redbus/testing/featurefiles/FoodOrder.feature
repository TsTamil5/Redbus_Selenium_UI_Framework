Feature: Food Search

  Background:
    Given user is on the food ordering page

@foodsearch
 Scenario: Verify user can search for a restaurant and navigate to its page
  When user enters data "Aasife Biriyani" in the search field
   And user selects "Aasife Biriyani" from the suggestions
    Then user should be navigated to the restaurant page
    And restaurant name "Aasife Biriyani" should be displayed

@suggestionVerification
Scenario Outline: Verify suggestions appear and contain relevant data while typing

    When user enters partial data "<input>" in the search field
    Then suggestions should be displayed
    And suggestions should contain "<expected>"

Examples:
    | input  | expected          |
    | Aasif  | Aasife Biriyani  |
    | french | French Fries Full   |
    | chine  | Chinese          |
    
   @popularfoodrestaurant 
  Scenario: Verify restaurant list is displayed after selecting a popular food item
    When user clicks on "Pizza" from Popular Foods section
    Then user should be navigated to the restaurant listing page
    And restaurant list should be displayed
    
    @trainrestaurant
  Scenario: Verify restaurant list is displayed after selecting train details
    When user searches train number "12622"
    And user selects train "TAMILNADU EXP" from suggestions
    Then boarding station and date fields should be enabled
    When user selects valid boarding date "2026-04-30"
    And user selects valid boarding station
    And user clicks on Find Food button
    Then user is navigated to train restaurant results page
    And restaurant list should be visible
    
    @dishverification
    Scenario: Verify dish is available in restaurant menu
    When user searches for restaurant name and selects it from suggestions
    Then user should be navigated to that restaurant menu page
    Then user checks whether dish is present in the menu
    
    @invaliddata
    Scenario: Verify invalid search input shows no results message
    When user enters invalid data "/////" in the search field
    And user clicks search button
    Then no results message should be displayed