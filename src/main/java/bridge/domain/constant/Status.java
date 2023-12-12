package bridge.domain.constant;

public enum Status {
    SUCCESS("O", "성공"),
    FAIL("X", "실패"),
    SPACE(" ", "");

    private final String status;
    private final String message;

    Status(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
