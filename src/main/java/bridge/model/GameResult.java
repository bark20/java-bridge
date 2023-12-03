package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class GameResult {

    private List<MoveResult> moveResults;

    public GameResult() {
        this.moveResults = new ArrayList<>();
    }

    public void report(final MoveResult moveResult) {
        moveResults.add(moveResult);
    }

    public boolean isAllPass() {
        return moveResults.stream().allMatch(MoveResult::isPass);
    }
}
