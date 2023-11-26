package mock;

import bridge.BridgeNumberGenerator;

public class FakeBridgeNumberGenerator implements BridgeNumberGenerator {

    private final int generatedNumber;

    public FakeBridgeNumberGenerator(int generatedNumber) {
        this.generatedNumber = generatedNumber;
    }

    @Override
    public int generate() {
        return generatedNumber;
    }

}
