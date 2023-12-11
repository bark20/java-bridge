package bridge.view;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap() {
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public void gameStartMessage() {
        System.out.println(ViewConstants.START_MESSAGE);
    }

    public void inputBridgeSizeMessage() {
        System.out.println(ViewConstants.INPUT_BRIDGE_SIZE_MESSAGE);
    }

    public void printInputMoveMessage() {
        System.out.println(ViewConstants.INPUT_MOVE_MESSAGE);
    }

    public void printMoveResult(boolean moveSuccess, int userPosition, List<String> bridge) {
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
                    }
                    if (!moveSuccess) {
                        upperBridge.insert(upIndex, "   ");
                        lowerBridge.insert(downIndex, " X ");
                    }
                }
                if (bridge.get(i).equals("D")) {
                    if (moveSuccess) {
                        upperBridge.insert(upIndex, "   ");
                        lowerBridge.insert(downIndex, " O ");
                    }
                    if (!moveSuccess) {
                        upperBridge.insert(upIndex, " X ");
                        lowerBridge.insert(downIndex, "   ");
                    }
                }
            }
        }

        System.out.println(upperBridge);
        System.out.println(lowerBridge);
    }

    public void printInputRetryGameMessage() {
        System.out.println(ViewConstants.INPUT_RETRY_GAME_MESSAGE);
    }
}
