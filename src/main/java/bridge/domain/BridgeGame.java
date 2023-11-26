package bridge.domain;

import bridge.constants.GameValue;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private int retryCount;
    private MoveResult moveResult;

    public BridgeGame(MoveResult moveResult, int retryCount) {
        this.moveResult = moveResult;
        this.retryCount = retryCount;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     */
    public void move(String square, String moveCommand) {
        if (moveCommand.equals(GameValue.MOVE_UP_COMMAND)) {
            moveUp(square, moveCommand);
        }
        if (moveCommand.equals(GameValue.MOVE_DOWN_COMMAND)) {
            moveLower(square, moveCommand);
        }
    }

    private boolean isMoveUp(String square, String moveCommand) {
        return square.equals(moveCommand);
    }

    private void moveUp(String square, String moveCommand) {
        if (isMoveUp(square, moveCommand)) {
            moveResult.moveUp(GameValue.MOVE);
        }
        if (!isMoveUp(square, moveCommand)) {
            moveResult.moveUp(GameValue.STOP);
        }
    }

    private boolean isMoveLower(String square, String moveCommand) {
        return square.equals(moveCommand);
    }

    private void moveLower(String square, String moveCommand) {
        if (isMoveLower(square, moveCommand)) {
            moveResult.moveLowwer(GameValue.MOVE);
        }
        if (!isMoveLower(square, moveCommand)) {
            moveResult.moveLowwer(GameValue.STOP);
        }
    }

    public boolean isSuccessful() {
        return moveResult.isSuccessful();
    }

    public String getGameResult() {
        if (isSuccessful()) {
            return "성공";
        }
        return "실패";
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     */
    public void retry() {
        retryCount++;
        moveResult = new MoveResult();
    }

    public int getRetryCount() {
        return retryCount;
    }

    public MoveResult getMoveResult() {
        return moveResult;
    }
}
