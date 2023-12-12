package bridge;

import bridge.controller.BridgeController;
import bridge.controller.BridgeGame;
import bridge.controller.MoveController;
import bridge.domain.BridgeMaker;
import bridge.util.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        BridgeController bridgeController = getBridgeController(inputView);
        MoveController moveController = getMoveController(inputView);
        BridgeGame bridgeGame = getBridgeGame(bridgeController, moveController);
        bridgeGame.run();
    }

    private static BridgeController getBridgeController(InputView inputView) {
        return new BridgeController(
                inputView,
                new BridgeMaker(new BridgeRandomNumberGenerator())
        );
    }

    private static MoveController getMoveController(InputView inputView) {
        return new MoveController(
                inputView,
                new OutputView()
        );
    }

    private static BridgeGame getBridgeGame(BridgeController bridgeController, MoveController moveController) {
        return new BridgeGame(
                new OutputView(),
                bridgeController,
                moveController
        );
    }
}
