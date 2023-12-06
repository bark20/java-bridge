package bridge.controller;

import bridge.BridgeGame;
import bridge.domain.Direction;
import bridge.domain.GameCommand;
import bridge.domain.MovingStatus;
import bridge.error.ErrorMessage;
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

        int bridgeSize = repeatReadForInvalid(this::getBridgeSize);

        List<String> bridge = bridgeGame.makeBridge(bridgeSize);

        while (bridgeGame.canMove(bridge)) {
            Direction movingDirection = repeatReadForInvalid(this::getDirection);
            MovingStatus movingStatus = bridgeGame.move(bridge, movingDirection);
            OutputView.printMap(movingStatus);
            if (movingStatus.cannotCross()) {
                restartOrQuit();
            }
        }

        OutputView.printResult(bridgeGame.currentMovingStatus(), bridgeGame.isSuccess(), bridgeGame.getTryCount());
    }

    private int getBridgeSize() {
        int bridgeSize = InputView.readBridgeSize();
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.INVALID_BRIDGE_SIZE.getMessage(), 3, 20));
        }
        return bridgeSize;
    }

    private Direction getDirection() {
        return Direction.of(InputView.readMoving());
    }

    private GameCommand getGameCommand() {
        return GameCommand.of(InputView.readGameCommand());
    }

    private void restartOrQuit() {
        GameCommand gameCommand = repeatReadForInvalid(this::getGameCommand);
        if (gameCommand == GameCommand.RESTART) {
            bridgeGame.retry();
        }
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
