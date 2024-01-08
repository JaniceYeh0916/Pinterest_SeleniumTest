@ignore
Feature: User enter the keyword and search

  Scenario Outline: User enter the keyword and search
    Given user navigate to the login page
    When User enters valid email address <email> into the email field
    And User enters valid password <password> into the password field
    And User clicks on the login button
    Then user clicks on the searchbar for searching <search_keyword>
    Then user click the category
    Then close the window

    Examples:
      | email                      | password    | search_keyword |
      | "D1051089@o365.fcu.edu.tw" | "D1051089"  | "cute cat"     |

