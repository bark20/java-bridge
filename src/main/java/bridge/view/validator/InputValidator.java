package bridge.view.validator;

public class InputValidator {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String MOVE_UP_COMMAND = "U";
    private static final String MOVE_DOWN_COMMAND = "D";
    private static final String RETRY_COMMAND = "R";
    private static final String QUIT_COMMAND = "Q";
    private static final int MIN_BRIDGE_SIZE = 3;
    private static final int MAX_BRIDGE_SIZE = 20;

    private InputValidator() {
    }

    public static void validateBridgeSize(int bridgeSize) {
        if (!(bridgeSize >= MIN_BRIDGE_SIZE && bridgeSize <= MAX_BRIDGE_SIZE)) {
            throw new IllegalArgumentException(ERROR_PREFIX + "다리의 길이는 3이상 20이하의 숫자만 입력할 수 있습니다.");
        }
    }

    public static void validateMoveCommand(String command) {
        if (!command.equals(MOVE_UP_COMMAND) && !command.equals(MOVE_DOWN_COMMAND)) {
            throw new IllegalArgumentException(ERROR_PREFIX + "이동할 칸은 U 또는 D 문자만 입력할 수 있습니다.");
        }
    }

    public static void validateRetryCommand(String command) {
        if (!command.equals(RETRY_COMMAND) && !command.equals(QUIT_COMMAND)) {
            throw new IllegalArgumentException(ERROR_PREFIX + "재시작/종료는 R 또는 Q 문자만 입력할 수 있습니다.");
        }
    }
}
