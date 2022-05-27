package org.iti.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/org/iti/features/Registration.feature"},
        glue = {"src/test/java/org/iti/steps"},
        plugin = {"pretty", "html:target/test-output"},
        monochrome = true
)
public class Runner extends AbstractTestNGCucumberTests {
}
