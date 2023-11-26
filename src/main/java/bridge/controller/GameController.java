package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeSize;
import bridge.domain.GameCommand;
import bridge.domain.MovingDirection;
import bridge.view.input.InputView;
import bridge.view.output.OutputView;
import java.util.function.Supplier;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.welcomePlayer();

        BridgeGame bridgeGame = setUpBridgeGame();

        while (bridgeGame.isOnGoing()) {
            movePosition(bridgeGame);

            if (bridgeGame.isFinished()) {
                outputView.showTotalResult(bridgeGame);
                break;
            }

            if (bridgeGame.isStopped()) {
                GameCommand command = input(() -> GameCommand.ofAbbreviation(inputView.readGameCommand()));

                if (command.isRetry()) {
                    bridgeGame.retry();
                    continue;
                }

                outputView.showTotalResult(bridgeGame);
                break;
            }
        }

    }

    private void movePosition(BridgeGame bridgeGame) {
        bridgeGame.move(inputMovingDirection());
        outputView.showMoveResult(bridgeGame.getMoveResults());
    }

    private MovingDirection inputMovingDirection() {
        return input(() -> MovingDirection.ofAbbreviation(inputView.readMovingDirection()));
    }

    private BridgeGame setUpBridgeGame() {
        BridgeMaker maker = new BridgeMaker(new BridgeRandomNumberGenerator());
        BridgeSize bridgeSize = inputBridgeSize();

        return BridgeGame.defaultOf(Bridge.from(maker.makeBridge(bridgeSize.getSize())));
    }

    private BridgeSize inputBridgeSize() {
        return input(() -> BridgeSize.from(inputView.readBridgeSize()));
    }

    public <T> T input(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            outputView.showErrorMessage(e.getMessage());
            return input(supplier);
        }
    }

}
