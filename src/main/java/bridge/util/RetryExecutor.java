package bridge.util;

import bridge.view.console.ConsoleWriter;
import java.util.function.Supplier;

public final class RetryExecutor {
    public static <T> T retryUntilSuccess(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                ConsoleWriter.printlnMessage(e.getMessage());
            }
        }
    }
}
