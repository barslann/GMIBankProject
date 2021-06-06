Feature: end-to-end test

  Background: User navigates to register page of gmi bank application
    Given user should be on the homepage "homepage_url"
    When user navigates to register page

  Scenario Outline: Customer creation
    Then User provide SSN "<SSN>"
    Then User provide firstName "<firstName>"
    Then User provide lastName "<lastName>"
    Then User provide address "<address>"
    Then User provide phoneNumber "<phoneNumber>"
    Then User provide userName "<userName>"
    Then User provide email "<email>"
    Then User provide newPassword "<newPassword>"
    Then User provide newPasswordConfirmation "<newPasswordConfirmation>"
    Then User clicks register button
    And  User successful message should be seen "Registration saved! Please check your email for confirmation."
    Examples: Valid user creation credentials
    |SSN| firstName|lastName|address|phoneNumber|userName|email|newPassword|newPasswordConfirmation|
    |123-12-1241|Esra|sdljf  |123 5th aven| 123-456-7890|test1|test1@gmail.com|Asdf123?|Asdf123?    |



