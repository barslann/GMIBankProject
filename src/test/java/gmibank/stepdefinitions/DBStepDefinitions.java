package gmibank.stepdefinitions;

import gmibank.pojo.CountryModel;
import gmibank.utilities.DBUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.eo.Do;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class DBStepDefinitions {
    String expectedId;
    List<CountryModel> actualList;
    @Given("ders user creates a connection with db using {string} , {string} and {string}")
    public void dersUserCreatesAConnectionWithDbUsingAnd(String port, String username, String password) {
        DBUtils.createConnection(port,username,password);
    }

    @And("Uders user creates a Country data using {string} {string}")
    public void udersUserCreatesACountryDataUsing(String query, String columnName) {

    }

    @And("Uders user reads the Country data using {string}")
    public void udersUserReadsTheCountryDataUsingAnd(String query) {
        actualList = DBUtils.getQueryResultList2(query);
    }

    @Then("Uders validate customers data with {string}")
    public void udersValidateCustomersData(String expectedId) {
        List<Long> idList = new ArrayList<>();
        for(CountryModel countryModel: actualList){
            idList.add(countryModel.getId());
        }

        Assert.assertTrue(idList.contains(Long.valueOf(expectedId)));

    }


}
