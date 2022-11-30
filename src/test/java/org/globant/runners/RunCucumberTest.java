package org.globant.runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(glue = {"org.globant.testing.stepDefinitions"},
        features = "org.globant.testing.features",
        plugin = {"pretty", "html:target/site/cucumber-pretty","json:target/cucumber.json"},
        snippets = CucumberOptions.SnippetType.CAMELCASE)


public class RunCucumberTest {

}
