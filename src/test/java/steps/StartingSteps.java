package steps;

import com.testvagrant.commons.entities.SmartBOT;
import com.testvagrant.optimus.device.OptimusController;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.IOUtils;
import utils.OptimusImpl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class StartingSteps extends BaseSteps {


    @Before
    public void setUp(Scenario scenario) throws Exception {
        String testFeed = System.getProperty("testFeed") + ".json";
        String appJson = getAppJson(testFeed);

        controller = new OptimusController(appJson, scenario);
        smartBOTs = controller.registerSmartBOTs();
//        scenario.write("This goes into reports");
//        scenario.embed("This goes into reports".getBytes(), "text/plain");
        optimus = new OptimusImpl(having(smartBOTs));
    }

    private List<SmartBOT> having(List<SmartBOT> smartBOTs) {
        return smartBOTs;
    }

    private String getAppJson(String fileName) {
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

}
