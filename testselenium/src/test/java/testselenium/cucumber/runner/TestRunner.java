package testselenium.cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",

        glue = {"testselenium.cucumber", "testselenium.hooks"},

        plugin = {
                "pretty",
                "html:target/cucumber-report.html"
        },

        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}