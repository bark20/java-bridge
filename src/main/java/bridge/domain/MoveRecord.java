package bridge.domain;

public class MoveRecord {

    private final MovePosition position;
    private final BridgeDirection direction;
    private final MoveResult moveResult;

    private MoveRecord(MovePosition position, BridgeDirection direction, MoveResult moveResult) {
        this.position = position;
        this.direction = direction;
        this.moveResult = moveResult;
    }

    public static MoveRecord successRecord(MovePosition position, BridgeDirection direction) {
        return new MoveRecord(position, direction, MoveResult.SUCCESS);
    }

    public static MoveRecord failRecord(MovePosition position, BridgeDirection direction) {
        return new MoveRecord(position, direction, MoveResult.FAIL);
    }

    public int getPosition() {
        return position.getPosition();
    }

}
