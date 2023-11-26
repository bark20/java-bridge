package bridge.domain;

import java.util.Arrays;

public enum GameCommand {

    RETRY("R"),
    QUIT("Q");

    private final String abbreviation;

    GameCommand(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public static GameCommand ofAbbreviation(String abbreviation) {
        return Arrays.stream(GameCommand.values())
                .filter(gameCommand -> gameCommand.matchesAbbreviation(abbreviation))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                                String.format("No GameCommand exist for abbreviation=%s", abbreviation)
                        )
                );
    }

    private boolean matchesAbbreviation(String abbreviation) {
        return this.abbreviation.equals(abbreviation);
    }

    public boolean isRetry() {
        return this == RETRY;
    }

}
