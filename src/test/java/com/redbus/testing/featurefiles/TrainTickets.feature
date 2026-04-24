Feature: RedBus Railway Ticket Booking
@trainSearch
  Scenario Outline: Search trains with valid details
    Given the user is on the RedBus homepage
    When the user navigates to train ticket booking page
    And user selects journey month "<month>" and day "<day>"
   And user enters source "<source>" and destination "<destination>"
    And user clicks on search trains
    Then the train results should be displayed

    Examples:
      | month | day | source  | destination |
      | April | 27  | Chennai | Bangalore   |
      @InvalidtrainSearch
  Scenario Outline: Search trains with valid details
    Given the user is on the RedBus homepage
    When the user navigates to train ticket booking page
    And user selects journey month "<month>" and day "<day>"
    And user enters source "<source>" and destination "<destination>"
    And user clicks on search trains
    Then the system should show an error message for each combination
      Examples:
      | month | day | source  | destination |
      | April | 27  | Chennai | Chennai     |
      
      
      @ViewRoute
  Scenario: View train route details
  Given User searches trains from "Chennai" to "Bangalore" on "April" "27"
  When User clicks on view route for a train
  Then User should see train route details
    
    @ResultPage
  Scenario: Search and re-search trains
     When the user navigates to train ticket booking page
     Given User enters "Chennai" as source and "Bangalore" as destination on "April" "27"
  When User clicks on search trains
  Then User should see train results
  When User verifies "Chennai" as source and "chennai" as destination on "April" "28"
  And User clicks on search trains again
  Then User should see updated train results
  
    
    @PassengerDetails
  Scenario: Enter passenger details and verify popup

    Given User searches trains from "Chennai" to "Bangalore" on "April" "27"
    When User selects a train
    And User fills passenger details
    Then User should see free cancellation popup

    