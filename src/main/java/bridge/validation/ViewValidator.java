package bridge.validation;

import bridge.error.ErrorMessage;

import java.util.regex.Pattern;

public class ViewValidator {
    private final int BRIDGE_MIN_LENGTH = 3;
    private final int BRIDGE_MAX_LENGTH = 20;
    private final String REGEX_MOVING_DIRECTION = "^[UD]$";
    private final String REGEX_GAME_COMMAND = "^[RQ]$";
    Pattern movingDirectionPattern = Pattern.compile(REGEX_MOVING_DIRECTION);
    Pattern gameCommandPattern = Pattern.compile(REGEX_GAME_COMMAND);

    public void validateBridgeSize(int bridgeSize) {
        if (bridgeSize < BRIDGE_MIN_LENGTH || bridgeSize > BRIDGE_MAX_LENGTH)
            throw new IllegalArgumentException(ErrorMessage.INVALID_BRIDGE_LENGTH.getMessage());
    }

    public void validateMovingDirection(String input) {
        if (!movingDirectionPattern.matcher(input).find())
            throw new IllegalArgumentException(ErrorMessage.INVALID_MOVING_DIRECTION.getMessage());
    }

    public void validateGameCommand(String input) {
        if (!gameCommandPattern.matcher(input).find())
            throw new IllegalArgumentException(ErrorMessage.INVALID_GAME_COMMAND.getMessage());
    }
}
