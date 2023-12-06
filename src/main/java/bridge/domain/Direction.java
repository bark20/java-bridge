package bridge.domain;

public enum Direction {

    UP("U", 1),
    DOWN("D", 0);

    private final String name;
    private final int number;

    Direction(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }
}
