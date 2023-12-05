package bridge.model;

public enum BridgeStructure {
    SUCCESS("O"),
    FAIL("X"),
    START("["),
    END("]"),
    MIDDLE("|")
    ;

    private String output;

    BridgeStructure(String output) {
        this.output = output;
    }
}
