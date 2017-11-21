package steps;

import cucumber.api.java.en.Given;
import org.junit.Assert;
import pages.HelloOptimusPage;

public class HelloOptimusSteps extends BaseSteps {

    @Given("^I get a welcome message on successful execution of my hello optimus project$")
    public void iGetAWelcomeMessageOnSuccessfulExecutionOfMyHelloOptimusProject() throws Throwable {
        HelloOptimusPage helloOptimusPage = new HelloOptimusPage(getDriverInstanceFor("optimus"));
        String welcomeMessage = helloOptimusPage.getWelcomeMessage();
        Assert.assertEquals(HelloOptimusPage.MESSAGE,welcomeMessage);
        Assert.fail("testing failure");
    }
}
