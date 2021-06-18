Feature: Registration API Validation
  Background: Api end point id being set in response
    Given User provides the api endpoint to set response using "registration_api_endpoint" "api_bearer_token"
  Scenario:
    And All registrations info will be set to Registrations with deserialization
    Then All registrations info will be saved to txt files
    Then All registrations info has been validated