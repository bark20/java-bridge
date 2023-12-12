package bridge.domain.constant;

import bridge.exception.InputException;
import java.util.Arrays;

public enum RetryCommand {
    RETRY("R"),
    QUIT("Q");

    private final String command;

    RetryCommand(String command) {
        this.command = command;
    }

    public static RetryCommand from(String input) {
        return Arrays.stream(RetryCommand.values())
                .filter(com -> com.command.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(
                        InputException.INVALID_RETRY_COMMAND.getMessage()));
    }
}
