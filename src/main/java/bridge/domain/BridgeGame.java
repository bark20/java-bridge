package bridge.domain;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final String UPPER = "U";
    private static final String LOWWER = "D";
    private static final String MOVE = "O";
    private static final String STOP = "X";
    private final Bridge bridge;
    private final int retryCount;

    public BridgeGame(Bridge bridge, int retryCount) {
        this.bridge = bridge;
        this.retryCount = retryCount;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     */
    public Bridge move(String square, String moveCommand) {
        if (moveCommand.equals(UPPER)) {
            moveUp(square, moveCommand);
        }
        if (moveCommand.equals(LOWWER)) {
            moveLowwer(square, moveCommand);
        }
        return bridge;
    }

    private boolean isMoveUp(String square, String moveCommand) {
        return square.equals(moveCommand);
    }

    private void moveUp(String square, String moveCommand) {
        if (isMoveUp(square, moveCommand)) {
            bridge.moveUp(MOVE);
        }
        if (!isMoveUp(square, moveCommand)) {
            bridge.moveUp(STOP);
        }
    }

    private boolean isMoveLowwer(String square, String moveCommand) {
        return square.equals(moveCommand);
    }

    private void moveLowwer(String square, String moveCommand) {
        if (isMoveLowwer(square, moveCommand)) {
            bridge.moveLowwer(MOVE);
        }
        if (!isMoveLowwer(square, moveCommand)) {
            bridge.moveLowwer(STOP);
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     */
    public void retry() {
    }
}
