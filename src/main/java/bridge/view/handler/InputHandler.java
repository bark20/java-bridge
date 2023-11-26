package bridge.view.handler;

import bridge.domain.Bridge;
import bridge.domain.BridgeMaker;
import bridge.view.ErrorView;
import bridge.view.InputView;
import java.util.function.Supplier;

public class InputHandler {
    private final InputView inputView;
    private final ErrorView errorView;

    public InputHandler(InputView inputView, ErrorView errorView) {
        this.inputView = inputView;
        this.errorView = errorView;
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
                errorView.printErrorMessage(exception.getMessage());
            }
        }
    }
}
