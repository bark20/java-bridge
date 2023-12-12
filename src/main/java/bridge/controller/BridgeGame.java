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
        MovingResult movingResult = move(bridges);
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
     * 사용자가 칸을 이동할 때 사용하는 메서드
     */
    public MovingResult move(List<String> bridges) {
        int count = 0;
        while (true) {
            List<SingleMove> result = tryMove(bridges);

            int size = result.size();
            if (result.get(size - 1).equals("O")) { // 성공 시 결과 반환
                return new MovingResult(
                        result,
                        "성공",
                        count
                );
            }
            // 실패 시 다시 시도할 지 여부를 입력한다.
            String retry = inputView.readGameCommand();

            // 실패 후 종료를 입력했을 시 결과를 반환한다.
            if (retry.equals("Q")) {
                return new MovingResult(
                        result,
                        "실패",
                        count
                );
            }
            count++;
        }
    }

    private List<SingleMove> tryMove(List<String> bridges) {
        List<SingleMove> moves = new ArrayList<>();

        for (String bridge : bridges) {
            String direction = inputView.readMoving();
            if (bridge.equals(direction)) { // 지나갈 수 있는 경우
                moves.add(new SingleMove(direction, "O"));
                outputView.printMap(moves);
                continue;
            }
            // 지나갈 수 없는 다리를 선택한 경우
            moves.add(new SingleMove(direction, "X"));
            outputView.printMap(moves);
            return moves;
        }
        return moves;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
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
