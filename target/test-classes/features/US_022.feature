Feature: States API Validation
  Background: Api end point id being set in response
    Given User provides the api end point to set response using "states_api_endpoint" "api_bearer_token"
  Scenario:
    And All states info will be set to countries with deserialization
    Then All states info will be saved to txt files
    Then All states info has been validated