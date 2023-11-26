package bridge.view.input;

public enum InputGuideMessage {

    BRIDGE_SIZE_INPUT("다리의 길이를 입력해주세요.");

    private final String message;

    InputGuideMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}

