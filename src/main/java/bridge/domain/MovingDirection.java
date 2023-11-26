package bridge.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum MovingDirection {

    UP("U", 1),
    DOWN("D", 0);

    private final String abbreviation;
    private final int directionNo;

    MovingDirection(String abbreviation, int directionNo) {
        this.abbreviation = abbreviation;
        this.directionNo = directionNo;
    }

    public static String getAbbreviationByDirectionNo(int directionNo) {
        return Arrays.stream(MovingDirection.values())
                .filter(bridgeDirection -> bridgeDirection.matchesDirectionNo(directionNo))
                .map(bridgeDirection -> bridgeDirection.getAbbreviation())
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                                String.format("No BadgeDirection exist for directionNo=%d", directionNo)
                        )
                );
    }

    public static MovingDirection ofAbbreviation(String abbreviation) {
        return Arrays.stream(MovingDirection.values())
                .filter(bridgeDirection -> bridgeDirection.matchesAbbreviation(abbreviation))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                                String.format("No BadgeDirection exist for abbreviation=%s", abbreviation)
                        )
                );
    }

    public static List<MovingDirection> toDirections(List<String> abbreviations) {
        return abbreviations.stream()
                .map(MovingDirection::ofAbbreviation)
                .collect(Collectors.toList());
    }

    private boolean matchesAbbreviation(String abbreviation) {
        return this.abbreviation.equals(abbreviation);
    }

    private boolean matchesDirectionNo(int directionNo) {
        return this.directionNo == directionNo;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

}
