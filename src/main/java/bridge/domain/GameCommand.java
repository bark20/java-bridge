package bridge.domain;

import bridge.error.ErrorMessage;
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
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_GAME_COMMAND.getMessage()));
    }

    public String getName() {
        return name;
    }
}
