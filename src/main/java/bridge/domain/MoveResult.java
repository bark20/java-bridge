package bridge.domain;

public enum MoveResult {

    SUCCESS("O"),
    FAIL("X");

    private final String resultSymbol;

    MoveResult(String resultSymbol) {
        this.resultSymbol = resultSymbol;
    }

    public String getResultSymbol() {
        return resultSymbol;
    }

    public boolean isFail() {
        return this == FAIL;
    }

}
