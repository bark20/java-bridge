package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeSize;
import bridge.domain.GameCommand;
import bridge.domain.MovingDirection;
import bridge.domain.Player;
import bridge.view.input.InputView;
import bridge.view.output.OutputView;
import java.util.function.Supplier;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        // welcome
        outputView.welcomePlayer();

        // 브릿지 사이즈 입력
        BridgeSize bridgeSize = input(() -> BridgeSize.from(inputView.readBridgeSize()));

        // 다리 생성
        BridgeMaker maker = new BridgeMaker(new BridgeRandomNumberGenerator());
        Bridge bridge = Bridge.from(maker.makeBridge(bridgeSize.getSize()));

        // 게임 생성
        BridgeGame bridgeGame = BridgeGame.defaultOf(bridge);

        while (bridgeGame.isOnGoing()) {
            MovingDirection direction = input(() -> MovingDirection.ofAbbreviation(inputView.readMovingDirection()));
            bridgeGame.move(direction);
            outputView.showMoveResult(bridgeGame.getMoveResults());

            // 게임이 완전히 끝났으면 결과 출력
            if (bridgeGame.isFinished()) {
                outputView.showTotalResult(bridgeGame);
                break;
            }

            // 게임이 완전히 끝난게 아니라 실패해서 끝났다면 재입력 로직
            if (bridgeGame.isStopped()) {
                // input 재시도
                GameCommand command = input(() -> GameCommand.ofAbbreviation(inputView.readGameCommand()));

                if (command.isRetry()) {
                    bridgeGame.retry();
                    continue;
                }

                // not retry
                outputView.showTotalResult(bridgeGame);
                break;
            }
        }

    }

    public <T> T input(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            outputView.showErrorMessage(e.getMessage());
            return input(supplier);
        }
    }

}
