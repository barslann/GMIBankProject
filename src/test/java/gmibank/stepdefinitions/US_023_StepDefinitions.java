package gmibank.stepdefinitions;
import com.fasterxml.jackson.databind.ObjectMapper;
import gmibank.pojo.Registration;
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
import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertTrue;
public class US_023_StepDefinitions {
    Response response;
    Registration[] registration;
    @Given("User provides the api endpoint to set response using {string} {string}")
    public void userProvidesTheApiEndpointToSetResponseUsing(String registrationEndpoint, String bearerToken) {
        response =given().headers("Authorization", "Bearer " + ConfigurationReader.getProperty(bearerToken), "Content-Type", ContentType.JSON,"Accept", ContentType.JSON)
                .when()
                .get(ConfigurationReader.getProperty(registrationEndpoint))
                .then()
                .contentType(ContentType.JSON)
                .extract().response();
        //response.prettyPrint();
        //System.out.println(response);
    }
    @And("All registrations info will be set to Registrations with deserialization")
    public void allRegistrationsInfoWillBeSetToRegistrationsWithDeserialization() throws IOException {
        ObjectMapper obj= new ObjectMapper();
        registration=obj.readValue(response.asString(),Registration[].class);
    }
    @Then("All registrations info will be saved to txt files")
    public void allRegistrationsInfoWillBeSavedToTxtFiles() {
        UtilityMethods.saveObjectToFile("src/test/resources/data/RegistrationData.txt",registration);
    }
    @Then("All registrations info has been validated")
    public void allRegistrationsInfoHasBeenValidated() {
      /*  List<String> actualIDList = ReadAllRegistrationList.readAllUserName("src/test/resources/data/RegistrationData.txt");
        List<String> expectedList = new ArrayList<>();
        expectedList.add("user2");
        expectedList.add("manager");
        //Assert.assertTrue(actualIDList.containsAll(expectedList), "Doesn't match");*/
        Assert.assertTrue(UtilityMethods.saveDataInfileAllRegistrationInfo("src/test/resources/data/RegistrationData.txt",registration).containsKey(2201),"Doesn't match");
    }
}