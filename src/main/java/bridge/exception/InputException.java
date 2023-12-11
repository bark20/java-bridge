package bridge.exception;

public enum InputException {
    INVALID_NUMERIC("자연수만 입력 가능합니다."),
    INVALID_RANGE("3이상 20이하의 자연수만 입력해주세요."),
    INVALID_MOVE_COMMAND("유효하지 않은 이동 커맨드 입니다. (위 - U, 아래 - D)"),
    INVALID_RETRY_COMMAND("유효하지 않은 재시작/종료 커맨드 입니다. (재시작 - R, 종료 - Q)");

    private static final String ERROR_MESSAGE = "[ERROR] ";
    private final String message;

    InputException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_MESSAGE + message;
    }
}
