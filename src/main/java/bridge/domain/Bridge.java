package bridge.domain;

import java.util.List;

public class Bridge {

    private final List<BridgeDirection> directions;

    public Bridge(List<BridgeDirection> directions) {
        this.directions = directions;
    }

    public static Bridge from(List<String> directionAbbreviations) {
        return new Bridge(BridgeDirection.toDirections(directionAbbreviations));
    }

    public boolean matchesDirection(MovePosition position, BridgeDirection direction) {
        return directions.get(position.getPosition() - 1) == direction;
    }

    public List<BridgeDirection> getDirections() {
        return directions;
    }

}
