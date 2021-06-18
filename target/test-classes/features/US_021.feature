Feature: Countries API Validation
  Background: Api end point id being set in response
    Given User provides the api end point to set response using "countries_api_endpoint" "api_bearer_token"
  Scenario:
    And All countries info will be set to countries with deserialization
    Then All countries info will be saved to txt files
    Then All countries info has been validated