package bridge;

import bridge.controller.BridgeController;
import bridge.domain.BridgeGame;
import bridge.domain.MoveResult;
import bridge.view.ErrorView;
import bridge.view.handler.InputHandler;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputHandler inputHandler = initHandler();
        BridgeGame bridgeGame = InitBridgeGame();
        OutputView outputView = new OutputView();
        BridgeController bridgeController = new BridgeController(inputHandler, outputView, bridgeGame);
        bridgeController.start();
    }

    private static InputHandler initHandler() {
        InputView inputView = new InputView();
        ErrorView errorView = new ErrorView();
        return  new InputHandler(inputView, errorView);
    }

    private static BridgeGame InitBridgeGame() {
        MoveResult moveResult = new MoveResult();
        int defaultRetryCount = 1;
        return new BridgeGame(moveResult, defaultRetryCount);
    }
}
