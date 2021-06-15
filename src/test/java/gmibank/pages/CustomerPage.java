package gmibank.pages;
import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPage {

    public CustomerPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id="entity-menu")
    public WebElement myOperationSection;

    @FindBy(xpath="//li[@id='entity-menu']//div//a[1]")
    public WebElement myAccountButton;

    @FindBy(xpath="//li[@id='entity-menu']//div//a[2]")
    public WebElement transferMoneyButton;
}