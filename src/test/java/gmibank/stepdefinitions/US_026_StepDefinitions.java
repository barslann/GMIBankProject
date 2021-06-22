package gmibank.stepdefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import gmibank.pojo.Country;
import gmibank.pojo.LoginInfo;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.ConstantVariables;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
public class US_026_StepDefinitions {
    Response response;

    @And("User updates a country from api using {string} with {string}")
    public void userUpdatesACountryFromApiUsingWith(String url, String id) throws IOException {
        // to get the specific user with id.
        response = given().headers("Authorization", "Bearer " + ConstantVariables.generalToken, "Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
                .when()
                .get(ConfigurationReader.getProperty(url) + "/" + id);
        response.prettyPrint();


        Country country = new ObjectMapper().readValue(response.asString(),Country.class);
        country.setName("Team46New");

        response = given().headers("Authorization", "Bearer " + ConstantVariables.generalToken, "Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
                .when()
                .body(country)
                .put(ConfigurationReader.getProperty(url))
                .then()
                .statusCode(200)
                .extract().response();
        response.prettyPrint();
    }

    @Then("User validates that country is updated")
    public void userValidatesThatCountryIsUpdated() {
        JsonPath jsonPath = response.jsonPath();
        String  actualName = jsonPath.get("name");
        Assert.assertTrue(actualName.contains("Team46New"));
    }
}