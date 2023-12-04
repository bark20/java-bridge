package bridge.error;

public enum ErrorMessage {
    PREFIX("[ERROR] "),
    INVALID_BRIDGE_LENGTH("다리의 길이는 3 ~ 20 사이의 정수여야 합니다."),
    INVALID_MOVING_DIRECTION("입력은 U 또는 D이어야 합니다."),
    INVALID_GAME_COMMAND("입력은 R 또는 Q이어야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
