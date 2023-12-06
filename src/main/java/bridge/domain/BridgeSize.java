package bridge.domain;

import bridge.error.ErrorMessage;

public class BridgeSize {

    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;

    private int size;

    public BridgeSize(int size) {
        validate(size);
        this.size = size;
    }

    private void validate(int size) {
        if (size < MIN_SIZE || size > MAX_SIZE) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.INVALID_BRIDGE_SIZE.getMessage(), MIN_SIZE, MAX_SIZE));
        }
    }

    public int getSize() {
        return size;
    }
}
