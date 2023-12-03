package bridge.model;

import static bridge.exception.ErrorType.INVALID_GAME_COMMAND;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public enum GameCommand {

    RESTART("R"),
    QUIT("Q");

    private static final Map<String, GameCommand> codeToCommand = Arrays.stream(values())
            .collect(Collectors.toMap(
                    gameOption -> gameOption.commandCode,
                    gameOption -> gameOption
            ));

    private final String commandCode;

    GameCommand(final String commandCode) {
        this.commandCode = commandCode;
    }

    public static GameCommand findByCode(final String commandCode) {
        final Optional<GameCommand> gameCommand
                = Optional.ofNullable(codeToCommand.get(commandCode));

        if (gameCommand.isEmpty()) {
            throw new IllegalArgumentException(INVALID_GAME_COMMAND.getMessage());
        }
        return gameCommand.get();
    }

    public boolean isRestart() {
        return this == RESTART;
    }
}
