package bridge.model;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    List<String> bridge;
    StringBuilder topBridge = new StringBuilder("[");
    StringBuilder downBridge = new StringBuilder("[");
    int currentPosition = 0;
    int trialCount = 1;

    public StringBuilder getTopBridge() {
        return topBridge;
    }

    public StringBuilder getDownBridge() {
        return downBridge;
    }

    public int getTrialCount() {
        return trialCount;
    }

    public void setBridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean checkGameIsFinish() {
        return currentPosition == bridge.size();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public Boolean move(String direction) {
        if (direction.equals("U")) {
            if (bridge.get(currentPosition++).equals("U")) {
                appendEachBridge("O", " ");
                return true;
            }
            appendEachBridge("X", " ");
            return false;
        }
        if (bridge.get(currentPosition++).equals("D")) {
            appendEachBridge(" ", "O");
            return true;
        }
        appendEachBridge(" ", "X");
        return false;
    }

    private void appendEachBridge(String top, String down) {
        topBridge.append(" ")
                .append(top)
                .append(" |");

        downBridge.append(" ")
                .append(down)
                .append(" |");
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        currentPosition = 0;
        trialCount++;
        topBridge = new StringBuilder("[");
        downBridge = new StringBuilder("[");
    }
}
