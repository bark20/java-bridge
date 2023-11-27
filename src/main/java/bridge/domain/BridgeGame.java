package bridge.domain;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static final int INITIAL_ATTEMPT_COUNT = 1;

    private GameStatus status;
    private int attemptCount;
    private final Bridge bridge;
    private Player player;

    private BridgeGame(GameStatus status, int attemptCount, Bridge bridge, Player player) {
        this.status = status;
        this.attemptCount = attemptCount;
        this.bridge = bridge;
        this.player = player;
    }

    public static BridgeGame defaultOf(Bridge bridge) {
        return new BridgeGame(GameStatus.ON_GOING, INITIAL_ATTEMPT_COUNT, bridge, Player.defaultOf());
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(MovingDirection direction) {
        player.move(direction, bridge);
        updateGameStatus();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        this.player = Player.defaultOf();
        this.status = GameStatus.ON_GOING;
        this.attemptCount++;
    }

    private void updateGameStatus() {
        if (player.hasCrossedAllBridge(bridge)) {
            this.status = GameStatus.FINISHED;
            return;
        }
        if (player.hasFailed()) {
            this.status = GameStatus.STOPPED;
        }
    }

    public List<MoveRecord> getMoveResults() {
        return player.getRecords();
    }

    public boolean isPlayerWon() {
        return this.player.hasCrossedAllBridge(this.bridge);
    }

    public boolean isOnGoing() {
        return this.status.isOnGoing();
    }

    public boolean isStopped() {
        return this.status.isStopped();
    }

    public int getAttemptCount() {
        return attemptCount;
    }

}
