package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class MoveResult {
    private final List<String> upperBridge;
    private final List<String> lowwerBridge;

    public MoveResult() {
        this.upperBridge = new ArrayList<>();
        this.lowwerBridge = new ArrayList<>();
    }

    public void moveUp(String moveResult) {
        upperBridge.add(moveResult);
        lowwerBridge.add(" ");
    }

    public void moveLowwer(String moveResult) {
        upperBridge.add(" ");
        lowwerBridge.add(moveResult);
    }

    public boolean isSuccessful() {
        if (upperBridge.contains("X") || lowwerBridge.contains("X")) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ " + String.join(" | ", upperBridge) + " ]\n" +
                "[ " + String.join(" | ", lowwerBridge) + " ]";
    }
}
