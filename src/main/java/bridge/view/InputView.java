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
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String moving = Console.readLine();
        validateNullAndEmpty(moving);
        validateSingleLetter(moving);
        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String gameCommand = Console.readLine();
        validateNullAndEmpty(gameCommand);
        validateSingleLetter(gameCommand);
        return gameCommand;
    }

    private void validateNullAndEmpty(String input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            throw new IllegalArgumentException("null 이거나 길이가 없는 문자열 입니다.");
        }
    }

    private void validateNumeric(String input) {
        if (!NUMERIC_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException("문자열이 숫자로만 이루어져 있지 않습니다.");
        }
    }

    private void validateSingleLetter(String input) {
        if (input.length() != 1) {
            throw new IllegalArgumentException("문자열의 크기는 한개로 이루어져야 합니다.");
        }
    }
}
