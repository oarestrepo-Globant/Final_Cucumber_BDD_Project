package org.globant.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(glue = {"org.globant.testing.stepDefinitions"},
        features = "src/test/java/org/globant/testing/features/",
        plugin = {"pretty", "html:target/site/cucumber-pretty","json:target/cucumber.json"},
        snippets = CucumberOptions.SnippetType.CAMELCASE)

/**
 * Class for Run Cucumber Test.
 * This class allow to run all the tests.
 * */
public class RunCucumberTest extends AbstractTestNGCucumberTests {
}
