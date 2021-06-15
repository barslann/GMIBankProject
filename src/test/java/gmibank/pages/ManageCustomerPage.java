package gmibank.pages;

import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageCustomerPage {

    public ManageCustomerPage() {
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id = "jh-create-entity")
    public WebElement createANewCustomerButton;

    @FindBy(id = "search-ssn")
    public WebElement searchSsnTextBox;

    @FindBy(xpath = "//button[text()=\"Search\"]")
    public WebElement searchButton;

    @FindBy(id = "tp-customer-middleInitial")
    public WebElement middleInitialTextBox;

    @FindBy(id = "tp-customer-phoneNumber")
    public WebElement phoneNumberTextBox;

    @FindBy(id = "tp-customer-zipCode")
    public WebElement zipNumberTextBox;

    @FindBy(id = "tp-customer-city")
    public WebElement cityTextBox;

    @FindBy(id = "tp-customer-account")
    public WebElement customerAccountSelect;

    @FindBy(id = "save-entity")
    public WebElement saveButton;


}
