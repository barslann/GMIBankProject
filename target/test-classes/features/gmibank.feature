Feature: navigate to the gmibank homepage

  Background:
    Given user should be on the homepage
    When navigate to the website "https://gmibank.com/"
    And You should navigate to registration page


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


  Scenario:  navigate to the register page and provide the ssn
    And Click on SSN textbox
    And Provide SSN ""
    Then I should see the Please enter your social security number error message "Please enter your social security number."


  Scenario Outline:  navigate to the register page and provide the firstname
    And Click on firstName textbox
    And Provide firstName "<FirstName>"
    Then I should not see any error
    Examples: Invalid SSN test
      |FirstName|
      |Ahmet|
      |Fatma|

  Scenario:  navigate to the register page and provide the firstname
    And Click on firstName textbox
    And Provide firstName ""
    Then I should see the error "Please enter your first name."

  Scenario Outline:  navigate to the register page and provide the firstname
    And Click on firstName textbox
    And Provide invalid firstName "<FirstName>"
    Then I should see the error "FirstName is invalid"
    Examples: Invalid FirstNames
      |FirstName|
      |Ahmet123|
      |Fa123tma|
      |Bu?se-|
      |12345|








