package gmibank.stepdefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import gmibank.pojo.LoginInfo;
import gmibank.pojo.State;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.UtilityMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

public class US_024_StepDefinitions {

    private String token;

    Response response;
    @Given("user sends login info and gets the bearer token")
    public void userSendsLoginInfoAndGetsTheBearerToken() throws InterruptedException {
        System.out.println("Token islemi basliyor");

        LoginInfo loginInfo = new LoginInfo("team46admin", "Team46admin.",false);

        response = given().contentType(ContentType.JSON)
                .when()
                .body(loginInfo)
                .post(ConfigurationReader.getProperty("authentication_api_endpoint"));

        token = UtilityMethods.parseToken(response.asString());

        System.out.println("Token elde edildi ve 2 sn bekleniyor");
        System.out.println("token:" + token);
//        Thread.sleep(2000);

    }

    @And("User creates a state from api using {string}")
    public void userCreatesAStateFromApiUsing(String url) {

        System.out.println("yeni state olusturulup post edilicek");

//        State state = new State("calii");

        Map<String, Object> map = new HashMap<>();
        map.put("name","calii");

        response = given().headers("Authorization","Bearer "  + token, "Content-Type", ContentType.JSON,"Accept",ContentType.JSON)
                .when()
                .body(map)
                .post("https://gmibank-qa-environment.com/api/tp-states");

        System.out.println("yeni state post edildi ve response altta");
        Assert.assertEquals(response.getStatusCode(),201);
        response.prettyPrint();


    }

    @Then("User validates that state is created")
    public void userValidatesThatStateIsCreated() {

    }
}