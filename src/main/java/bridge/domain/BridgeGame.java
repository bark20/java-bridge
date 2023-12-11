package bridge.domain;

import java.util.List;

public class BridgeGame {

    private final List<String> bridge;
    private boolean isRetry = true;
    private int userPosition = 0;
    private boolean isMoved = true;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
    }

    public void move(String userMove) {
        if (bridge.get(userPosition).equals(userMove)) {
            isMoved = true;
        }
        if (!(bridge.get(userPosition).equals(userMove))) {
            isMoved = false;
        }
    }

    public boolean isMoved() {
        return isMoved;
    }

    public boolean retry() {
        return isRetry;
    }

    public void quit() {
        isRetry = false;
    }

    public void resetUserPosition() {
        userPosition = 0;
    }

    public void userMoved() {
        userPosition++;
    }

    public int getUserPosition() {
        return userPosition;
    }

    public boolean endGame() {
        if (userPosition == bridge.size()) {
            return true;
        }
        return false;
    }

    public String nextCorrectBridge(int position) {
        return bridge.get(position);
    }
}
