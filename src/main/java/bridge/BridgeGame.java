package bridge;

import bridge.domain.Direction;
import bridge.domain.MovingStatus;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;
    private final MovingStatus movingStatus;
    private int tryCount;

    public BridgeGame(List<String> bridge, MovingStatus movingStatus) {
        this.bridge = bridge;
        this.movingStatus = movingStatus;
        this.tryCount = 1;
    }

    public boolean canMove() {
        return movingStatus.count() < bridge.size();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(Direction direction) {
        boolean canCross = bridge.get(movingStatus.count()).equals(direction.getName());
        movingStatus.add(direction);
        return canCross;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        movingStatus.clear();
        tryCount++;
    }

    public boolean hasMovedAll() {
        return movingStatus.count() == bridge.size();
    }
}
