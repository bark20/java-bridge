package bridge;

import bridge.domain.MovingStatus;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    BridgeGame bridgeGame;

    @BeforeEach
    void setUp() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeGame = new BridgeGame(bridgeMaker, new MovingStatus());
    }

    @Test
    void makeBridge_Success() {
        // when
        List<String> bridge = bridgeGame.makeBridge(3);

        // then
        Assertions.assertThat(bridge.size()).isEqualTo(3);
    }
}