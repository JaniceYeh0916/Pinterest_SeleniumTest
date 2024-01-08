@ignore
Feature: User logins the account

  Scenario: Logging in with invalid credentials
    Given user navigate to the login page
    When User enters valid email address " " into the email field
    And User enters valid password " " into the password field
    And User clicks on the login button
    Then user should get an error message about forgetting to input email in login page
    And close the window

  Scenario: Logging in with invalid credentials
    Given user navigate to the login page
    When User enters valid email address " " into the email field
    And User enters valid password "D1018661" into the password field
    And User clicks on the login button
    Then user should get an error message about forgetting to input email in login page
    And close the window

  Scenario: Logging in with invalid credentials
    Given user navigate to the login page
    When User enters valid email address "123" into the email field
    And User enters valid password "D1018661" into the password field
    And User clicks on the login button
    Then user should get an error message about error email in login page
    And close the window

  Scenario: Logging in with invalid credentials
    Given user navigate to the login page
    When User enters valid email address "123" into the email field
    And User enters valid password "" into the password field
    And User clicks on the login button
    Then user should get an error message about error email in login page
    And close the window

  Scenario: Logging in with invalid credentials
    Given user navigate to the login page
    When User enters valid email address "D1018661@o365.fc.edu.tw" into the email field
    And User enters valid password "D1018661" into the password field
    And User clicks on the login button
    Then user should get an error message about not belong to any email in login page
    And close the window