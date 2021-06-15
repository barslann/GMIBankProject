package gmibank.stepdefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import gmibank.pojo.Customer;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.UtilityMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.*;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class US_020_StepDefinitions {
    Response response;
    Customer[] customers;

    @Given("User provides the api end point to set the response using {string} {string}")
    public void userProvidesTheApiEndPointToSetTheResponseUsing(String customerEndPoint, String bearerToken) throws IOException {
        Map<String,Object> mapForToken= new HashMap<>();
        mapForToken.put("username","team46admin");
        mapForToken.put("password","Team46admin.");
        mapForToken.put("rememberMe",false);

//        response = given().headers("Content-Type", ContentType.JSON,"Accept",ContentType.JSON)
//                .when().body(mapForToken)
//                .post(ConfigurationReader.getProperty("authentication_api_endpoint"))
//                .then()
//                .contentType(ContentType.JSON)
//                .extract().response();
//
//        response.prettyPrint();


        response = given().headers("Authorization", "Bearer " + ConfigurationReader.getProperty(bearerToken),"Content-Type", ContentType.JSON,"Accept",ContentType.JSON)
                .when().param("size",5)
                .get(ConfigurationReader.getProperty(customerEndPoint))
                .then()
                .contentType(ContentType.JSON)
                .extract().response();

//        response.prettyPrint();

    }

    @And("All customer info will be set to customers with deserialization")
    public void allCustomerInfoWillBeSetToCustomersWithDeserialization() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        customers = objectMapper.readValue(response.asString(),Customer[].class);
    }

    @Then("All customer info will be saved to txt files")
    public void allCustomerInfoWillBeSavedToTxtFiles() {
        UtilityMethods.saveObjectToFile("/Users/coderman/Desktop/GMIBankFramework/src/test/resources/data/CustomerData.txt",customers);
    }

    @Then("All customer info has been validated")
    public void allCustomerInfoHasBeenValidated() {
        List<String> customerSsnList = UtilityMethods.getCustomerSsnList();
        List<String> expectedList = new ArrayList<>();
        expectedList.add("476-90-9374");
        expectedList.add("473-22-1798");
        expectedList.add("326-87-0676");

        Assert.assertTrue("There is an error!", customerSsnList.containsAll(expectedList));

    }
}
