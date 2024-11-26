package stepDefination;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		glue = {"stepDefination"},
		monochrome = true,
		plugin = {"pretty","html:target/cucumber html.report"},
		tags= "@FunctionalTest"
		)
public class TestRunner {

}
