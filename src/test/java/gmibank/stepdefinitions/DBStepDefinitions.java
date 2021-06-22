package gmibank.stepdefinitions;

import gmibank.utilities.DBUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;

public class DBStepDefinitions {
    String expectedId;
    @Given("ders user creates a connection with db using {string} , {string} and {string}")
    public void dersUserCreatesAConnectionWithDbUsingAnd(String arg0, String arg1, String arg2) {

    }

    @And("Uders user creates a Country data using {string} {string}")
    public void udersUserCreatesACountryDataUsing(String query, String id) {
        DBUtils.executeQuery(query);
        expectedId = id;
    }

    @And("Uders user reads the Country data using {string} and {string}")
    public void udersUserReadsTheCountryDataUsingAnd(String query, String columnName) {
        List<Object> countryIdList  = DBUtils.getColumnData(query,columnName);

    }

    @Then("Uders validate customers data")
    public void udersValidateCustomersData() {
    }
}
