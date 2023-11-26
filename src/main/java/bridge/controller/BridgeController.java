package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.constants.GameValue;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.view.handler.InputHandler;
import bridge.view.OutputView;

public class BridgeController {
    private final InputHandler inputHandler;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;
    private boolean status = true;

    public BridgeController(InputHandler inputHandler, OutputView outputView, BridgeGame bridgeGame) {
        this.inputHandler = inputHandler;
        this.outputView = outputView;
        this.bridgeGame = bridgeGame;
    }

    public void start() {
        outputView.printStartMessage();
        Bridge bridge = createBridge();
        run(bridge);
    }

    private Bridge createBridge() {
        outputView.printBridgeSizeInputMessage();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return inputHandler.createValidatedBridge(bridgeMaker);
    }

    private void run(Bridge bridge) {
        while (status) {
            move(bridge);
            if (isFinished()) {
                finishGame();
            }
            if (!isFinished()) {
                askRetry();
            }
        }
    }

    private void move(Bridge bridge) {
        for (String square : bridge.getBridge()) {
            outputView.printMoveInputMessage();
            String moveCommand = inputHandler.readMoving();
            bridgeGame.move(square, moveCommand);
            outputView.printMap(bridgeGame.getMoveResult());
        }
    }

    private boolean isFinished() {
        return bridgeGame.isSuccessful();
    }

    private void finishGame() {
        outputView.printResult(bridgeGame);
        status = false;
    }

    private void askRetry() {
        outputView.printRetryMessage();
        String retryCommand = inputHandler.readGameCommand();
        if (retryCommand.equals(GameValue.RETRY_COMMAND)) {
            bridgeGame.retry();
        }
        if (retryCommand.equals(GameValue.QUIT_COMMAND)) {
            outputView.printResult(bridgeGame);
        }
    }
}
