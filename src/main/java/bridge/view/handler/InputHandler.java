package bridge.view.handler;

import bridge.domain.Bridge;
import bridge.domain.BridgeMaker;
import bridge.view.InputView;
import java.util.function.Supplier;

public class InputHandler {
    private final InputView inputView;

    public InputHandler(InputView inputView) {
        this.inputView = inputView;
    }

    public Bridge createValidatedBridge(BridgeMaker bridgeMaker) {
        return receiveValidatedInput(() -> {
            int bridgeSize = inputView.readBridgeSize();
            return Bridge.from(bridgeMaker.makeBridge(bridgeSize));
        });
    }

    public String readMoving() {
        return receiveValidatedInput(inputView::readMoving);
    }

    public String readGameCommand() {
        return receiveValidatedInput(inputView::readGameCommand);
    }

    private <T> T receiveValidatedInput(Supplier<T> inputView) {
        while (true) {
            try {
                return inputView.get();
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
