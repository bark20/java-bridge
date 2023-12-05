package bridge.model;

import java.util.Arrays;

public enum BridgeGameDecision {

    RETRY("R", "재시도"),
    QUIT("Q", "종료"),;

    private String signature;
    private String korean;

    BridgeGameDecision(String signature, String korean) {
        this.signature = signature;
        this.korean = korean;
    }

    public static BridgeGameDecision of(String signature){
        return Arrays.stream(values())
                .filter(bridgeGameDecision -> bridgeGameDecision.signature.equals(signature))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("주어진 문자에 해당하는 게임 진행 의사가 없습니다."));
    }
}
