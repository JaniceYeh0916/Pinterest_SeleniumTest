@ignore
Feature: Search keyword in explore page without login

  Scenario Outline: search keyword without login
    Given user navigate to the explore page
    When User clicks on the explore button
    Then user searches for <keyword> from explore
    Then close the window

    Examples:
      | keyword      |
      | "IKEA shark" |
