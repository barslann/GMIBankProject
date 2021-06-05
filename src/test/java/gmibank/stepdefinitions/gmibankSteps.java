package gmibank.stepdefinitions;

import gmibank.pages.MainPage;
import gmibank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class gmibankSteps{
    Logger logger = LoggerFactory.getLogger(gmibankSteps.class);
    MainPage mainPage = new MainPage();

    @Given("user should be on the homepage")
    public void userShouldBeOnTheHomepage() {
    }

    @When("navigate to the website {string}")
    public void navigateToTheWebsite(String url) {
        Driver.get().get(url);
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @And("You should navigate to registration page")
    public void youShouldNavigateToRegistrationPage() {
        mainPage.menu.click();
        Driver.get().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        mainPage.register.click();
    }

    @And("Click on SSN textbox")
    public void clickOnSSNTextbox() {
        mainPage.ssnTextBox.click();
    }

    @And("Provide SSN {string}")
    public void provideSSN(String ssnNumber) {
        mainPage.ssnTextBox.sendKeys(ssnNumber);
        mainPage.ssnTextBox.sendKeys(Keys.ENTER);
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
//
//    @And("Provide the SNN of the applicant {string}")
//    public void provideTheSNNOfTheApplicant(String ssnNumber) {
//        mainPage.ssnTextBox.sendKeys(ssnNumber);
//        mainPage.ssnTextBox.sendKeys(Keys.ENTER);
//        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//
//    }

    @Then("I should not see the error message translation-not-found[Your SSN is required]")
    public void iShouldNotSeeTheErrorMessageTranslationNotFoundYourSSNIsRequired() {
        boolean isPresent = Driver.get().findElements(By.className("invalid-feedback")).size() == 8;
//        System.out.println("Size: " + Driver.get().findElements(By.className("invalid-feedback")).size());
//        System.out.println("Boolean" + isPresent);
        logger.info("Valid SSN test ----> " + (isPresent == true));
        Assert.assertEquals(isPresent,true,"No error. Test passed!");

    }

    @Then("I should  see the ssn is invalid error message {string}")
    public void iShouldSeeTheSsnIsInvalidErrorMessage(String errorMessage) {
        String ssnErrorLabel = mainPage.errorMessageLabel.getText();
        logger.info("SSN is invalid test ---> "  + errorMessage.equals("SSN is invalid"));
        Assert.assertEquals(ssnErrorLabel,errorMessage,"Invalid SSN number test passed!");
    }

    @Then("I should see the Please enter your social security number error message {string}")
    public void iShouldSeeThePleaseEnterYourSocialSecurityNumberErrorMessage(String errorMessage) {
        String ssnErrorLabel = mainPage.errorMessageLabel.getText();
        logger.info("SSN field is empty test ---> "  + errorMessage.equals("Please enter your social security number."));
        Assert.assertEquals(ssnErrorLabel,errorMessage,"Empty SSN field test passed!");
    }

    @Then("I should not see the ssn is required error message")
    public void iShouldNotSeeTheSsnIsRequiredErrorMessage() {
        String ssnErrorLabel = mainPage.errorMessageLabel.getText();
        Assert.assertNotEquals(ssnErrorLabel,"SSN is required","When the ssn is invalid, then I should not see the ssn is required message.");

    }
    @And("Click on firstName textbox")
    public void clickOnFirstNameTextbox() {
        mainPage.firstNameTextBox.click();
    }


    @And("Provide firstName {string}")
    public void provideFirstName(String firstName) {
        mainPage.firstNameTextBox.sendKeys(firstName);
        mainPage.firstNameTextBox.sendKeys(Keys.ENTER);
    }

    @Then("I should not see any error")
    public void iShouldNotSeeAnyError() {
        String classAttrText =  mainPage.firstNameTextBox.getAttribute("class");
        Assert.assertFalse(classAttrText.contains("invalid"));
    }


    @Then("I should see the error {string}")
    public void iShouldSeeTheError(String firstNameErrorMessage) {
        String webFirstNameError =mainPage.firstNameErrorLabel.getText();
        Assert.assertEquals(firstNameErrorMessage, webFirstNameError);
    }

    @And("Provide invalid firstName {string}")
    public void provideInvalidFirstName(String invalidFirstName) {
        mainPage.firstNameTextBox.sendKeys(invalidFirstName);


        boolean containsSpecialCharacter = false;

        for(char chr : invalidFirstName.toCharArray()){
            if(!Character.isLetter(chr)){
                containsSpecialCharacter = true;
                break;
            }
        }

        Assert.assertFalse(containsSpecialCharacter);

    }
}
/*
*  hello + 10 + 20  -> hello1020
*
*  10 + 20 + hello ->  30hello
*
* */
