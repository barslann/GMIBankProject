package gmibank.stepdefinitions;


import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
public class Hook {
//    @Before
//    public void setup() {
//        System.out.println("### setup! start d###############\n");
//        Driver.get().manage().window().maximize();
//        Driver.get().get(ConfigurationReader.getProperty("url"));
//    }
//    @After
//    public void teardown(Scenario scenario) {
//        //if test fails - do this
//        if (scenario.isFailed()) {
//            System.out.println("Tets failed! Check your ScreenShot");
//            byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
//            scenario.attach(screenshot, "image/png", "attached screenshot");
//        } else {
//            System.out.println("CleanUp!");
//            System.out.println("Test completed! Thumbs Up");
//        }
//        System.out.println("##########-THE END-############");
//        //After every test, it will close the browser
//        Driver.close();
//    }
}