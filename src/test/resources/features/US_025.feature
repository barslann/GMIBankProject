Feature: US_025
  Scenario: Creation a country
    And User creates a country from api using "countries_api_endpoint"
    Then User validates that country is created