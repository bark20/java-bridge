package bridge.controller;

import bridge.model.BridgeFactory;
import bridge.model.BridgeGame;
import bridge.model.BridgeSize;
import bridge.model.MoveResult;
import bridge.model.Round;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private final InputView inputView;

    private final OutputView outputView;

    public BridgeGameController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printBridgeGameTitle();

        final BridgeSize bridgeSize = inputView.readBridgeSize();
        final BridgeGame bridgeGame = new BridgeGame(
                BridgeFactory.createBridge(bridgeSize),
                Round.of(bridgeSize.intValue())
        );
        play(bridgeGame);
        outputView.printResult(bridgeGame);
    }

    private void play(final BridgeGame game) {
        while (!game.isClear()) {
            final MoveResult moveResult = moveBridge(game);

            if (!moveResult.isFail()) {
                continue;
            }
            if (isQuit()) {
                break;
            }
            game.retry();
        }
    }

    private MoveResult moveBridge(final BridgeGame game) {
        final MoveResult moveResult = game.move(inputView.readMoving());
        outputView.printMap(game.getResult());
        return moveResult;
    }

    private boolean isQuit() {
        return inputView.readGameCommand().isQuit();
    }
}
