package bridge.validator;

import static bridge.exception.ErrorType.*;

import bridge.exception.ErrorType;
import java.util.regex.Pattern;

public class NumericValidator {

    private static final Pattern NUMERIC_PATTERN = Pattern.compile("\\d+");

    // 기본 생성자가 만들어지는 것을 막는다. (인스턴스화 방지용).
    private NumericValidator() {
        throw new AssertionError();
    }

    public static void validate(final String stringNumber) {
        if (isNullOrEmpty(stringNumber) || !isNumeric(stringNumber)) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    private static boolean isNullOrEmpty(final String stringNumber) {
        return stringNumber == null || stringNumber.isEmpty();
    }

    private static boolean isNumeric(final String stringNumber) {
        return NUMERIC_PATTERN.matcher(stringNumber).matches();
    }
}
