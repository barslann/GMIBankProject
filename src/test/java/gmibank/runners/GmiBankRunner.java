package gmibank.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "gmibank/stepdefinitions",
        tags = "@wip",
        plugin = {"pretty",
                "html:target/default-cucumber-reports",
                "json:target/json-reports/cucumber.json"
//                "junit:target/xml-report/cucumber.xml",
        }
)
public class GmiBankRunner {
}
