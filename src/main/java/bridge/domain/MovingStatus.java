package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class MovingStatus {

    private List<Direction> movingDirections = new ArrayList<>();

    public void add(Direction direction) {
        movingDirections.add(direction);
    }

    public int count() {
        return movingDirections.size();
    }

    public void clear() {
        movingDirections.clear();
    }
}
