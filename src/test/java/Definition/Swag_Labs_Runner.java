package Definition;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features",
                     glue = {"Definition"},
            	     tags = ("@loginTest or @productBuyDeny"),
            	   plugin = {"pretty", "junit:target/cucumber-reports/Cucumber.xml",
            			     "html:target/cucumber-reports/dsalgo.html",
            	             "json:target/jsonReports/Cucumber.json"})

public class Swag_Labs_Runner {

}
