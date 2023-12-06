package bridge.controller;

import bridge.BridgeGame;
import bridge.domain.BridgeSize;
import bridge.domain.Direction;
import bridge.domain.GameCommand;
import bridge.domain.MovingStatus;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;
import java.util.function.Supplier;

public class BridgeController {

    private final BridgeGame bridgeGame;

    public BridgeController(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    public void run() {
        OutputView.printStartMessage();

        BridgeSize bridgeSize = repeatReadForInvalid(this::getBridgeSize);

        List<String> bridge = bridgeGame.makeBridge(bridgeSize.getSize());

        while (bridgeGame.canMove(bridge)) {
            Direction movingDirection = repeatReadForInvalid(this::getDirection);
            MovingStatus movingStatus = bridgeGame.move(bridge, movingDirection);
            OutputView.printMap(movingStatus);
            if (movingStatus.cannotCross()) {
                GameCommand gameCommand = repeatReadForInvalid(this::getGameCommand);
                if (gameCommand.isRestart()) {
                    bridgeGame.retry();
                    continue;
                }
                break;
            }
        }

        OutputView.printResult(bridgeGame.currentMovingStatus(), bridgeGame.isSuccess(), bridgeGame.getTryCount());
    }

    private BridgeSize getBridgeSize() {
        return new BridgeSize(InputView.readBridgeSize());
    }

    private Direction getDirection() {
        return Direction.of(InputView.readMoving());
    }

    private GameCommand getGameCommand() {
        return GameCommand.of(InputView.readGameCommand());
    }

    private <T> T repeatReadForInvalid(Supplier<T> reader) {
        try {
            return reader.get();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return repeatReadForInvalid(reader);
        }
    }
}
