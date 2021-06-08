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
    |123-12-1241|Esra|sdljf  |123 5th aven| 123-456-7890|test1|test1@gmail.com|Asdf123?|Asdf123?    |

  Scenario Outline:  navigate to the register page and provide the ssn
    And Click on SSN textbox
    And Provide SSN "<SSN>"
    Then I should not see the error message translation-not-found[Your SSN is required]
    Examples: Data test
      |SSN|
      |345-34-4567|
      |213-34-6561|
      |800-12-1231|
      |555-55-5555|

  Scenario Outline:  navigate to the register page and provide the ssn
    And Click on SSN textbox
    And Provide SSN "<SSN>"
    Then I should  see the ssn is invalid error message "Ssn is invalid."
    Examples: Invalid SSN test
      |SSN|
      |999-12-1234|
      |000-12-1234|