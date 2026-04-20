Feature: RedBus Railway Ticket Booking

  Scenario Outline: Search trains with valid details
    Given the user is on the RedBus homepage
    When the user navigates to train ticket booking page
    And user selects journey month "<month>" and day "<day>"
    And user enters source "<source>" and destination "<destination>"
    And user clicks on search trains
    Then the train results should be displayed

    Examples:
      | month | day | source  | destination |
      | April | 19  | Chennai | Bangalore   |