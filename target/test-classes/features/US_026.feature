Feature:
  Scenario: Update a country
    Given user sends login info and gets the bearer token
    And User updates a country from api using "countries_api_endpoint" with "22339"
    Then User validates that country is updated