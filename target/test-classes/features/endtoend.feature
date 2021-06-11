Feature: end-to-end test

  Background: User navigates to register page of gmi bank application
    Given user should be on the homepage "homepage_url"

  @registration
  Scenario Outline: Customer creation
    When user navigates to register page
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
    |123-12-1261|Mehmet|kaya  |123 5th aven| 123-456-7890|sdf|test1@gmail.com|Asdf123?|Asdf123?    |


  @SignIn
  Scenario Outline: user sign in
    When user navigates to sign in page
    Then user enter username "<username>"
    Then user enter password "<password>"
    Then user clicks sign in button
    Then user should be on the home page with "<userName>"
    Examples: user sign in data
    |username| password|userName|
    |laurine.wiza| a1STEM!ilg%!0C|Tommie Runolfsson|

  @SignIn
  Scenario: Admin activates user
    When admin clicks the administration menu
    And admin clicks user management option
    And admin click created date to sort the users
    And admin finds user and clicks deactivate button
    And user should be activated
    Then admin should log out




# isim , soyisim, sifre , ssn
#  employee tarafindan olusturulan account bilgileri kaydedilmeli -- ssn den bulup customer hesaplari olusturup kaydetmeli.
#  bu bilgiler uzerinden para transferi








