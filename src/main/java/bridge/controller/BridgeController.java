package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeMaker;
import bridge.view.InputHandler;
import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class BridgeController {
    private final InputHandler inputHandler;
    private final OutputView outputView;

    public BridgeController(InputHandler inputHandler, OutputView outputView) {
        this.inputHandler = inputHandler;
        this.outputView = outputView;
    }

    public void run() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();

        System.out.println("다리의 길이를 입력해주세요.");
        int bridgeSize = inputHandler.readBridgeSize();
        System.out.println();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        System.out.println(bridge);


        List<String> upperBridge = new ArrayList<>(bridge.size());
        List<String> lowwerBridge = new ArrayList<>(bridge.size());

        for (String s : bridge) {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            String moveCommand = inputHandler.readMoving();

            if (moveCommand.equals("U") && s.equals(moveCommand)) {
                upperBridge.add("O");
                lowwerBridge.add(" ");
            }
            if (moveCommand.equals("U") && !s.equals(moveCommand)) {
                upperBridge.add("X");
                lowwerBridge.add(" ");
            }

            if (moveCommand.equals("D") && s.equals(moveCommand)) {
                upperBridge.add(" ");
                lowwerBridge.add("O");
            }
            if (moveCommand.equals("D") && !s.equals(moveCommand)) {
                upperBridge.add(" ");
                lowwerBridge.add("X");
            }

            System.out.println("[ " + String.join(" | ", upperBridge) + " ]");
            System.out.println("[ " + String.join(" | ", lowwerBridge) + " ]");
            System.out.println();
        }

        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        inputHandler.readGameCommand();
    }
}
