package bridge.model;

public enum MoveResult {

    PASS("O"),
    FAIL("X");

    private final String symbol;

    MoveResult(final String symbol) {
        this.symbol = symbol;
    }

    public boolean isPass() {
        return this == PASS;
    }

    public boolean isFail() {
        return this == FAIL;
    }
}
