package steps;

import cucumber.api.PendingException;
import cucumber.api.java8.En;
import pages.DriverLoginPage;

public class DriverSteps extends BaseSteps implements En {
    public DriverSteps() {
        And("^the driver is logged in$", () -> {
            // Write code here that turns the phrase above into concrete actions
            new DriverLoginPage(getDriverInstanceFor("driver")).login();
        });
        And("^the driver accepts the booking$", () -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });
        When("^driver starts the trip$", () -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });
        And("^driver end the trip$", () -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });
    }
}
