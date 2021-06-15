Feature: Customer API Validation
  Background: Api end point is being set in response
    Given User provides the api end point to set the response using countries api "countries_api_endpoint" "api_bearer_token"

  @CountryApiTesting
  Scenario:
    And All country info will be set to countries with deserialization
    Then All country info will be saved to txt files
    Then All country info has been validated