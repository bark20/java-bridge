package bridge.controller.dto;

import java.util.List;

public record MovingResult(
        List<SingleMove> singleMoves,
        String success,
        int count
) {
}
