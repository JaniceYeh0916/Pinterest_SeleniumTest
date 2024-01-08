@ignore
Feature: Update the picture and create the pin

  Scenario: Create pin fail
    Given user navigate to the login page
    When User enters valid email address "D1050957@o365.fcu.edu.tw" into the email field
    And User enters valid password "d1050957" into the password field
    And User clicks on the login button
    And User clicks on the create button
    Then the user want to click publish button but should not see it
    Then close the window

  Scenario: Create pin success
    Given user navigate to the login page
    When User enters valid email address "D1050957@o365.fcu.edu.tw" into the email field
    And User enters valid password "d1050957" into the password field
    And User clicks on the login button
    And User clicks on the create button
    And selects an image file to upload
    Then user clicks on the submit button
    Then close the window
