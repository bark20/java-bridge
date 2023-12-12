package bridge;

import bridge.controller.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.util.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame(
                new InputView(),
                new OutputView(),
                new BridgeMaker(new BridgeRandomNumberGenerator())
        );
        bridgeGame.run();
    }
}
