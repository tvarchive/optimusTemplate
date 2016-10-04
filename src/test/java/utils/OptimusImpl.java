package utils;

import com.testvagrant.optimus.device.OptimusPool;
import com.testvagrant.optimus.entity.SmartBOT;
import com.testvagrant.optimus.utils.ScreenShotGenerator;

import java.io.IOException;
import java.util.List;

public class OptimusImpl {


    private List<SmartBOT> smartBOTs;

    public OptimusImpl(List<SmartBOT> smartBOTs) {
        this.smartBOTs = smartBOTs;
    }

    public SmartBOT findBOTFor(String appConsumer) {
        SmartBOT smartBOT = smartBOTs.stream()
                .filter(s -> s.getBelongsTo().equals(appConsumer))
                .findFirst().get();
        return smartBOT;
    }


    public List<SmartBOT> getSmartBOTs() {
        return smartBOTs;
    }

    public byte[] getScreenCapture() throws IOException {
        return new ScreenShotGenerator(smartBOTs).getFailureImage();
    }

    public void deRegisterSmartBOTs() {
        new OptimusPool().deRegisterSmartBOTs(smartBOTs);
    }
}
