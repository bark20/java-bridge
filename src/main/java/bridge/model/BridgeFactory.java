package bridge.model;

import bridge.BridgeRandomNumberGenerator;

public class BridgeFactory {

    // 기본 생성자가 만들어지는 것을 막는다. (인스턴스화 방지용).
    private BridgeFactory() {
        throw new AssertionError();
    }

    public static Bridge createBridge(final BridgeSize size) {
        final BridgeMaker bridgeMaker = createBridgeMaker();
        return Bridge.withSymbols(bridgeMaker.makeBridge(size.intValue()));
    }

    private static BridgeMaker createBridgeMaker() {
        return new BridgeMaker(new BridgeRandomNumberGenerator());
    }
}
