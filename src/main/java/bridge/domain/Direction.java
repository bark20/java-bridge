package bridge.domain;

import java.util.Arrays;

public enum Direction {

    UP("U", 1),
    DOWN("D", 0);

    private final String name;
    private final int number;

    Direction(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public static Direction of(String name) {
        return Arrays.stream(Direction.values())
                .filter(direction -> direction.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException()); // TODO 예외 메시지
    }

    public String getName() {
        return name;
    }
}
