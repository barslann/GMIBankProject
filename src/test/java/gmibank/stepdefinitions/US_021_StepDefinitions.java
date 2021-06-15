package gmibank.stepdefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import gmibank.pojo.Country;
import gmibank.pojo.Customer;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.UtilityMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class US_021_StepDefinitions {
    Response response;
    Country[] countries;

    @Given("User provides the api end point to set the response using countries api {string} {string}")
    public void userProvidesTheApiEndPointToSetTheResponseUsingCountriesApi(String countries_api_endpoint, String api_bearer_token) {
//        Map<String,Object> mapForToken= new HashMap<>();
//        mapForToken.put("username","team46admin");
//        mapForToken.put("password","Team46admin.");
//        mapForToken.put("rememberMe",false);
//
//        response = given().headers("Content-Type", ContentType.JSON,"Accept",ContentType.JSON)
//                .when().body(mapForToken)
//                .post(ConfigurationReader.getProperty("authentication_api_endpoint"))
//                .then()
//                .contentType(ContentType.JSON)
//                .extract().response();
//
//        response.prettyPrint();


        response = given().headers("Authorization", "Bearer " + ConfigurationReader.getProperty(api_bearer_token),"Content-Type", ContentType.JSON,"Accept",ContentType.JSON)
                .when()
                .get(ConfigurationReader.getProperty(countries_api_endpoint))
                .then()
                .contentType(ContentType.JSON)
                .extract().response();

        response.prettyPrint();
    }

    @And("All country info will be set to countries with deserialization")
    public void allCountryInfoWillBeSetToCountriesWithDeserialization() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        countries = objectMapper.readValue(response.asString(), Country[].class);
    }

    @Then("All country info will be saved to txt files")
    public void allCountryInfoWillBeSavedToTxtFiles() {
        UtilityMethods.saveCountriesToFile("/Users/coderman/Desktop/GMIBankFramework/src/test/resources/data/CountryData.txt",countries);
    }


    @Then("All country info has been validated")
    public void allCountryInfoHasBeenValidated() {
    }


}
