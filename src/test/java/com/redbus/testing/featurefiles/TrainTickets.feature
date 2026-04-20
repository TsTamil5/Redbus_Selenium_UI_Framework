Feature:RedBus Railway Ticket Booking

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
      
      
  # ─── TC02: Invalid Station Name ─────────────────────────────────────────────
  Scenario: TC02 - Search with an invalid station name
    When the user enters "XYZABC" in the From station field
    And the user enters "Bengaluru City Junction" in the To station field
    And the user selects the travel date "25-May-2025"
    And the user clicks the Search button
    Then an error message or no trains message should be displayed

  # ─── TC03: Empty Fields Validation ───────────────────────────────────────────
  Scenario: TC03 - Search without entering From and To stations
    When the user clicks the Search button without entering any station
    Then a validation error or alert should be shown to the user

  # ─── TC04: No Trains Available Route ─────────────────────────────────────────
  Scenario: TC04 - Search for a route with no available trains
    When the user enters "Chennai Central" in the From station field
    And the user enters "Leh" in the To station field
    And the user selects the travel date "25-May-2025"
    And the user clicks the Search button
    Then a no trains found message should be displayed

  # ─── TC05: Swap From and To Stations ─────────────────────────────────────────
  Scenario: TC05 - Swap From and To station fields
    When the user enters "Chennai Central" in the From station field
    And the user enters "Bengaluru City Junction" in the To station field
    And the user clicks the Swap button
    Then the From station should now show "Bengaluru City Junction"
    And the To station should now show "Chennai Central"

  # ─── TC06: Page Title and URL Validation ─────────────────────────────────────
  Scenario: TC06 - Verify the RedBus Railways page loads correctly
    Then the page title should contain "Train Tickets"
    And the current URL should contain "redbus.in/railways"

      
      