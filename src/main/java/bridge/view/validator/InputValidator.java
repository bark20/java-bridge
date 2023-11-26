package bridge.view.validator;

import bridge.constants.GameValue;
import bridge.constants.RegexPattern;

public class InputValidator {

    private InputValidator() {
    }

    public static void validateNumber(String input) {
        if (!RegexPattern.ONLY_NUMBER.matches(input)) {
            throw new IllegalArgumentException("다리의 길이는 숫자만 입력할 수 있습니다.");
        }
    }

    public static void validateMoveCommand(String command) {
        if (!command.equals(GameValue.MOVE_UP_COMMAND) && !command.equals(GameValue.MOVE_DOWN_COMMAND)) {
            throw new IllegalArgumentException("이동할 칸은 U 또는 D 문자만 입력할 수 있습니다.");
        }
    }

    public static void validateRetryCommand(String command) {
        if (!command.equals(GameValue.RETRY_COMMAND) && !command.equals(GameValue.QUIT_COMMAND)) {
            throw new IllegalArgumentException("재시작/종료는 R 또는 Q 문자만 입력할 수 있습니다.");
        }
    }
}
