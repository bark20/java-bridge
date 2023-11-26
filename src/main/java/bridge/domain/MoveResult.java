package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class MoveResult {
    private final List<String> upperBridge;
    private final List<String> lowerBridge;

    public MoveResult() {
        this.upperBridge = new ArrayList<>();
        this.lowerBridge = new ArrayList<>();
    }

    public void moveUp(String moveResult) {
        upperBridge.add(moveResult);
        lowerBridge.add(" ");
    }

    public void moveLowwer(String moveResult) {
        upperBridge.add(" ");
        lowerBridge.add(moveResult);
    }

    public boolean isSuccessful() {
        if (upperBridge.contains("X") || lowerBridge.contains("X")) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ " + String.join(" | ", upperBridge) + " ]\n" +
                "[ " + String.join(" | ", lowerBridge) + " ]";
    }
}
