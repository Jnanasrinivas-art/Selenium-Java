package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//cucumber-> TestNG,Junit(runners)

@CucumberOptions(
        features="src/test/java/cucumber",
        glue = "bddStepDefinition",
        tags = "@Sanity",
        monochrome = true,
        plugin = {"html:target/cucumber.html"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests
{


}
