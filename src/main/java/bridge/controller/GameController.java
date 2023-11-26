package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeSize;
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
        Player player = Player.defaultOf();

        // 게임 생성
        BridgeGame bridgeGame = new BridgeGame(bridge, player);

        // 이동칸 입력
        MovingDirection direction = input(() -> MovingDirection.ofAbbreviation(inputView.readMovingDirection()));

        // 이동
        bridgeGame.move(direction);
    }

//    private <T> T process(Supplier<T> supplier, ErrorConsumer consumer) {
//        try {
//            return supplier.get();
//        } catch (IllegalArgumentException | IllegalStateException e) {
//            consumer.accept();
//            return process(supplier, consumer);
//        }
//    }

    public <T> T input(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            outputView.showErrorMessage(e.getMessage());
            return input(supplier);
        }
    }

}
