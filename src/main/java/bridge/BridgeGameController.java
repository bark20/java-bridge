package bridge;

import view.InputView;
import view.OutputView;

import java.util.*;

public class BridgeGameController {

    private final List<String> bridge;

    private List<String> finalUpBridge;
    private List<String> finalDownBridge;
    private int tryCount = 0;
    public BridgeGameController(List<String> bridge) {
        this.bridge = bridge;
    }

    public void run(){
        while(true){
            boolean isGameEnd = play();
            tryCount++;
            if(isGameEnd){
                OutputView.printGameEndMessage();
                OutputView.printResult(finalUpBridge, finalDownBridge);
                OutputView.printGameStateMessage(isGameEnd);
                OutputView.printGameTryMessage(tryCount);
                return;
            }
            String gameCommand = InputView.readGameCommand(); // gameCommand 선언을 이동
            System.out.println(gameCommand);
            if(gameCommand.equals("Q")){
                OutputView.printGameEndMessage();
                OutputView.printResult(finalUpBridge, finalDownBridge);
                OutputView.printGameStateMessage(isGameEnd);
                OutputView.printGameTryMessage(tryCount);
                return;
            }
        }
    }

    private boolean play() {
        BridgeGame bridgeGame = new BridgeGame(bridge);
        for (int location = 0; location < bridge.size(); location++) {
            String moving = InputView.readMoving();
            System.out.println(moving);
            boolean isMove = bridgeGame.move(moving, location);
            OutputView.printMap(bridgeGame.getUpBridge());
            OutputView.printMap(bridgeGame.getDownBridge());
            System.out.println();
            if (!isMove) {
                finalUpBridge = bridgeGame.getUpBridge();
                finalDownBridge = bridgeGame.getDownBridge();
                return false;
            }
        }
        finalUpBridge = bridgeGame.getUpBridge();
        finalDownBridge = bridgeGame.getDownBridge();
        return true;
    }
}
