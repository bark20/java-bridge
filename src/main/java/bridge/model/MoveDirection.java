package bridge.model;

import static bridge.exception.ErrorType.INVALID_MOVE_DIRECTION;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public enum MoveDirection {

    UP("U"),
    DOWN("D");

    private static final Map<String, MoveDirection> symbolToDirection = Arrays.stream(values())
            .collect(Collectors.toMap(
                    direction -> direction.symbol,
                    direction -> direction
            ));

    private final String symbol;

    MoveDirection(final String symbol) {
        this.symbol = symbol;
    }

    static MoveDirection findBySymbol(final String symbol) {
        final Optional<MoveDirection> direction
                = Optional.ofNullable(symbolToDirection.get(symbol));

        if (direction.isEmpty()) {
            throw new IllegalArgumentException(INVALID_MOVE_DIRECTION.getMessage());
        }
        return direction.get();
    }
}
