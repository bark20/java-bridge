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
        int currentPosition = 0;
        while (currentPosition != bridgeSize) {
            String movingDirection = inputView.readMoving();
            outputView.printMap(bridge, currentPosition, movingDirection);

            if (bridge.get(currentPosition).equals(movingDirection)) {
                currentPosition++;
                continue;
            }

            if (inputView.readGameCommand().equals(Command.R.name())) {
                currentPosition = 0;
                continue;
            }
            break;
        }
        outputView.printResult();
    }
}
