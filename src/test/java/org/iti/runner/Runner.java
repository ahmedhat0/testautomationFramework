package org.iti.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/org/iti/features/Registration.feature",
        glue = {"org/iti/steps"},
        plugin = {"pretty", "html:test-output/cucumber-pretty.html"}
)
public class Runner extends AbstractTestNGCucumberTests {
}
