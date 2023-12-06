package bridge.view;

import bridge.domain.Direction;
import bridge.domain.MovingStatus;
import java.util.StringJoiner;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String O = "O";
    private static final String X = "X";
    private static final String SPACE = " ";

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
    public static void printMap(MovingStatus movingStatus) {
        StringJoiner up = getStringJoiner();
        StringJoiner down = getStringJoiner();
        for (int i = 0; i < movingStatus.count(); i++) {
            Direction movingDirection = movingStatus.getMovingDirections().get(i);
            Boolean canCross = movingStatus.getCanCrosses().get(i);
            if (movingDirection == Direction.UP) {
                addOToUpIfCanCrossOrNot(up, down, canCross);
                continue;
            }
            addOToDownIfCanCrossOrNot(up, down, canCross);
        }

        System.out.println(up);
        System.out.println(down);
    }

    private static void addOToUpIfCanCrossOrNot(StringJoiner up, StringJoiner down, Boolean canCross) {
        if (canCross) {
            up.add(O);
            down.add(SPACE);
            return;
        }
        up.add(X);
        down.add(SPACE);
    }

    private static void addOToDownIfCanCrossOrNot(StringJoiner up, StringJoiner down, Boolean canCross) {
        if (canCross) {
            down.add(O);
            up.add(SPACE);
            return;
        }
        down.add(X);
        up.add(SPACE);
    }

    private static StringJoiner getStringJoiner() {
        return new StringJoiner(" | ", "[ ", " ]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(MovingStatus movingStatus, boolean isSuccess, int tryCount) {
        System.out.println("최종 게임 결과");
        printMap(movingStatus);
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
