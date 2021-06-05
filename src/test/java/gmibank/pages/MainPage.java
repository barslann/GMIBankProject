package gmibank.pages;

import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    public MainPage() {
        PageFactory.initElements(Driver.get(),this);
    }

//    @FindBy(xpath = "//li[@id=\"account-menu\"]")
    @FindBy(id = "account-menu")
    public WebElement menu;

//    @FindBy(xpath = "(//a[@class='dropdown-item'])[2]")
    @FindBy(xpath = "(//span[text()='Register'])[1]")
    public WebElement register;


//    @FindBy(xpath = "//input[@id=\"ssn\"]")
//    public WebElement ssnTextBox;

    @FindBy(id="ssn")
    public WebElement ssnTextBox;

    @FindBy(xpath = "//div[@class=\"invalid-feedback\"]")
    public WebElement errorMessageLabel;

    @FindBy(id = "firstname")
    public WebElement firstNameTextBox;

    @FindBy(xpath = "//*[text()='Please enter your first name.']")
    public WebElement firstNameErrorLabel;



}
