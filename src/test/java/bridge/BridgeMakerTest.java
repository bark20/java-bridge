package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.MovingDirection;
import java.util.List;
import mock.FakeBridgeNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {

    @DisplayName("다리 길이에 해당하는 다리 생성 - UUU")
    @Test
    void makeBridgeU() {
        // given
        BridgeMaker maker = new BridgeMaker(new FakeBridgeNumberGenerator(MovingDirection.UP.getDirectionNo()));

        // when
        List<String> bridges = maker.makeBridge(3);

        // then
        assertThat(bridges)
                .hasSize(3)
                .containsExactly("U", "U", "U");
    }

    @DisplayName("다리 길이에 해당하는 다리를 만든다. - DDD")
    @Test
    void makeBridgeD() {
        // given
        BridgeMaker maker = new BridgeMaker(new FakeBridgeNumberGenerator(MovingDirection.DOWN.getDirectionNo()));

        // when
        List<String> bridges = maker.makeBridge(3);

        // then
        assertThat(bridges)
                .hasSize(3)
                .containsExactly("D", "D", "D");
    }

}