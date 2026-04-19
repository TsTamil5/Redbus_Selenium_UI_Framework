Feature: Bus Ticket Booking End-to-End Flow

  @BusSearch
  Scenario: Search buses
    Given User is on the RedBus home page
    When User enters source
    And User enters destination
    And User selects travel date
    And User clicks on search button
    Then User should see list of available buses

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
