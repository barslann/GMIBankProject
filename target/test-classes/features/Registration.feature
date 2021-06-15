Feature:
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
    |123-12-1243|Esra|sdljf  |123 5th aven| 123-456-7890|test1|test1@gmail.com|Asdf123?|Asdf123?    |

  Scenario Outline:  navigate to the register page and provide the ssn
    And Click on SSN textbox
    And Provide SSN "<SSN>"
    Then I should  see the ssn is invalid error message "Ssn is invalid."

    Examples: Invalid SSN test
      |SSN|
      |999-12-1234|
      |000-12-1234|

    @US_002
    @TC_002
  Scenario Outline: SSN number cannot be any chars nor spec chars expect "-"
      When user navigates to register page
      And User provide SSN "<SSN>"
      Then The error message should be seen "<Error Message>"
      Examples: invalid ssn and error message
      |   SSN   |Error Message|
      |  asd    |Your SSN is invalid|
      | 123asd  |Your SSN is invalid|
      | 123?12?1232| Your SSN is invalid|

  @US_002
  @TC_003
  Scenario Outline: Mobilephone number cannot be any chars nor spec chars expect "-"
    When user navigates to register page
    And User provide SSN "<Mobilephone>"
    Then The error message should be seen "<Error Message>"
    Examples: invalid ssn and error message
      |   Mobilephone   |Error Message|
      | 123-123-123a    |Your mobile phone number is invalid|
      | 12a-12a-123a    |Your mobile phone number is invalid|
      | 123?122?1232    | Your mobile phone number is invalid|

  @US_002
  @TC_003
  Scenario Outline: Mobilephone number cannot be any chars nor spec chars expect "-"
    When user navigates to register page
    And User provide phoneNumber "<Mobilephone>"
    Then The error message should be seen "<Error Message>"
    Examples: invalid phoneNumber and error message
      |   Mobilephone   |Error Message|
      | 123-123-123a    |Your mobile phone number is invalid|
      | 12a-12a-123a    |Your mobile phone number is invalid|
      | 123?122?1232    | Your mobile phone number is invalid|

  @US_003
  @TC_004
  Scenario Outline: email id cannot be created without "@" sign and "." extensions
    When user navigates to register page
    And User provide email "<email>"
    Then The error message should be seen "<Error Message>"
    Examples: invalid email and error message
      |   email   |Error Message|
      | beckars@gmailcom  |This field is invalid|
      | beckarsgmail.com  |This field is invalid|
      | @gmail.com        |This field is invalid|

  @US_004
    @TC_001
  Scenario Outline: There has to be at least 7 chars for a stronger password
    When user navigates to register page
    And User provide newPassword "<password>"
    Then The error message should be seen "<Error Message>"
    Examples: password and error message
      |   password   |Error Message|
      | beckars@gmailcom  |This field is invalid|
      | beckarsgmail.com  |This field is invalid|
      | @gmail.com        |This field is invalid|




