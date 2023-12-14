package bridge;

import view.InputView;
import view.OutputView;

import java.util.*;

public class BridgeGameController {

    private final BridgeGame bridgeGame;

    private int tryCount = 0;

    public BridgeGameController(List<String> bridge) {
        this.bridgeGame = new BridgeGame(bridge);
    }

    public void run() {
        while (true) {
            BridgeGameResult bridgeGameResult = play();
            tryCount++;
            if (isGameEnd(bridgeGameResult)) {
                OutputView.printGameResultMessage(bridgeGameResult, tryCount);
                return;
            }
            bridgeGame.retry();
        }
    }

    private BridgeGameResult play() {
        boolean isSuccess = true;
        for (int turn = 0; turn < bridgeGame.getSize() && isSuccess; turn++) {
            String moving = InputView.readMoving();
            System.out.println(moving);
            isSuccess = bridgeGame.move(moving);
            OutputView.printMap(bridgeGame.getBridgeBoard());
            System.out.println();
        }
        BridgeGameResult bridgeGameResult = new BridgeGameResult(
                bridgeGame.getBridgeBoard(),
                isSuccess);
        return bridgeGameResult;
    }

    boolean isGameEnd(BridgeGameResult bridgeGameResult) {
        if (!bridgeGameResult.isSuccess) {
            String gameCommand = InputView.readGameCommand(); // gameCommand 선언을 이동
            System.out.println(gameCommand);
            if (gameCommand.equals("R")) {
                return false;
            }
        }
        return true;
    }
}
