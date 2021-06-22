package gmibank.stepdefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import gmibank.pojo.Country;
import gmibank.utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class US_025_StepDefinitions {
    Response response;
    String bearerToken= ConfigurationReader.getProperty("api_bearer_token");
    Country[] country;
    ObjectMapper objectMapper = new ObjectMapper();
    int expectedId;
    String filePath = "src/test/resources/data/AllcountryIds.txt";
    @And("User creates a country from api using {string}")
    public void userCreatesACountryFromApiUsing(String endPoint) throws IOException {
        Map<String, Object> createdCountry = new HashMap<>();
        createdCountry.put("name", "Gambiya");
        createdCountry.put("states", null);
        response = given().headers("Authorization" , "Bearer " + bearerToken, "Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
                .when()
                .body(createdCountry)
                .post(ConfigurationReader.getProperty(endPoint))
                .then()
                .extract().response();

        response = given().headers("Authorization" , "Bearer " + bearerToken, "Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
                .when()
                .get(ConfigurationReader.getProperty(endPoint))
                .then()
                .extract().response();
        response.prettyPrint();
    }
    @Then("User validates that country is created")
    public void userValidatesThatCountryIsCreated()  {
        JsonPath jsonPath = response.jsonPath();
        List<Integer> actualId= jsonPath.get("id");
        Assert.assertTrue(actualId.contains(22339));
    }
}