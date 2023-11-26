package bridge.view.input;

public enum InputGuideMessage {

    BRIDGE_SIZE_INPUT("다리의 길이를 입력해주세요."),
    MOVING_DIRECTION_INPUT("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    RETRY_INPUT("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

    private final String message;

    InputGuideMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}

