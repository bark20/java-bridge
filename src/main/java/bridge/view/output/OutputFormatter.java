package bridge.view.output;

import bridge.common.constant.CharacterSymbol;
import bridge.domain.MoveRecord;
import bridge.domain.MovingDirection;
import java.util.List;
import java.util.stream.Collectors;

public class OutputFormatter {

    private static final String BLANK = CharacterSymbol.BLANK.getLiteral();

    private OutputFormatter() {
    }

    public static String formatMoveResult(List<MoveRecord> moveResults) {
        return createLineByDirection(moveResults, MovingDirection.UP)
                + System.lineSeparator()
                + createLineByDirection(moveResults, MovingDirection.DOWN);
    }

    private static String createLineByDirection(List<MoveRecord> moveResults, MovingDirection direction) {
        return new StringBuilder()
                .append("[")
                .append(withDirection(moveResults, direction))
                .append("]")
                .toString();
    }

    private static String withDirection(List<MoveRecord> moveResults, MovingDirection direction) {
        return moveResults.stream()
                .map(moveResult -> BLANK + parseSymbol(moveResult, direction) + BLANK)
                .collect(Collectors.joining("|"));
    }

    private static String parseSymbol(MoveRecord moveResult, MovingDirection direction) {
        if (moveResult.matchesDirection(direction)) {
            return moveResult.getResultSymbol();
        }
        return BLANK;
    }

}
