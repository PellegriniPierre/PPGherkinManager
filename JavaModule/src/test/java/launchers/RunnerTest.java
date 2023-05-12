package launchers;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(features = "features",tags = "",plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json", "junit:target/cucumber.xml"}, glue = {"stepsdefinitions", "cucumberSetup"})
@RunWith(Cucumber.class)
public class RunnerTest {

}