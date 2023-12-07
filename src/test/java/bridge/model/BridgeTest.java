package bridge.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;


class BridgeTest {

    @Test
    @DisplayName("칸을 컨널 수 있는지 없는지 알 수 있다.")
    void cross() {
        Bridge bridge = new Bridge(List.of("U", "D", "D"));
        assertAll(
                () -> assertThat(bridge.cross("U")).isTrue(),
                () -> assertThat(bridge.cross("D")).isTrue(),
                () -> assertThat(bridge.cross("U")).isFalse()
        );
    }

    @Test
    @DisplayName("다리의 끝인지 확인할 수 있다.")
    void end() {
        Bridge bridge = new Bridge(new ArrayList<>());
        assertThat(bridge.end()).isTrue();
    }

}