package gmibank.pages;

import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmiRegisterPage {
    public GmiRegisterPage() {
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id="ssn")
    public WebElement ssnTextBox;

    @FindBy(id = "firstname")
    public WebElement firstNameTextBox;

    @FindBy(id = "lastname")
    public WebElement lastNameTextBox;

    @FindBy(id = "address")
    public WebElement addressTextBox;

    @FindBy(id = "mobilephone")
    public WebElement phoneNumberTextBox;

    @FindBy(id = "username")
    public WebElement userNameTextBox;

    @FindBy(id = "email")
    public WebElement emailTextBox;

    @FindBy(id = "firstPassword")
    public WebElement newPasswordTextBox;

    @FindBy(id = "secondPassword")
    public WebElement newPasswordConfirmationTextBox;

    @FindBy(id = "register-submit")
    public WebElement registerButton;


    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    public WebElement successMessage;


}
