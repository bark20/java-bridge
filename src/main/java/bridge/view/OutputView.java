package bridge.view;

import bridge.error.ErrorMessage;
import bridge.model.BridgeGame;

import static bridge.view.GuideMessage.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printGameStart() {
        System.out.println(GAME_START.getMessage());
    }

    public void printInputBridgeSize() {
        System.out.println(INPUT_BRIDGE_LENGTH.getMessage());
    }

    public void printInputNextDirection() {
        System.out.println(INPUT_NEXT_DIRECTION.getMessage());
    }

    public void printInputRetryOrNot() {
        System.out.println(INPUT_RETRY_OR_NOT.getMessage());
    }


    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame bridgeGame) {
        String topBridge = bridgeGame.getTopBridge()
                .substring(0, bridgeGame.getTopBridge().length() - 1)
                + "]";

        String downbridge = bridgeGame.getDownBridge()
                .substring(0, bridgeGame.getDownBridge().length() - 1)
                + "]";

        System.out.println(topBridge);
        System.out.println(downbridge);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame, boolean success) {
        System.out.println(OUTPUT_GAME_RESULT.getMessage());
        printMap(bridgeGame);
        printGameSuccessOrNot(success);
        System.out.printf(OUTPUT_TOTAL_TRIAL_COUNT.getMessage(), bridgeGame.getTrialCount());
    }

    private void printGameSuccessOrNot(boolean success) {
        if (success) {
            System.out.printf(OUTPUT_GAME_SUCCESS_OR_NOT.getMessage(), "성공");
            return;
        }
        System.out.printf(OUTPUT_GAME_SUCCESS_OR_NOT.getMessage(), "실패");
    }

    public void printError(String errorMessage) {
        System.out.println(ErrorMessage.PREFIX + errorMessage);
    }
}
