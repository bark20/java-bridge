package bridge.view;

import bridge.domain.Direction;
import bridge.domain.GameCommand;
import bridge.error.ErrorMessage;
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
        return convertToInt(input);
    }

    private static int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        System.out.printf("이동할 칸을 선택해주세요. (위: %s, 아래: %s)%n",
                Direction.UP.getName(), Direction.DOWN.getName());
        String input = Console.readLine();
        validateInputRegex(MOVING_INPUT_REGEX, input);
        return input;
    }

    private static void validateInputRegex(Pattern regex, String input) {
        if (!regex.matcher(input).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_FORMAT.getMessage());
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        System.out.printf("게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)%n",
                GameCommand.RESTART.getName(), GameCommand.QUIT.getName());
        String input = Console.readLine();
        validateInputRegex(GAME_COMMAND_INPUT_REGEX, input);
        return input;
    }
}
