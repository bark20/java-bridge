package bridge.controller;

import bridge.controller.dto.Move;
import bridge.controller.dto.MoveResult;
import bridge.domain.constants.Result;
import bridge.util.RetryExecutor;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MoveController {
    private final InputView inputView;
    private final OutputView outputView;

    public MoveController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     */
    public MoveResult retry(List<String> bridges) {
        int count = 1;
        while (true) {
            List<Move> moves = move(bridges);
            Optional<MoveResult> moveResult = createMoveResult(moves, count);
            if (moveResult.isPresent()) {
                return moveResult.get();
            }
            count++;
        }
    }

    private Optional<MoveResult> createMoveResult(List<Move> moves, int count) {
        if (isSucceed(moves)) { // 끝까지 이동에 성공한 경우
            return Optional.of(new MoveResult(moves, Result.SUCCESS, count));
        }
        String retry = RetryExecutor.retryUntilSuccess(inputView::readGameCommand);
        if ("Q".equals(retry)) { // 종료
            return Optional.of(new MoveResult(moves, Result.FAIL, count));
        }
        return Optional.empty(); // 재시작
    }

    private boolean isSucceed(List<Move> result) {
        int size = result.size();
        return result.get(size - 1).success().equals("O");
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     */
    public List<Move> move(List<String> bridges) {
        List<Move> moves = new ArrayList<>();
        for (String bridge : bridges) {
            Move move = createSingleMove(bridge);
            moves.add(move);
            outputView.printMap(moves);
            if (move.success().equals("X")) {
                return moves;
            }
        }
        return moves;
    }

    private Move createSingleMove(String bridge) {
        String direction = RetryExecutor.retryUntilSuccess(inputView::readMoving);
        if (cannotMove(bridge, direction)) {
            return new Move(direction, "X");
        }
        return new Move(direction, "O");
    }

    private boolean cannotMove(String bridge, String direction) {
        return !bridge.equals(direction);
    }
}
