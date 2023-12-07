package bridge.model;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
    }


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public CrossingResult move(String bridgeUnitLetter) {
        if (bridge.cross(bridgeUnitLetter)) {
            return CrossingResult.SUCCESS;
        }
        return CrossingResult.FAIL;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String decision) {
        return GameDecision.of(decision).equals(GameDecision.RETRY);
    }

    public boolean finish() {
        return bridge.end();
    }

    public GameResult win(CrossingResult crossingResult) {
        if (finish() && crossingResult.equals(CrossingResult.SUCCESS)) {
            return GameResult.SUCCESS;
        }
        return GameResult.FAIL;
    }
}
