package bridge.model;

public enum MoveResult {

    PASS("O"),
    FAIL("X"),
    NONE(" ");

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

    public boolean isNone() {
        return this == NONE;
    }

    public String getSymbol() {
        return symbol;
    }
}
