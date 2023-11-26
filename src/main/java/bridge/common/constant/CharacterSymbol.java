package bridge.common.constant;

public enum CharacterSymbol {

    BLANK(" "),
    NEW_LINE(System.lineSeparator());

    private final String literal;

    CharacterSymbol(String symbolLiteral) {
        this.literal = symbolLiteral;
    }

    public String getLiteral() {
        return literal;
    }

}
