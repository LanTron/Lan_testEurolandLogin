package finalCucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:Target\\testreport.html"},
        glue = "stepDefinitions",
        features = "src\\test\\resources\\feature\\login.feature"

)
public class RunCucumberTest {

}
