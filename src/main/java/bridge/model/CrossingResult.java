package bridge.model;

public enum CrossingResult {
    SUCCESS("O"),
    FAIL("X"),
    NOT_CROSSING(" ");

    private final String output;

    CrossingResult(String output) {
        this.output = output;
    }

    public String getOutput() {
        return output;
    }
}
