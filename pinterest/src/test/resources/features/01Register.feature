@ignore
Feature: Login

  Scenario: Logging in with invalid credentials
    Given user navigate to the register page
    When user enters " " into the email field
    And user enters " " into the password field
    And user enters "0020030707" into the birthdate field
    And user clicks on the continue button
    Then user should get an error message about forgetting to input email in login page
    And close the window

  Scenario: Logging in with invalid credentials
    Given user navigate to the register page
    When user enters " " into the email field
    And user enters "D1018661" into the password field
    And user enters "0020030707" into the birthdate field
    And user clicks on the continue button
    Then user should get an error message about forgetting to input email in login page
    And close the window

  Scenario: Logging in with invalid credentials
    Given user navigate to the register page
    When user enters "123" into the email field
    And user enters "D1018661" into the password field
    And user clicks on the continue button
    Then user should get an error message about error email in register page
    And close the window

  Scenario: Logging in with invalid credentials
    Given user navigate to the register page
    When user enters "123" into the email field
    And user enters "" into the password field
    And user clicks on the continue button
    Then user should get an error message about error email in register page
    And close the window

  Scenario: Logging in with invalid credentials
    Given user navigate to the register page
    When user enters "D1018661@o365.fc.edu.tw" into the email field
    And user enters "D1018661" into the password field
    And user clicks on the continue button
    Then user should get an error message about not belong to any email in register page
    And close the window

  Scenario: Logging in with valid credentials
    Given user navigate to the register page
    When user enters "D1018661@o365.fcu.edu.tw" into the email field
    And user enters "D1018661" into the password field
    And user clicks on the continue button
    Then user should get an error message about not belong to any email in register page
    And close the window
