package bridge.controller.dto;

import java.util.List;

public class MovingResult {
    private List<Move> moves;
    private String success;
    private int count;

    public MovingResult(List<Move> moves, String success, int count) {
        this.moves = moves;
        this.success = success;
        this.count = count;
    }

    public List<Move> singleMoves() {
        return moves;
    }

    public String success() {
        return success;
    }

    public int count() {
        return count;
    }
}
