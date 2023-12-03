package bridge.model;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;

public class GameResult {

    private final EnumMap<BridgeType, List<MoveResult>> moveResults;

    public GameResult() {
        this.moveResults = new EnumMap<>(BridgeType.class);
        moveResults.put(BridgeType.LEFT, new ArrayList<>());
        moveResults.put(BridgeType.RIGHT, new ArrayList<>());
    }

    public void report(final MoveDirection direction, final MoveResult moveResult) {
        if (direction == MoveDirection.UP) {
            addResult(BridgeType.LEFT, moveResult);
            addResult(BridgeType.RIGHT, MoveResult.NONE);
            return;
        }
        addResult(BridgeType.RIGHT, moveResult);
        addResult(BridgeType.LEFT, MoveResult.NONE);
    }

    private void addResult(final BridgeType type, final MoveResult moveResult) {
        moveResults.get(type).add(moveResult);
    }

    public boolean isAllPass() {
        return moveResults.values().stream().allMatch(GameResult::isAllPassOf);
    }

    private static boolean isAllPassOf(final List<MoveResult> moveResults) {
        return moveResults.stream()
                .filter(moveResult -> !moveResult.isNone())
                .allMatch(MoveResult::isPass);
    }

    public List<String> getResultOf(BridgeType type) {
        return moveResults.get(type).stream()
                .map(MoveResult::getSymbol)
                .collect(Collectors.toList());
    }

    public void clear() {
        for (final BridgeType bridgeType : moveResults.keySet()) {
            moveResults.get(bridgeType).clear();
        }
    }
}
