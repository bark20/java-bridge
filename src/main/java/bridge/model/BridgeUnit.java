package bridge.model;

import java.util.Arrays;

public enum BridgeUnit {
    TOP("U", 1),
    BOTTOM("D", 0),
    ;

    private String signatureLetter;
    private int signatureNumber;

    BridgeUnit(String signatureLetter, int signatureNumber) {
        this.signatureLetter = signatureLetter;
        this.signatureNumber = signatureNumber;
    }

    public String getSignatureLetter() {
        return signatureLetter;
    }

    public static BridgeUnit of(int signatureNumber) {
        return Arrays.stream(values())
                .filter(bridgeUnit -> bridgeUnit.signatureNumber == signatureNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("전달된 숫자에 해당하는 칸이 없습니다."));
    }

    public static BridgeUnit of(String signatureLetter) {
        return Arrays.stream(values())
                .filter(bridgeUnit -> bridgeUnit.signatureLetter == signatureLetter)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("전달된 문자에 해당하는 칸이 없습니다."));
    }
}
