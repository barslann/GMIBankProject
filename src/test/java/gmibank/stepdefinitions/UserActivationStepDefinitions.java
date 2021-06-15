package gmibank.stepdefinitions;

import gmibank.pages.AdminHomePage;
import gmibank.pages.GmiHomePage;
import gmibank.pages.UserManagementPage;
import gmibank.pojo.CustomerInformation;
import gmibank.utilities.Driver;
import gmibank.utilities.UtilityMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class UserActivationStepDefinitions {
    UserManagementPage userManagementPage = new UserManagementPage();
    AdminHomePage adminHomePage = new AdminHomePage();
    GmiHomePage gmiHomePage = new GmiHomePage();
    WebDriverWait webDriverWait = new WebDriverWait(Driver.get(),3);

    @When("admin clicks the administration menu")
    public void adminClicksTheAdministrationMenu() {
        adminHomePage.administrationMenu.click();
    }

    @And("admin clicks user management option")
    public void adminClicksUserManagementOption() throws InterruptedException {
        adminHomePage.userManagementOption.click();
        Thread.sleep(2000l);
    }

    @And("admin click created date to sort the users")
    public void adminClickCreatedDateToSortTheUsers() throws InterruptedException {
        userManagementPage.createdDateArrows.click();
        Thread.sleep(3000l);
    }

//    @And("admin finds user and clicks deactivate button")
//    public void adminFindsUserAndClicksDeactivateButton() throws InterruptedException, IOException {
//        String customerName = FindCustomerNameFromCustomerInformationFile.getCustomerName();
//        Thread.sleep(3000l);
//        ((JavascriptExecutor) Driver.get())
//                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
//
//
//        int lastPageNumber = Integer.parseInt(Driver.get().findElement(By.xpath("(//a[@class=\"page-link\"])[7]")).getText());
//        System.out.println("Last page: " + lastPageNumber);
//
//
//        for (int i = 1; i < lastPageNumber; i++) {
//
//            boolean customerFound = false;
//
//            for (WebElement webElement :  new UserManagementPage().allTableUsers){
//                System.out.println(webElement.getText());
//            }
//
//            for(WebElement webElement : new UserManagementPage().allTableUsers){
//                System.out.println("Web Element id: " +  webElement.getAttribute("id"));
//                System.out.println("Customer Name:" + customerName);
//                if(customerName.equals(webElement.getAttribute("id"))){
//
//                    webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement.findElement(By.xpath("(//tr//td//button)[1]")))).click();
////                webElement.findElement(By.xpath("//td//button[@type=\"button\"]")).click();
////                webElement.findElement(By.xpath("//td//button//span")).click();
//                    customerFound= true;
//                    break;
//                }
//            }
//            if(customerFound) break;
//            userManagementPage.nextPageArrow.click();
//            System.out.println("Yeni sayfa geciliyor!");
//            System.out.println();
//            System.out.println();
//        }
//
//
//        //if customer is not found
////        if (!customerFound){
////            if(userManagementPage.nextPageArrow.isEnabled()){
////
////                userManagementPage.nextPageArrow.click();
////                Thread.sleep(3000l);
//////                Actions actions = new Actions(Driver.get());
//////                actions.doubleClick(userManagementPage.createdDateArrows);
////                adminFindsUserAndClicksDeactivateButton();
////            }else{
////                System.out.println("User not found");
////                System.exit(25);
////            }
////        }
//
//        Thread.sleep(2000l);
//    }
@And("admin finds user and clicks deactivate button")
public void adminFindsUserAndClicksDeactivateButton() throws InterruptedException, IOException {
    CustomerInformation customer = UtilityMethods.getCustomerFromCustomerInformationFile();
    String customerName = customer.getUserName();
    System.out.println("Customer userName" + customerName);

    boolean customerFound = false;
    for(WebElement webElement : userManagementPage.allTableUsers){
        System.out.println("tr id: " + webElement.getAttribute("id"));
        if(customerName.equals(webElement.getAttribute("id"))){
            while(true){
                try {
                    String trId = webElement.getAttribute("id");
                    Thread.sleep(3000l);
                    webElement.findElement(By.xpath("//tr[@id='"+trId+"']//td//button")).click();
                    customerFound= true;
                    break;
                }
                catch (Exception e){
                    JavascriptExecutor jse = (JavascriptExecutor)Driver.get();
                    jse.executeScript("window.scrollBy(0,-500)");
                }
            }
            break;
        }
    }
    if (!customerFound){
        if(userManagementPage.nextPageArrow.isEnabled()){
            userManagementPage.nextPageArrow.click();
            Thread.sleep(3000l);
            adminFindsUserAndClicksDeactivateButton();
        }else{
            System.out.println("User not found");
            System.exit(25);
        }
    }
    Thread.sleep(2000l);
}

    @And("user should be activated")
    public void userShouldBeActivated() {
//        Assert.assertEquals(userManagementPage.activateButtonText.getText(),"Activated");
    }


    @Then("admin should log out")
    public void adminShouldLogOut() {
        gmiHomePage.userName.click();
        gmiHomePage.logOutOption.click();
    }
}
