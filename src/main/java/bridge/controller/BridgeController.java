package bridge.controller;

import bridge.domain.model.Bridge;
import bridge.domain.model.BridgeGame;
import bridge.domain.constant.MoveCommand;
import bridge.domain.constant.RetryCommand;
import bridge.domain.constant.Status;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;

    public BridgeController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeGame = new BridgeGame();
    }

    public void crossBridge() {
        outputView.printStartMessage();
        Bridge bridge = createBridge();
        startCrossingTheBridge(bridge);
    }

    private void startCrossingTheBridge(Bridge bridge) {
        int count = 1;
        Status status;
        while (true) {
            status = startGame(bridge);
            if (status == Status.FAIL) {
                if (restartGame() == RetryCommand.RETRY) {
                    count++;
                    continue;
                }
            }
            break;
        }
        outputView.printResult(count, status, bridgeGame);
    }

    private RetryCommand restartGame() {
        outputView.printRestart();
        while (true) {
            try {
                String command = inputView.readGameCommand();
                return RetryCommand.from(command);
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
            }
        }
    }

    private Status startGame(Bridge bridge) {
        Status status = Status.SUCCESS;
        for (int idx = 0; idx < bridge.getSize(); idx++) {
            MoveCommand moveCommand = getMoveCommand();
            status = bridgeGame.move(idx, moveCommand, bridge);
            outputView.printMap(bridgeGame);
            if (bridgeGame.retry(status)) {
                break;
            }
        }
        return status;
    }

    private Bridge createBridge() {
        outputView.printInputSize();
        while (true) {
            try {
                int bridgeSize = inputView.readBridgeSize();
                Bridge bridge = Bridge.createBridge(bridgeSize);
                bridge.setBridge(bridgeSize);
                return bridge;
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
            }
        }
    }

    private MoveCommand getMoveCommand() {
        outputView.printInputMoveCommand();
        while (true) {
            try {
                String command = inputView.readMoving();
                return MoveCommand.from(command);
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
            }
        }
    }
}
