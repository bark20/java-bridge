package bridge.controller.dto;

public record SingleMove(
        String direction, // U, D
        String success // O, X
) {
}
