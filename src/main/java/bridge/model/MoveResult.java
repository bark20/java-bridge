package bridge.model;

public enum MoveResult {

    PASS("O"),
    FAIL("X"),
    NONE(" ");

    private final String symbol;

    MoveResult(final String symbol) {
        this.symbol = symbol;
    }

    boolean isPass() {
        return this == PASS;
    }

    boolean isNone() {
        return this == NONE;
    }

    String getSymbol() {
        return symbol;
    }

    public boolean isFail() {
        return this == FAIL;
    }
}
