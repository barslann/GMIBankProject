package gmibank.pages;

import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UserManagementPage {

    public UserManagementPage() {
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "(//*[@class=\"svg-inline--fa fa-sort fa-w-10 \"])[5]")
    public WebElement createdDateArrows;

    @FindBy(xpath = "//*[text()=\"sdf\"]//following-sibling::td[2]/button")
    public WebElement deActivateButton;

    @FindBy(xpath = "//*[text()=\"bekir\"]//following-sibling::td[2]/button/span")
    public List<WebElement> activateButtonText;

    @FindBy(xpath = "//*[table]//tbody//tr")
    public List<WebElement> allTableUsers;

    @FindBy(xpath = "//li//a[@aria-label=\"Next\"]")
    public WebElement nextPageArrow;

    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    public WebElement successMessage;

}
