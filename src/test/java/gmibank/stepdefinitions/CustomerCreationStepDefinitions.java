package gmibank.stepdefinitions;

import com.github.javafaker.Faker;
import gmibank.pages.GmiHomePage;
import gmibank.pages.GmiRegisterPage;
import gmibank.pojo.CustomerInformation;
import gmibank.utilities.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;


import java.util.concurrent.TimeUnit;

public class CustomerCreationStepDefinitions{

    Logger logger = LoggerFactory.getLogger(CustomerCreationStepDefinitions.class);
    GmiHomePage mainPage = new GmiHomePage();
    GmiRegisterPage registerPage = new GmiRegisterPage();
    CustomerInformation customer = new CustomerInformation();
    Faker faker = new Faker();

    @Given("user should be on the homepage {string}")
    public void userShouldBeOnTheHomepage(String url) throws InterruptedException {
        Driver.get().get(ConfigurationReader.getProperty(url));
        Thread.sleep(3000);
    }

    @When("user navigates to register page")
    public void userNavigatesToRegisterPage() {
        mainPage.menu.click();
        Driver.get().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        mainPage.register.click();
    }

    @Then("User provide SSN {string}")
    public void userProvideSSN(String ssn)  {
        registerPage.ssnTextBox.sendKeys(ssn);
        customer.setSsn(ssn);
        BrowserUtils.wait(2);
    }

    @Then("User provide firstName {string}")
    public void userProvideFirstName(String firstName) {
//        firstName = faker.name().firstName();
        registerPage.firstNameTextBox.sendKeys(firstName);
        customer.setFirstName(firstName);
        BrowserUtils.wait(2);
    }

    @Then("User provide lastName {string}")
    public void userProvideLastName(String lastName) {
        registerPage.lastNameTextBox.sendKeys(lastName);
        customer.setLastName(lastName);
        BrowserUtils.wait(2);
    }

    @Then("User provide address {string}")
    public void userProvideAddress(String address) {
        registerPage.addressTextBox.sendKeys(address+Keys.TAB);
        customer.setAddress(address);
        BrowserUtils.wait(2);
    }

    @Then("User provide phoneNumber {string}")
    public void userProvidePhoneNumber(String phoneNumber) {
        registerPage.phoneNumberTextBox.sendKeys(phoneNumber);
        customer.setPhoneNumber(phoneNumber);
        BrowserUtils.wait(2);
    }

    @Then("User provide userName {string}")
    public void userProvideUserName(String userName) {
        registerPage.userNameTextBox.sendKeys(userName);
        customer.setUserName(userName);
        BrowserUtils.wait(2);
    }

    @Then("User provide email {string}")
    public void userProvideEmail(String email) {
        registerPage.emailTextBox.sendKeys(email);
        customer.setEmail(email);
        BrowserUtils.wait(2);
    }

    @Then("User provide newPassword {string}")
    public void userProvideNewPassword(String newPassword) {
        registerPage.newPasswordTextBox.sendKeys(newPassword);
        customer.setPassword(newPassword);
        BrowserUtils.wait(2);
    }

    @Then("User provide newPasswordConfirmation {string}")
    public void userProvideNewPasswordConfirmation(String newPasswordConfirmation) {
        registerPage.newPasswordConfirmationTextBox.sendKeys(newPasswordConfirmation);
        BrowserUtils.wait(2);
    }

    @Then("User clicks register button")
    public void userClicksRegisterButton() {
        registerPage.registerButton.click();
        BrowserUtils.wait(2);
        UtilityMethods.saveObjectToFile(ConstantVariables.customerInformationFilePath,customer);
    }

    @And("User successful message should be seen {string}")
    public void userSuccessfulMessageShouldBeSeen(String successMessage) {
        Assert.assertEquals(registerPage.successMessage.getText(),successMessage);
    }
}
