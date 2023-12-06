package bridge;

import bridge.domain.Direction;
import bridge.domain.MovingStatus;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final BridgeMaker bridgeMaker;
    private final MovingStatus movingStatus;
    private int tryCount;

    public BridgeGame(BridgeMaker bridgeMaker, MovingStatus movingStatus) {
        this.bridgeMaker = bridgeMaker;
        this.movingStatus = movingStatus;
        this.tryCount = 1;
    }

    public List<String> makeBridge(int size) {
        return bridgeMaker.makeBridge(size);
    }

    public boolean canMove(List<String> bridge) {
        return movingStatus.count() < bridge.size();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public MovingStatus move(List<String> bridge, Direction direction) {
        boolean canCross = bridge.get(movingStatus.count()).equals(direction.getName());
        movingStatus.add(direction, canCross);
        return movingStatus;
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

    public String formatMovingStatus() {
        return movingStatus.formatMovingStatus();
    }

    public boolean isSuccess() {
        return !movingStatus.cannotCross();
    }

    public int getTryCount() {
        return tryCount;
    }
}
