package bridge.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final Pattern NUMERIC_PATTERN = Pattern.compile("^[0-9]*$");

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String bridgeSize = Console.readLine();
        validateNullAndEmpty(bridgeSize);
        validateNumeric(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    private void validateNullAndEmpty(String input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            throw new IllegalArgumentException("null 이거나 길이가 없는 문자열 입니다.");
        }
    }

    private void validateNumeric(String input) {
        if (!NUMERIC_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException("문자열이 숫자로 이루어져 있지 않습니다.");
        }
    }
}
