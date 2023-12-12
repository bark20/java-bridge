package bridge.view;

import bridge.exception.InputException;
import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final Pattern BRIDGE_SIZE_PATTERN = Pattern.compile("^[0-9]{1,2}$");
    private static final Pattern COMMAND_PATTERN = Pattern.compile("^[A-Z]$");

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = input();
        if (!BRIDGE_SIZE_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(InputException.INVALID_NUMERIC.getMessage());
        }
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input = input();
        if (!COMMAND_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(InputException.INVALID_MOVE_COMMAND.getMessage());
        }
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String input = input();
        if (!COMMAND_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(InputException.INVALID_RETRY_COMMAND.getMessage());
        }
        return input;
    }

    public String input() {
        return Console.readLine();
    }
}
