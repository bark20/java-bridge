package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void gameStart() {
        outputView.gameStartMessage();
        outputView.inputBridgeSizeMessage();
        int bridgeSize = inputView.readBridgeSize();

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        System.out.println(bridge);
        BridgeGame bridgeGame = new BridgeGame(bridge);
        int userPosition = 0;

        boolean isCrossingBridge = true;
        while (isCrossingBridge) {
            outputView.printInputMoveMessage();
            String userMove = inputView.readMoving();
            boolean moveSuccess = bridgeGame.move(userMove, userPosition);
            outputView.printMoveResult(moveSuccess, userPosition, bridge);

            if (!moveSuccess) {
                outputView.printInputRetryGameMessage();
                String userChoice = inputView.readGameCommand();
                if (userChoice.equals("Q")) {
                    isCrossingBridge = false;
                }
                if (userChoice.equals("R")) {
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
        //outputView.printGameResult();


    }
}
