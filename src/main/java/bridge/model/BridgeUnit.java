package bridge.model;

public enum BridgeUnit {
    TOP("U", 1),
    BOTTOM("D", 0),;

    private String signatureLetter;
    private int signatureNumber;

    BridgeUnit(String signatureLetter, int signatureNumber) {
        this.signatureLetter = signatureLetter;
        this.signatureNumber = signatureNumber;
    }
}
