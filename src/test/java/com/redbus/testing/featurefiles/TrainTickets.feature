#Feature: Enter details with valid deatils
#Scenario:
#Given User launches browser and opens redBus
#When User clicks on Train Tickets
#And User selects source city
#And User selects destination city
#And User selects journey date
#And User clicks on search trains
#Then User clicks on search trains
Feature: RedBus Railway Ticket Booking End-to-End Flow

  Background:
    Given the user is on the RedBus homepage
    When the user navigates to train ticket booking page


  # ================= SCENARIO 1 =================
  Scenario Outline: Search trains with valid details
    When user Selects journey month "<month>" and day "<day>"
    And user enters source "<source>" and destination "<destination>"
    And user click on search trains
    Then the train results should be displayed

    Examples:
      | month | day | source  | destination |
      | April | 19  | Chennai | Bangalore   |


  # ================= SCENARIO 2 =================
  Scenario Outline: Modify search from results page
    When user Choses journey month "<month>" and day "<day>"
    And user enters From "<source>" and destination "<destination>"
    And user clicks on search trains
    And user modifies search with new source "Delhi" and destination "Delhi"
    Then updated train results should be displayed

    Examples:
      | month | day | source    | destination |
      | April | 20  | Hyderabad | Pune        |


  # ================= SCENARIO 3 =================
  Scenario Outline: Apply filters and view trains
    When user selects  month "<month>" and day "<day>"
    And user enters source "<source>" and To "<destination>"
    And user Press on search trains
    And user applies filters for AC and available tickets
    Then filtered train results should be displayed

    Examples:
      | month | day | source  | destination |
      | April | 19  | Chennai | Bangalore   |


  # ================= SCENARIO 4 =================
  Scenario Outline: View train route details
    When user selects Planed month "<month>" and day "<day>"
    And user Provides source "<source>" and destination "<destination>"
    And user Clicks on search trains
    And user clicks on view route for a train
    Then train route details should be displayed

    Examples:
      | month | day | source  | destination |
      | April | 19  | Chennai | Bangalore   |


  # ================= SCENARIO 5 =================
  Scenario Outline: Enter passenger details and verify popup
    When user Provides journey month "<month>" and day "<day>"
    And user entered source "<source>" and destination "<destination>"
    And user Selects on search trains
    And user selects a train and enters passenger details
    Then free cancellation popup should be displayed

    Examples:
      | month | day | source  | destination |
      | April | 19  | Chennai | Bangalore   |


  # ================= SCENARIO 6 =================
  Scenario Outline: Proceed to payment page
    When user gives planned journey month "<month>" and day "<day>"
    And user gives source "<source>" and destination "<destination>"
    And user clicks on Search Trains
    And user completes booking steps
    Then payment page should be displayed

    Examples:
      | month | day | source  | destination |
      | April | 19  | Chennai | Bangalore   |