Feature: Money transfer should be available
  Scenario: User performs every steps to transfer money between user's accounts
    Given User on the "homepage_qa_url"
    When User navigates to sign in page
    And User provides a valid username "customer_username"
    And User provides a valid password "customer_password"
    And User clicks on sign in button
    Then User navigates My Account page
    And User gets the info about users accounts balance
    Then User navigates to Transfer Money Page
    And User performs the money transfer
    Then User navigates My Accounts Page
    Then User validates that User $ money transferred successfully