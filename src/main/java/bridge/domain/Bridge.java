package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.exception.InputException;
import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private static final int MIN_BRIDGE_RANGE = 3;
    private static final int MAX_BRIDGE_RANGE = 20;
    private final List<String> bridge = new ArrayList<>();

    private Bridge(int size) {
        validateSize(size);
    }

    public static Bridge createBridge(int size) {
        return new Bridge(size);
    }

    public void setBridge(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge.addAll(bridgeMaker.makeBridge(size));
    }

    private void validateSize(int size) {
        if (size < MIN_BRIDGE_RANGE || MAX_BRIDGE_RANGE < size) {
            throw new IllegalArgumentException(InputException.INVALID_RANGE.getMessage());
        }
    }
}
