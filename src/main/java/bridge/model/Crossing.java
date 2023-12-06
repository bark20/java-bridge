package bridge.model;

public enum Crossing {
    SUCCESS("O"),
    FAIL("X");

    private String output;

    Crossing(String output) {
        this.output = output;
    }
}
