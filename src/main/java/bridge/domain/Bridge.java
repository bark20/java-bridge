package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private final List<String> upperBridge;
    private final List<String> lowwerBridge;

    private Bridge() {
        this.upperBridge = new ArrayList<>();
        this.lowwerBridge = new ArrayList<>();
    }

    public static Bridge getInstance() {
        return Holder.INSTANCE;
    }

    public void moveUp(String moveResult) {
        upperBridge.add(moveResult);
        lowwerBridge.add(" ");
    }

    public void moveLowwer(String moveResult) {
        upperBridge.add(" ");
        lowwerBridge.add(moveResult);
    }

    private static class Holder {
        private static final Bridge INSTANCE = new Bridge();
    }

    @Override
    public String toString() {
        return "[ " + String.join(" | ", upperBridge) + " ]\n" + "[ " + String.join(" | ", lowwerBridge) + " ]";
    }
}
