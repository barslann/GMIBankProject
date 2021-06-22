Feature:
  Scenario: Delete a state
    Given user sends login info and gets the bearer token
    And User deletes a state from api using "states_api_endpoint" with "27513"
    Then User validates that state is deleted