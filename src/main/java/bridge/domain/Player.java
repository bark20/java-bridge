package bridge.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {

    private MovePosition currentPosition;
    private final List<MoveRecord> records = new ArrayList<>();

    private Player(MovePosition currentPosition) {
        this.currentPosition = currentPosition;
    }

    public static Player defaultOf() {
        return new Player(MovePosition.defaultOf());
    }

    public void move(MovingDirection direction, Bridge bridge) {
        addRecord(direction, bridge);
        moveNextPosition();
    }

    private void addRecord(MovingDirection direction, Bridge bridge) {
        if (bridge.matchesDirection(currentPosition, direction)) {
            records.add(MoveRecord.successRecord(currentPosition, direction));
            return;
        }
        records.add(MoveRecord.failRecord(currentPosition, direction));
    }

    private void moveNextPosition() {
        this.currentPosition = currentPosition.moveNext();
    }

    public int getCurrentPosition() {
        return currentPosition.getPosition();
    }

    public List<MoveRecord> getRecords() {
        return Collections.unmodifiableList(records);
    }

    public boolean hasFailed() {
        return records.stream()
                .anyMatch(MoveRecord::isResultFail);
    }

    public boolean hasCrossedAllBridge(Bridge bridge) {
        return this.currentPosition.isGreaterThan(bridge.getSize());
    }

}
