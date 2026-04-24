Feature: RedBus Accounts Feature

  Background:
    Given user is on RedBus homepage
    When user clicks on accounts

  Scenario Outline: login using saved cookies and click on bookings
    When user clicks on bookings
    And user navigates to My Profile
    And user clicks on Edit Profile
    And user updates profile details "<name>" "<email>" "<gender>"
    And user clicks on Save
    Then profile should reflect updated details "<name>" "<email>" "<gender>"

	Examples:
  	| name | email | gender |
  	| ABC  | abc@gmail.com | female |

  Scenario: Verify Offers page navigation from Accounts
    And user clicks on Offers
    Then Offers page should be displayed
    When user clicks on first offer
    Then offer details page should be displayed and verified

  Scenario: Verify the help section
    When user navigate to the Help page
    And user click  on Bus FAQ
    And user click on Bus cancellation category
    And user tap on the query
    Then the FAQ page title should be displayed

  Scenario: Reshedule Ticket using excel
    When user clicks on Reshedule Ticket
    And Enter Ticket number and Mobile number from excel sheet "RescheduleData" row 1
    And user click on search
    Then verify the Reshedule page

  Scenario: Cancel the Ticket in Accounts
    When user clicks on Cancel the Ticket
    And Enter Ticketnumber and Mobilenumber
      | Ticket number | Mobile number |
      | TV4H90793910  | 8015921423    |
    And click on select passengers
    Then verify the cancel ticket page

  Scenario: Cancel the Ticket in Accounts using Invalid Mobile number
    When user clicks on Cancel the Ticket
    And Enter Ticketnumber and Mobilenumber
      | Ticket number | Mobile number |
      | TV4H90793910  | 80159         |
    And click on select passengers
    Then verify the cancel ticket page with invalid number
    
    Scenario: Search the Ticket and verify using excel
    When user click on Search Ticket
    And Enter TicketNo and MobileNo from excel sheet "RescheduleData" row 1
    And click on searchButton
    And verify the Ticket
    And click on chat with RedBuddy
    Then Verify the help page

    
   



   

  

