Feature: US_024
  Scenario: Creation a state
    Given user sends login info and gets the bearer token
    And User creates a state from api using "https://gmibank-qa-environment.com/api/tp-states"
    Then User validates that state is created