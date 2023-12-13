package bridge;

import java.util.*;

public class BridgeGame {
    private final List<String> bridge;

    private List<String> upBridge = new ArrayList<>();
    private List<String> downBridge = new ArrayList<>();

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean move(String moving, int currentLocation) {
        if (isPossibleMove(moving, currentLocation) && moving.equals("U")) {
            upBridge.add("O");
            downBridge.add(" ");
            return true;
        }
        if (isPossibleMove(moving, currentLocation) && moving.equals("D")) {
            upBridge.add(" ");
            downBridge.add("O");
            return true;
        }
        if (!isPossibleMove(moving, currentLocation) && moving.equals("U")) {
            upBridge.add("X");
            downBridge.add(" ");
            return false;
        }
        upBridge.add(" ");
        downBridge.add("X");
        return false;
    }

    private boolean isPossibleMove(String moving, int currentLocation) {
        if (moving.equals(bridge.get(currentLocation))) {
            return true;
        }
        return false;
    }

    public void retry() {
    }

    public List<String> getUpBridge() {
        return upBridge;
    }

    public List<String> getDownBridge() {
        return downBridge;
    }
}
