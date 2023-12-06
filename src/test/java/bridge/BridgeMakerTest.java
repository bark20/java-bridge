package bridge;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {

    @Test
    void makeBridge_Success() {
        // given
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        // when
        List<String> bridge = bridgeMaker.makeBridge(3);

        // then
        Assertions.assertThat(bridge.size()).isEqualTo(3);
    }
}
