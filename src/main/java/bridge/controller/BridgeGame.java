package bridge.controller;

import bridge.controller.dto.MovingResult;
import bridge.controller.dto.SingleMove;
import bridge.domain.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.view.console.ConsoleWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;

    public BridgeGame(InputView _inputView, OutputView _outputView, BridgeMaker bridgeMaker) {
        this.inputView = _inputView;
        this.outputView = _outputView;
        this.bridgeMaker = bridgeMaker;
        outputView.printStartMessage();
    }

    public void run() {
        List<String> bridges = prepare();
        MovingResult movingResult = retry(bridges);
        outputView.printResult(movingResult);
    }

    /**
     * 다리를 자동으로 생성하는 메서드
     */
    public List<String> prepare() {
        int bridgeSize = retryUntilSuccess(() -> {
            return inputView.readBridgeSize();
        });
        return bridgeMaker.makeBridge(bridgeSize);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     */
    public MovingResult retry(List<String> bridges) {
        int count = 1;
        while (true) {
            List<SingleMove> result = move(bridges);
            if (isSucceed(result)) {
                return new MovingResult(result, "성공", count);
            }
            String retry = retryUntilSuccess(() -> {
                return inputView.readGameCommand();
            });
            if (retry.equals("Q")) {
                return new MovingResult(result, "실패", count);
            }
            count++;
        }
    }

    private boolean isSucceed(List<SingleMove> result) {
        int size = result.size();
        return cannotMove(result.get(size - 1).success(), "O");
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     */
    public List<SingleMove> move(List<String> bridges) {
        List<SingleMove> moves = new ArrayList<>();
        for (String bridge : bridges) {
            String direction = retryUntilSuccess(() -> {
                return inputView.readMoving();
            });
            if (cannotMove(bridge, direction)) {
                addMove(moves, direction, "X");
                return moves;
            }
            addMove(moves, direction, "O");
        }
        return moves;
    }

    private boolean cannotMove(String bridge, String direction) {
        return !bridge.equals(direction);
    }

    private void addMove(List<SingleMove> moves, String direction, String success) {
        moves.add(new SingleMove(direction, success));
        outputView.printMap(moves);
    }

    private static <T> T retryUntilSuccess(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                ConsoleWriter.printlnMessage(e.getMessage());
            }
        }
    }
}
