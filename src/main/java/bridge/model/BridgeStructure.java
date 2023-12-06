package bridge.model;

public enum BridgeStructure {
    START("["),
    END("]"),
    MIDDLE("|")
    ;

    private String output;

    BridgeStructure(String output) {
        this.output = output;
    }
}
