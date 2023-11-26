package bridge.view.input;

// InputView 클래스에서만 camp.nextstep.edu.missionutils.Console 의 readLine() 메서드를 이용해 사용자의 입력을 받을 수 있다.

import bridge.common.utils.validator.NumericValidator;
import bridge.view.print.Printer;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final Printer printer;

    public InputView(Printer printer) {
        this.printer = printer;
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        printer.printWithEmptyLineAhead(InputGuideMessage.BRIDGE_SIZE_INPUT.getMessage());

        String input = readLine();
        NumericValidator.validateNumeric(input);

        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMovingDirection() {
        printer.printWithEmptyLineAhead(InputGuideMessage.MOVING_DIRECTION_INPUT.getMessage());
        return readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        printer.printLine(InputGuideMessage.RETRY_INPUT.getMessage());
        return readLine();
    }

    public String readLine() {
        return Console.readLine().trim();
    }

}
