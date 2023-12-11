package bridge.view;

import bridge.domain.validator.Validator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final Validator validator = new Validator();

    public int readBridgeSize() {
        String userInput = Console.readLine();
        validator.validateBridgeSize(userInput);
        return Integer.parseInt(userInput);
    }

    public String readMoving() {
        String userInput = Console.readLine();
        validator.validateUserMove(userInput);
        return userInput;
    }

    public String readGameCommand() {
        String userInput = Console.readLine();
        validator.validateGameCommand(userInput);
        return userInput;
    }
}
