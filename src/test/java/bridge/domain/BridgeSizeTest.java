package bridge.domain;

import bridge.error.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BridgeSizeTest {

    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;

    @Test
    void constructBridgeSize_Fail_ByGreaterThanMaximum() {
        // when, then
        Assertions.assertThatThrownBy(() -> new BridgeSize(30))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(
                        String.format(ErrorMessage.INVALID_BRIDGE_SIZE.getMessage(), MIN_SIZE, MAX_SIZE));
    }

    @Test
    void constructBridgeSize_Fail_ByLessThanMinimum() {
        // when, then
        Assertions.assertThatThrownBy(() -> new BridgeSize(1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(
                        String.format(ErrorMessage.INVALID_BRIDGE_SIZE.getMessage(), MIN_SIZE, MAX_SIZE));
    }
}
