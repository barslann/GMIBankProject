package gmibank.stepdefinitions;

import gmibank.pages.GmiHomePage;
import gmibank.pages.LoginPage;
import gmibank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class adminSignInStepDefinitions {
    GmiHomePage homePage = new GmiHomePage();
    LoginPage loginPage = new LoginPage();

    @When("admin navigates to sign in page")
    public void adminNavigatesToSignInPage() throws InterruptedException {
        homePage.menu.click();
        Driver.get().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        homePage.singIn.click();
    }

    @Then("admin enter username {string}")
    public void adminEnterUsername(String username) {
        loginPage.usernameBox.sendKeys(username + Keys.TAB);
    }

    @Then("admin enter password {string}")
    public void adminEnterPassword(String password) {
        loginPage.passwordBox.sendKeys(password + Keys.TAB);
    }

    @Then("admin clicks sign in button")
    public void adminClicksSignInButton() throws InterruptedException {
        loginPage.singInButton.click();
        Thread.sleep(3000);
    }


    @Then("admin should be on the home page with {string}")
    public void adminShouldBeOnTheHomePageWith(String adminName) {
        Assert.assertEquals(homePage.adminName.getText(),adminName);
    }
}
