package steps;

import com.testvagrant.optimus.entity.SmartBOT;
import io.appium.java_client.android.AndroidDriver;
import utils.OptimusImpl;

public class BaseSteps {


    protected static OptimusImpl optimus;

    protected AndroidDriver getDriverInstanceFor(String appConsumer) {
        return getSmartBOTBelongingTo(appConsumer).getDriver();
    }

    protected SmartBOT getSmartBOTBelongingTo(String appConsumer) {
        return optimus.findBOTFor(appConsumer);
    }


}
