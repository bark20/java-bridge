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
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[]\n[]");
        //[]\n[]

        int OXIndex = 1;
        for (int i = 0; i <= userPosition; i++) {

            if (i < userPosition) {
                if (bridge.get(i).equals("U")) {
                    stringBuilder.insert(OXIndex, " O |");
                    stringBuilder.insert(OXIndex+7, "   |");
                }
                if (bridge.get(i).equals("D")) {
                    stringBuilder.insert(OXIndex, "   |");
                    stringBuilder.insert(OXIndex+7, " O |");
                }
            }

            if (i == userPosition) {
                if (bridge.get(i).equals("U")) {
                    if (moveSuccess) {
                        stringBuilder.insert(OXIndex, " O ");
                        stringBuilder.insert(OXIndex+6, "   ");
                    }
                    if (!moveSuccess) {
                        stringBuilder.insert(OXIndex, "   ");
                        stringBuilder.insert(OXIndex+6, " X ");
                    }
                }
                if (bridge.get(i).equals("D")) {
                    if (moveSuccess) {
                        stringBuilder.insert(OXIndex, "   ");
                        stringBuilder.insert(OXIndex+6, " O ");
                    }
                    if (!moveSuccess) {
                        stringBuilder.insert(OXIndex, " X ");
                        stringBuilder.insert(OXIndex+6, "   ");
                    }
                }
            }
        }

        System.out.println(stringBuilder);

    }
}
