package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * Created by krishnanand on 05/01/17.
 */
public class HelloOptimusSteps extends BaseSteps {
    @Given("^I have optimus hello application$")
    public void iHaveOptimusHelloApplication() throws Throwable {
        getDriverInstanceFor("optimus");
    }

    @When("^I open it on either emulator, simulator or device on any platform$")
    public void iOpenItOnEitherEmulatorSimulatorOrDeviceOnAnyPlatform() throws Throwable {

    }

    @Then("^I should be able to say a hello to optimus$")
    public void iShouldBeAbleToSayAHelloToOptimus() throws Throwable {
        Assert.assertTrue(true);
        Thread.sleep(5000);
    }

    @Then("^a failing step$")
    public void aFailingStep() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.fail();
    }

    @And("^i have a new (.*)$")
    public void iHaveANewStep(String param1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^i have definite \"([^\"]*)\"$")
    public void iHaveAnother(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
