package gmibank.stepdefinitions;

import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.ConstantVariables;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class US_027_StepDefinitions {
    public Response response;
    public String uriPath ="";

    @And("User deletes a state from api using {string} with {string}")
    public void userDeletesAStateFromApiUsingWith(String url, String stateId) {
        uriPath= ConfigurationReader.getProperty(url) + "/" + stateId;
         RestAssured.given().contentType(ContentType.JSON)
                .auth().oauth2(ConstantVariables.generalToken)
                .delete(uriPath)
                .then()
                .statusCode(204)
                .extract().response();
//        response.prettyPrint();
    }

    @Then("User validates that state is deleted")
    public void userValidatesThatStateIsDeleted() {
        RestAssured.given().contentType(ContentType.JSON)
                .auth().oauth2(ConstantVariables.generalToken)
                .get(uriPath)
                .then()
                .statusCode(404)
                .extract().response();
    }
}
