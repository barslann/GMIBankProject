package gmibank.stepdefinitions;

import gmibank.pages.AdminHomePage;
import gmibank.pages.GmiHomePage;
import gmibank.pages.UserManagementPage;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class UserActivationStepDefinitions {
    UserManagementPage userManagementPage = new UserManagementPage();
    AdminHomePage adminHomePage = new AdminHomePage();
    GmiHomePage gmiHomePage = new GmiHomePage();

    @When("admin clicks the administration menu")
    public void adminClicksTheAdministrationMenu() {
        adminHomePage.administrationMenu.click();
    }

    @And("admin clicks user management option")
    public void adminClicksUserManagementOption() throws InterruptedException {
        adminHomePage.userManagementOption.click();
        Thread.sleep(2000l);
    }

    @And("admin click created date to sort the users")
    public void adminClickCreatedDateToSortTheUsers() {
        userManagementPage.createdDateArrows.click();
    }

    @And("admin finds user and clicks deactivate button")
    public void adminFindsUserAndClicksDeactivateButton() throws InterruptedException {
        userManagementPage.deActivateButton.click();
        Thread.sleep(2000l);
    }

    @And("user should be activated")
    public void userShouldBeActivated() {
//        Assert.assertEquals(userManagementPage.activateButtonText.getText(),"Activated");
    }


    @Then("admin should log out")
    public void adminShouldLogOut() {
        gmiHomePage.userName.click();
        gmiHomePage.logOutOption.click();
    }
}
