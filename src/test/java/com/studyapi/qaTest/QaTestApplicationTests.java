package com.studyapi.qaTest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/resources/features",
		glue = "com.studyapi.qaTest.stepsDefinitions",
		plugin = {"pretty", "html:target/cucumber-reports"}
)
class QaTestApplicationTests {

}
