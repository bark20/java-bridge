package bridge.domain;

public class GameResult {

    private boolean isSuccess = false;
    private int gameCount = 1;
    private String moveResult;
    private StringBuilder upperBridge = new StringBuilder();
    private StringBuilder lowerBridge = new StringBuilder();

    public void plusCount() {
        gameCount++;
    }

    public boolean isCrossSuccess() {
        return isSuccess;
    }

    public int getGameCount() {
        return gameCount;
    }

    public String getMoveResult(BridgeGame bridgeGame) {
        resetBridge();
        int insertIndex = 1;

        for (int position = 0; position <= bridgeGame.getUserPosition(); position++) {
            insertIndex = makeBeforeBridge(bridgeGame, position, insertIndex);
            makeFinalBridgePosition(bridgeGame, position, insertIndex);
        }

        moveResult = upperBridge.toString() + "\n" + lowerBridge.toString();
        return moveResult;
    }

    private void resetBridge() {
        upperBridge = new StringBuilder();
        lowerBridge = new StringBuilder();
        upperBridge.append("[]");
        lowerBridge.append("[]");
    }

    private void makeFinalBridgePosition(BridgeGame bridgeGame, int position, int insertIndex) {
        if (position == bridgeGame.getUserPosition()) {
            if (bridgeGame.nextCorrectBridge(position).equals("U")) {
                addFinalResultIfUp(bridgeGame, insertIndex);
            }
            if (bridgeGame.nextCorrectBridge(position).equals("D")) {
                addFinalResultIfDown(bridgeGame, insertIndex);
            }
        }
    }

    private int makeBeforeBridge(BridgeGame bridgeGame, int position, int insertIndex) {
        if (position < bridgeGame.getUserPosition()) {
            if (bridgeGame.nextCorrectBridge(position).equals("U")) {
                upperBridge.insert(insertIndex, " O |");
                lowerBridge.insert(insertIndex, "   |");
            }
            if (bridgeGame.nextCorrectBridge(position).equals("D")) {
                upperBridge.insert(insertIndex, "   |");
                lowerBridge.insert(insertIndex, " O |");
            }
            insertIndex += 4;
        }
        return insertIndex;
    }

    private void addFinalResultIfDown(BridgeGame bridgeGame, int insertIndex) {
        if (bridgeGame.isMoved()) {
            upperBridge.insert(insertIndex, "   ");
            lowerBridge.insert(insertIndex, " O ");
            isSuccess = true;
        }
        if (!bridgeGame.isMoved()) {
            upperBridge.insert(insertIndex, " X ");
            lowerBridge.insert(insertIndex, "   ");
            isSuccess = false;
        }
    }

    private void addFinalResultIfUp(BridgeGame bridgeGame, int insertIndex) {
        if (bridgeGame.isMoved()) {
            upperBridge.insert(insertIndex, " O ");
            lowerBridge.insert(insertIndex, "   ");
            isSuccess = true;
        }
        if (!bridgeGame.isMoved()) {
            upperBridge.insert(insertIndex, "   ");
            lowerBridge.insert(insertIndex, " X ");
            isSuccess = false;
        }
    }

    public String getFinalMoveResult() {
        return moveResult;
    }
}
