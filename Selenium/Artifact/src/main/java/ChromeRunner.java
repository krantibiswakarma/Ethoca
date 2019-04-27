import cucumber.api.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/FeatureFiles",
        glue = {"src/test/java/StepDefinitions"},
        tags = {"@test"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        })
public class ChromeRunner {

}
