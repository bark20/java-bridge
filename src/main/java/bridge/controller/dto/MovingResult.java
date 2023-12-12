package bridge.controller.dto;

import java.util.List;

public record MovingResult(
        List<SingleMove> singleMoves,
        boolean success,
        int count
) {
}
