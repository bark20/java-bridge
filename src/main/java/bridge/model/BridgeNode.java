package bridge.model;

import java.util.Objects;

public class BridgeNode {

    private final MoveDirection direction;

    private final int position;

    private BridgeNode(final MoveDirection direction, final int position) {
        this.direction = direction;
        this.position = position;
    }

    static BridgeNode create(final MoveDirection direction, final int position) {
        return new BridgeNode(direction, position);
    }

    MoveResult compare(final BridgeNode other) {
        if (equals(other)) {
            return MoveResult.PASS;
        }
        return MoveResult.FAIL;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final BridgeNode other = (BridgeNode) o;
        return position == other.position && direction == other.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction, position);
    }

    @Override
    public String toString() {
        return "BridgeNode{" +
                "direction=" + direction +
                ", position=" + position +
                '}';
    }
}
