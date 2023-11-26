package bridge.view.output;

import bridge.common.constant.CharacterSymbol;
import bridge.domain.BridgeGame;
import bridge.domain.MoveRecord;
import bridge.domain.MovingDirection;
import java.util.List;
import java.util.stream.Collectors;

public class OutputFormatter {

    private static final String BLANK = CharacterSymbol.BLANK.getLiteral();
    private static final String NEW_LINE = CharacterSymbol.NEW_LINE.getLiteral();

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

    public static String formatTotalResult(List<MoveRecord> moveResults) {
        return new StringBuilder()
                .append("최종 게임 결과")
                .append(NEW_LINE)
                .append(formatMoveResult(moveResults))
                .toString();
    }

    public static String formatSuccessFail(BridgeGame bridgeGame) {
        return String.format("게임 성공 여부: %s", parseSuccessFail(bridgeGame));
    }

    private static String parseSuccessFail(BridgeGame bridgeGame) {
        if (bridgeGame.isPlayerWon()) {
            return "성공";
        }
        return "실패";
    }

    public static String formatTotalAttemptCount(int attemptCount) {
        return String.format("총 시도한 횟수: %d", attemptCount);
    }

}
