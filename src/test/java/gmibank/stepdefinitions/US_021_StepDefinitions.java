package gmibank.stepdefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import gmibank.pojo.Country;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.UtilityMethods;
import io.cucumber.java.en.And;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.openqa.selenium.json.Json;
import org.testng.Assert;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertTrue;

public class US_021_StepDefinitions {

    Response response;
    Country[] country;
    // private static final String filePath= "/Users/esraozdem/IdeaProjects/GMIBankProjectOzdem/src/test/resources/data/AllCountriesData.txt";
    //@Given("User provides the api end point to set response using {string} {string}")
    // public void userProvidesTheApiEndPointToSetResponseUsing(String countriesEndpoint, String bearerToken) {
//        Map<String,Object> mapForToken= new HashMap<>();
//        mapForToken.put("username","team46admin");
//        mapForToken.put("password","Team46admin.");
//        mapForToken.put("rememberMe",false);
//        response = given().headers("Content-Type", ContentType.JSON,"Accept",ContentType.JSON)
//                .when().body(mapForToken)
//                .post(ConfigurationReader.getProperty("authentication_api_endpoint"))
//                .then()
//                .contentType(ContentType.JSON)
//                .extract().response();
//        response.prettyPrint();
       /*response =given().headers("Authorization", "Bearer " + ConfigurationReader.getProperty("api_bearer_token"), "Content-Type", ContentType.JSON,"Accept", ContentType.JSON)
                .when().param("size", 5).get(ConfigurationReader.getProperty("Countries_api_endpoint"))
                .then().contentType(ContentType.JSON)
                .extract().response();
       // response.prettyPrint();
    }*/
    @And("All countries info will be set to countries with deserialization")
    public void allCountriesInfoWillBeSetToCountriesWithDeserialization() throws IOException {
//        response =given().headers("Authorization", "Bearer " + ConfigurationReader.getProperty("api_bearer_token"), "Content-Type", ContentType.JSON,"Accept", ContentType.JSON)
//                .when().param("size", 5).get(ConfigurationReader.getProperty("Countries_api_endpoint"))
//                .then().contentType(ContentType.JSON)
//                .extract().response();
        //response.prettyPrint();
//        ObjectMapper obj = new ObjectMapper();
//        country = obj.readValue(response.asString(), Country[].class);
        //System.out.println(country[0].);
        // for(int i=0; i<country.length; i++) {
        //  System.out.println(country[i].getId());
        // System.out.println(country[i].getName());
        // }

        Response response =given().headers("Content-Type", ContentType.JSON,"Accept", ContentType.JSON)
                .when().get("https://jsonmock.hackerrank.com/api/iot_devices/search?status=STOP")
                .then().contentType(ContentType.JSON)
                .extract().response();

        response.prettyPrint();

        int parentId = 7;

//        System.out.println(json.toString());
        JSONObject obj = new JSONObject(response);
        String id = obj.getJSONObject("parent").getString("id");
        System.out.println(id);


    }
//    @Then("All countries info will be saved to txt files")
//    public void allCountriesInfoWillBeSavedToTxtFiles() {
//        UtilityMethods.saveObjectToFile("src/test/resources/data/AllObjectsData.txt", country);
//    }
//    @Then("All countries info has been validated")
//    public void allCountriesInfoHasBeenValidated() throws IOException {
//        List<Integer> actualIDList = UtilityMethods.returnAllCountryIdList("src/test/resources/data/AllObjectsData.txt");
//        List<Integer> expectedList = new ArrayList<>();
//        expectedList.add(24360);
//        expectedList.add(24375);
//        expectedList.add(24377);
//        //Assert.assertTrue(actualIDList.containsAll(expectedList),"Ids don't match");
//        // Assert.assertEquals(actualIDList.get(0), expectedList);
//        List<Integer> actualid1 = new ArrayList<>();
//        for (Object obj: actualIDList) {
//            Integer obj1 = Integer.valueOf((Integer) obj);
//            actualid1.add(obj1);
//        }
//        Assert.assertTrue(actualid1.containsAll(expectedList),"Ids don't match");
//    }
}

