package bridge.global.exception;

public enum ErrorMessage {
    BLANK_INPUT_ERROR("빈 문자열이 입력되었습니다."),
    NOT_NUMBER_ERROR("올바른 숫자를 입력해주세요."),
    BRIDGE_SIZE_RANGE_ERROR("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    INVALID_MOVING_MESSAGE("이동할 칸을 잘못 입력하였습니다."),
    INVALID_GAME_COMMAND("재시도 혹은 종료 여부를 잘못 입력하였습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
