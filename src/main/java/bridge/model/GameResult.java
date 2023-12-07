package bridge.model;

public enum GameResult {
    SUCCESS("성공"),
    FAIL("실패");

    private final String output;

    GameResult(String output) {
        this.output = output;
    }

    public String getOutput() {
        return output;
    }
}
