package bridge.controller;

import bridge.controller.dto.MoveResult;
import bridge.view.OutputView;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final OutputView outputView;
    private final BridgeController bridgeController;
    private final MoveController moveController;

    public BridgeGame(
            OutputView outputView,
            BridgeController bridgeController,
            MoveController moveController
    ) {
        this.outputView = outputView;
        this.bridgeController = bridgeController;
        this.moveController = moveController;
        this.outputView.printStartMessage();
    }

    public void run() {
        List<String> bridges = bridgeController.prepare();
        MoveResult moveResult = moveController.retry(bridges);
        outputView.printResult(moveResult);
    }
}
