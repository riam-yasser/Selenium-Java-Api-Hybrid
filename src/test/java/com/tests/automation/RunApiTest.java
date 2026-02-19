package com.tests.automation;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/spec/features",
        //glue = "com.tests.automation.steps",
        plugin = {
                "pretty",
                "html:target/report-back/cucumber-report.html",
                "json:target/report-back/cucumber.json"
        },
        tags = "@users",
        monochrome = true,
        snippets = CAMELCASE
)
public class RunApiTest {
}
