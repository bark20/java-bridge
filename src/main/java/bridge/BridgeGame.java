package bridge;

import java.util.*;

public class BridgeGame {
    private final List<String> bridge;

    private BridgeBoard bridgeBoard = new BridgeBoard();

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean move(String moving) {
        int currentLocation = bridgeBoard.getSize();
        boolean isPossible = isPossibleMove(moving, currentLocation);
        if (moving.equals("U")) {
            bridgeBoard.drawUpMovement(isPossible);
        }
        if (moving.equals("D")) {
            bridgeBoard.drawDownMovement(isPossible);
        }
        return isPossible;
    }

    private boolean isPossibleMove(String moving, int currentLocation) {
        if (moving.equals(bridge.get(currentLocation))) {
            return true;
        }
        return false;
    }

    public void retry() {
        bridgeBoard = new BridgeBoard();
    }

    public BridgeBoard getBridgeBoard() {
        return bridgeBoard;
    }

    public int getSize() {
        return bridge.size();
    }
}
