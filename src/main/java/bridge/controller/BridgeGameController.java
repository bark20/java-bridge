package bridge.controller;

import bridge.domain.*;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public BridgeGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void gameStart() {
        outputView.gameStartMessage();
        List<String> bridge = bridgeMaker.makeBridge(getBridgeSize());
        System.out.println(bridge);
        BridgeGame bridgeGame = new BridgeGame(bridge);
        GameResult gameResult = new GameResult();

        crossBridge(gameResult, bridgeGame);
        outputView.printGameResult(
                gameResult.getFinalMoveResult(), gameResult.isCrossSuccess(), gameResult.getGameCount());
    }

    private void crossBridge(GameResult gameResult, BridgeGame bridgeGame) {
        while (bridgeGame.retry()) {
            String userMove = getUserMove();
            bridgeGame.move(userMove);

            String moveResult = gameResult.getMoveResult(bridgeGame);
            outputView.printMoveResult(moveResult);

            doFunctionAfterMove(gameResult, bridgeGame);
        }
    }

    private void doFunctionAfterMove(GameResult gameResult, BridgeGame bridgeGame) {
        if (!bridgeGame.isMoved()) {
            askRetry(gameResult, bridgeGame);
        }
        if (bridgeGame.isMoved()) {
            readyForNextMove(bridgeGame);
        }
    }

    private static void readyForNextMove(BridgeGame bridgeGame) {
        bridgeGame.userMoved();
        if (bridgeGame.endGame()) {
            bridgeGame.quit();
        }
    }

    private void askRetry(GameResult gameResult, BridgeGame bridgeGame) {
        String userChoice = getUserChoice();
        if (userChoice.equals("Q")) {
            bridgeGame.quit();
        }
        if (userChoice.equals("R")) {
            gameResult.plusCount();
            bridgeGame.resetUserPosition();
        }
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

    private String getUserMove() {
        String userMove;
        try {
            outputView.printInputMoveMessage();
            userMove = inputView.readMoving();
        } catch (IllegalArgumentException e) {
            userMove = getUserMove();
        }
        return userMove;
    }

    private String getUserChoice() {
        String userChoice;
        try {
            outputView.printInputRetryGameMessage();
            userChoice = inputView.readGameCommand();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            userChoice = getUserChoice();
        }
        return userChoice;
    }
}
