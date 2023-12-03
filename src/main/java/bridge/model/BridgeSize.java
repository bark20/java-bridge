package bridge.model;

import static bridge.exception.ErrorType.INVALID_BRIDGE_SIZE;

public class BridgeSize {

    private static final int MAX = 20;
    private static final int MIN = 3;

    private final int size;

    private BridgeSize(final int size) {
        validate(size);
        this.size = size;
    }

    private void validate(final int size) {
        if (size > MAX || size < MIN) {
            throw new IllegalArgumentException(INVALID_BRIDGE_SIZE.getMessage());
        }
    }

    public static BridgeSize withSize(final int number) {
        return new BridgeSize(number);
    }

    public int intValue() {
        return size;
    }
}
