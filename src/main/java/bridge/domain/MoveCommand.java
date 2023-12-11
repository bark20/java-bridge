package bridge.domain;

import java.util.Arrays;

public enum MoveCommand {
    UP("U", 1),
    DOWN("D", 0);

    private final String command;
    private final int number;

    MoveCommand(String command, int number) {
        this.command = command;
        this.number = number;
    }

    public static MoveCommand from(int number) {
        return Arrays.stream(MoveCommand.values())
                .filter(com -> com.number == number)
                .findAny()
                .get();
    }

    public static String convertCommand(int number) {
        return from(number).command;
    }
}
