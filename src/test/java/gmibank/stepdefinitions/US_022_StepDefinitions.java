package gmibank.stepdefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import gmibank.pojo.State;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.UtilityMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class US_022_StepDefinitions {
    Response response;
    State[] states;
    @Given("User provides the api end point to set response using {string} {string}")
    public void userProvidesTheApiEndPointToSetResponseUsing(String statesEndpoint, String bearerToken) {
        response =given().headers("Authorization", "Bearer " + ConfigurationReader.getProperty(bearerToken), "Content-Type", ContentType.JSON,"Accept", ContentType.JSON)
                .when().get(ConfigurationReader.getProperty(statesEndpoint))
                .then()
                .contentType(ContentType.JSON)
                .extract().response();
        response.prettyPrint();
    }
    @And("All states info will be set to countries with deserialization")
    public void allStatesInfoWillBeSetToCountriesWithDeserialization() {
        //ObjectMapper obj = new ObjectMapper();
        try {
            states =  new ObjectMapper().readValue(response.asString(),State[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Then("All states info will be saved to txt files")
    public void allStatesInfoWillBeSavedToTxtFiles() {
        UtilityMethods.saveObjectToFile("src/test/resources/data/Allstates.txt", states);
    }
    @Then("All states info has been validated")
    public void allStatesInfoHasBeenValidated() {
        List<String> actualStatesData= UtilityMethods.returnAllStatesIdList("src/test/resources/data/Allstates.txt");
        List<String> expectedData= new ArrayList<>();
        expectedData.add("Midi-Pyrenees");
        expectedData.add("California");
        Assert.assertTrue(actualStatesData.containsAll(expectedData), "Doesn't match");
    }
}