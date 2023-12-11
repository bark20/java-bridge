package bridge.domain.validator;

public class Validator {

    public void validateBridgeSize(String userInput) {
        validateOnlyNumber(userInput);
        validateNumberRange(Integer.parseInt(userInput));
    }

    private void validateOnlyNumber(String userInput) {
        for (char c : userInput.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException(VaildatorConstants.ONLY_NUMBER);
            }
        }
    }

    private void validateNumberRange(int num) {
        if (!(num >= VaildatorConstants.MINIMUM_LENGTH && num <= VaildatorConstants.MAXIMUM_LENGTH)) {
            throw new IllegalArgumentException(VaildatorConstants.NUMBER_RANGE);
        }
    }

    public void validateUserMove(String userInput) {
        if (!(userInput.equals("U") || userInput.equals("D"))) {
            throw new IllegalArgumentException(VaildatorConstants.USER_MOVE);
        }
    }

    public void validateGameCommand(String userInput) {
        if (!(userInput.equals("R") || userInput.equals("Q"))) {
            throw new IllegalArgumentException(VaildatorConstants.GAME_COMMAND);
        }
    }
}
