Feature:Login Feature 

Background:
    Given user is on RedBus homepage
    And user clicks on Accounts

Scenario: Login to Redbus using excel
   
    And user clicks on Login button
    And user enters mobile number
    And user clicks on captcha checkbox
    And user clicks on Continue button
    And user clicks on Verify button
  

Scenario:Successful login and profile update

  	
    And the user clicks on Bookings
    And user clicks on Login using excel
    And user enters mobile number using excel data
    And user clicks on captcha 
    And user click on generate otp
    And user clicks on Verify otp
    When the user navigates to My Profile
    And the user clicks on Edit Profile
    And the user updates the profile details
    | name       | email         |
    | ABC        | abc@gmail.com |
    And the user clicks on Save
    Then the profile should be updated successfully

Scenario: Verify Offers page navigation from Accounts
 
  And user clicks on Offers
  Then Offers page should be displayed
  When user clicks on first offer
  Then offer details page should be displayed and verified
  
 Scenario Outline: Verify the help section
    
    When user navigate to the Help page
    And user click  on Bus FAQ 
    And user click on Bus cancellation category
    And user tap on the query   
    Then the FAQ page title should be displayed 

   

  

