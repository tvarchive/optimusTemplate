package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import pages.ExamplePage;

public class ExampleSteps extends BaseSteps{
    @Given("^I have an example application$")
    public void iHaveAnExampleApplication() throws Throwable {
       AppiumDriver driver =  getDriverInstanceFor("optimus");
        ExamplePage examplePage = new ExamplePage(driver).doSomething();
    }


}
