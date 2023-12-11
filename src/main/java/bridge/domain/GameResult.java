package bridge.domain;

import java.util.List;

public class GameResult {

    private boolean isSuccess = false;
    private int gameCount = 1;
    private String moveResult;

    public void plusCount() {
        gameCount++;
    }

    public void resetCount() {
        gameCount = 0;
    }

    public boolean isCrossSuccess() {
        return isSuccess;
    }

    public int getGameCount() {
        return gameCount;
    }

    public String getMoveResult(boolean moveSuccess, int userPosition, List<String> bridge) {
        StringBuilder upperBridge = new StringBuilder();
        StringBuilder lowerBridge = new StringBuilder();
        upperBridge.append("[]");
        lowerBridge.append("[]");


        int upIndex = 1;
        int downIndex = 1;
        for (int i = 0; i <= userPosition; i++) {

            if (i < userPosition) {
                if (bridge.get(i).equals("U")) {
                    upperBridge.insert(upIndex, " O |");
                    lowerBridge.insert(downIndex, "   |");
                }
                if (bridge.get(i).equals("D")) {
                    upperBridge.insert(upIndex, "   |");
                    lowerBridge.insert(downIndex, " O |");
                }
                upIndex += 4;
                downIndex += 4;
            }

            if (i == userPosition) {
                if (bridge.get(i).equals("U")) {
                    if (moveSuccess) {
                        upperBridge.insert(upIndex, " O ");
                        lowerBridge.insert(downIndex, "   ");
                        isSuccess = true;
                    }
                    if (!moveSuccess) {
                        upperBridge.insert(upIndex, "   ");
                        lowerBridge.insert(downIndex, " X ");
                        isSuccess = false;
                    }
                }
                if (bridge.get(i).equals("D")) {
                    if (moveSuccess) {
                        upperBridge.insert(upIndex, "   ");
                        lowerBridge.insert(downIndex, " O ");
                        isSuccess = true;
                    }
                    if (!moveSuccess) {
                        upperBridge.insert(upIndex, " X ");
                        lowerBridge.insert(downIndex, "   ");
                        isSuccess = false;
                    }
                }
            }
        }
        moveResult = upperBridge.toString() + "\n" + lowerBridge.toString();
        return moveResult;
    }

    public String getFinalMoveResult() {
        return moveResult;
    }
}
