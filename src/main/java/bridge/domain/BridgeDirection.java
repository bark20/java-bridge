package bridge.domain;

import java.util.Arrays;

public enum BridgeDirection {

    UP("U", 1),
    DOWN("D", 0);

    private final String abbreviation;
    private final int directionNo;

    BridgeDirection(String abbreviation, int directionNo) {
        this.abbreviation = abbreviation;
        this.directionNo = directionNo;
    }

    public static String getAbbreviationByDirectionNo(int directionNo) {
        return Arrays.stream(BridgeDirection.values())
                .filter(bridgeDirection -> bridgeDirection.matchesDirectionNo(directionNo))
                .map(bridgeDirection -> bridgeDirection.getAbbreviation())
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                                String.format("No BadgeDirection exist for directionNo=%d", directionNo)
                        )
                );
    }

    private boolean matchesDirectionNo(int directionNo) {
        return this.directionNo == directionNo;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

}
