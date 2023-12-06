package bridge.view;

import bridge.domain.Direction;
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
    public static void printMap(String map) {
        System.out.println(map);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(String bridgeStatus, boolean isSuccess, int tryCount) {
        System.out.println("최종 게임 결과");
        System.out.println(bridgeStatus);
        printSuccessOrFailure(isSuccess);
        System.out.println("총 시도한 횟수: " + tryCount);
    }

    private static void printSuccessOrFailure(boolean isSuccess) {
        System.out.print("게임 성공 여부: ");
        if (isSuccess) {
            System.out.println("성공");
            return;
        }
        System.out.println("실패");
    }

    public static void printErrorMessage(IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
    }
}
