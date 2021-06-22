package gmibank.stepdefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import gmibank.pojo.LoginInfo;
import gmibank.pojo.State;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.UtilityMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

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
    public void userCreatesAStateFromApiUsing(String url) throws JsonProcessingException {
        System.out.println("yeni state olusturulup post edilicek");
        State state = new State();
        state.setName("Moon");

//        ObjectMapper mapper = new ObjectMapper();
//        String jsonString = mapper.writeValueAsString(state);

//        Map<String, Object> map = new HashMap<>();
//        map.put("name","calii");

        response = given().headers("Authorization","Bearer "  + token, "Content-Type", ContentType.JSON,"Accept",ContentType.JSON)
                .when()
                .body(state)
                .contentType(ContentType.JSON)
                .post("https://gmibank-qa-environment.com/api/tp-states");

        System.out.println("yeni state post edildi ve response altta");
        Assert.assertEquals(response.getStatusCode(),201);
        response.prettyPrint();

    }

    @Then("User validates that state is created")
    public void userValidatesThatStateIsCreated() {
        JsonPath jsonPath = response.jsonPath();
        String  actualName = jsonPath.get("name");
        Assert.assertTrue(actualName.contains("Moon"));
    }
}
