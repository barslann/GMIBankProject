package gmibank.stepdefinitions;

import com.github.javafaker.Faker;
import gmibank.pages.GmiHomePage;
import gmibank.pages.GmiRegisterPage;
import gmibank.pojo.CustomerInformation;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class CustomerCreationStepDefinitions {

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
    public void userProvideSSN(String ssn) {
        registerPage.ssnTextBox.sendKeys(ssn + Keys.TAB);
        customer.setSsn(ssn);
    }

    @Then("User provide firstName {string}")
    public void userProvideFirstName(String firstName) {
//        firstName = faker.name().firstName();
        registerPage.firstNameTextBox.sendKeys(firstName +Keys.TAB);
        customer.setFirstName(firstName);
    }

    @Then("User provide lastName {string}")
    public void userProvideLastName(String lastName) {
        registerPage.lastNameTextBox.sendKeys(lastName+Keys.TAB);
        customer.setLastName(lastName);
    }

    @Then("User provide address {string}")
    public void userProvideAddress(String address) {
        registerPage.addressTextBox.sendKeys(address+Keys.TAB);
        customer.setAddress(address);
    }

    @Then("User provide phoneNumber {string}")
    public void userProvidePhoneNumber(String phoneNumber) {
        registerPage.phoneNumberTextBox.sendKeys(phoneNumber+Keys.TAB);
    }

    @Then("User provide userName {string}")
    public void userProvideUserName(String userName) {
        registerPage.userNameTextBox.sendKeys(userName + Keys.TAB);
        customer.setUserName(userName);
    }

    @Then("User provide email {string}")
    public void userProvideEmail(String email) {
        registerPage.emailTextBox.sendKeys(email + Keys.TAB);
        customer.setEmail(email);
    }

    @Then("User provide newPassword {string}")
    public void userProvideNewPassword(String newPassword) {
        registerPage.newPasswordTextBox.sendKeys(newPassword + Keys.TAB);
        customer.setPassword(newPassword);
    }

    @Then("User provide newPasswordConfirmation {string}")
    public void userProvideNewPasswordConfirmation(String newPasswordConfirmation) {
        registerPage.newPasswordConfirmationTextBox.sendKeys(newPasswordConfirmation + Keys.TAB);
    }

    @Then("User clicks register button")
    public void userClicksRegisterButton() throws InterruptedException {
        registerPage.registerButton.click();
        Thread.sleep(2000l);
        // TODO: 6/5/21
        //  save this customer to the customerinforamtion.xml file
    }

    @And("User successful message should be seen {string}")
    public void userSuccessfulMessageShouldBeSeen(String successMessage) {
        System.out.println(registerPage.successMessage.getText());
        System.out.println(registerPage.successMessage.getText());
        Assert.assertEquals(registerPage.successMessage.getText(),"Registration saved! Please check your email for confirmation.");
    }
}
