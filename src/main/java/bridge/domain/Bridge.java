package bridge.domain;

import java.util.List;

public class Bridge {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final int MIN_BRIDGE_SIZE = 3;
    private static final int MAX_BRIDGE_SIZE = 20;
    private final List<String> bridge;


    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public static Bridge from(List<String> bridge) {
        validateBridgeSize(bridge.size());
        return new Bridge(bridge);
    }

    private static void validateBridgeSize(int bridgeSize) {
        if (bridgeSize < MIN_BRIDGE_SIZE || bridgeSize > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException(ERROR_PREFIX + "다리의 길이는 3이상 20이하의 숫자만 입력할 수 있습니다.");
        }
    }

    public List<String> getBridge() {
        return bridge;
    }
}
