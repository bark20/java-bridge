package bridge.controller;

import bridge.constants.Command;
import bridge.model.BridgeGame;
import bridge.model.BridgeMaker;
import bridge.model.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeGame bridgeGame = new BridgeGame();
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public void process() {
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        bridgeGame.setBridge(bridge);

        outputView.printGameStart();

        while (true) {
            String direction = inputView.readMoving();

            if (bridgeGame.move(direction)) {
                outputView.printMap(bridgeGame);
                if (bridgeGame.checkGameIsFinish())
                    break;
                continue;
            }
            outputView.printMap(bridgeGame);
            if (inputView.readGameCommand().equals(Command.R.name())) {
                bridgeGame.retry();
                continue;
            }
            break;
        }
        outputView.printResult(bridgeGame, bridgeGame.checkGameIsFinish());
    }
}
