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
    public static void printMap(List<Direction> movingDirections, List<Boolean> canCrosses) {
        StringJoiner up = new StringJoiner(" | ", "[ ", " ]");
        StringJoiner down = new StringJoiner(" | ", "[ ", " ]");
        for (int i = 0; i < movingDirections.size(); i++) {
            if (movingDirections.get(i) == Direction.UP) {
                if (canCrosses.get(i)) {
                    up.add("O");
                    down.add(" ");
                    continue;
                }
                up.add("X");
                down.add(" ");
                continue;
            }
            if (canCrosses.get(i)) {
                down.add("O");
                up.add(" ");
                continue;
            }
            down.add("X");
            up.add(" ");
        }

        System.out.println(up);
        System.out.println(down);
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
