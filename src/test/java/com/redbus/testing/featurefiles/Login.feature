Feature: RedBus Accounts Login

Background:

 Given user is on RedBus homepage
  When user clicks on accounts

 Scenario: Login to RedBus and save cookies
 	When user clicks on login button
    Then user should be logged in successfully
    And cookies should be saved for future use
