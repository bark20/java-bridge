package bridge.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.as;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;


class BridgeTest {

    @Test
    @DisplayName("칸을 컨널 수 있는지 없는지 알 수 있다.")
    void cross(){
        Bridge bridge = new Bridge(List.of("U","D","D"));
        assertAll(
                () -> assertThat(bridge.cross("U")).isTrue(),
                () -> assertThat(bridge.cross("D")).isTrue(),
                () -> assertThat(bridge.cross("U")).isFalse()
        );

    }

}