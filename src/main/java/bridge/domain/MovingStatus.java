package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class MovingStatus {

    private List<Direction> movingDirections = new ArrayList<>();
    private List<Boolean> canCrosses = new ArrayList<>();

    public void add(Direction direction, boolean canCross) {
        movingDirections.add(direction);
        canCrosses.add(canCross);
    }

    public int count() {
        return movingDirections.size();
    }

    public void clear() {
        movingDirections.clear();
        canCrosses.clear();
    }

    public boolean cannotCross() {
        return canCrosses.contains(false);
    }

    public List<Direction> getMovingDirections() {
        return movingDirections;
    }

    public List<Boolean> getCanCrosses() {
        return canCrosses;
    }
}
