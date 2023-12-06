package bridge.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final Pattern MOVING_INPUT_REGEX = Pattern.compile("^[UD]$");
    private static final Pattern GAME_COMMAND_INPUT_REGEX = Pattern.compile("^[RQ]$");

    private InputView() {
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(); // TODO 예외 메시지
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)"); // TODO Direction 사용
        String input = Console.readLine();
        if (MOVING_INPUT_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException(); // TODO 예외 메시지
        }
        return input; // TODO Direction return
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"); // TODO GameCommand 사용
        String input = Console.readLine();
        if (GAME_COMMAND_INPUT_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException(); // TODO 예외 메시지
        }
        return input; // TODO GameCommand return
    }
}
