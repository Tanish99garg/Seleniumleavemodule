package TestRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features ="C:\\Users\\tangarg\\eclipse-workspace\\LeaveModule\\src\\test\\resources\\Features\\leave2.feature", glue = {
"StepDefination" }
//,plugin= {"pretty","html:test-output"}
)

public class Runner {

}
