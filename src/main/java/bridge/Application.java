package bridge;

import bridge.controller.BridgeController;
import bridge.domain.MovingStatus;

public class Application {

    public static void main(String[] args) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        MovingStatus movingStatus = new MovingStatus();
        BridgeController bridgeController = new BridgeController(new BridgeGame(bridgeMaker, movingStatus));
        bridgeController.run();
    }
}
