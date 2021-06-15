package gmibank.pages;
import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
public class MyAccountPage {
    public MyAccountPage() {
        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy(xpath="(//td)[3]")
    public WebElement accountBalance1;
    @FindBy(xpath="(//td)[7]")
    public WebElement getAccountBalance2;
    //    @FindBy(xpath="(//tbody//tr//td[3]")
//    public List<WebElement> accountBalanceList;
    // @FindBy(xpath = "//td[contains(text(),'1.03')]")
    // public WebElement getAccountBalance1;
    //@FindBy(xpath = "//td[contains(text(),'2.27')]")
    //public WebElement accountBalance2;
    @FindBy(xpath="(//td[3])[1]")
    public List<WebElement> TryList;
}