@ignore
Feature: Save, download, share the picture

  Scenario: Save、download、share picture
    Given user navigate to the login page
    When User enters valid email address "D1018661@o365.fcu.edu.tw" into the email field
    And User enters valid password "D1018661" into the password field
    And User clicks on the login button
    And user click the first picture
    Then user save the picture
    Then close the window

  Scenario: Download picture
    Given user navigate to the login page
    When User enters valid email address "D1051415@o365.fcu.edu.tw" into the email field
    And User enters valid password "20030408helloworld" into the password field
    And User clicks on the login button
    And user click the first picture
    And user click the function list
    And user click the button of saving picture
    Then close the window

  Scenario: Share picture
    Given user navigate to the login page
    When User enters valid email address "D1051089@o365.fcu.edu.tw" into the email field
    And User enters valid password "D1051089" into the password field
    And User clicks on the login button
    And user click the first picture
    And user click the button of sharing picture
    And user click the button of copying path
    Then close the window
