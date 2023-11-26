package bridge.domain;

import java.util.List;

public class Bridge {

    private final List<MovingDirection> directions;

    public Bridge(List<MovingDirection> directions) {
        this.directions = directions;
    }

    public static Bridge from(List<String> directionAbbreviations) {
        return new Bridge(MovingDirection.toDirections(directionAbbreviations));
    }

    public boolean matchesDirection(MovePosition position, MovingDirection direction) {
        return directions.get(position.getPosition() - 1) == direction;
    }

    public List<MovingDirection> getDirections() {
        return directions;
    }

}
