package eurolandLogin;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:Target\\testReport.html"},
        glue = "stepDefinitions",
        features = "src\\test\\resources\\eurolandLogin",
        dryRun = false

)
public class RunCucumberTest {

}
