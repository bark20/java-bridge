package bridge.domain.model;

import bridge.domain.constant.MoveCommand;
import bridge.domain.constant.Status;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final GameDashboard gameDashboard;

    public BridgeGame() {
        this.gameDashboard = new GameDashboard();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public Status move(int index, MoveCommand moveCommand, Bridge bridge) {
        Status status = bridge.getStatus(index, moveCommand);
        gameDashboard.updateResult(status, moveCommand);
        return status;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(Status status) {
        return status == Status.FAIL;
    }

    public GameDashboard getGameDashboard() {
        return gameDashboard;
    }
}
