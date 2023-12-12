package bridge.controller.dto;

import java.util.List;

public class MovingResult {
    private List<SingleMove> singleMoves;
    private String success;
    private int count;

    public MovingResult(List<SingleMove> singleMoves, String success, int count) {
        this.singleMoves = singleMoves;
        this.success = success;
        this.count = count;
    }

    public List<SingleMove> singleMoves() {
        return singleMoves;
    }

    public String success() {
        return success;
    }

    public int count() {
        return count;
    }
}
