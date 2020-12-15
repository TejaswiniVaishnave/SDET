package cucumberTest;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Features",
    glue = {"stepDefinitions"},
    tags = "@Activity2_4",
    plugin = {"html: HRMReports/html_test_report4.html"},
    monochrome = true
)

public class ActivitiesRunner {
    //empty
}