package bridge.common.utils.formatter;

import bridge.common.constant.CharacterSymbol;

public class ErrorMessageFormatter {

    private static final String ERROR_PREFIX = "[ERROR]";

    private ErrorMessageFormatter() {
    }

    public static String addErrorPrefix(String message) {
        return ERROR_PREFIX + CharacterSymbol.BLANK.getLiteral() + message;
    }

}
