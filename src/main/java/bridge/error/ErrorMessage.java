package bridge.error;

public enum ErrorMessage {

    INVALID_INPUT_FORMAT("유효하지 않은 입력 형식입니다."),
    INVALID_NUMBER_FORMAT("숫자만 입력 가능합니다."),
    INVALID_BRIDGE_SIZE("다리 길이는 %d 이상 %d 이하의 숫자만 가능합니다."),
    INVALID_DIRECTION("유효하지 않은 방향입니다.");

    private static final String MESSAGE_FORMAT = "[ERROR] %s";
    private final String message;

    ErrorMessage(String message) {
        this.message = String.format(MESSAGE_FORMAT, message);
    }

    public String getMessage() {
        return message;
    }
}