package gmibank.stepdefinitions;

import gmibank.pages.CustomerPage;
import gmibank.pages.MoneyTransferPage;
import gmibank.pages.MyAccountPage;
import gmibank.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import static org.apache.commons.math3.util.Precision.round;

public class MoneyTransferStepDefinitions {

    CustomerPage customerPage = new CustomerPage();
    MyAccountPage myAccountPage= new MyAccountPage();
    MoneyTransferPage moneyTransferPage = new MoneyTransferPage();
    double firstAccountBalance;
    double secondAccountBalance;
    String balance;
    String cent;


    @When("User navigates My Account page")
    public void userNavigatesMyAccountPage() throws InterruptedException {
        customerPage.myOperationSection.click();
        Thread.sleep(1000);
        customerPage.myAccountButton.click();
        Thread.sleep(3000);
    }

    @And("User gets the info about users accounts balance")
    public void userGetsTheInfoAboutUsersAccountsBalance() throws InterruptedException {

        firstAccountBalance = Double.parseDouble(myAccountPage.accountBalance1.getText());
        Thread.sleep(1000);
        secondAccountBalance = Double.parseDouble(myAccountPage.getAccountBalance2.getText());
        Thread.sleep(1000);
    }

    @Then("User navigates to Transfer Money Page")
    public void userNavigatesToTransferMoneyPage() throws InterruptedException {
        customerPage.myOperationSection.click();
        Thread.sleep(3000);
        customerPage.transferMoneyButton.click();
    }


    @And("User performs the money transfer {string} {string}")
    public void userPerformsTheMoneyTransfer(String balance, String cent) {
        this.balance = balance;
        this.cent =cent;
        Select from = new Select(moneyTransferPage.fromDropDown);
        Select to = new Select(moneyTransferPage.toDropDown);
        from.selectByIndex(1);
        to.selectByIndex(1);
        moneyTransferPage.balanceTextBox.sendKeys(balance);
        BrowserUtils.wait(2);
        moneyTransferPage.centTextBox.clear();
        moneyTransferPage.centTextBox.sendKeys(cent);
        BrowserUtils.wait(2);
        moneyTransferPage.descriptionTextBox.sendKeys("hotel booking");
        BrowserUtils.wait(2);
        moneyTransferPage.makeTransferButton.click();

    }

    @Then("User navigates My Accounts Page")
    public void userNavigatesMyAccountsPage() throws InterruptedException {
        customerPage.myOperationSection.click();
        Thread.sleep(1000);
        customerPage.myAccountButton.click();
    }

    @Then("User validates that User $ money transferred successfully")
    public void userValidatesThatUser$MoneyTransferredSuccessfully() throws InterruptedException {
        customerPage.myOperationSection.click();
        Thread.sleep(1000);
        customerPage.myAccountButton.click();
        Thread.sleep(1000);
        double firstAccountBalanceAfterTransfer= Double.parseDouble(myAccountPage.accountBalance1.getText());
        double secondAccountBalanceAfterTransfer = Double.parseDouble(myAccountPage.getAccountBalance2.getText());
        double balanceDouble =Double.parseDouble(balance);
        double centDouble = Double.parseDouble(cent);
        balanceDouble += centDouble/100.00;
        Assert.assertEquals(firstAccountBalanceAfterTransfer, round(firstAccountBalance-balanceDouble,2), "doesn't match");
        Assert.assertEquals(secondAccountBalanceAfterTransfer, round(secondAccountBalance+balanceDouble,2), "doesn't match");
    }
}
