package org.globant.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        glue = {"org.globant.testing.stepDefinitions.web"},
        features = "src/test/java/org/globant/testing/features/",
        plugin = {"pretty", "html:target/site/cucumber-pretty","json:target/cucumber.json"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@web"
)

/**
 * Class for Run Cucumber Test.
 * This class allow to run all the tests.
 * */
public class RunCucumberWebTest extends AbstractTestNGCucumberTests {
}
