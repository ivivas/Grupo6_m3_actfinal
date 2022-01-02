package customer;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        glue = {"customer.browseSteps","customer.signupSteps"},
        plugin = {"pretty"},
        features = "src/test/resources/features"
)
public class Group6TestSuite {


}
