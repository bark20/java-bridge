package bridge;

import view.InputView;
import view.OutputView;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        OutputView.printGameStart();
        int bridgeSize = InputView.readBridgeSize();
        System.out.println(bridgeSize);

        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        System.out.println(bridge);

        BridgeGameController bridgeGameController = new BridgeGameController(bridge);
        bridgeGameController.run();
    }
}


