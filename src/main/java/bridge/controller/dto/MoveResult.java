package bridge.controller.dto;

import bridge.domain.constants.Result;
import java.util.List;

public class MoveResult {
    private List<Move> moves;
    private Result success;
    private int count;

    public MoveResult(List<Move> moves, Result success, int count) {
        this.moves = moves;
        this.success = success;
        this.count = count;
    }

    public List<Move> singleMoves() {
        return moves;
    }

    public Result success() {
        return success;
    }

    public int count() {
        return count;
    }
}
