package bridge.model;

public class Round {

    private static final int INITIAL_ROUND = 0;

    private final int numberOfRound;

    private int current;

    private Round(final int current, final int numberOfRound) {
        this.current = current;
        this.numberOfRound = numberOfRound;
    }

    public static Round of(final int numberOfRound) {
        return new Round(INITIAL_ROUND, numberOfRound);
    }

    Round next() {
        final int nextRound = Math.min(current + 1, numberOfRound);
        return new Round(nextRound, numberOfRound);
    }

    public Round reset() {
        return new Round(INITIAL_ROUND, numberOfRound);
    }

    int current() {
        return current;
    }

    boolean isLast() {
        return current == numberOfRound;
    }

    @Override
    public String toString() {
        return "Round{" +
                "numberOfRound=" + numberOfRound +
                ", current=" + current +
                '}';
    }
}
