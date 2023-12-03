package bridge.model;

public class TryCount {

    private final int count;

    TryCount(final int count) {
        this.count = count;
    }

    TryCount increase() {
        return new TryCount(count + 1);
    }

    int intValue() {
        return count;
    }
}
