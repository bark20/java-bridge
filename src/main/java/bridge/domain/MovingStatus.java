package bridge.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

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

    public String formatMovingStatus() {
        StringJoiner up = new StringJoiner(" | ", "[ ", " ]\n");
        StringJoiner down = new StringJoiner(" | ", "[ ", " ]\n");
        for (int i = 0; i < movingDirections.size(); i++) {
            if (movingDirections.get(i) == Direction.UP) {
                if (canCrosses.get(i)) {
                    up.add("O");
                    down.add(" ");
                    continue;
                }
                up.add("X");
                down.add(" ");
                continue;
            }
            if (canCrosses.get(i)) {
                down.add("O");
                up.add(" ");
                continue;
            }
            down.add("X");
            up.add(" ");
        }

        return up.toString() + down.toString();
    }

    public List<Direction> getMovingDirections() {
        return movingDirections;
    }

    public List<Boolean> getCanCrosses() {
        return canCrosses;
    }
}
