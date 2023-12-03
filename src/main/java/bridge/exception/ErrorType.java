package bridge.exception;

public enum ErrorType {

    INVALID_MOVE_DIRECTION("U(위 칸)와 D(아래 칸) 중 하나의 문자만 입력할 수 있습니다."),
    INVALID_BRIDGE_SIZE("다리 길이는 3부터 20 사이의 숫자여야 합니다.");

    private static final String ERROR_PREFIX = "[ERROR] ";

    private final String message;

    ErrorType(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}
