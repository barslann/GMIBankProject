Feature: end-to-end test

  Background: User navigates to register page of gmi bank application
    Given user should be on the homepage "homepage_url"


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
    |123-12-1241|Esra|sdljf  |123 5th aven| 123-456-7890|test1|test1@gmail.com|Asdf123?|Asdf123?    |

#    change naming convention.
  @adminSignIn
  Scenario Outline: admin sign in
    When admin navigates to sign in page
    Then admin enter username "<username>"
    Then admin enter password "<password>"
    Then admin clicks sign in button
    Then admin should be on the home page with "<adminName>"
    Examples: admin sign in data
    |username| password|adminName|
    |laurine.wiza| a1STEM!ilg%!0C|Tommie Runolfsson|

    @adminSignIn
    Scenario: Admin activates user
      When admin clicks the administration menu
      And admin clicks user management option
      And admin click created date to sort the users
      And admin finds user and clicks deactivate button
      Then user should be activated


#  @SignIn
#  Scenario Outline: user sign in
#    When user navigates to sign in page
#    Then user enter username "<username>"
#    Then user enter password "<password>"
#    Then user clicks sign in button
#    Then user should be on the home page with "<adminName>"
#    Examples: user sign in data
#      |username| password|adminName|
#      |laurine.wiza| a1STEM!ilg%!0C|Tommie Runolfsson|



# isim , soyisim, sifre , ssn
#  employee tarafindan olusturulan account bilgileri kaydedilmeli -- ssn den bulup customer hesaplari olusturup kaydetmeli.
#  bu bilgiler uzerinden para transferi








