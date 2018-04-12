package steps;

import com.testvagrant.commons.exceptions.OptimusException;
import com.testvagrant.stepdefs.exceptions.NoSuchEventException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

import java.io.IOException;

import static com.testvagrant.stepdefs.core.Tapster.tapster;

public class GenericSteps extends BaseSteps {
    @Given("^(\\w+)\\s+on\\s+(\\w+)\\s+screen\\s+(\\w+)\\s+on\\s+(\\w+)\\s+value\\s+(.*)$")
    public void consumerOnScreenPerformsActionOnElementWithValue(String consumer, String screen, String action, String element, String value) throws NoSuchEventException, OptimusException, IOException {
        tapster().useDriver(getDriverInstanceFor(consumer))
                .asConsumer(consumer)
                .onScreen(screen)
                .onElement(element)
                .doAction(action)
                .withValue(value)
                .serve();
    }

    @And("^(\\w+)\\s+on\\s+(\\w+)\\s+screen\\s+(\\w+)\\s+on\\s+(\\w+)$")
    public void consumerOnScreenPerformsActionOnElement(String consumer, String screen, String action, String element) throws OptimusException, NoSuchEventException, IOException {
        tapster().useDriver(getDriverInstanceFor(consumer))
                .onScreen(screen)
                .asConsumer(consumer)
                .onElement(element)
                .doAction(action)
                .serve();
    }

    @And("^(\\w+)\\s+on\\s+(\\w+)\\sscreen verifies\\s+(\\w+)\\s+is\\s+(.*)$")
    public void assertelement(String consumer, String screen, String element, String action) throws NoSuchEventException, IOException, OptimusException {
        tapster().useDriver(getDriverInstanceFor(consumer))
                .onScreen(screen)
                .asConsumer(consumer)
                .onElement(element)
                .doAction(action)
                .serve();
    }

    @And("^(\\w+)\\s+on\\s+(\\w+)\\sscreen verifies\\s+(\\w+)\\s+has\\s+(\\w+)\\s+value\\s+(.*)$")
    public void assertelementwithvalue(String consumer, String screen, String element, String action, String value) throws OptimusException, NoSuchEventException, IOException {
        tapster().useDriver(getDriverInstanceFor(consumer))
                .onScreen(screen)
                .asConsumer(consumer)
                .onElement(element)
                .doAction(action)
                .withValue(value)
                .serve();
    }

    @And("^(\\w+)\\s+on\\s+(\\w+)\\s+screen\\s+(\\w+)\\s+on\\s+(\\w+)\\s+with index as\\s+(\\w+)\\s+and value is\\s+(.*)$")
    public void consumerOnScreenPerformsActionOnListOfElementsWithValue(String consumer, String screen, String action, String element, int index, String value) throws NoSuchEventException, OptimusException, IOException, InterruptedException {
        tapster().useDriver(getDriverInstanceFor(consumer))
                .asConsumer(consumer)
                .onScreen(screen)
                .onElement(element)
                .doAction(action)
                .withIndex(index)
                .withValue(value)
                .serve();
    }

    @And("^(\\w+)\\s+on\\s+(\\w+)\\s+screen\\s+(\\w+)\\s+on\\s+(\\w+)\\s+with index as\\s+(\\w+)$")
    public void consumerOnScreenPerformsActionOnListOfElements(String consumer, String screen, String action, String element, int index) throws NoSuchEventException, OptimusException, IOException, InterruptedException {
        tapster().useDriver(getDriverInstanceFor(consumer))
                .asConsumer(consumer)
                .onScreen(screen)
                .onElement(element)
                .doAction(action)
                .withIndex(index)
                .serve();
    }

    @Given("^(\\w+)\\s+on\\s+(\\w+)\\s+screen\\s+performs\\s+(.*)$")
    public void consumerOnScreenPerformsNavigation(String consumer, String screen, String navigation) throws NoSuchEventException, IOException, OptimusException {
        tapster().useDriver(getDriverInstanceFor(consumer))
                .asConsumer(consumer)
                .onScreen(screen)
                .doAction(navigation)
                .serve();
    }

    @Given("^I am running this scenario in parrallel on IOS$")
    public void iAmRunningThisScenarioInParrallelOnIOS() throws Throwable {
        System.out.println("Something Ran");
    }
}
