Feature: Bus Ticket Booking End-to-End Flow
	
	@SwapFeature
  Scenario: Verify buses are displayed after swapping source and destination
    Given User is on the RedBus homepage
    When the user enters source and destination
      | source  | destination |
      | Chennai | Bangalore   |
    And the user clicks on swap button
    And the user clicks on search buses
    Then the bus list should be displayed

  @BusSearch
  Scenario: Search buses
    Given User is on the RedBus home page
    When User enters source
    And User enters destination
    And User selects travel date
    And User clicks on search button
    Then User should see list of available buses

  @NegativeSearch
  Scenario: Search buses without entering source and destination
    Given User is on the RedBus home page
    When User clicks on search button without entering source and destination
    Then User should see validation error message

  @NegativeSearch_SameCity
  Scenario Outline: Search buses with same source and destination
    Given User is on the RedBus homepage
    When the user enters source "<city>"
    And the user enters destination "<city>"
    And the user clicks on search buses
    Then the error message "Source and Destination city cannot be same" should be displayed

    Examples: 
      | city      |
      | Koyambedu |

  @SeatSelection
  Scenario: Select bus and seat
    Given User searches buses
    When User selects FlixBus and route
    And User selects an available seat
    And User clicks on proceed button
    Then User should move to boarding and dropping page

  @BoardandDrop
  Scenario: Select boarding and dropping points
    Given User has selected seat
    When User selects boarding point
    And User selects dropping point
    And User clicks on continue
    Then User should move to passenger details page

  @Payment
  Scenario Outline: Enter passenger details and proceed to payment
    Given User is on passenger details page
    When User enters basic passenger details
      | phone      | email          | state      |
      | 9876543210 | test@gmail.com | Tamil Nadu |
    And User enters personal details "<name>" "<age>" "<gender>"
    Then User should see payment options

    Examples: 
      | name      | age | gender |
      | Test User |  25 | female |
      | Demo User |  30 | male   |
