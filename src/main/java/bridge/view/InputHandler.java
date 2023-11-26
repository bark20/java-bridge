package bridge.view;

import java.util.function.Supplier;

public class InputHandler {
    private final InputView inputView;

    public InputHandler(InputView inputView) {
        this.inputView = inputView;
    }

    public int readBridgeSize() {
        return receiveValidatedInput(inputView::readBridgeSize);
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
