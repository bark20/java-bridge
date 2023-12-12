package bridge.view;

import static bridge.view.ViewMessage.*;

import bridge.domain.model.BridgeGame;
import bridge.domain.model.GameDashboard;
import bridge.domain.constant.Status;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printError(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public void printStartMessage() {
        System.out.println(START_MESSAGE.getMessage());
    }

    public void printInputSize() {
        System.out.println(INPUT_BRIDGE_SIZE_MESSAGE.getMessage());
    }

    public void printInputMoveCommand() {
        System.out.println(INPUT_MOVE_COMMAND_MESSAGE.getMessage());
    }

    public void printRestart() {
        System.out.println(INPUT_RETRY_COMMAND_MESSAGE.getMessage());
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame bridgeGame) {
        GameDashboard dashboard = bridgeGame.getGameDashboard();
        System.out.printf(RESULT_FORMAT.getMessage(), convertToString(dashboard.getUpResult()));
        System.out.printf(RESULT_FORMAT.getMessage(), convertToString(dashboard.getDownResult()));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int count, Status status, BridgeGame bridgeGame) {
        System.out.println(RESULT_MESSAGE.getMessage());
        printMap(bridgeGame);
        System.out.printf(SUCCESS_OR_FAIL.getMessage(), status.getMessage());
        System.out.printf(TOTAL_ATTEMPTS_COUNT.getMessage(), count);
    }

    private String convertToString(List<Status> result) {
        List<String> convertResult = result.stream().map(Status::getStatus)
                .collect(Collectors.toList());
        return String.join(DELIMITER.getMessage(), convertResult);
    }
}
