package steps;

import com.google.common.base.CaseFormat;
import com.testvagrant.optimus.device.OptimusPool;
import com.testvagrant.optimus.entity.SmartBOT;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import utils.OptimusImpl;

import java.io.IOException;
import java.util.*;


public class StartingSteps extends BaseSteps {
    private static volatile boolean dunit = false;




    @Before
    public void setUp(Scenario scenario) throws Exception {
        String appJson = getAppJson(System.getProperty("testFeed") + ".json");
        runGlobalHooks();

        if (runModeFragmentation(appJson)) {
            appJson = updateAppJsonWithUdid(appJson);
        }
        //register bots for as many devices as required for this test
        List<SmartBOT> smartBOTs = new OptimusPool().registerSmartBOTs(appJson, getUniqueScenarioName(scenario));
        optimus = new OptimusImpl(having(smartBOTs));

    }

    private String updateAppJsonWithUdid(String appJson) {
        JSONObject jsonObject = new JSONObject(appJson);
        JSONArray testFeedArray = (JSONArray) jsonObject.get("testFeed");
        JSONObject testFeed = (JSONObject) testFeedArray.get(0);
        JSONObject appiumServerCapabilities = (JSONObject) ((JSONObject) testFeed.get("optimusDesiredCapabilities")).get("appiumServerCapabilities");
        appiumServerCapabilities.put("udid", System.getProperty("udid"));
        return jsonObject.toString();
    }

    private boolean runModeFragmentation(String appJson) {
        JSONObject jsonObject = new JSONObject(appJson);
        Map<String, Object> executionMap = toMap((JSONObject) jsonObject.get("executionDetails"));
        return executionMap.get("deviceFragmentation") != null;
    }

    private Map<String, Object> toMap(JSONObject appiumServerCapabilities) {
        Iterator<String> keysIterator = appiumServerCapabilities.keys();
        Map<String, Object> capabilitiesMap = new HashMap<>();
        while (keysIterator.hasNext()) {
            String key = keysIterator.next();
            Object value = appiumServerCapabilities.get(key);

            capabilitiesMap.put(key, value);
        }
        return capabilitiesMap;
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
