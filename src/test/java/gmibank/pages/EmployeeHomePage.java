package gmibank.pages;

import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeeHomePage {
    public EmployeeHomePage() {
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//span[text()='My Operations']")
    public WebElement myOperationsMenu;

    @FindBy(xpath = "//a[@href='/tp-account']")
    public WebElement manageAccountsLink;

    @FindBy(xpath = "//a[@href='/tp-customer']")
    public WebElement manageCustomersLink;

}
