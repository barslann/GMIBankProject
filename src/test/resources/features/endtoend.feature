Feature: end-to-end test

  Background: User navigates to register page of gmi bank application
    Given user should be on the homepage "homepage_qa_url"

  @endtoend
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
    |123-12-9971|Mehmet|Kaya  |123 5th aven| 123-456-7890|team46test8|team46test8@gmail.com|Asdf123?|Asdf123?    |


  @endtoend
  Scenario Outline: user sign in
    When user navigates to sign in page
    Then user enter username "<username>"
    Then user enter password "<password>"
    Then user clicks sign in button
    Then user should be on the home page with "<userName>"
    Examples: user sign in data
    |username| password|userName|
    |team46admin| Team46admin.| team46 Admin|
#    |laurine.wiza| a1STEM!ilg%!0C|Tommie Runolfsson|

  @endtoend
  Scenario: Admin activates user
    When admin clicks the administration menu
    And admin clicks user management option
    And admin click created date to sort the users
    And admin finds user and clicks deactivate button
    And user should be activated with message "A user is updated with identifier "
    Then admin should log out

  @endtoend
  Scenario Outline: user sign in
    When user navigates to sign in page
    Then user enter username "<username>"
    Then user enter password "<password>"
    Then user clicks sign in button
    Then user should be on the home page with "<name>"
    Examples: user sign in data
      |username| password|name|
      |team46employee| Team46employee.| team46 Employee|

  @endtoend
    Scenario Outline: employee creates 2 account for a customer
      When employee click my operations menu
      And employee click manage accounts option
      And employee click create a new account
      And employee provide description "<Description>" with "<userName>"
      And employee provide balance "<Balance>"
      And employee provide accountType "<AccountType>"
      And employee select create date
      And employee click save button
      Then account creation is successful message should be seen
      Examples: data needed for account creation
      |Description|userName| Balance | AccountType|
      |checking account for | | 20000| CHECKING   |
      |saving account for    | | 10000| SAVING    |

  @endtoend
    Scenario Outline: employee assign 2 accounts to a customer
      When employee click my operations menu
      And employee click manage customers option
      And employee click create a new customer
      And employee provide customer ssn
      And employee click search button
      And employee provide middle initial "<Middle Initial>"
      And employee provide phoneNumber "<PhoneNumber>"
      And employee provide zipcode "<zipCode>"
      And employee provide city "<City>"
      And employee pick accounts
      And employee clicks save button
      Then successful message should be seen
      And employee should log out
      Examples: data needed for connecting accounts to customer
      |Middle Initial| PhoneNumber|zipCode|City|
      |A             |123-123-1212| 98765 |Los Angeles|

  @endtoend
  Scenario Outline: user sign in
    When user navigates to sign in page
    Then user enter username "<username>"
    Then user enter password "<password>"
    Then user clicks sign in button
    Then user should be on the home page with "<userName>"
    Examples: user sign in data
      |username| password|userName|
      |team46test5| Asdf123?| Mehmet kaya|
#    |laurine.wiza| a1STEM!ilg%!0C|Tommie Runolfsson|

  @endtoend
  Scenario Outline: User performs every steps to transfer money between user's accounts
    When User navigates My Account page
    And User gets the info about users accounts balance
    Then User navigates to Transfer Money Page
    And User performs the money transfer "<Balance>" "<Cent>"
    Then User navigates My Accounts Page
    Then User validates that User $ money transferred successfully
    Examples:
    |Balance| Cent|
    |50      |10   |



















