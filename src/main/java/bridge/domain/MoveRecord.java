package bridge.domain;

public class MoveRecord {

    private final MovePosition position;
    private final MovingDirection direction;
    private final MoveResult moveResult;

    private MoveRecord(MovePosition position, MovingDirection direction, MoveResult moveResult) {
        this.position = position;
        this.direction = direction;
        this.moveResult = moveResult;
    }

    public static MoveRecord successRecord(MovePosition position, MovingDirection direction) {
        return new MoveRecord(position, direction, MoveResult.SUCCESS);
    }

    public static MoveRecord failRecord(MovePosition position, MovingDirection direction) {
        return new MoveRecord(position, direction, MoveResult.FAIL);
    }

    public int getPosition() {
        return position.getPosition();
    }

}
