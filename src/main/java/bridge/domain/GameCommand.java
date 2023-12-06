package bridge.domain;

import java.util.Arrays;

public enum GameCommand {

    RESTART("R"),
    QUIT("Q");

    private final String name;

    GameCommand(String name) {
        this.name = name;
    }

    public static GameCommand of(String name) {
        return Arrays.stream(GameCommand.values())
                .filter(gameCommand -> gameCommand.name.equals(name))
                .findFirst()
                .orElseThrow(); // TODO 예외 메시지
    }
}
