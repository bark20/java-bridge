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

    public void printMoveResult(String moveResult) {
        System.out.println(moveResult);
    }

    public void printInputRetryGameMessage() {
        System.out.println(ViewConstants.INPUT_RETRY_GAME_MESSAGE);
    }

    public void printGameResult(String finalMoveResult, boolean isSuccess, int gameCount) {
        System.out.println("최종 게임 결과");
        System.out.println(finalMoveResult);

        String crossSuccess = "";
        if (isSuccess) {
            crossSuccess = "성공";
        }
        if (!isSuccess) {
            crossSuccess = "실패";
        }
        System.out.println("게임 성공 여부: " + crossSuccess);
        System.out.println("총 시도한 횟수: " + gameCount);
    }
}
