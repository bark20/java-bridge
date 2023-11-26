package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.view.InputHandler;
import bridge.view.OutputView;
import java.util.List;

public class BridgeController {
    private final InputHandler inputHandler;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;

    public BridgeController(InputHandler inputHandler, OutputView outputView, BridgeGame bridgeGame) {
        this.inputHandler = inputHandler;
        this.outputView = outputView;
        this.bridgeGame = bridgeGame;
    }

    public void run() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();

        System.out.println("다리의 길이를 입력해주세요.");
        int bridgeSize = inputHandler.readBridgeSize();
        System.out.println();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> randomBridge = bridgeMaker.makeBridge(bridgeSize);
        System.out.println(randomBridge);


        for (String square : randomBridge) {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            String moveCommand = inputHandler.readMoving();
            Bridge bridge = bridgeGame.move(square, moveCommand);
            System.out.println(bridge);
            System.out.println();
        }



        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        inputHandler.readGameCommand();
    }
}
