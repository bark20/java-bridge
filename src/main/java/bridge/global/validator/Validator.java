package bridge.global.validator;

import bridge.global.exception.CustomException;
import bridge.global.exception.ErrorMessage;

public final class Validator {
    public static int validateNumber(String message, ErrorMessage errorMessage) {
        if (isNotNumber(message)) {
            throw CustomException.from(errorMessage);
        }
        return Integer.parseInt(message);
    }

    private static boolean isNotNumber(String str) {
        return !str.matches("\\d+");
    }

    public static void validateRange(
            int number,
            int start,
            int end,
            ErrorMessage errorMessage
    ) {
        if (isInvalidRange(number, start, end)) {
            throw CustomException.from(errorMessage);
        }
    }

    private static boolean isInvalidRange(int number, int start, int end) {
        return number < start || number > end;
    }
}
