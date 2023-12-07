package bridge.model;

import java.util.Arrays;

public enum GameDecision {

    RETRY("R", "재시도"),
    QUIT("Q", "종료"),
    ;

    private final String signature;
    private final String korean;

    GameDecision(String signature, String korean) {
        this.signature = signature;
        this.korean = korean;
    }

    public static GameDecision of(String signature) {
        return Arrays.stream(values())
                .filter(gameDecision -> gameDecision.signature.equals(signature))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("주어진 문자에 해당하는 게임 진행 의사가 없습니다."));
    }
}
