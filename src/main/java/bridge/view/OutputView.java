package bridge.view;

import java.util.List;
import java.util.StringJoiner;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private OutputView() {
    }

    public static void printStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(List<String> upMovingResults, List<String> downMovingResults) {
        StringBuilder bridgeStatus = new StringBuilder();
        bridgeStatus.append(formatStatus(upMovingResults));
        bridgeStatus.append(formatStatus(downMovingResults));
        System.out.println(bridgeStatus);
    }

    private static String formatStatus(List<String> movingResults) {
        StringJoiner stringJoiner = new StringJoiner(" | ", "[ ", " ]\n");
        for (String result : movingResults) {
            stringJoiner.add(result);
        }
        return stringJoiner.toString();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(String bridgeStatus, boolean isSuccess, int tryCount) {
        System.out.println(bridgeStatus);
        System.out.println();
        printSuccessOrFailure(isSuccess);
        System.out.println(tryCount);
    }

    private static void printSuccessOrFailure(boolean isSuccess) {
        if (isSuccess) {
            System.out.println("성공");
            return;
        }
        System.out.println("실패");
    }
}
