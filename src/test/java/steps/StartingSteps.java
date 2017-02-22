package steps;

import com.google.common.base.CaseFormat;
import com.testvagrant.optimus.device.OptimusController;

import com.testvagrant.optimus.entity.SmartBOT;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.IOUtils;
import utils.OptimusImpl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;


public class StartingSteps extends BaseSteps {


    @Before
    public void setUp(Scenario scenario) throws Exception {
        String testFeed = System.getProperty("testFeed") + ".json";
        System.out.println("file name -- " + testFeed);
        controller = new OptimusController(getAppJson(testFeed),getUniqueScenarioName(scenario));
        smartBOTs = controller.registerSmartBOTs();
        optimus = new OptimusImpl(having(smartBOTs));
    }


    private List<SmartBOT> having(List<SmartBOT> smartBOTs) {
        return smartBOTs;
    }

    private String getAppJson(String fileName) {
//        System.out.println("file name -- " + fileName);
        String result = "";
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            InputStream resourceAsStream = classLoader.getResourceAsStream(fileName);
            result = IOUtils.toString(resourceAsStream);
        } catch (FileNotFoundException f) {
            throw new RuntimeException("File not found exception");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @After
    public void e2eTearDown(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            byte[] failedScreens = optimus.getScreenCapture();
            scenario.embed(failedScreens, "image/png");
        }
        controller.deRegisterSmartBOTs(smartBOTs);
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
