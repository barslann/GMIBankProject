package gmibank.pages;

import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmiHomePage {

    public GmiHomePage() {
        PageFactory.initElements(Driver.get(),this);
    }

    //    @FindBy(xpath = "//li[@id=\"account-menu\"]")
    @FindBy(id = "account-menu")
    public WebElement menu;

    //    @FindBy(xpath = "(//a[@class='dropdown-item'])[2]")
    @FindBy(xpath = "(//span[text()='Register'])[1]")
    public WebElement register;

//    @FindBy(id = "login-item")
    @FindBy(xpath = "(//span[text()='Sign in'])[1]")
    public WebElement singIn;

//    @FindBy(xpath = "//*[text()=\"Tommie Runolfsson\"]")
    @FindBy(id="account-menu")
    public WebElement userName;

    @FindBy(xpath = "//a[@href=\"/logout\"]")
    public WebElement logOutOption;



}
