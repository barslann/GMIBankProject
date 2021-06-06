package gmibank.pages;

import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserManagementPage {

    public UserManagementPage() {
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "(//*[@class=\"svg-inline--fa fa-sort fa-w-10 \"])[5]")
    public WebElement createdDateArrows;

    @FindBy(xpath = "//*[text()=\"sdf\"]//following-sibling::td[2]/button")
    public WebElement deActivateButton;

    @FindBy(xpath = "//*[text()=\"sdf\"]//following-sibling::td[2]/button/span")
    public WebElement activateButtonText;

}
