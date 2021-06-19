package gmibank.stepdefinitions;

import gmibank.pages.GmiHomePage;
import gmibank.pages.LoginPage;
import gmibank.utilities.BrowserUtils;
import gmibank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class userSignInStepDefinitions {
    GmiHomePage homePage = new GmiHomePage();
    LoginPage loginPage = new LoginPage();

    @When("user navigates to sign in page")
    public void userNavigatesToSignInPage(){
        homePage.menu.click();
        Driver.get().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        homePage.singIn.click();
    }

    @Then("user enter username {string}")
    public void userEnterUsername(String username) {
        loginPage.usernameBox.sendKeys(username);
        BrowserUtils.wait(2);
    }

    @Then("user enter password {string}")
    public void userEnterPassword(String password) {
        loginPage.passwordBox.sendKeys(password);
        BrowserUtils.wait(2);
    }

    @Then("user clicks sign in button")
    public void userClicksSignInButton() {
        loginPage.singInButton.click();
        BrowserUtils.wait(3);
    }

    @Then("user should be on the home page with {string}")
    public void userShouldBeOnTheHomePageWith(String userName) {
        Assert.assertEquals(homePage.userName.getText(),userName);
    }
}
