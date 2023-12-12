package bridge.controller;

import bridge.domain.BridgeMaker;
import bridge.util.RetryExecutor;
import bridge.view.InputView;
import java.util.List;

public class BridgeController {
    private final InputView inputView;
    private final BridgeMaker bridgeMaker;

    public BridgeController(InputView inputView, BridgeMaker bridgeMaker) {
        this.inputView = inputView;
        this.bridgeMaker = bridgeMaker;
    }

    public List<String> prepare() {
        int bridgeSize = RetryExecutor.retryUntilSuccess(() -> {
            return inputView.readBridgeSize();
        });
        return bridgeMaker.makeBridge(bridgeSize);
    }
}
