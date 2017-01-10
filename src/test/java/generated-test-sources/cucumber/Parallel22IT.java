import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(strict = true,
    features = {"src/test/resources/features/helloOptimus.feature:4"},
    plugin = {"json:target/cucumber-parallel/1.json", "pretty"},
    monochrome = false,
    glue = { "steps" })
public class Parallel22IT {
}