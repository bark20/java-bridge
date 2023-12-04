package bridge.view;

import bridge.validation.ViewValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final OutputView outputView = new OutputView();
    private static final ViewValidator validator = new ViewValidator();
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        outputView.printInputBridgeSize();

        String input = Console.readLine();
        int bridgeSize = 0;

        try {
            bridgeSize = Integer.parseInt(input);
            validator.validateBridgeSize(bridgeSize);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            readBridgeSize();
        }
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        outputView.printInputNextDirection();

        String input = Console.readLine();
        input = input.trim();

        try {
            validator.validateMovingDirection(input);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            readMoving();
        }
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        outputView.printInputRetryOrNot();

        String input = Console.readLine();
        input = input.trim();
        try {
            validator.validateGameCommand(input);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            readGameCommand();
        }
        return input;
    }
}
