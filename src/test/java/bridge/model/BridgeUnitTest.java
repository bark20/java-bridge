package bridge.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeUnitTest {

    @Test
    @DisplayName("전달된 숫자에 해당하는 칸이 없을 경우 예외가 발생한다")
    void failOf(){
        assertThatThrownBy(() -> BridgeUnit.of(2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("전달된 숫자에 해당하는 칸이 없습니다.");
    }

    @Test
    @DisplayName("무작위 값으로 해당 칸이 위칸인지 아래칸인지 구분할 수 있다.")
    void of(){
        assertAll(
                () -> assertThat(BridgeUnit.of(1)).isEqualTo(BridgeUnit.TOP),
                () -> assertThat(BridgeUnit.of(0)).isEqualTo(BridgeUnit.BOTTOM)
        );
    }
}