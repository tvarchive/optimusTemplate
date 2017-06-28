package steps;

import com.testvagrant.stepdefs.steps.BaseSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

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

    }
}
