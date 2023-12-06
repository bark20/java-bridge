package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Direction;
import bridge.domain.MovingStatus;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeController {

    public void run() {
        OutputView.printStartMessage();

        int bridgeSize = InputView.readBridgeSize();
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException(); // TODO 예외 메시지
        }

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        BridgeGame bridgeGame = new BridgeGame(bridge, new MovingStatus());
        while (bridgeGame.canMove()) {
            Direction movingDirection = Direction.of(InputView.readMoving());
            MovingStatus movingStatus = bridgeGame.move(movingDirection);
            OutputView.printMap(movingStatus.getMovingDirections(), movingStatus.getCanCrosses());
        }
    }
}
