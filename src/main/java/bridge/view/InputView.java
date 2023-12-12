package bridge.view;

import bridge.global.exception.CustomException;
import bridge.global.exception.ErrorMessage;
import bridge.global.validator.Validator;
import bridge.view.console.ConsoleReader;
import bridge.view.console.ConsoleWriter;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        ConsoleWriter.printlnMessage("다리의 길이를 입력해주세요.");
        return validateBridgeSize(ConsoleReader.enterMessage());
    }

    private int validateBridgeSize(String message) {
        int size = Validator.validateNumber(
                message,
                ErrorMessage.NOT_NUMBER_ERROR
        );
        Validator.validateRange(size,
                3,
                20,
                ErrorMessage.BRIDGE_SIZE_RANGE_ERROR
        );
        return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        ConsoleWriter.printlnMessage("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        return validateMoving(ConsoleReader.enterMessage());
    }

    private String validateMoving(String message) {
        if (isNotMatch(message, "U") && isNotMatch(message, "D")) {
            throw CustomException.from(ErrorMessage.INVALID_MOVING_MESSAGE);
        }
        return message;
    }

    private boolean isNotMatch(String actual, String expected) {
        return actual.equals(expected);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
