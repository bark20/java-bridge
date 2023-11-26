package bridge.domain;

public class BridgeSize {

    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;

    private final int size;

    private BridgeSize(int size) {
        this.size = size;
    }

    public static BridgeSize from(int size) {
        validateSizeRange(size);
        return new BridgeSize(size);
    }

    private static void validateSizeRange(int size) {
        if (!meetsSizeCriterion(size)) {
            throw new IllegalArgumentException(String.format("Size %d is in invalid range.", size));
        }
    }

    private static boolean meetsSizeCriterion(int size) {
        return size >= MIN_SIZE && size <= MAX_SIZE;
    }

    public int getSize() {
        return size;
    }

}
