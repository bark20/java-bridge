package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeTest {

    @DisplayName("방향 약어를 통해 다리 객체 생성")
    @Test
    void from() {
        // given
        List<String> directionAbbreviations = List.of("U", "U", "U");

        // when
        Bridge bridge = Bridge.from(directionAbbreviations);

        // then
        assertThat(bridge.getDirections())
                .hasSize(3)
                .isEqualTo(List.of(MovingDirection.UP, MovingDirection.UP, MovingDirection.UP));
    }

}