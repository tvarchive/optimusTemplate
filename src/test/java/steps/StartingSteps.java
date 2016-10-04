package steps;

import com.google.common.base.CaseFormat;
import com.testvagrant.optimus.device.OptimusPool;
import com.testvagrant.optimus.entity.SmartBOT;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.IOUtils;
import utils.OptimusImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class StartingSteps extends BaseSteps {

    private static boolean dunit = false;

    @Before
    public void setUp(Scenario scenario) throws Exception {
        runGlobalHooks();

        String appJson = getAppJson(System.getProperty("testFeed") + ".json");

        //register bots for as many devices as required for this test - appium server should be running
        List<SmartBOT> smartBOTs = new OptimusPool().registerSmartBOTs(appJson, forScenario(getUniqueScenarioName(scenario)));
        optimus = new OptimusImpl(having(smartBOTs));
    }

    private void runGlobalHooks() {
        if (!dunit) {
            new GlobalHooks().testSuiteSetUp();
            dunit = true;
        }
    }

    private List<SmartBOT> having(List<SmartBOT> smartBOTs) {
        return smartBOTs;
    }

    private String forScenario(String scenarioName) {
        return scenarioName;
    }

    private String getAppJson(String fileName) {
        String result = "";
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            result = IOUtils.toString(classLoader.getResourceAsStream(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            byte[] failedScreens = optimus.getScreenCapture();
            scenario.embed(failedScreens, "image/png");
        }
        optimus.deRegisterSmartBOTs();
    }

    private String getUniqueScenarioName(Scenario scenario) {
        ArrayList<String> scenariosList = new ArrayList<String>();
        String uniqueScenarioName;
        String scenarioName = scenario.getName();
        int frequency = 1;
        if (scenariosList.contains(scenarioName)) {
            frequency = Collections.frequency(scenariosList, scenarioName);
            ++frequency;
        }
        if (frequency >= 1) {
            uniqueScenarioName = scenarioName + frequency;
        } else {
            uniqueScenarioName = scenarioName;
        }
        uniqueScenarioName = uniqueScenarioName.toUpperCase().replace(" ", "_").replace("-", "_");
        scenariosList.add(uniqueScenarioName);
        uniqueScenarioName = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, uniqueScenarioName);
        System.out.println(uniqueScenarioName);
        return uniqueScenarioName;
    }
}
