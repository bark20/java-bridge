package bridge.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class CrossingDirectionTest {

    @Test
    @DisplayName("전달된 숫자에 해당하는 칸이 없을 경우 예외가 발생한다")
    void failOf() {
        assertThatThrownBy(() -> CrossingDirection.of(2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("전달된 숫자에 해당하는 칸이 없습니다.");
    }

    @Test
    @DisplayName("무작위 값으로 해당 칸이 위칸인지 아래칸인지 구분할 수 있다.")
    void of() {
        assertAll(
                () -> assertThat(CrossingDirection.of(1)).isEqualTo(CrossingDirection.TOP),
                () -> assertThat(CrossingDirection.of(0)).isEqualTo(CrossingDirection.BOTTOM)
        );
    }

    @Test
    @DisplayName("특정 문자로 해당 칸이 위칸인지 아래칸인지 구분할 수 있다.")
    void letterOf() {
        assertAll(
                () -> assertThat(CrossingDirection.of("U")).isEqualTo(CrossingDirection.TOP),
                () -> assertThat(CrossingDirection.of("D")).isEqualTo(CrossingDirection.BOTTOM)
        );
    }
}