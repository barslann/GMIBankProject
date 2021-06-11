package gmibank.stepdefinitions;

import gmibank.pages.GmiHomePage;
import gmibank.pages.LoginPage;
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
    public void userNavigatesToSignInPage() throws InterruptedException {
        homePage.menu.click();
        Driver.get().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        homePage.singIn.click();
    }

    @Then("user enter username {string}")
    public void userEnterUsername(String username) {
        loginPage.usernameBox.sendKeys(username + Keys.TAB);
    }

    @Then("user enter password {string}")
    public void userEnterPassword(String password) {
        loginPage.passwordBox.sendKeys(password + Keys.TAB);
    }

    @Then("user clicks sign in button")
    public void userClicksSignInButton() throws InterruptedException {
        loginPage.singInButton.click();
        Thread.sleep(3000);
    }


    @Then("user should be on the home page with {string}")
    public void userShouldBeOnTheHomePageWith(String userName) {
        Assert.assertEquals(homePage.userName.getText(),userName);
    }
}
