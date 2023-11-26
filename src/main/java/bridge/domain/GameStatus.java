package bridge.domain;

public enum GameStatus {

    ON_GOING,
    STOPPED,
    FINISHED;

    public boolean isOnGoing() {
        return this == ON_GOING;
    }

    public boolean isFinished() {
        return this == FINISHED;
    }

    public boolean isStopped() {
        return this == STOPPED;
    }

}
