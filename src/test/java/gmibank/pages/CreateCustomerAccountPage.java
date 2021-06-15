package gmibank.pages;

import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCustomerAccountPage {
    public CreateCustomerAccountPage() {
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id = "jh-create-entity")
    public WebElement createANewAccountButton;

    @FindBy(id = "tp-account-description")
    public WebElement descriptionTextBox;

    @FindBy(id = "tp-account-balance")
    public WebElement balanceTextBox;

    @FindBy(id = "tp-account-accountType")
    public WebElement accountTypeCheckBox;

    @FindBy(id = "tp-account-createDate")
    public WebElement createDateInput;

    @FindBy(id = "save-entity")
    public WebElement saveButton;

//    @FindBy(xpath = "//div[@class=\"Toastify__toast-body\"]")
    @FindBy(xpath = "//div[@class=\"Toastify__toast-container Toastify__toast-container--top-left toastify-container\"]")
    public WebElement successMessage;

    @FindBy(xpath = "//div[@class=\"Toastify__toast-body\"]")
    public WebElement successMessage2;



}
