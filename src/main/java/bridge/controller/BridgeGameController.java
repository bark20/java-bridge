package bridge.controller;

import bridge.domain.*;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private final GameResult gameResult = new GameResult();
    private final Validator validator;

    public BridgeGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.validator = new Validator();
    }

    public void gameStart() {
        outputView.gameStartMessage();
        List<String> bridge = bridgeMaker.makeBridge(getBridgeSize());
        BridgeGame bridgeGame = new BridgeGame(bridge);

        int userPosition = 0;
        boolean isCrossingBridge = true;

        while (isCrossingBridge) {
            outputView.printInputMoveMessage();
            String userMove = inputView.readMoving();
            boolean moveSuccess = bridgeGame.move(userMove, userPosition);

            String moveResult = gameResult.getMoveResult(moveSuccess, userPosition, bridge);
            outputView.printMoveResult(moveResult);

            if (!moveSuccess) {
                outputView.printInputRetryGameMessage();
                String userChoice = inputView.readGameCommand();
                if (userChoice.equals("Q")) {
                    isCrossingBridge = false;
                }
                if (userChoice.equals("R")) {
                    gameResult.plusCount();
                    userPosition = 0;
                }
            }
            if (moveSuccess) {
                ++userPosition;
                if (userPosition == bridge.size()) {
                    isCrossingBridge = false;
                }
            }

        }
        outputView.printGameResult(
                gameResult.getFinalMoveResult(), gameResult.isCrossSuccess(), gameResult.getGameCount());
    }

    private int getBridgeSize() {
        int bridgeSize;
        try {
            outputView.inputBridgeSizeMessage();
            bridgeSize = inputView.readBridgeSize();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            bridgeSize = getBridgeSize();
        }
        return bridgeSize;
    }
}
