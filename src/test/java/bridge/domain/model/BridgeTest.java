package bridge.domain.model;

import static org.assertj.core.api.Assertions.*;

import bridge.exception.InputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeTest {

    @Test
    @DisplayName("다리 크기 검증")
    void validate() {

        assertThatThrownBy(() -> Bridge.createBridge(21))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputException.INVALID_RANGE.getMessage());

        assertThatThrownBy(() -> Bridge.createBridge(2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputException.INVALID_RANGE.getMessage());
    }
}