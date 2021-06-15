package gmibank.stepdefinitions;

import gmibank.pages.EmployeeHomePage;
import gmibank.pages.GmiHomePage;
import gmibank.pages.ManageCustomerPage;
import gmibank.pojo.CustomerInformation;
import gmibank.utilities.ConstantVariables;
import gmibank.utilities.UtilityMethods;
import io.cucumber.java.an.E;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.xml.crypto.KeySelector;

public class ManageCustomerStepDefinitions {
    GmiHomePage gmiHomePage = new GmiHomePage();
    EmployeeHomePage employeeHomePage = new EmployeeHomePage();
    ManageCustomerPage manageCustomerPage = new ManageCustomerPage();
    CustomerInformation customer = UtilityMethods.getCustomerFromCustomerInformationFile();

//    @When("employee click my operations menu")
//    public void employeeClickMyOperationsMenu() {
//        employeeHomePage.myOperationsMenu.click();
//    }


    @And("employee click manage customers option")
    public void employeeClickManageCustomersOption() throws InterruptedException {
        employeeHomePage.manageCustomersLink.click();
        Thread.sleep(4000l);
    }

    @And("employee click create a new customer")
    public void employeeClickCreateANewCustomer() {
        manageCustomerPage.createANewCustomerButton.click();
    }

    @And("employee provide customer ssn")
    public void employeeProvideCustomerSsn() {
        String customerSsn = customer.getSsn();
        manageCustomerPage.searchSsnTextBox.sendKeys(customerSsn + Keys.TAB);
    }
    @And("employee click search button")
    public void employeeClickSearchButton() {
        manageCustomerPage.searchButton.click();
    }

    @And("employee provide middle initial {string}")
    public void employeeProvideMiddleInitial(String middleInitial) {
        manageCustomerPage.middleInitialTextBox.sendKeys(middleInitial + Keys.TAB);
    }



    @And("employee provide phoneNumber {string}")
    public void employeeProvidePhoneNumber(String phoneNumber) {
        manageCustomerPage.phoneNumberTextBox.sendKeys(phoneNumber + Keys.TAB);
    }

    @And("employee provide zipcode {string}")
    public void employeeProvideZipcode(String zipCode) {
        manageCustomerPage.zipNumberTextBox.sendKeys(zipCode + Keys.TAB);
    }

    @And("employee provide city {string}")
    public void employeeProvideCity(String city) {
        manageCustomerPage.cityTextBox.sendKeys(city + Keys.TAB);
    }

    @And("employee pick accounts")
    public void employeePickAccounts() {
        String customerName = customer.getUserName();
        String[] accounts = UtilityMethods.getCustomerAccountFromCustomerAccountFile(customerName);
        Select select = new Select(manageCustomerPage.customerAccountSelect);
        for(String account: accounts) select.selectByVisibleText(account);
    }
    @And("employee clicks save button")
    public void employeeClicksSaveButton() throws InterruptedException {
        manageCustomerPage.saveButton.click();
        Thread.sleep(2000l);
    }

    @Then("successful message should be seen")
    public void successfulMessageShouldBeSeen() {
        System.out.println("evething is ok so farrr!");
    }


    @And("employee should log out")
    public void employeeShouldLogOut() {
        gmiHomePage.userName.click();
        gmiHomePage.logOutOption.click();
    }

}
