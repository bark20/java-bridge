package bridge;

import bridge.model.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeRandomNumberGeneratorTest {

    public static final int ENOUGH_BIG_NUMBER = 10000;

    @Test
    @DisplayName("무작위 값으로 나올 수 있는 수는 0 과 1만 존재한다.")
    void generate() {
        for (int i = 0; i < ENOUGH_BIG_NUMBER; i++) {
            assertThat(new BridgeRandomNumberGenerator().generate()).isBetween(0, 1);
        }
    }
}