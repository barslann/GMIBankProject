package gmibank.stepdefinitions;

import gmibank.pages.CreateCustomerAccountPage;
import gmibank.pages.EmployeeHomePage;
import gmibank.pojo.CustomerAccount;
import gmibank.pojo.CustomerInformation;
import gmibank.utilities.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CreateCustomerAccountStepDefinitions{

    EmployeeHomePage employeeHomePage = new EmployeeHomePage();
    CreateCustomerAccountPage createCustomerAccountPage = new CreateCustomerAccountPage();
    CustomerAccount customerAccount = new CustomerAccount();

    @When("employee click my operations menu")
    public void employeeClickMyOperationsMenu() {
        employeeHomePage.myOperationsMenu.click();
        BrowserUtils.wait(2);
    }

    @And("employee click manage accounts option")
    public void employeeClickManageAccountsOption() throws InterruptedException {
        employeeHomePage.manageAccountsLink.click();
        Thread.sleep(4000l);
    }

    @And("employee click create a new account")
    public void employeeClickCreateANewAccount() {
        createCustomerAccountPage.createANewAccountButton.click();
    }

    @And("employee provide description {string} with {string}")
    public void employeeProvideDescriptionWith(String description, String username) {
        BrowserUtils.wait(1);
        CustomerInformation customer = UtilityMethods.getCustomerFromCustomerInformationFile();
        username = customer.getUserName();
        customerAccount.setDescription(description + " " + username);
        customerAccount.setCustomerName(username);
        createCustomerAccountPage.descriptionTextBox.sendKeys(description +" " + username);
        BrowserUtils.wait(2);
    }

    @And("employee provide balance {string}")
    public void employeeProvideBalance(String balance) {
        customerAccount.setBalance(balance);
        createCustomerAccountPage.balanceTextBox.sendKeys(balance);
        BrowserUtils.wait(2);
    }

    @And("employee provide accountType {string}")
    public void employeeProvideAccountType(String accountType) {
        customerAccount.setAccountType(accountType);
        Select accountTypeSelectBox = new Select(createCustomerAccountPage.accountTypeCheckBox);
        accountTypeSelectBox.selectByVisibleText(accountType);
        BrowserUtils.wait(2);
    }

    @And("employee select create date")
    public void employeeSelectCreateDate() throws InterruptedException {
        int[] currentTimeArr = UtilityMethods.parseCurrentTime();
        String day  = String.valueOf(currentTimeArr[0]);
        String month = String.valueOf(currentTimeArr[1]);
        String  year = String.valueOf(currentTimeArr[2]);
        String hour= String.valueOf(currentTimeArr[3]);
        String minute = String.valueOf(currentTimeArr[4]);
        String period = currentTimeArr[5] == 0 ? "AM" : "PM";
        customerAccount.setCreatedDate(month + "/" + day + "/" + year+ "/" + hour + ":" +minute +" " + period);
        createCustomerAccountPage.createDateInput.sendKeys(
                month+day+year+Keys.TAB+hour+minute+period+Keys.TAB
        );

        BrowserUtils.wait(2);

    }

    @And("employee click save button")
    public void employeeClickSaveButton() throws InterruptedException {
        UtilityMethods.saveObjectToFile(ConstantVariables.customerAccountFilePath,customerAccount);
        createCustomerAccountPage.saveButton.click();
        Thread.sleep(2000l);
    }

    @Then("account creation is successful message should be seen")
    public void accountCreationIsSuccessfulMessageShouldBeSeen() {
        Assert.assertEquals(createCustomerAccountPage.successMessage.getText(),"translation-not-found[gmiBankBackendApp.tPAccount.created]");
    }
}
