package gmibank.pages;

import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage {

    public AdminHomePage() {
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//*[text()=\"Administration\"]")
    public WebElement administrationMenu;

    @FindBy(xpath = "//*[text()=\"User management\"]")
    public WebElement userManagementOption;





}
