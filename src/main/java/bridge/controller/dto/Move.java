package bridge.controller.dto;

public class Move {
    private String direction; // U, D
    private String success; // O, X

    public Move(String direction, String success) {
        this.direction = direction;
        this.success = success;
    }

    public String direction() {
        return direction;
    }

    public String success() {
        return success;
    }
}
