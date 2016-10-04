package steps;

import com.testvagrant.optimus.device.OptimusPool;

public class GlobalHooks {

    String appium_node_path = "/usr/local/bin/node";
    String appium_js_path = "/usr/local/bin/appium";

    public void testSuiteSetUp() {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                System.out.println("Appium Server Setup");
            }
        });

        String[] args = new String[2];

        args[0] = appium_node_path;
        args[1] = appium_js_path;

        new OptimusPool().createDevicePool();
        new OptimusPool().createServerPool(args);
    }


}
