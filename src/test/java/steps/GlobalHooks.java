package steps;

import com.testvagrant.optimus.device.OptimusPool;

public class GlobalHooks {

    public void testSuiteSetUp() {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                System.out.println("Optimus Suite Setup");
            }
        });

        new OptimusPool().createDevicePool();
    }
}
