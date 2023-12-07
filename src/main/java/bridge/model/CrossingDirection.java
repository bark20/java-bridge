package bridge.model;

import java.util.Arrays;

public enum CrossingDirection {
    TOP("U", 1),
    BOTTOM("D", 0),
    ;

    private final String signatureLetter;
    private final int signatureNumber;

    CrossingDirection(String signatureLetter, int signatureNumber) {
        this.signatureLetter = signatureLetter;
        this.signatureNumber = signatureNumber;
    }

    public String getSignatureLetter() {
        return signatureLetter;
    }

    public static CrossingDirection of(int signatureNumber) {
        return Arrays.stream(values())
                .filter(bridgeUnit -> bridgeUnit.signatureNumber == signatureNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("전달된 숫자에 해당하는 칸이 없습니다."));
    }

    public static CrossingDirection of(String signatureLetter) {
        return Arrays.stream(values())
                .filter(bridgeUnit -> bridgeUnit.signatureLetter.equals(signatureLetter))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("전달된 문자에 해당하는 칸이 없습니다."));
    }
}
